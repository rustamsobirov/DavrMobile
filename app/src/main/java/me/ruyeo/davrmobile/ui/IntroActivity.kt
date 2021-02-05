package me.ruyeo.davrmobile.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import me.ruyeo.davrmobile.R
import me.ruyeo.davrmobile.SharedPref
import me.ruyeo.davrmobile.adapter.IntroSliderAdapter
import me.ruyeo.davrmobile.databinding.ActivityIntroBinding
import me.ruyeo.davrmobile.model.IntroSlide

class IntroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntroBinding
    private val introSliderAdapter = IntroSliderAdapter(
            listOf(
                    IntroSlide(
                            "Speed \uD83D\uDE80",
                            "Lorem ipsum dolorLorem ipsum dolor Lorem ipsum dolorLorem ipsum dolor",
                        R.drawable.ic_launcher_foreground
                    ),
                    IntroSlide(
                            "Secure",
                            "Lorem ipsum dolorLorem ipsum dolor Lorem ipsum dolorLorem ipsum dolor",
                        R.drawable.ic_launcher_foreground

                    ),
                    IntroSlide(
                            "Innovative",
                            "Lorem ipsum dolorLorem ipsum dolor Lorem ipsum dolorLorem ipsum dolor",
                        R.drawable.ic_launcher_foreground

                    ), IntroSlide(
                    "Save money!",
                    "Lorem ipsum dolorLorem ipsum dolor Lorem ipsum dolorLorem ipsum dolor",
                    R.drawable.ic_launcher_foreground

            )
            )
    )


    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.introSliderViewPager.adapter = introSliderAdapter

        binding.introSliderViewPager.registerOnPageChangeCallback(object :
                ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 3){
                    binding.btnFurther.visibility = View.INVISIBLE
                    binding.btnSkip.visibility = View.INVISIBLE
                    binding.btnStart.visibility = View.VISIBLE
                }
                else{
                    binding.btnFurther.visibility = View.VISIBLE
                    binding.btnSkip.visibility = View.VISIBLE
                    binding.btnStart.visibility = View.GONE
                }
            }
        })
        binding.btnSkip.setOnClickListener {
            binding.introSliderViewPager.currentItem = 3
        }
        binding.btnFurther.setOnClickListener {
            if (binding.introSliderViewPager.currentItem + 1 < introSliderAdapter.itemCount) {
                binding.introSliderViewPager.currentItem += 1
            }
        }
        binding.btnStart.setOnClickListener {
            Intent(applicationContext, RegistrationActivity::class.java).also {
                startActivity(it)
                SharedPref(this).setFirstEnter(false)
                finish()
            }
        }
    }


}
