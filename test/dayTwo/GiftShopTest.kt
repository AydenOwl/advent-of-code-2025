package dayTwo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class GiftShopTest {

    @Nested
    inner class RepeatedTwiceMethod {
        @Test
        fun `should return 0 when the added range is valid`() {
            val giftShop = GiftShop()
            val aValidRange = ProductRange(12, 16)

            giftShop.addProductRange(aValidRange)

            assertEquals(0, giftShop.getInvalidSum(InvalidMethod.REPEATED_TWICE))
        }

        @Test
        fun `should return the sum of the invalid ids when the added range is invalid`() {
            val giftShop = GiftShop()
            val aRangeWithTwoInvalidIds = ProductRange(11, 22)

            giftShop.addProductRange(aRangeWithTwoInvalidIds)

            assertEquals(33, giftShop.getInvalidSum(InvalidMethod.REPEATED_TWICE))
        }

        @Test
        fun `should return the sum of each invalid ids in each range`() {
            val giftShop = GiftShop()
            val aRangeWithTwoInvalidIds = ProductRange(11, 22)
            val aValidRange = ProductRange(234, 238)
            val aRangeWithOneInvalidId = ProductRange(1188511880, 1188511890)

            giftShop.addProductRange(aRangeWithTwoInvalidIds)
            giftShop.addProductRange(aValidRange)
            giftShop.addProductRange(aRangeWithOneInvalidId)

            assertEquals(33 + 1188511885, giftShop.getInvalidSum(InvalidMethod.REPEATED_TWICE))
        }
    }

    @Nested
    inner class RepeatedAtLeastTwiceMethod {
        @Test
        fun `should return 0 when the added range is valid`() {
            val giftShop = GiftShop()
            val aValidRange = ProductRange(1, 10)

            giftShop.addProductRange(aValidRange)

            assertEquals(0, giftShop.getInvalidSum(InvalidMethod.REPEATED_AT_LEAST_TWICE))
        }

        @Test
        fun `should return the sum of the invalid ids when the added ranges contains invalid ids divisible by 2`() {
            val giftShop = GiftShop()
            val aRangeWithOneInvalidIdOfSizeTwo = ProductRange(21, 23)
            val aRangeWithOneInvalidIdOfSizeFour = ProductRange(1009, 1011)
            val aRangeWithOneInvalidIdOfSizeTen = ProductRange(2121212120, 2121212122)

            giftShop.addProductRange(aRangeWithOneInvalidIdOfSizeTwo)
            giftShop.addProductRange(aRangeWithOneInvalidIdOfSizeFour)
            giftShop.addProductRange(aRangeWithOneInvalidIdOfSizeTen)

            val expectedSum: Long = 22 + 1010 + 2121212121

            assertEquals(expectedSum, giftShop.getInvalidSum(InvalidMethod.REPEATED_AT_LEAST_TWICE))
        }

        @Test
        fun `should return the sum of each invalid ids in each range`() {
            val giftShop = GiftShop()

            giftShop.addProductRange(ProductRange(11, 22))
            giftShop.addProductRange(ProductRange(95, 115))
            giftShop.addProductRange(ProductRange(998, 1012))
            giftShop.addProductRange(ProductRange(1188511880, 1188511890))
            giftShop.addProductRange(ProductRange(222220, 222224))
            giftShop.addProductRange(ProductRange(1698522, 1698528))
            giftShop.addProductRange(ProductRange(446443, 446449))
            giftShop.addProductRange(ProductRange(38593856, 38593862))
            giftShop.addProductRange(ProductRange(565653, 565659))
            giftShop.addProductRange(ProductRange(824824821, 824824827))
            giftShop.addProductRange(ProductRange(2121212118, 2121212124))

            val expectedSum: Long =
                11L + 22 + 99 + 111 + 999 + 1010 + 1188511885 + 222222 + 446446 + 38593859 + 565656 + 824824824 + 2121212121
            assertEquals(expectedSum, giftShop.getInvalidSum(InvalidMethod.REPEATED_AT_LEAST_TWICE))
        }
    }
}