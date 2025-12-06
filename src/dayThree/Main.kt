package dayThree

import java.io.File

fun main() {
    val lobby = Lobby()

    File("input_lobby.txt").forEachLine {
        val bank = Bank()

        for(char in it) {
            bank.addBattery(Battery(char.digitToInt()))
        }

        lobby.addJoltageProvider(bank)
    }

    println("The lobby maximum joltage is ${lobby.getTotalJoltageFromProviders()}")
}