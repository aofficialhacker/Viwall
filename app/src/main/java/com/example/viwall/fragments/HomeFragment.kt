package com.example.viwall.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viwall.Adapter.BomAdapter
import com.example.viwall.Adapter.catAdapter
import com.example.viwall.Adapter.colortoneAdapter
import com.example.viwall.databinding.FragmentHomeBinding
import com.example.viwall.model.bommodel
import com.example.viwall.model.catModel
import com.example.viwall.model.colortoneModel
import com.google.firebase.firestore.FirebaseFirestore


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var db:FirebaseFirestore


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentHomeBinding.inflate(layoutInflater,container,false)
        db=FirebaseFirestore.getInstance()
        db.collection("bestofmonth").addSnapshotListener { value, error ->
            val listBestOfTheMonth= arrayListOf<bommodel>()
            val data=value?.toObjects(bommodel::class.java)
            listBestOfTheMonth.addAll(data!!)
            binding.rcvBom.layoutManager=LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            binding.rcvBom.adapter=BomAdapter(requireContext(),listBestOfTheMonth)

        }

        db.collection("thecolortone").addSnapshotListener { value, error ->

            val listTheColorTone= arrayListOf<colortoneModel>()
            val data=value?.toObjects(colortoneModel::class.java)
            listTheColorTone.addAll(data!!)
            binding.rcvTct.layoutManager=LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            binding.rcvTct.adapter=colortoneAdapter(requireContext(),listTheColorTone)

        }

        db.collection("categories").addSnapshotListener { value, error ->

            val listOfCategory = arrayListOf<catModel>()
            val data=value?.toObjects(catModel::class.java)
            listOfCategory.addAll(data!!)
            binding.rcvCat.layoutManager=GridLayoutManager(requireContext(),2)
            binding.rcvCat.adapter=catAdapter(requireContext(),listOfCategory)

        }

        return binding.root
    }

}