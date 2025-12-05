package dayTwo

class GiftShop() {
    var productRanges: MutableList<ProductRange> = mutableListOf<ProductRange>()

    fun addProductRange(productRange: ProductRange): Unit {
        productRanges.add(productRange)
    }

    fun getInvalidSum(): Long {
        var sum: Long = 0
        for (range in productRanges) {
            sum += range.getInvalidSum()
        }

        return sum
    }
}