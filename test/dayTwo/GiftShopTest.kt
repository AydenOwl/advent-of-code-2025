package dayTwo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GiftShopTest {
    @Test
    fun `should return 0 when the added range is valid`() {
        var giftShop = GiftShop()
        var aValidRange = ProductRange(12, 16)

        giftShop.addProductRange(aValidRange)

        assertEquals(0, giftShop.getInvalidSum())
    }

    @Test
    fun `should return the sum of the invalid ids when the added range is invalid`() {
        var giftShop = GiftShop()
        var aRangeWithTwoInvalidIds = ProductRange(11, 22)

        giftShop.addProductRange(aRangeWithTwoInvalidIds)

        assertEquals(33, giftShop.getInvalidSum())
    }

    @Test
    fun `should return the sum of each invalid ids in each range`() {
        var giftShop = GiftShop()
        var aRangeWithTwoInvalidIds = ProductRange(11, 22)
        var aValidRange = ProductRange(234, 238)
        var aRangeWithOneInvalidId = ProductRange(1188511880, 1188511890)

        giftShop.addProductRange(aRangeWithTwoInvalidIds)
        giftShop.addProductRange(aValidRange)
        giftShop.addProductRange(aRangeWithOneInvalidId)

        assertEquals(33 + 1188511885, giftShop.getInvalidSum())
    }
}