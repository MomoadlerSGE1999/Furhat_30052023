package furhatos.app.newskill.flow.main
import java.util.Date

import furhatos.flow.kotlin.*
import java.text.SimpleDateFormat

val greeting12: State = state (){
    onEntry {
        furhat.ask("Hallo sage mir etwas und ich schreibe es in einen QR-Code ")
    }

        onResponse {

            val speechofUser: String = it.text

            QRCodeErstellungmiteingabeText(speechofUser)

            val speicherOrt: String = "C:/data/Bilder QR-Code"
            val timestamp2: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
            val dateiName: String = "qr_code_$timestamp2.png"


            furhat.say("Super, der QR-Code enthält folgenden Text: $speechofUser, ist unter folgendem " +
                    "Pfad gespeichert $speicherOrt und hat folgenden Dateinamen: $dateiName")
            goto(Idle)
        }

    }

