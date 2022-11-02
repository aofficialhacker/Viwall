package com.example.viwall.fragments

import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.viwall.Adapter.CollectionAdapter
import com.example.viwall.databinding.FragmentDownloadBinding
import java.io.File


class DownloadFragment : Fragment() {

    lateinit var binding: FragmentDownloadBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentDownloadBinding.inflate(layoutInflater,container,false)

        val allfiles:Array<File>
        val imagelist= arrayListOf<String>()
        val targetPath=Environment.getExternalStorageDirectory().absolutePath+"/Pictures/Amoled Wallpaper"
        val targetFile=File(targetPath)
        allfiles=targetFile.listFiles()!!

        for(data in allfiles)
        {
            imagelist.add(data.absolutePath)
        }
        binding.rcvCollection.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        binding.rcvCollection.adapter=CollectionAdapter(requireContext(),imagelist)

        return binding.root
    }

}