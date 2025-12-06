package dayTwo

class ProductRange(val firstProductId: Long, val lastProductId: Long) {

    fun getInvalidSum(invalidMethod: InvalidMethod): Long {
        var sum: Long = 0

        for (id in firstProductId..lastProductId) {
            val product = Product(id.toString(), invalidMethod)

            if(product.isInvalid()) {
                sum += id
            }
        }
        return sum
    }
}
