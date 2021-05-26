package com.kyrgyzbilim.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kyrgyzbilim.R
import com.kyrgyzbilim.data.remote.topic.Topic
import com.kyrgyzbilim.ui.courses.sections.SectionsFragment
import kotlinx.android.synthetic.main.item_sections.view.*
import kotlinx.android.synthetic.main.item_themes.view.*


class ThemesAdapter : ListAdapter<Topic, ThemesAdapter.ThemeViewHolder>(DIFF) {
    private lateinit var onClickListener: ThemesOnClickListener
    private lateinit var items: List<Topic>
    private lateinit var framentManager: FragmentManager



    companion object{
        val DIFF  = object: DiffUtil.ItemCallback<Topic>(){
            override fun areItemsTheSame(oldItem: Topic, newItem: Topic): Boolean {
                return oldItem.id == newItem.id
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: Topic, newItem: Topic): Boolean {
                return oldItem == newItem
            }
        }
    }

    fun setData(
        onClickListener: ThemesOnClickListener,
        items: List<Topic>?,
        framentManager: FragmentManager,
    ){
        this.onClickListener = onClickListener
        if (items != null) {
            this.items = items
        }
        this.framentManager = framentManager
    }

    inner class ThemeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun onBind(position: Int){
            val currentTheme = getItem(position)

            val themesRV = itemView.themes_RV

            itemView.theme_title.text = items[position].name


            itemView.setOnClickListener{
                onClickListener.onClickTheme(position)
            }

            val sectionsFragment: Fragment = SectionsFragment()
            itemView.theme_title.setOnClickListener{
                framentManager.beginTransaction()
                    .setCustomAnimations(
                        R.animator.slide_in_left,
                        R.animator.slide_out_right, 0, 0
                    )
                    .replace(R.id.fragment_home, sectionsFragment)
                    .addToBackStack(null)
                    .commit()

            }

        }
    }

    fun getItemAtPos(position: Int): Topic {
        return getItem(position)
    }


    interface ThemesOnClickListener {
        fun onClickTheme(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThemeViewHolder {
        return ThemeViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_themes,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ThemeViewHolder, position: Int) {
        holder.onBind(position)
    }
}