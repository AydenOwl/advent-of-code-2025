package dayOne

import java.io.File

fun main() {
    getDoorPassword()
}

fun getDoorPassword(): Unit {
    val secretEntrance = SecretEntrance(0, 99, 50)

    File("input_secret_entrance.txt").forEachLine {
        val direction = when(it[0]) {
            'R' -> Direction.RIGHT
            else -> Direction.LEFT
        }
        val step = it.substring(1).toInt()
        secretEntrance.moveTo(direction, step)
    }

    println("The door password is ${secretEntrance.pointedCounter}")
}