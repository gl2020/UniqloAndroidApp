package com.uniqlo.uniqloandroidapp.ui.settings

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.preference.EditTextPreference
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat

import com.uniqlo.uniqloandroidapp.R

/**
 * A simple [Fragment] subclass.
 */
class SettingsFragment : PreferenceFragmentCompat() {

    private lateinit var toolbar: Toolbar
    val namePreference: EditTextPreference? = findPreference("name")
    val themePreference: ListPreference? = findPreference("theme")

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)

        namePreference?.summaryProvider = EditTextPreference.SimpleSummaryProvider.getInstance()
        themePreference?.summaryProvider = ListPreference.SimpleSummaryProvider.getInstance()

       /* namePreference?.summaryProvider = Preference.SummaryProvider <EditTextPreference>{
                preference ->
            val name = preference.text
            if(!TextUtils.isEmpty(name))
                preference.text
            else
                ""
        }*/

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


        /*override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // bind resources
        toolbar = view.findViewById(
            R.id.toolbar)

        toolbar.title = "Settings"

    }*/




}
