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

    val finalSum = giftShop.getInvalidSum()
    println("The invalid sum if $finalSum")
}