package furhatos.app.newskill.flow.main
import furhatos.nlu.Intent

class ja : Intent(){
    override fun getExamples(lang: furhatos.util.Language): List<String> {
        return listOf("Genau", "Steinau", "Richtig", "Korrekt", "So ist es", "Das ist richtig",
            "Yes", "Auf jeden Fall", "Ganz Genau", "nlu.Ja, so ist es", "Genau richtig", "ja, bin ich",
            "ja, das ist wahr", "Jap","habt ihr einen", "ja", "doch", "jawohl", "ja klar", "aber sicher",
            "sicher doch", "klar", "Janna", "Pia", "Peer", "Jara", "zu holen", "zu bringen",
            "ja ich bringe jemanden", "ja ich hole jemanden", "nlu.Ja, stimmt", "Das stimmt", "Exakt",
            "zu bringen ja", "nia")
    }
}

class HelloFurhat : Intent() {
    override fun getExamples(lang: furhatos.util.Language): List<String> {
        return listOf("Hallo Furhat, Aufwachen", "Hallo, bist du bereit für deinen Auftritt", "Furhat?", "Aufwachen", "")
    }
}
class rechtsvondir : Intent() {
    override fun getExamples(lang: furhatos.util.Language): List<String> {
        return listOf("ja, rechts von dir", "Rechts von dir", "Auf deiner rechten Seite", "Ja sie befinden sich rechts voin dir", "schau mal rechts von dir")
    }
}
class wieheisstdu : Intent() {
    override fun getExamples(lang: furhatos.util.Language): List<String> {
        return listOf(" Und Wie ist dein name", "Verrätst du mir deinen namen?", "wie heißt du", "dein name?")
    }
}
class Okaydergroßealso : Intent() {
    override fun getExamples(lang: furhatos.util.Language): List<String> {
        return listOf("Okay", "Alles klar", "Gut, dann weiß ich Bescheid", "danke für die Erklärung", "der Allwissende also?", "wissend also", "Okay ich bleibe bei diesem Namen", "Ich bleibe bei der Allwissende", "Dann nenne ich dich Furhat der Allwissende")
    }
}
class DigitaleInnovationen : Intent() {
    override fun getExamples(lang: furhatos.util.Language): List<String> {
        return listOf(
            "Im Rahmen des Moduls Digitale Innovationen",
            "Im Rahmen der Veranstaltung Digitale Innovationen",
            "Digitale Innovationen",
            "Der Grund ist die Verasntaltung Digitale Innovationen")
    }
}