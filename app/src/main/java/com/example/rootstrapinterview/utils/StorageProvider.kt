package com.example.rootstrapinterview.utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import java.util.*

/**
 * Created by Maxi
 * since 19/12/2020
 */
class StorageProvider {
    /**
     * Returns the shared preferences.
     *
     * @return Shared prefs.
     */
    var preferences: SharedPreferences? = null
        private set

    fun init(context: Context) {
        preferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    }

    /**
     * Saves the preference.
     *
     * @param key   Key for preference.
     * @param value Value for preference store.
     */
    fun savePreferences(key: String?, value: String?) {
        val editor = preferences!!.edit()
        editor.putString(key, value)
        editor.apply()
    }

    /**
     * Saves the preference.
     *
     * @param key   Key for preference.
     * @param value Value for preference store.
     */
    fun savePreferences(key: String?, value: Boolean?) {
        val editor = preferences!!.edit()
        editor.putBoolean(key, value!!)
        editor.apply()
    }

    /**
     * Saves the preference.
     *
     * @param key   Key for preference.
     * @param value Value for preference store.
     */
    fun savePreferences(key: String?, value: Int) {
        val editor = preferences!!.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    /**
     * Saves the preference.
     *
     * @param key   Key for preference.
     * @param value Value for preference store.
     */
    fun savePreferences(key: String?, value: Long) {
        val editor = preferences!!.edit()
        editor.putLong(key, value)
        editor.apply()
    }

    /**
     * Saves the preference.
     *
     * @param key   Key for preference.
     * @param value Value for preference store.
     */
    fun savePreferences(key: String?, value: Double) {
        val editor = preferences!!.edit()
        editor.putLong(key, java.lang.Double.doubleToRawLongBits(value))
        editor.apply()
    }

    /**
     * Saves the preference.
     *
     * @param key   Key for preference.
     * @param value Value for preference store.
     */
    fun savePreferences(key: String?, value: HashSet<Int>) {
        val editor = preferences!!.edit()
        val stringSet = HashSet<String>()
        for (i in value) {
            stringSet.add(i.toString())
        }
        editor.putStringSet(key, stringSet)
        editor.apply()
    }

    fun getPreferencesDouble(key: String?): Double {
        return java.lang.Double.longBitsToDouble(preferences!!.getLong(key, java.lang.Double.doubleToLongBits(-1.0)))
    }

    /**
     * retrieve a string saved preference.
     *
     * @param key
     * @return
     */
       fun getPreferencesString(key: String?): String? {
        return getPreferencesString(key, null)
    }

    /**
     * retrieve a string saved preference.
     *
     * @param key
     * @param defaultValue
     * @return
     */
    fun getPreferencesString(key: String?, defaultValue: String?): String? {
        return preferences?.getString(key, defaultValue)
    }

    /**
     * retrieve an int saved preference.
     *
     * @param key
     * @return
     */
    fun getPreferencesInt(key: String?): Int {
        return preferences!!.getInt(key, -1)
    }

    /**
     * retrieve a boolean saved preference.
     *
     * @param key
     * @return
     */
    fun getPreferencesBoolean(key: String?): Boolean {
        return preferences!!.getBoolean(key, false)
    }

    /**
     * retrieve a long saved preference.
     *
     * @param key
     * @return
     */
    fun getPreferencesLong(key: String?): Long {
        return preferences!!.getLong(key, 0)
    }

    /**
     * retrieve an Integer Hash Set from saved preference.
     *
     * @param key
     * @return
     */
    fun getPreferencesIntegerHashSet(key: String?): HashSet<Int> {
        val stringSet = preferences!!.getStringSet(key, null)
        val integerSet = HashSet<Int>()
        if (stringSet != null) {
            for (s in stringSet) {
                if (s != null) {
                    integerSet.add(s.toInt())
                }
            }
        }
        return integerSet
    }

    fun deletePreferences(key: String?) {
        val editor = preferences!!.edit()
        editor.remove(key)
        editor.apply()
    }

    fun storeObjectPreference(objectIdentifier: String?, myObject: Any?) {
        val prefsEditor = preferences!!.edit()
        val gson = Gson()
        val json = gson.toJson(myObject)
        prefsEditor.putString(objectIdentifier, json)
        prefsEditor.commit()
    }
}