data class Medications(
    var antianginal : Array<DrugType>,
    var anticoagulants : Array<DrugType>,
    var betaBlocker : Array<DrugType>,
    var aceInhibitors : Array<DrugType>,
    var diuretic : Array<DrugType>,
    var mineral : Array<DrugType>,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Medications

        if (!antianginal.contentEquals(other.antianginal)) return false
        if (!anticoagulants.contentEquals(other.anticoagulants)) return false
        if (!betaBlocker.contentEquals(other.betaBlocker)) return false
        if (!aceInhibitors.contentEquals(other.aceInhibitors)) return false
        if (!diuretic.contentEquals(other.diuretic)) return false
        if (!mineral.contentEquals(other.mineral)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = antianginal.contentHashCode()
        result = 31 * result + anticoagulants.contentHashCode()
        result = 31 * result + betaBlocker.contentHashCode()
        result = 31 * result + aceInhibitors.contentHashCode()
        result = 31 * result + diuretic.contentHashCode()
        result = 31 * result + mineral.contentHashCode()
        return result
    }
}
