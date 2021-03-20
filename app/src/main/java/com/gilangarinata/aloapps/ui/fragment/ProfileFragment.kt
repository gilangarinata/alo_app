package com.gilangarinata.aloapps.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gilangarinata.aloapps.R
import com.gilangarinata.aloapps.databinding.FragmentProfileBinding
import com.gilangarinata.aloapps.local.PreferenceManager
import com.gilangarinata.aloapps.models.UserInfo

/**
 * Created by Gilang Arinata on 20/03/21.
 * https://github.com/gilangarinata/
 */
class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var binding: FragmentProfileBinding
    private var userInfo : UserInfo? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getPreference()
        binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView(){
        userInfo?.let {
            binding.tvName.text = it.username
            binding.tvAddresss.text = it.address
            binding.tvPhone.text = it.phoneNumber
        }

    }

    private fun getPreference(){
        val preferenceManager = activity?.let { PreferenceManager(it) }
        userInfo = preferenceManager?.getUserInfo()
    }


}