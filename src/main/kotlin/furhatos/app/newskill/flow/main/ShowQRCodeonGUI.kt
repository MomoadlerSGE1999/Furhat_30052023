package furhatos.app.newskill.flow.main

import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.onResponse
import furhatos.flow.kotlin.state
import furhatos.nlu.common.Yes
import furhatos.skills.HostedGUI
import java.text.SimpleDateFormat
import java.util.*

val greeting13: State = state (){
    onEntry {
        furhat.ask("Möchtest du den zuletzt erstellten QR-Code auf der Furhat GUi angezeigt bekommen? ")
    }

    onResponse<Yes> {

        val default_gui = HostedGUI("My Default GUI","assets/webTemplates/BASIC", port = 51234)

        default_gui.write("Banana")
    }

}