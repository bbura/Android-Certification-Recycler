package com.example.androidcertificationrecyclerview


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class WordListAdapter(private val context: Context, val mWordList: LinkedList<String>) :
    RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WordListAdapter.WordViewHolder {
        val mItemView: View = LayoutInflater.from(context).inflate(
            R.layout.wordlist_item,
            parent, false
        )

        return WordViewHolder(mItemView, this)
    }

    override fun onBindViewHolder(holder: WordListAdapter.WordViewHolder, position: Int) {
        holder.wordItemView?.text = mWordList[position]
    }

    override fun getItemCount() = mWordList.size

    inner class WordViewHolder(val view2: View, private val mAdapter: WordListAdapter) :
        RecyclerView.ViewHolder(view2), View.OnClickListener  {
        val wordItemView: TextView? = view2.findViewById(R.id.word)

        init {
            view2.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val mPosition = layoutPosition
            val element = mWordList[mPosition]
            mWordList[mPosition] = "Clicked! $element"
            mAdapter.notifyDataSetChanged()
        }
    }
}