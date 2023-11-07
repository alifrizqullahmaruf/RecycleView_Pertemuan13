package com.example.recycleview_pertemuan10

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var newRecylerview: RecyclerView
    private lateinit var newArrayList: ArrayList<News>
    private lateinit var imageId: Array<Int>
    private lateinit var heading: Array<String>
    private lateinit var desc: Array<String>
    private lateinit var descFull: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize your imageId, heading, and desc arrays here
        imageId = arrayOf(
            R.drawable.python,
            R.drawable.java,
            R.drawable.kotlin,
            R.drawable.cplus2,
            R.drawable.csharp,
            R.drawable.js
        )

        heading = arrayOf(
            "Introduction to Python Programming",
            "Intermediate Java Programming",
            "Advanced Kotlin Development",
            "Mastering C++ for Professionals",
            "Intermediate C# Programming",
            "Web Development with JavaScript"
        )

        desc = arrayOf(
            "Python is a versatile and beginner-friendly programming language.",
            "Kotlin is a modern and concise language for Android app development.",
            "Java is a widely-used language for building cross-platform applications.",
            "C++ is a powerful language used in game development and system programming.",
            "C# is a language commonly used in game development with Unity.",
            "JavaScript is the primary language for web development and front-end scripting."
        )

        descFull = arrayOf(
            "Python is one of the most popular and versatile programming languages. This course is designed for beginners who want to learn the fundamentals of Python programming. Python is known for its simplicity and readability, making it an excellent choice for those new to programming. By taking this course, you will gain a strong foundation in Python, which is essential for a wide range of applications, including web development, data analysis, and more. Whether you're looking to start a career in programming or simply want to expand your skillset, this course is the ideal starting point.",
            "Java is a powerful and widely-used programming language with a broad range of applications. This intermediate-level course is perfect for those who already have some programming experience and want to dive deeper into Java development. You will explore advanced topics such as object-oriented programming, data structures, and more. By the end of this course, you will have the skills to build complex applications and work on various Java projects. Java's versatility and demand in the job market make it a valuable skill to acquire",
            "Kotlin is a modern and concise programming language, especially known for Android app development. In this advanced course, you will master the intricacies of Kotlin, enabling you to create efficient and elegant Android apps. Kotlin offers powerful features like null safety, extension functions, and more, making it a favorite among Android developers. By taking this course, you will be well-prepared to develop high-quality Android applications and excel in the competitive world of mobile app development.",
            "C++ is a versatile language, widely used in game development and systems programming. This course is designed for professionals and enthusiasts who want to master C++ for advanced applications. With C++, you can create high-performance software, games, and system-level applications. By taking this course, you will gain the expertise to work on demanding projects, optimize code for performance, and become a proficient C++ programmer",
            "C# is an intermediate-level course for those who want to dive deeper into C# programming. This language is commonly used in game development, especially with the Unity game engine. By completing this course, you will expand your knowledge of C# and be ready to tackle game development projects, create interactive 2D and 3D games, and explore the exciting world of game programming.",
            "JavaScript is the primary language for web development and front-end scripting. This course will introduce you to web development concepts and JavaScript programming. With JavaScript, you can create dynamic and interactive web applications. By taking this course, you will be well-equipped to work on web development projects, create stunning websites, and bring your creative ideas to life on the web."
        )


        newRecylerview = findViewById(R.id.recyclerView)
        newRecylerview.layoutManager = LinearLayoutManager(this)
        newRecylerview.setHasFixedSize(true)

        newArrayList = ArrayList()
        getUserdata()
    }

    private fun getUserdata() {
        for (i in imageId.indices) {
            val news = News(imageId[i], heading[i], desc[i])
            newArrayList.add(news)
        }

        var adapter = MyAdapter(newArrayList)
        newRecylerview.adapter = adapter

        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
//                Toast.makeText(this@MainActivity, "you clicked the course no $position", Toast.LENGTH_SHORT).show()

                val intent = Intent( this@MainActivity, MyCourse::class.java)
                intent.putExtra( "heading", newArrayList[position].heading)
                intent.putExtra( "imageId",newArrayList[position].titleImage)
                intent.putExtra( "news", descFull[position])
                startActivity(intent)
            }
            
        })
    }
}

