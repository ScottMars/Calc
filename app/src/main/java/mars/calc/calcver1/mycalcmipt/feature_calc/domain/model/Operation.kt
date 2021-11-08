package mars.calc.calcver1.mycalcmipt.feature_calc.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Operation(
    val expr: String,
    @PrimaryKey
    val id: Int? = null
)
