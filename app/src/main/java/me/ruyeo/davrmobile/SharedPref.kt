package me.ruyeo.davrmobile

import android.content.Context
import android.content.SharedPreferences

class SharedPref(context: Context) {

    private var mySharedPref: SharedPreferences =
            context.getSharedPreferences("prefs", Context.MODE_PRIVATE)

    fun setFirstEnter(state: Boolean?) {
        val editor = mySharedPref.edit()
        editor.putBoolean("first_enter", state!!)
        editor.commit()
    }
    fun isFirstEnter(): Boolean {
        return mySharedPref.getBoolean("first_enter", true)
    }
}