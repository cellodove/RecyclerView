package com.cellodove.recyclerview.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.cellodove.recyclerview.R
import com.cellodove.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val viewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.liveFragmentStep.value = MainViewModel.FragmentStep.HOME
    }

    override fun onStart() {
        super.onStart()
        viewModel.liveFragmentStep.observe(this@MainActivity){ step ->
            supportFragmentManager.beginTransaction().run {
                when(step){
                    MainViewModel.FragmentStep.HOME -> replace(R.id.container,RecyclerAdapterFragment(),"home_fragment")
                    MainViewModel.FragmentStep.PROFILE_DETAIL -> replace(R.id.container, ListAdapterFragment(),"home_fragment")
                }
                addToBackStack(null)
                commit()
            }
        }
    }

    override fun onBackPressed() {
        val fm = supportFragmentManager
        if (fm.fragments[0] is RecyclerAdapterFragment) {
            finishAffinity()
            return
        }
        if (fm.fragments[0].childFragmentManager.backStackEntryCount>=2){
            fm.fragments[0].childFragmentManager.popBackStackImmediate()
        }else{
            super.onBackPressed()
        }
    }

}