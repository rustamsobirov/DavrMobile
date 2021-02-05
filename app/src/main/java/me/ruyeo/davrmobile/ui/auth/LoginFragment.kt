package me.ruyeo.davrmobile.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import me.ruyeo.davrmobile.R
import me.ruyeo.davrmobile.databinding.FragmentLoginBinding
import me.ruyeo.davrmobile.ui.MainActivity
import me.ruyeo.davrmobile.utils.viewBinding

class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var navController: NavController
    private val binding: FragmentLoginBinding by viewBinding { FragmentLoginBinding.bind(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        setupUI()

    }

    private fun setupUI() {
        binding.loginBtn.setOnClickListener {
            binding.progressbar.visibility = View.VISIBLE
            binding.loginBtn.visibility = View.INVISIBLE
            val timer: Thread = object : Thread() {
                override fun run() {
                    try {
                        //Display for 3 seconds
                        sleep(3000)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    } finally {
                        Intent(requireContext(),MainActivity::class.java).also {
                            startActivity(it)
                            activity?.finish()
                        }
                    }
                }
            }
            timer.start()
        }

        binding.registrationBtn.setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_registrationFragment)
        }
    }
}