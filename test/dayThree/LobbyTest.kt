package dayThree

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LobbyTest {
    @Test
    fun `should sum total joltage from providers`() {
        var lobby = Lobby()

        lobby.addJoltageProvider(FakeProviderFromJoltage(98))
        lobby.addJoltageProvider(FakeProviderFromJoltage(89))
        lobby.addJoltageProvider(FakeProviderFromJoltage(78))
        lobby.addJoltageProvider(FakeProviderFromJoltage(92))

        assertEquals(357, lobby.getTotalJoltageFromProviders())
    }
}

class FakeProviderFromJoltage(var power: Int): JoltageProvider {
    override fun getJoltage(): Int {
        return power
    }
}