package dayTwo

import java.io.File

fun main() {
    val giftShop = GiftShop()

    File("input_gift_shop.txt").forEachLine {
        val rawRanges = it.split(',')

        for (rawRange in rawRanges) {
            val rawProductIds = rawRange.split('-')
            val productRange = ProductRange(rawProductIds[0].toLong(), rawProductIds[1].toLong())
            giftShop.addProductRange(productRange)
        }

    }

    println("The invalid sum of repeated twice method is ${giftShop.getInvalidSum(InvalidMethod.REPEATED_TWICE)}")
    println("The invalid sum of repeated at least twice method is ${giftShop.getInvalidSum(InvalidMethod.REPEATED_AT_LEAST_TWICE)}")
}