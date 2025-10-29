package com.example.sis2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PostAdapter
    private var posts = mutableListOf<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        posts = if (savedInstanceState != null) {
            savedInstanceState.getParcelableArrayList<Post>("posts")?.toMutableList() ?: MockDataProvider.getPosts().toMutableList()
        } else {
            MockDataProvider.getPosts().toMutableList()
        }

        adapter = PostAdapter(posts)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList("posts", ArrayList(posts))
    }
}
