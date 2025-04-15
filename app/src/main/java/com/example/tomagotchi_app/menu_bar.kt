package com.example.tomagotchi_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private val Frag1 = FirstFragment()
private val Frag2 = SecondFragment()
private val Frag3 = ThirdFragment()
private val Frag4 = fragment_fourth()

class menu_bar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
            replaceFrag(Frag1)
            val bottomBar = findViewById<BottomNavigationView>(R.id.NavBar)
            bottomBar.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.feeding -> replaceFrag(Frag2)
                    R.id.wrestle -> replaceFrag(Frag3)
                    R.id.cool -> replaceFrag(Frag4)
                }
                true
            }
        }
        private fun replaceFrag(fragment: Fragment) {
            if (fragment != null) {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frameLayout, fragment)
                transaction.commit()
            }
        }
    }
