package furhatos.app.newskill.flow.main

import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.common.BitMatrix
import java.awt.Color
import java.awt.Graphics2D
import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import javax.imageio.ImageIO
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date

fun QRCodeErstellungmiteingabeText (text: String) {
    val width = 300
    val height = 300

    val qrCodeFormat = BarcodeFormat.QR_CODE //Das Format des Barcodes wird hier festgelegt

    val bitMatrix: BitMatrix = MultiFormatWriter().encode(text, qrCodeFormat, width, height)
    //Eine Bitmatrix repräsentiert ein zweidimensionales Raster von Bits,
    // das die codierten Informationen für den QR-Code enthält.

    val qrCodeImage = generateQRCodeImage(bitMatrix)

    val directoryPath = "C:/data/Bilder QR-Code"
    val timestamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
    val fileName = "qr_code_$timestamp.png"

    val path = "$directoryPath/$fileName"

    saveQRCodeImage(qrCodeImage, path) // Aufruf der Funktion zum Speichern des QR-Codes
}

private fun generateQRCodeImage(bitMatrix: BitMatrix): BufferedImage {
    val qrCodeWidth = bitMatrix.width
    val qrCodeHeight = bitMatrix.height
    val bufferedImage = BufferedImage(qrCodeWidth, qrCodeHeight, BufferedImage.TYPE_INT_RGB)
    bufferedImage.createGraphics().apply {
        color = Color.WHITE
        fillRect(0, 0, qrCodeWidth, qrCodeHeight)
        color = Color.BLACK
        for (x in 0 until qrCodeWidth) {
            for (y in 0 until qrCodeHeight) {
                if (bitMatrix[x, y]) {
                    fillRect(x, y, 1, 1)
                }
            }
        }
        dispose()
    }
    return bufferedImage
}

private fun saveQRCodeImage(image: BufferedImage, path: String) {
    val file = File(path)
    ImageIO.write(image, "png", file)
    println("QR-Code wurde erfolgreich gespeichert: $path")
}


