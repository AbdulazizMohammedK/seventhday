package com.android.seventhday
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
class MainActivity : AppCompatActivity() {
    private var frameLayout:FrameLayout ?= null
    private var bottomNavigation : BottomNavigationView? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        connectViews()
        bottomNavigationClick()
    }
    private fun bottomNavigationClick(){
        bottomNavigation?.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    chooseFragment(FirstFragment(),"Home")
                }
                R.id.person -> {
                    chooseFragment(SecondFragment(),"Person")
                }
                R.id.setting -> {
                    chooseFragment(ThirdFragment(),"Setting")
                }

            }
            true
        }
    }
    private fun connectViews(){
        frameLayout = findViewById(R.id.frameLayout)
        bottomNavigation = findViewById(R.id.nav)
    }
    private fun chooseFragment(fragment: androidx.fragment.app.Fragment,tag:String){
        val fragmentTransaction:androidx.fragment.app.FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,FirstFragment(),"Home")
        fragmentTransaction.commit()
    }
}