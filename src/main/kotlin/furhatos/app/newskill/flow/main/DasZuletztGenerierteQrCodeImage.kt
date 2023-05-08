package furhatos.app.newskill.flow.main

import java.io.File

fun getLatestQRCodeImage(directoryPath: String): File? {
    val directory = File(directoryPath)
    val files = directory.listFiles { file -> file.name.endsWith(".png") }
    if (files.isNullOrEmpty()) {
        return null
    }

    val latestFile = files.maxBy { file -> file.lastModified() }
    return latestFile
}
