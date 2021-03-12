package ee.it.navigation

import android.content.Context
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavGraph
import androidx.navigation.NavType
import androidx.navigation.createGraph
import androidx.navigation.fragment.fragment
import ee.it.navigation.data.DataNavGraph
import ee.it.navigation.data.MyData
import ee.it.navigation.data.SingleFragment

object AppNavGraph {
    private var idCounter = 100
    private val id = idCounter++

    private object dest {
        val homeFragment = idCounter++
        val singleFragment = idCounter++
    }

    fun create(context: Context, navController: NavController): NavGraph =
        navController.createGraph(id, dest.homeFragment) {
            fragment<HomeFragment>(dest.homeFragment) {
                label = context.getString(R.string.home_title)
            }

            fragment<SingleFragment>(dest.singleFragment) {
                label = context.getString(R.string.single_title)

                argument(DataNavGraph.args.data) {
                    type = NavType.ParcelableType(MyData::class.java)
                    nullable = false
                }
            }
        }

    fun singleDirections(data: MyData): NavDirections = object : NavDirections {
        override fun getActionId(): Int = dest.singleFragment
        override fun getArguments(): Bundle = bundleOf(DataNavGraph.args.data to data)
    }
}