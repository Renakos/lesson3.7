package com.example.lesson37

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lesson37.databinding.FragmentCBinding


class FragmentC : Fragment() {

    private lateinit var binding: FragmentCBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnAddClick()
    }

    private fun btnAddClick() = with(binding) {
        addButton.setOnClickListener {
            val name = textInput.text.toString().trim()
            val image = imageUrlInput.text.toString().trim()

            if (name.isNotEmpty() && image.isNotEmpty()) {
                val arguments = Bundle()
                arguments.putString(NAME_KEY, name)
                arguments.putString(IMAGE_KEY, image)

                parentFragmentManager.beginTransaction()
                    .add(R.id.container, FragmentA::class.java, arguments)
                    .commit()
            }
        }
    }

    companion object {
        const val NAME_KEY = "name"
        const val IMAGE_KEY = "image"
    }
}