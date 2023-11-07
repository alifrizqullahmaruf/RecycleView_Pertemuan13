package com.example.recycleview_pertemuan10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MyCourse : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_course)

        val headingNews: TextView = findViewById(R.id.heading)
        val mainNews: TextView = findViewById(R.id.descFull)
        val imageNews: ImageView = findViewById(R.id.image_heading)

        val bundle: Bundle? = intent.extras
        val heading = bundle?.getString("heading")
        val imageld = bundle?.getInt("imageId")
        val descFull = bundle?.getString("descFull")

        if (heading != null && imageld != null && descFull != null) {
            headingNews.text = heading
            mainNews.text = descFull
            imageNews.setImageResource(imageld)
        }
    }
}
