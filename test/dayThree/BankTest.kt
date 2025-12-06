package dayThree

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BankTest {

    @Test
    fun `should power up the first two`() {
        val bank = Bank()
        bank.addBattery(Battery(9))
        bank.addBattery(Battery(8))
        bank.addBattery(Battery(7))
        bank.addBattery(Battery(6))
        bank.addBattery(Battery(5))
        bank.addBattery(Battery(4))

        assertEquals(98, bank.getJoltage())
    }

    @Test
    fun `should power up the first one and the last one`() {
        val bank = Bank()
        bank.addBattery(Battery(8))
        bank.addBattery(Battery(1))
        bank.addBattery(Battery(1))
        bank.addBattery(Battery(1))
        bank.addBattery(Battery(9))

        assertEquals(89, bank.getJoltage())
    }

    @Test
    fun `should power up the last two ones`() {
        val bank = Bank()
        bank.addBattery(Battery(2))
        bank.addBattery(Battery(3))
        bank.addBattery(Battery(7))
        bank.addBattery(Battery(2))
        bank.addBattery(Battery(7))
        bank.addBattery(Battery(8))

        assertEquals(78, bank.getJoltage())
    }

    @Test
    fun `should power up the middle ones`() {
        val bank = Bank()
        bank.addBattery(Battery(8))
        bank.addBattery(Battery(1))
        bank.addBattery(Battery(8))
        bank.addBattery(Battery(1))
        bank.addBattery(Battery(9))
        bank.addBattery(Battery(1))
        bank.addBattery(Battery(1))
        bank.addBattery(Battery(4))
        bank.addBattery(Battery(2))
        bank.addBattery(Battery(1))

        assertEquals(94, bank.getJoltage())
    }
}