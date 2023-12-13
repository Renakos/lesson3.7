package com.example.lesson37

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentB : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_b, container, false)
        val name = arguments?.getString("name")
        val imageUrl = arguments?.getString("image")
        val titleTextView = view.findViewById<TextView>(R.id.name)
        val imageView = view.findViewById<ImageView>(R.id.image)
        titleTextView.text = name
        imageView.setImageURI(Uri.parse(imageUrl))

        return view
    }
}
