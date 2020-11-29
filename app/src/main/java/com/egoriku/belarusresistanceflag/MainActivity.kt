package com.egoriku.belarusresistanceflag

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.egoriku.belarusresistanceflag.databinding.ActivityMainBinding
import org.koin.androidx.scope.ScopeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ScopeActivity(R.layout.activity_main) {

    private val viewModel: MainViewModel by viewModel()

    private val binding by viewBinding(ActivityMainBinding::bind, R.id.home_root)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            viewModel.fetchFlags()
        }

        binding.homeBottomNavigation
            .setupWithNavController(
                (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
            )
    }
}