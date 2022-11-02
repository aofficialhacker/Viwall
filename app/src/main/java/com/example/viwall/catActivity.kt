package com.example.viwall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.viwall.Adapter.CatImagesAdapter
import com.example.viwall.databinding.ActivityCatBinding
import com.example.viwall.model.bommodel
import com.google.firebase.firestore.FirebaseFirestore

class catActivity : AppCompatActivity() {
    lateinit var binding: ActivityCatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val db= FirebaseFirestore.getInstance()
        val uid=intent.getStringExtra("uid")
        val name=intent.getStringExtra("name")

        db.collection("categories").document(uid!!).collection("wallpaper").addSnapshotListener { value, error ->
            val listOfCatWallpaper= arrayListOf<bommodel>()
            val data=value?.toObjects(bommodel::class.java)
            listOfCatWallpaper.addAll(data!!)
            binding.catTitle.text=name.toString()
            binding.catCount.text="${listOfCatWallpaper.size} Wallpaper Available"
            binding.catRcv.layoutManager=
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            binding.catRcv.adapter=CatImagesAdapter(this,listOfCatWallpaper)

        }






    }
}