package dayThree

class Bank: JoltageProvider {
    var batteries: MutableList<Battery> = mutableListOf()

    fun addBattery(battery: Battery) {
        batteries.add(battery)
    }

    override fun getJoltage(): Int {
        var firstHighestBatteryIndex = 0
        var firstHighestBattery = batteries[0]

        for((index, battery) in batteries.withIndex()) {
            val isLastBattery = index == batteries.size - 1

            if(isLastBattery) {
                break
            }

            if(battery.hasMorePowerThan(firstHighestBattery)) {
                firstHighestBattery = battery
                firstHighestBatteryIndex = index
            }
        }

        var secondMaximumBattery = batteries[firstHighestBatteryIndex + 1]

        for(battery in batteries.subList(firstHighestBatteryIndex + 1, batteries.size)) {
            if(battery.hasMorePowerThan(secondMaximumBattery)) {
                secondMaximumBattery = battery
            }
        }

        val joltage: String = firstHighestBattery.getJoltage().toString() + secondMaximumBattery.getJoltage().toString()
        return joltage.toInt()
    }
}