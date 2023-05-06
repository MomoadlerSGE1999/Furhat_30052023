package furhatos.app.newskill.flow.main
import furhatos.flow.kotlin.*
import furhatos.nlu.common.Yes
import furhatos.nlu.common.No
import furhatos.records.User

var Benutzer: User? = null

val greeting1: State = state (){
    onEntry {
furhat.ask("Hallo, hast du einen QR-Code für mich, sodass ich dir die Informationen, " +
        "die in diesem QR-Code enthalten sind auslesen kann? ")


    onResponse {
        furhat.say("Super, der QR-Code enthält folgende Informationen")
        ConnectBarcodeReaderWithZMQPort(Benutzer = users.getUser(it.userId))
        furhat.say("${Benutzer!!.get("QR Code Text")}")
    }

}

}
