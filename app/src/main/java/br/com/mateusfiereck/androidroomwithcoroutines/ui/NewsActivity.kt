package br.com.mateusfiereck.androidroomwithcoroutines.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import br.com.mateusfiereck.androidroomwithcoroutines.R

class NewsActivity : AppCompatActivity() {

	private val navController by lazy { findNavController(R.id.nav_host_fragment) }
	private val appBarConfiguration by lazy { AppBarConfiguration(navController.graph) }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_news)

		setupActionBarWithNavController(navController, appBarConfiguration)
	}

	override fun onSupportNavigateUp(): Boolean {
		return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
	}

}
