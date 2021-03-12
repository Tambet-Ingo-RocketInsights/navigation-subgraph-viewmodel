package ee.it.navigation.data

import android.content.Context
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavGraph
import androidx.navigation.NavType
import androidx.navigation.createGraph
import androidx.navigation.fragment.fragment

object DataNavGraph {
    private var idCounter = 100000

    internal val id = idCounter++

    private object dest {
        val dataFragment1 = idCounter++
        val dataFragment2 = idCounter++
    }

    internal object action {
        val toDataFragment2 = idCounter++
    }

    object args {
        const val data = "data"
    }

    fun create(context: Context, navController: NavController): NavGraph =
        navController.createGraph(id, dest.dataFragment1) {
            argument(args.data) {
                type = NavType.ParcelableType(MyData::class.java)
                nullable = false
            }

            fragment<DataFragment1>(dest.dataFragment1) {
                label = context.getString(R.string.data_fragment1_title)
                action(action.toDataFragment2) {
                    destinationId = dest.dataFragment2
                }
            }

            fragment<DataFragment2>(dest.dataFragment2) {
                label = context.getString(R.string.data_fragment2_title)
            }
        }

    fun directions(data: MyData): NavDirections = object : NavDirections {
        override fun getActionId(): Int = id
        override fun getArguments(): Bundle = bundleOf(args.data to data)
    }
}
