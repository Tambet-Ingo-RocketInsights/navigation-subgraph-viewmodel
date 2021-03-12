package ee.it.navigation.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MyData(
    val name: String,
    val amount: Int
) : Parcelable
