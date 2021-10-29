package mars.calc.calcver1.mycalcmipt.feature_calc.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Operation(
    val num1: Double,
    val num2: Double,
    val sign: Sign,
    var eq: Double? = null,
    @PrimaryKey
    val id: Int?= null
)
