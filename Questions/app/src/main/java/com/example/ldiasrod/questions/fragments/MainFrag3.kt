package com.example.ldiasrod.questions.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import com.example.ldiasrod.questions.R
import kotlinx.android.synthetic.main.fragment_main3.*
import kotlinx.android.synthetic.main.fragment_main3.view.*
import kotlinx.android.synthetic.main.item_view_pager_frag.view.*

class MainFrag3 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main3, container, false)

        val arrayList = ArrayList<String>()
        arrayList.add("Card 1")
        arrayList.add("Card 2")
        arrayList.add("Card 3")
        arrayList.add("Card 4")
        arrayList.add("Card 5")
        arrayList.add("Card 6")
        arrayList.add("Card 7")
        arrayList.add("Card 8")

        view.viewPager.clipToPadding = false
        view.viewPager.setPadding(100, 0, 100, 0)
        view.viewPager.offscreenPageLimit = 4
        view.viewPager.adapter = MyAdaper(arrayList, context!!)

        return view
    }

    internal class MyAdaper(private val list: ArrayList<String>, private val context: Context) : PagerAdapter() {

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val view = LayoutInflater.from(context).inflate(R.layout.item_view_pager_frag, container, false)
            view.cardText.text = list.get(position)
            container.addView(view)
            return view
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View?)
        }

        override fun isViewFromObject(p0: View, p1: Any): Boolean {
            return p0 == p1
        }

        override fun getCount(): Int {
            return list.size
        }

//        override fun getPageWidth(position: Int): Float {
//            return 0.93f
//        }

    }
}