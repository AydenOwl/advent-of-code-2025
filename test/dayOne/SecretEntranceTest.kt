package dayOne

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class SecretEntranceTest {
    @Test
    fun `should be initialized with a pointed-counter at 0`() {
        val secretEntrance = SecretEntrance(3, 10, 3)

        assertEquals(0, secretEntrance.pointedCounter)
        assertEquals(3, secretEntrance.currentPosition)
    }

    @Nested
    inner class DefaultMethod {
        @Test
        fun `should update position without incrementing the dial-pointed counter when moving to the right without a full rotation`() {
            val secretEntrance = SecretEntrance(0, 20, 0)

            secretEntrance.moveTo(Direction.RIGHT, 5)
            secretEntrance.moveTo(Direction.RIGHT, 7)

            assertEquals(0, secretEntrance.pointedCounter)
            assertEquals(12, secretEntrance.currentPosition)
        }

        @Test
        fun `should start back at zero when moving to the right with a step exceeding the maximum dial value`() {
            val aMaximumDialValue = 4
            val secretEntrance = SecretEntrance(0, aMaximumDialValue, 4)

            val step = 5
            val stepWithThreeFullRotations = step + (aMaximumDialValue * 3)
            secretEntrance.moveTo(Direction.RIGHT, stepWithThreeFullRotations)

            assertEquals(0, secretEntrance.pointedCounter)
            assertEquals(1, secretEntrance.currentPosition)
        }

        @Test
        fun `should update position without incrementing the dial-pointed counter when moving to the left without a full rotation`() {
            val secretEntrance = SecretEntrance(0, 6, 4)

            secretEntrance.moveTo(Direction.LEFT, 3)

            assertEquals(0, secretEntrance.pointedCounter)
            assertEquals(1, secretEntrance.currentPosition)
        }

        @Test
        fun `should start back at maximum dial value when moving to the left with a step exceeding the initial 0 dial value`() {
            val aMaximumValue = 7
            val secretEntrance = SecretEntrance(0, aMaximumValue, 2)

            val step = 5
            val stepWithTwoFullRotations = step + (aMaximumValue * 2)
            secretEntrance.moveTo(Direction.LEFT, stepWithTwoFullRotations)

            assertEquals(0, secretEntrance.pointedCounter)
            assertEquals(7, secretEntrance.currentPosition)
        }

        @Test
        fun `should add one to the dial-pointed counter and stay at the same position after a full rotation`() {
            val secretEntrance = SecretEntrance(0, 20, 0)

            secretEntrance.moveTo(Direction.RIGHT, 21)
            secretEntrance.moveTo(Direction.RIGHT, 21)
            secretEntrance.moveTo(Direction.LEFT, 21)

            assertEquals(3, secretEntrance.pointedCounter)
            assertEquals(0, secretEntrance.currentPosition)
        }
    }

    @Nested
    inner class Method0x434C49434B {
        @Test
        fun `should increment the clicked counter for each full rotation`() {
            val secretEntrance = SecretEntrance(0, 20, 7)

            val fullRotation = 21

            secretEntrance.moveTo(Direction.RIGHT, fullRotation)
            secretEntrance.moveTo(Direction.LEFT, fullRotation)
            secretEntrance.moveTo(Direction.RIGHT, fullRotation)

            assertEquals(3, secretEntrance.clickedCounter)
            assertEquals(0, secretEntrance.pointedCounter)
            assertEquals(7, secretEntrance.currentPosition)
        }

        @Test
        fun `should increment the clicked counter when pointing without stopping after moving to the right`() {
            val secretEntrance = SecretEntrance(0, 20, 17)

            secretEntrance.moveTo(Direction.RIGHT, 6)
            secretEntrance.moveTo(Direction.RIGHT, 3)

            assertEquals(1, secretEntrance.clickedCounter)
            assertEquals(0, secretEntrance.pointedCounter)
            assertEquals(5, secretEntrance.currentPosition)
        }

        @Test
        fun `should increment the clicked counter when pointing without stopping after moving to the left`() {
            val secretEntrance = SecretEntrance(0, 20, 2)

            secretEntrance.moveTo(Direction.LEFT, 5)
            secretEntrance.moveTo(Direction.LEFT, 2)

            assertEquals(1, secretEntrance.clickedCounter)
            assertEquals(0, secretEntrance.pointedCounter)
            assertEquals(16, secretEntrance.currentPosition)
        }
    }
}