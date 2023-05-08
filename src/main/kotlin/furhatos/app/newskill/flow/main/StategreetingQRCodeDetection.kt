package furhatos.app.newskill.flow.main
import furhatos.flow.kotlin.*
import furhatos.records.User

//Jeweils zum Start des Skills wird die Variable Benutzer initialisiert und mit null überschrieben, sodass
//Informationen über den Nutzer mit Benutzer!!.put() während des Skills gespeichert werden können
var Benutzer: User? = null

val greeting1: State = state (){
    onEntry {
        furhat.ask(
            "Hallo, hast du einen QR-Code für mich, sodass ich dir die Informationen, " +
                    "die in diesem QR-Code enthalten sind auslesen kann? "
        )
    }


    onResponse {
        furhat.say("Super, der QR-Code enthält folgende Informationen")
        ConnectBarcodeReaderWithZMQPort(Benutzer = users.getUser(it.userId))
        furhat.say("${Benutzer!!.get("QR Code Text")}")
    }

}


