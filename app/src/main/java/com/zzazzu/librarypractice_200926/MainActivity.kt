package com.zzazzu.librarypractice_200926

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_main.*
import java.util.jar.Manifest

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()

    }

    override fun setupEvents() {

        callPhoneBtn.setOnClickListener{

            val    pl = object : PermissionListener {
                override fun onPermissionGranted() {

                    val myUri = Uri.parse("tel:${phoneNumID}")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(mContext, "권한이 거부되어 통화가 안 됩니다.", Toast.LENGTH_SHORT).show()
                }

            }

// [설정]으로 입력해두면 나중에 메시지에서 설정을 클릭했을 때 설정 메뉴로 이동이 가능하다.

            TedPermission.with(mContext)
                .setPermissionListener(pl)
                .setDeniedMessage("권한이 거부되었습니다. [설정] 에서 권한을 켜주세요")
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()
        }


        loadWebImageButton.setOnClickListener{

            Glide.with(mContext).load("https://nsimg.kbs.co.kr/data/news/2019/12/08/4338865_Bjk.jpg).into(otherPersonIm").into(otherPersonImg)
        }


        profilePhotoImg.setOnClickListener {
            Toast.makeText(mContext, "사진 클릭됨", Toast.LENGTH_SHORT).show()


            val myIntent = Intent(mContext, ViewPrototypeActivity :: class.java)
            startActivity(myIntent)
        }

    }

    override fun setValues() {



    }

}