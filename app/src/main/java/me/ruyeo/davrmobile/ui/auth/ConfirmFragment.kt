package me.ruyeo.davrmobile.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import me.ruyeo.davrmobile.R
import me.ruyeo.davrmobile.databinding.FragmentConfirmBinding
import me.ruyeo.davrmobile.utils.viewBinding

class ConfirmFragment : Fragment(R.layout.fragment_confirm) {
    private val binding: FragmentConfirmBinding by viewBinding { FragmentConfirmBinding.bind(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}