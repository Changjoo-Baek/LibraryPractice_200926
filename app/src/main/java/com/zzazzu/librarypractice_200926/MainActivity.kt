package com.zzazzu.librarypractice_200926

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()

    }

    override fun setupEvents() {

    }

    override fun setValues() {

        loadWebImageButton.setOnClickListener{

            Glide.with(mContext).load("https://nsimg.kbs.co.kr/data/news/2019/12/08/4338865_Bjk.jpg).into(otherPersonIm").into(otherPersonImg)
        }


        profilePhotoImg.setOnClickListener {
            Toast.makeText(mContext, "사진 클릭됨", Toast.LENGTH_SHORT).show()


            val myIntent = Intent(mContext, ViewPrototypeActivity :: class.java)
            startActivity(myIntent)
        }

    }

}