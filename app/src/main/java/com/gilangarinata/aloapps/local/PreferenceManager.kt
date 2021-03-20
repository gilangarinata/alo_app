package com.gilangarinata.aloapps.local

import android.app.Activity
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.gilangarinata.aloapps.models.UserInfo

/**
 * Created by Gilang Arinata on 20/03/21.
 * https://github.com/gilangarinata/
 */
class PreferenceManager(activity: Activity) {
    private val loginSharedName = "Login"
    private val usernameKey = "username"
    private var sharedPreferences : SharedPreferences

    init {
        sharedPreferences = activity.getSharedPreferences(loginSharedName, MODE_PRIVATE)
    }

    fun saveUserInfo(username : String){
        val spEdit = sharedPreferences.edit()
        spEdit.putString(usernameKey, username)
        spEdit.apply()
    }

    fun getUserInfo() : UserInfo? {
        val username = sharedPreferences.getString(usernameKey, "")
        return username?.let { UserInfo(username = it) }
    }

    fun clearUserInfo(){
        val spEdit = sharedPreferences.edit()
        spEdit.clear()
        spEdit.apply()
    }
}