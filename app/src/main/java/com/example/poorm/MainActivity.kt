package com.example.poorm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_home.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        plantRecyclerView.adapter = PlantRecyclerViewAdapter()
        var gridLayoutManager = GridLayoutManager(this, 2)
        plantRecyclerView.layoutManager = gridLayoutManager

        val fab:View = findViewById(R.id.floatingActionButton)
        fab.setOnClickListener {
            val nextIntent: Intent = Intent(this, HomeActivityAddPlant::class.java)
            startActivity(nextIntent)
        }

    }

    class PlantRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        // Dummy Data
        val images =
            arrayOf(
                R.drawable.plant_sanse,
                R.drawable.plant_gomu,
                R.drawable.plant_dongbaek,
                R.drawable.plant_rose,
                R.drawable.plant_sunflower,
                R.drawable.plant_sanse,
                R.drawable.plant_gomu,
                R.drawable.plant_dongbaek,
                R.drawable.plant_rose,
                R.drawable.plant_sunflower
            )

        val nicknames =
            arrayOf(
                "산세1호",
                "고무1호",
                "동백1호",
                "장미1호",
                "해바1호",
                "산세2호",
                "고무2호",
                "동백2호",
                "장미2호",
                "해바2호"
            )

        val species =
            arrayOf(
                "(산세베리아)",
                "(고무나무)",
                "(동백나무)",
                "(장미)",
                "(해바라기)",
                "(산세베리아)",
                "(고무나무)",
                "(동백나무)",
                "(장미)",
                "(해바라기)"
            )

        // Connect : view - layout by type
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.home_item_layout, parent, false)

            var params = view.layoutParams
            params.height = parent.measuredWidth / 2
            params.width = parent.measuredWidth / 2
            return PlantViewHolder(view)
        }

        // Count item
        override fun getItemCount(): Int {
            return images.size
        }

        // Bind view holder - data
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            var view = holder as PlantViewHolder
            view!!.plant_image!!.setImageResource(images[position])
            view!!.plant_nickname!!.text = nicknames[position]
            view!!.plant_species!!.text = species[position]
        }

    }
}

class PlantViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
    var plant_image: ImageView? = null
    var plant_nickname: TextView? = null
    var plant_species: TextView? = null

    init {
        plant_image = view!!.findViewById(R.id.plant_image)
        plant_nickname = view!!.findViewById(R.id.plant_nickname)
        plant_species = view!!.findViewById(R.id.plant_species)
    }
}
