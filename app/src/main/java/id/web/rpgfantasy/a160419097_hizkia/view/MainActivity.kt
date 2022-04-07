package id.web.rpgfantasy.a160419097_hizkia.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import id.web.rpgfantasy.a160419097_hizkia.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = (supportFragmentManager.findFragmentById(R.id.hostFragment) as NavHostFragment).navController
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(navView, navController)
        bottomNav.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _->
            when (destination.id) {
                R.id.itemHome -> showBottomNav()
                R.id.itemFav -> showBottomNav()
                R.id.itemProfile -> showBottomNav()
                else -> hideBottomNav()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(drawerLayout) || super.onSupportNavigateUp()
    }

    private fun showBottomNav() {
        bottomNav.visibility = View.VISIBLE

    }

    private fun hideBottomNav() {
        bottomNav.visibility = View.GONE

    }
}