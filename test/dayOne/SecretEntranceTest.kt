package dayOne

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SecretEntranceTest {
    @Test
    fun `should be initialized with a pointed-counter at 0`() {
        val secretEntrance = SecretEntrance(3, 10, 3)

        assertEquals(0, secretEntrance.pointedCounter)
        assertEquals(3, secretEntrance.currentPosition)
    }

    @Test
    fun `should update position without incrementing the counter when moving to the right without a full rotation`() {
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
    fun `should update position without incrementing the counter when moving to the left without a full rotation`() {
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
    fun `should add one to the counter and stay at the same position after a full rotation`() {
        val secretEntrance = SecretEntrance(0, 20, 0)

        secretEntrance.moveTo(Direction.RIGHT, 21)
        secretEntrance.moveTo(Direction.RIGHT, 21)
        secretEntrance.moveTo(Direction.LEFT, 21)

        assertEquals(3, secretEntrance.pointedCounter)
        assertEquals(0, secretEntrance.currentPosition)
    }
}