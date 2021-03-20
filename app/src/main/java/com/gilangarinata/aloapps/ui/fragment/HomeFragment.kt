package com.gilangarinata.aloapps.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.gilangarinata.aloapps.R
import com.gilangarinata.aloapps.adapters.AlbumAdapter
import com.gilangarinata.aloapps.databinding.FragmentHomeBinding
import com.gilangarinata.aloapps.models.AlbumModel
import com.gilangarinata.aloapps.tools.DataGenerator
import com.gilangarinata.aloapps.ui.DetailActivity

/**
 * Created by Gilang Arinata on 20/03/21.
 * https://github.com/gilangarinata/
 */

const val dataAlbum = "data_album"

class HomeFragment : Fragment(R.layout.fragment_home), AlbumAdapter.AdapterCallback {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter : AlbumAdapter
    private var dataCollection : MutableList<AlbumModel> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getDataList()
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    private fun getDataList(){
        dataCollection = context?.let { DataGenerator().getImageDate(it) } as MutableList<AlbumModel>
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initRecyclerView()
    }

    private fun initAdapter(){
        adapter = activity?.let { AlbumAdapter(it,this) }!!
        adapter.differ.submitList(dataCollection)
    }

    private fun initRecyclerView(){
        val layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL, false)
        binding.rvContent.layoutManager = layoutManager
        binding.rvContent.adapter = adapter
    }

    override fun onItemSelected(item: AlbumModel) {
        var intent = Intent(activity,DetailActivity::class.java)
        intent.putExtra(dataAlbum, item)
        startActivity(intent)
    }

}