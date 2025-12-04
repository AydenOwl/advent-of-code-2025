package dayOne

import java.io.File

enum class Direction {
    LEFT, RIGHT
}

class SecretEntrance(val pointedNumber: Int, val maximumDialValue: Int, val startingPosition: Int) {
    var pointedCounter: Int = 0
    var currentPosition: Int = startingPosition

    fun moveTo(direction: Direction, step: Int): Unit {
        val numberOfStepsToDoAFullRotation = maximumDialValue + 1
        val stepWithoutRotations = step % numberOfStepsToDoAFullRotation

        if (direction === Direction.RIGHT) {
            currentPosition = (currentPosition + stepWithoutRotations) % numberOfStepsToDoAFullRotation

        } else {
            val leftStepConvertedToRightStep = numberOfStepsToDoAFullRotation - stepWithoutRotations
            currentPosition = (currentPosition + leftStepConvertedToRightStep) % numberOfStepsToDoAFullRotation
        }

        if (currentPosition == pointedNumber) {
            pointedCounter++
        }
    }
}