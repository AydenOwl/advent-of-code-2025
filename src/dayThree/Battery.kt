package dayThree

class Battery(val power: Int): JoltageProvider {
    init {
        require(power in 0..<10) {
            "A battery has a value between 1 and 9. $power is a invalid value."
        }
    }

    override fun getJoltage(): Int {
        return power
    }

    fun hasMorePowerThan(comparedBattery: Battery): Boolean {
        return power > comparedBattery.power
    }
}