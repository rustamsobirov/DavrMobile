package me.ruyeo.davrmobile.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import me.ruyeo.davrmobile.R
import me.ruyeo.davrmobile.adapter.OperationsAdapter
import me.ruyeo.davrmobile.databinding.FragmentMyCardsBinding
import me.ruyeo.davrmobile.model.Operations
import me.ruyeo.davrmobile.utils.viewBinding
import java.util.ArrayList

class MyCardsFragment : Fragment(R.layout.fragment_my_cards) {
    private val binding: FragmentMyCardsBinding by viewBinding { FragmentMyCardsBinding.bind(it) }
    private lateinit var adapter: OperationsAdapter
    private lateinit var list: ArrayList<Operations>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
    }

    private fun setupUI() {
        list = ArrayList()
        list.add(Operations(R.drawable.ic_e_bike_line_1,"Amtrak","21/6, 4PM","-$3"))
        list.add(Operations(R.drawable.ic_t_shirt_2_line_1,"Redtag","21/6, 4PM","-$57.50"))
        list.add(Operations(R.drawable.ic_restaurant_line_1,"OOO ”Restaruant”","21/6, 4PM","-$23"))
        list.add(Operations(R.drawable.ic_restaurant_line_1,"Five Guys","21/6, 4PM","-$19"))
        list.add(Operations(R.drawable.ic_gamepad_line_1,"Microsoft","21/6, 4PM","-$41"))
        adapter = OperationsAdapter(requireContext(),list)
        var layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerview.layoutManager = layoutManager
        binding.recyclerview.adapter = adapter
    }
}