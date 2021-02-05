package me.ruyeo.davrmobile.ui.auth

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import me.ruyeo.davrmobile.R
import me.ruyeo.davrmobile.databinding.DialogConditionsBinding
import me.ruyeo.davrmobile.databinding.FragmentRegistrationBinding
import me.ruyeo.davrmobile.ui.MainActivity
import me.ruyeo.davrmobile.utils.DateInputMask
import me.ruyeo.davrmobile.utils.viewBinding
import java.text.SimpleDateFormat
import java.util.*

class RegistrationFragment : Fragment(R.layout.fragment_registration) {
    private val binding: FragmentRegistrationBinding by viewBinding { FragmentRegistrationBinding.bind(it) }
    private lateinit var bindingDialog: DialogConditionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()


    }

    private fun setupUI() {

        DateInputMask(binding.birthdate)
        binding.checkbox.setOnClickListener {
            if (binding.checkbox.isChecked){
                showDialog()
            }else {
                binding.checkbox.isChecked = false
            }

        }

        binding.registerBtn.setOnClickListener {
            when {
                binding.username.text.isNullOrEmpty() -> {
                    binding.username.requestFocus()
                }
                binding.birthdate.text.isNullOrEmpty() || binding.birthdate.text.contains("Y") -> {
                    binding.birthdate.requestFocus()
                }
                binding.phone.text.isNullOrEmpty() -> {
                    binding.phone.requestFocus()
                }
                binding.password.text.isNullOrEmpty() -> {
                    binding.password.requestFocus()
                }
                !binding.checkbox.isChecked ->{
                    binding.checkbox.requestFocus()
                }
                else -> {
                    binding.progressbar.visibility = View.VISIBLE
                    binding.registerBtn.visibility = View.INVISIBLE
                    val timer: Thread = object : Thread() {
                        override fun run() {
                            try {
                                //Display for 3 seconds
                                sleep(3000)
                            } catch (e: InterruptedException) {
                                e.printStackTrace()
                            } finally {
                                Intent(requireContext(), MainActivity::class.java).also {
                                    startActivity(it)
                                    activity?.finish()
                                }
                            }
                        }
                    }
                    timer.start()
                    }
                }
            }

        }


    @SuppressLint("InflateParams")
    private fun showDialog() {
        Dialog(requireActivity()).apply {
            bindingDialog = DialogConditionsBinding.inflate(LayoutInflater.from(context))
            setContentView(bindingDialog.root)
            window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            show()
            bindingDialog.closeAboutDialog.setOnClickListener { dismiss() }
        }
    }

    }

