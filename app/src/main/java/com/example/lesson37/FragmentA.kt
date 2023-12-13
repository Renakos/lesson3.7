package com.example.lesson37

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lesson37.databinding.FragmentABinding

class FragmentA : Fragment() {

    private val adapter = Adapter()
    private lateinit var binding: FragmentABinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        clickButton()
        dataTransfer()
    }

    private fun initRecycler() {
        binding.recyclerView.adapter = adapter
    }

    private fun clickButton() {
        binding.button.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, FragmentC())
                .addToBackStack("")
                .commit()
        }
    }

    private fun dataTransfer() {
        arguments?.let {
            val image = it.getString(FragmentC.IMAGE_KEY)
            val name = it.getString(FragmentC.NAME_KEY)
            Log.e("TAG", "dataTransfer ")
            if (image != null && name != null) {
                val game = Game(name, image)
                SafeList.gameList.add(game)
                Log.e("TAG", "dataTransfer: ${game.name} ")
                adapter.addImage(SafeList.gameList)
            }
        }
    }
}