/*package furhatos.app.newskill.flow.main

import com.google.zxing.*
import com.google.zxing.common.HybridBinarizer
import org.zeromq.SocketType
import org.zeromq.ZContext
import java.awt.image.BufferedImage
import java.io.ByteArrayInputStream
import javax.imageio.ImageIO


fun scanBarcodeFromImageV2(image: BufferedImage): String? {
    try {
        val source = RGBLuminanceSource(image.width, image.height, getIntArray2(image))
        val bitmap = BinaryBitmap(HybridBinarizer(source))
        val reader = MultiFormatReader()

        val hints: MutableMap<DecodeHintType, Any> = mutableMapOf()
        hints[DecodeHintType.POSSIBLE_FORMATS] = BarcodeFormat.QR_CODE // Adjust this for other barcode formats if needed

        val result = reader.decode(bitmap, hints)
        return result.text
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return null
}

fun getIntArray2V2(image: BufferedImage): IntArray {
    val width = image.width
    val height = image.height
    val pixels = IntArray(width * height)
    image.getRGB(0, 0, width, height, pixels, 0, width)
    return pixels
}

fun mainV2() {
    val context = ZContext()
    val socket = context.createSocket(SocketType.REQ)
    socket.connect("tcp://localhost:5555") // Replace with the appropriate address and port

    // Receive images with QR codes from the ZMQ server
    while (true) {
        socket.send("request".toByteArray(), 0)
        val imageBytes = socket.recv()

        val image = ImageIO.read(ByteArrayInputStream(imageBytes))
        val barcodeText = scanBarcodeFromImage(image)
        if (barcodeText != null) {
            println("QR Code: $barcodeText")
            // Do something with the QR code text
        }
    }

    socket.close()
    context.close()
}

 */