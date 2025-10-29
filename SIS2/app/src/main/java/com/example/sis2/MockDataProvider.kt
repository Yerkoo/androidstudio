package com.example.sis2

object MockDataProvider {
    fun getPosts(): List<Post> {
        return listOf(
            Post(1, "Первый пост", "https://picsum.photos/600/400?random=1"),
            Post(2, "Второй пост", "https://picsum.photos/600/400?random=2"),
            Post(3, "Третий пост", "https://picsum.photos/600/400?random=3"),
            Post(4, "Четвёртый пост", "https://picsum.photos/600/400?random=4")
        )
    }
}
