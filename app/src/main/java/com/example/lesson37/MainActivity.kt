package com.example.lesson37

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_a)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, FragmentA())
            .commit()
    }
}