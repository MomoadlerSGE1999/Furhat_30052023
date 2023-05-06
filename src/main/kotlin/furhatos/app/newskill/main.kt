package furhatos.app.newskill

import furhatos.app.demo02.flow.Init
import furhatos.app.newskill.flow.*
import furhatos.app.newskill.flow.main.Idle
import furhatos.app.newskill.flow.main.greeting1
import furhatos.app.newskill.flow.main.greeting2
import furhatos.skills.Skill
import furhatos.flow.kotlin.*

class NewskillSkill : Skill() {
    override fun start() {
        Flow().run(Init)
    }
}

fun main(args: Array<String>) {
    Skill.main(args)
}
