package com.gilangarinata.aloapps.tools

import android.text.TextUtils
import android.util.Patterns


/**
 * Created by Gilang Arinata on 20/03/21.
 * https://github.com/gilangarinata/
 */
class Utils {
    fun isValidUsername(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target)
    }
    fun isValidPassword(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target)
    }
}