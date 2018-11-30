package com.example.ldiasrod.questions

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.ldiasrod.questions.fragments.MainFrag1
import com.example.ldiasrod.questions.fragments.MainFrag2
import com.example.ldiasrod.questions.fragments.MainFrag3
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBar(toolbar)

        openFragment(MainFrag1(), "Frag1")

        bottomBar.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.item1 ->
                    openFragment(MainFrag1(), "Frag1")
                R.id.item2 ->
                    openFragment(MainFrag2(), "Frag2")
                R.id.item3 ->
                    openFragment(MainFrag3(), "Frag3")
                R.id.item4 ->
                    openFragment(MainFrag2(), "Frag2")
                R.id.item5 ->
                    openFragment(MainFrag1(), "Frag1")
                else ->
                    openFragment(MainFrag1(), "Frag1")
            }
            true
        }
    }

    fun openFragment(fragment: Fragment, tag: String) {
        val transaction = supportFragmentManager.beginTransaction()
     //   transaction.addToBackStack(tag)
        transaction.setCustomAnimations(R.animator.fade_in, R.animator.fade_out)
        transaction.replace(R.id.frameLayout, fragment, tag)
        transaction.commitAllowingStateLoss()
    }
}
