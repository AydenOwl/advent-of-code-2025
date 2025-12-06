package dayThree

class Lobby {
    var joltageProviders: MutableList<JoltageProvider> = mutableListOf()

    fun addJoltageProvider(joltageProvider: JoltageProvider) {
        joltageProviders.add(joltageProvider)
    }

    fun getTotalJoltageFromProviders(): Int {
        var sum = 0

        for(provider in joltageProviders) {
            sum += provider.getJoltage()
        }

        return sum
    }
}