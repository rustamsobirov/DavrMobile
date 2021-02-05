package me.ruyeo.davrmobile.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import me.ruyeo.davrmobile.R
import me.ruyeo.davrmobile.databinding.FragmentHomeBinding
import me.ruyeo.davrmobile.utils.viewBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private val binding: FragmentHomeBinding by viewBinding { FragmentHomeBinding.bind(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}