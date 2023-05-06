package furhatos.app.demo02.flow


import furhatos.app.newskill.flow.main.Idle
import furhatos.app.newskill.setting.distanceToEngage
import furhatos.app.newskill.setting.maxNumberOfUsers
import furhatos.autobehavior.enableSmileBack
import furhatos.autobehavior.setDefaultMicroexpression
import furhatos.flow.kotlin.*
import furhatos.flow.kotlin.voice.PollyVoice
import furhatos.records.User

//Im State "Init" werden Parameter des Skills vor jedem Start initialisiert. States werden als Werte definiert.
//Die Klammer hinter "state" regelt die Vererbung von anderen States. In diesem Fall erbt der State vom State "Parent".

val Init : State = state() {
    init {

        //Jeweils zum Start des Skills wird die Variable Benutzer initialisiert und mit null überschrieben, sodass
        //Informationen über den Nutzer mit Benutzer!!.put() während des Skills gespeichert werden können
        var Benutzer: User? = null

        //Der dialogLogger sorgt dafür, dass die Gespräche mit Furhat unter
        //dem Pfad: C:\Users\Benutzer\.furhat\logs protokolliert werden.
        dialogLogger.startSession()

        //Mit furhat.voice wird die NLU ausgewählt, die Furhat für die Interaktion verwenden soll.
        furhat.voice = PollyVoice.Hans()

        //Mikroexpressionen sind kleine Gesichtsausdrücke, die kontinuierlich während eines Skill ablaufen,
        //so wirkt Furhat lebendiger. von "facialMovements = true" wird abgeraten, da Furhat das
        //Gesicht sonst als zu unruhig wahrgenommen werden könnte, wenn man ohnehin schon mit furhat.gestures arbeitet.
        furhat.setDefaultMicroexpression(blinking = true, facialMovements = false, eyeMovements = true)

        //furhat.enableSmileBack = true sorgt dafür, dass Furhat zurücklächelt, wenn der Gesprächspartner lacht.
        furhat.enableSmileBack = true

        //Mit users.setSimpleEngagementPolicy werden von Furhat Robotics definierte Default-Werte gesetzt.
        //Die Defaultwerte umfassen zum Beispiel die maximale Anzahl an zugelassenen Gesprächspartnern.
        users.setSimpleEngagementPolicy(distanceToEngage, maxNumberOfUsers)

        furhat.cameraFeed.enable()
        furhat.cameraFeed.port()
        println("${furhat.cameraFeed.port()}")
        furhat.say("${furhat.cameraFeed.port()}")

        //Mit dem goto() Befehl definiert man welcher State der Anwendung als nächstes eingeleitet wird.
        goto(Idle)
    }
}
