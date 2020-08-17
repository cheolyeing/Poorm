package com.example.poorm.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.poorm.R

class HomePlantAdd : AppCompatActivity() {

    private val GET_GALLERY_IMAGE: Int = 200
    private var plantImage: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_plant_add_layout)

        plantImage = findViewById(R.id.plantImg)
        plantImage!!.setOnClickListener(View.OnClickListener() {
            var intent: Intent = Intent(Intent.ACTION_PICK)
            intent.setDataAndType(
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                "image/*"
            )
            startActivityForResult(intent, GET_GALLERY_IMAGE)
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GET_GALLERY_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            var selectedImageUri: Uri? = data.getData()
            plantImage!!.setImageURI(selectedImageUri)
        }
    }
}