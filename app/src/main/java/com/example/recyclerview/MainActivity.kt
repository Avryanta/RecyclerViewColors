package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = Adapter(this, fetchList(), object : ColorOnClickListener{
        override fun OnClicked(tag: String) {

            val toast = Toast.makeText(applicationContext, "It's $tag :)", Toast.LENGTH_SHORT)
            toast.show()
        }
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        fillColorList()
    }

    private fun fillColorList() {

        binding.apply {
            rView.layoutManager = LinearLayoutManager(this@MainActivity)
            rView.adapter = adapter
        }
    }

    private fun fetchList(): ArrayList<ColorData>{
        val list = arrayListOf<ColorData>()

        list.add(ColorData("Apricot",R.drawable.apricot))
        list.add(ColorData("Butternut",R.drawable.butternut))
        list.add(ColorData("Honey",R.drawable.honey))
        list.add(ColorData("Milk Honey",R.drawable.milk_honey))
        list.add(ColorData("Blueberry",R.drawable.blueberry))
        list.add(ColorData("Denim",R.drawable.denim))
        list.add(ColorData("Seashell",R.drawable.seashell))

        return list
    }

}