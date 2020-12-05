package com.example.androidcertificationrecyclerview

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*


class MainActivity : AppCompatActivity() {

    private val mWordList: LinkedList<String> = LinkedList()
    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: WordListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            val wordListSize = mWordList.size
            // Add a new word to the wordList.
            // Add a new word to the wordList.
            mWordList.addLast("+ Word $wordListSize")
            // Notify the adapter, that the data has changed.
            // Notify the adapter, that the data has changed.
            mRecyclerView!!.adapter!!.notifyItemInserted(wordListSize)
            // Scroll to the bottom.
            // Scroll to the bottom.
            mRecyclerView!!.smoothScrollToPosition(wordListSize)
        }

        for (i in 0..19) {
            mWordList.addLast("Word $i")
        }

        mRecyclerView = findViewById(R.id.recyclerview)
        mAdapter = WordListAdapter(this, mWordList)

        mRecyclerView?.run { adapter = mAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }



    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}