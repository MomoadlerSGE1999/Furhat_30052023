package furhatos.app.newskill.flow.main
import com.google.zxing.BarcodeFormat
import com.google.zxing.BinaryBitmap
import com.google.zxing.MultiFormatReader
import com.google.zxing.RGBLuminanceSource
import com.google.zxing.common.HybridBinarizer
import com.google.zxing.DecodeHintType
import com.google.zxing.Result
import furhatos.records.User
import org.zeromq.SocketType
import org.zeromq.ZContext
import java.awt.image.BufferedImage
import java.io.ByteArrayInputStream
import javax.imageio.ImageIO
import java.io.File

fun scanBarcode(Image: BufferedImage): String? {
    //Ergebnis dieser Funktion ist der ausgelesene Text eines QR-Codes
    try {

        /*
        val imageFile = File(imageFilePath)
        val bufferedImage: BufferedImage = ImageIO.read(imageFile)
        //Weil in der Funktion ConnectBarcodeReaderWithZMQPort nur ein Image BufferedImage übergeben werden kann
        wurden diese Werte ausgeklammert und von vorne rein als Argument nummer eins in der Funktion mit einem bufferedImage gearbeitet
         */

        val source = RGBLuminanceSource(Image.width, Image.height, getIntArray(Image))
        val bitmap = BinaryBitmap(HybridBinarizer(source))
        val reader = MultiFormatReader()

        val hints: MutableMap<DecodeHintType, Any> = mutableMapOf()
        hints[DecodeHintType.POSSIBLE_FORMATS] = BarcodeFormat.QR_CODE// Adjust this for other barcode formats if needed

        val result: Result = reader.decode(bitmap, hints)
        return result.text
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return null
}

fun getIntArray(image: BufferedImage): IntArray {
    val width = image.width
    val height = image.height
    val pixels = IntArray(width * height)
    image.getRGB(0, 0, width, height, pixels, 0, width)
    return pixels
}

fun ConnectBarcodeReaderWithZMQPort(Benutzer: User) {
    val context = ZContext()
    val socket = context.createSocket(SocketType.SUB)


    socket.connect("tcp://IP-Adresse der Furhat-Kamera:Port der Kamera") // Replace with the appropriate address and port
    //// Verbindung zum ZMQ-Server herstellen

    var qrCodeDetected = false // Flag zur Überprüfung, ob ein QR-Code erkannt wurde

    // Empfange Bilder mit QR-Codes vom ZMQ-Server
    while (!qrCodeDetected) {
        socket.subscribe("".toByteArray())
        val imageBytes = socket.recv() // Empfange ein Bild als Byte-Array vom ZMQ-Server
        val image: BufferedImage = ImageIO.read(ByteArrayInputStream(imageBytes)) // Wandele das Byte-Array in ein BufferedImage um

        val barcodeText = scanBarcode(image) // QR-Code im Bild scannen und den Text erhalten

        if (barcodeText != null) {
            println("QR Code: $barcodeText")
            Benutzer!!.put("QR Code Text", barcodeText) // Speichert den erkannten QR-Code-Text im Benutzerobjekt


            qrCodeDetected = true // Setze das Flag, um die Endlosschleife zu beenden

        }

        Thread.sleep(500) // Füge eine Verzögerung von einer halben Sekunde ein
    }

    socket.close() // Socket schließen
    context.close() // ZMQ-Kontext schließen
}