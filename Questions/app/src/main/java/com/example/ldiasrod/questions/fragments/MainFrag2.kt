package com.example.ldiasrod.questions.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.example.ldiasrod.questions.R
import kotlinx.android.synthetic.main.fragment_main2.view.*
import kotlinx.android.synthetic.main.item_list_frag2.view.*

class MainFrag2 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main2, container, false)

        val arrayList: ArrayList<String> = ArrayList()
        arrayList.add("Lucas")
        arrayList.add("Lucas")
        arrayList.add("Lucas")
        arrayList.add("Lucas")
        arrayList.add("Lucas")
        arrayList.add("Lucas")
        arrayList.add("Lucas")
        arrayList.add("Lucas")
        arrayList.add("Lucas")
        arrayList.add("Lucas")
        arrayList.add("Lucas")

        view.recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        //   recyclerView.addItemDecoration(DividerItemDecoration(context, VERTICAL))
        view.recyclerView.adapter = ListAdapter(arrayList, context!!)

        runLayoutAnimation(view.recyclerView)
        return view
    }


    private fun runLayoutAnimation(recyclerView: RecyclerView) {
        val context = recyclerView.context
        val controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down)

        recyclerView.layoutAnimation = controller
        recyclerView.adapter!!.notifyDataSetChanged()
        recyclerView.scheduleLayoutAnimation()
    }

    internal class ListAdapter(private val list: ArrayList<String>, private val context: Context) : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.name.text = list.get(position)
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.item_list_frag2, p0, false)

            return MyViewHolder(view)
        }


        class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val name = itemView.name
            val image = itemView.image
        }
    }
}