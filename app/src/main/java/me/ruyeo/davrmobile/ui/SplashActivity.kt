package me.ruyeo.davrmobile.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.ruyeo.davrmobile.SharedPref
import me.ruyeo.davrmobile.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val timer: Thread = object : Thread() {
            override fun run() {
                try {
                    //Display for 3 seconds
                    sleep(3000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } finally {
                    if (!SharedPref(this@SplashActivity).isFirstEnter()){
                        val intent = Intent(this@SplashActivity, RegistrationActivity::class.java)
                        startActivity(intent)
                        finish()
                    }else{
                        val intent = Intent(this@SplashActivity, IntroActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            }
        }
        timer.start()




    }
}