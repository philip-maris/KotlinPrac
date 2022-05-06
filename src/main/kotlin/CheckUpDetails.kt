data class CheckUpDetails(
    var medications : Array<Medications>,
    var labs : Array<Labs> ,
    var imaging : Array<Imaging>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CheckUpDetails

        if (!medications.contentEquals(other.medications)) return false
        if (!labs.contentEquals(other.labs)) return false
        if (!imaging.contentEquals(other.imaging)) return false


        return true
    }

    override fun hashCode(): Int {
        var result = medications.contentHashCode()
        result = 31 * result + labs.hashCode()
        result = 31 * result + imaging.hashCode()
        return result
    }
}
