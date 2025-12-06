package dayTwo

enum class InvalidMethod {
    REPEATED_TWICE,
    REPEATED_AT_LEAST_TWICE
}

class Product(val id: String, val method: InvalidMethod) {

    fun isInvalid(): Boolean {
        if (method == InvalidMethod.REPEATED_TWICE) {
            return this.isInvalidForRepeatedTwiceMethod()
        }
        return this.isInvalidForRepeatedAtLeastTwiceMethod()
    }

    fun isInvalidForRepeatedTwiceMethod(): Boolean {
        val isOdd = id.length % 2 != 0

        if (isOdd) {
            return false
        }

        val sliceIndex = (id.length / 2) - 1
        val firstPart = id.slice(0..sliceIndex)
        val secondPart = id.slice(sliceIndex + 1..<id.length)

        return firstPart == secondPart
    }

    fun isInvalidForRepeatedAtLeastTwiceMethod(): Boolean {
        if(id.length == 1) {
            return false
        }

        val divisors = this.getDivisors(id.length)

        val repeatedSequences = mutableListOf<String>()

        for(divisor in divisors) {
            val numberOfRepetitions = id.length / divisor
            val repeatedSequence = id.take(divisor).repeat(numberOfRepetitions)
            repeatedSequences.add(repeatedSequence)
        }

        return repeatedSequences.any { it == id}
    }

    private fun getDivisors(number: Int): List<Int> {
        val divisors = mutableListOf(1)
        val numberHalf = number / 2

        for(divisor in 2..numberHalf) {
            if(number % divisor == 0) {
                divisors.add(divisor)
            }
        }

        return divisors
    }
}
