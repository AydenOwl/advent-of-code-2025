package dayOne

import java.io.File

fun main() {
    getDoorPassword()
}

fun getDoorPassword() {
    val secretEntrance = SecretEntrance(0, 99, 50)

    File("input_secret_entrance.txt").forEachLine {
        val direction = when(it[0]) {
            'R' -> Direction.RIGHT
            else -> Direction.LEFT
        }
        val step = it.substring(1).toInt()
        secretEntrance.moveTo(direction, step)
    }

    secretEntrance.displayDefaultMethodPassword()
    secretEntrance.display0x434C49434BMethodPassword()
}