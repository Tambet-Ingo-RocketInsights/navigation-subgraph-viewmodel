package ee.it.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import ee.it.navigation.data.DataNavGraph
import ee.it.navigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(ActivityMainBinding.inflate(layoutInflater)) {
            setContentView(root)

            setSupportActionBar(toolbar)

            val f = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            val navController = f.navController

            navController.graph = AppNavGraph.create(this@MainActivity, navController)
            navController.graph.addDestination(DataNavGraph.create(this@MainActivity, navController))

            val appBarConfiguration = AppBarConfiguration(navController.graph)
            toolbar.setupWithNavController(navController, appBarConfiguration)
        }
    }
}