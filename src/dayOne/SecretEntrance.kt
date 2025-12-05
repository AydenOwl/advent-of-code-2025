package dayOne

enum class Direction {
    LEFT, RIGHT
}

class SecretEntrance(val pointedNumber: Int, val maximumDialValue: Int, val startingPosition: Int) {
    var pointedCounter: Int = 0
    var clickedCounter: Int = 0
    var currentPosition: Int = startingPosition
    val numberOfStepsToDoAFullRotation: Int = maximumDialValue + 1

    fun moveTo(direction: Direction, step: Int): Unit {
        val stepWithoutRotations = step % numberOfStepsToDoAFullRotation
        val numberOfFullRotations = step / numberOfStepsToDoAFullRotation

        clickedCounter += numberOfFullRotations

        val stepConvertedToRightStep =
            if (direction == Direction.RIGHT) stepWithoutRotations else numberOfStepsToDoAFullRotation - stepWithoutRotations

        val oldPosition: Int = currentPosition
        currentPosition = (currentPosition + stepConvertedToRightStep) % numberOfStepsToDoAFullRotation

        val hasClicked = this.hasClicked(direction, oldPosition)

        if(hasClicked) {
            clickedCounter++
        }

        if (currentPosition == pointedNumber) {
            pointedCounter++
        }
    }

    private fun hasClicked(direction: Direction, oldPosition: Int): Boolean {
        if(oldPosition == pointedNumber || currentPosition == pointedNumber) {
            return false
        }

        if(direction == Direction.RIGHT) {
            return oldPosition > currentPosition
        }

        return oldPosition < currentPosition
    }

    fun displayDefaultMethodPassword(): Unit {
        println("The door password with default method is $pointedCounter")
    }

    fun display0x434C49434BMethodPassword(): Unit {
        println("The door password with method 0x434C49434B is ${clickedCounter + pointedCounter}")
    }
}