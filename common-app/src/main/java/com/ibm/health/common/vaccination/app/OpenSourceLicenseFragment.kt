package com.ibm.health.common.vaccination.app

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ibm.health.common.android.utils.viewBinding
import com.ibm.health.common.navigation.android.FragmentNav
import com.ibm.health.common.vaccination.app.databinding.OpenSourceLicenseBinding
import kotlinx.parcelize.Parcelize

@Parcelize
public class OpenSourceLicenseFragmentNav : FragmentNav(OpenSourceLicenseFragment::class)

/**
 * Displays open source licenses for all app dependencies. The licenses are displayed in a webview, the html is
 * generated by the plugin https://github.com/jaredsburrows/gradle-license-plugin.
 */
public class OpenSourceLicenseFragment : BaseFragment() {

    private val binding by viewBinding(OpenSourceLicenseBinding::inflate)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupActionBar()
        binding.openSourceLicenseWebView.loadUrl(getString(R.string.open_source_licenses_path))
    }

    private fun setupActionBar() {
        (activity as? AppCompatActivity)?.run {
            setSupportActionBar(binding.openSourceLicenseToolbar)
            supportActionBar?.run {
                setDisplayShowTitleEnabled(false)
                setDisplayHomeAsUpEnabled(true)
                setHomeAsUpIndicator(R.drawable.back_arrow)
            }
            binding.openSourceLicenseToolbar.title = getString(R.string.app_information_title_open_source)
        }
    }
}
