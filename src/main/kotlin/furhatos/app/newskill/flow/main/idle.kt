package furhatos.app.newskill.flow.main

import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures
import furhatos.util.Gender
import furhatos.util.Language


val Idle: State = state {

    init {
furhat.setVoice(Language.GERMAN, Gender.MALE)
        when {
            users.count > 0 -> {
                furhat.attend(users.random)
                goto(greeting13)
            }
            users.count == 0 && furhat.isVirtual() -> furhat.say("Ich sehe niemanden, bitte füge einen virtuellen Nutzer hinzu ")
            users.count == 0 && !furhat.isVirtual() -> furhat.say("Ich kann niemanden sehen, bitte komm näher ")
        }
    }

    onEntry {
        furhat.attendNobody()
    }

    onUserEnter {
        furhat.attend(it)
        goto(greeting13)
    }
}
