package dayTwo

class Product(val id: String) {

    fun isInvalid(): Boolean {
        val isOdd = id.length % 2 != 0

        if (isOdd) {
            return false
        }

        val sliceIndex = (id.length / 2) - 1
        val firstPart = id.slice(0..sliceIndex)
        val secondPart = id.slice(sliceIndex + 1..<id.length)

        return firstPart == secondPart
    }
}
