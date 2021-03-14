package com.t3h.firstproject

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class DemoActivity : AppCompatActivity(), View.OnClickListener, View.OnLongClickListener {
    private lateinit var btnLogin: Button
    private lateinit var tvRegister: TextView
    private lateinit var edtUsername: EditText
    private lateinit var edtPassword: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_login)

        //anh xa tu xml ra
        btnLogin = findViewById(R.id.btn_login)
        tvRegister = findViewById(R.id.tv_register)
        edtUsername = findViewById(R.id.edt_username)
        edtPassword = findViewById(R.id.edt_password)

        //bat su kien click
//        setOnClickListener la phuong thuc cua view
        btnLogin.setOnClickListener(this)
        btnLogin.setOnLongClickListener(this)
        tvRegister.setOnClickListener(this)
        tvRegister.setOnLongClickListener(this)

        findViewById<View>(R.id.btn_message).setOnClickListener(this)
        findViewById<View>(R.id.btn_open_music).setOnClickListener(this)
        Log.d("DemoActivity", "onCreate..................")
    }

    override fun onLongClick(v: View): Boolean {
        when (v.id) {
            R.id.btn_login -> {
                Toast.makeText(
                    this, "Long Click Button Login",
                    Toast.LENGTH_SHORT
                ).show()

                //mo trinh duy voi link: https://vnexpress.net
                val intent = Intent()
                //set action
                intent.action = Intent.ACTION_VIEW
                //set diem den
                intent.data = Uri.parse("https://vnexpress.net")
                //cho intent chay
                startActivity(intent)
            }
            R.id.tv_register -> {
                Toast.makeText(
                    this, "Long Click Button Register",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
        return true
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_login -> {
                Toast.makeText(
                    this, "Click Button Login",
                    Toast.LENGTH_SHORT
                ).show()

            }
            R.id.tv_register -> {
                Toast.makeText(
                    this, "Click Button Register",
                    Toast.LENGTH_SHORT
                ).show()
                //mo register
                val intent = Intent()
                intent.setClass(this, RegisterActivity::class.java)
                //lay noi dung trong edittext
                val username = edtUsername.text.toString()
                val password = edtPassword.text.toString()

                //dua du lieu vao intent
//                intent.putExtra("USERNAME", username)
//                intent.putExtra("PASSWORD", password)

                //cach 2: dua du lieu vao ApplicationContext
                //ep kieu
                (applicationContext as MyApp).account =
                    Account(age = 20, username = username, password = password)

                //mo activity khong quan tam ket qua
//                startActivity(intent)

                //mo activity quan tam ket qua
                startActivityForResult(intent, 100)
            }
            R.id.btn_message -> {
                val sendIntent = Intent(Intent.ACTION_VIEW)
                sendIntent.data = Uri.parse("sms:")
                startActivity(sendIntent);
            }
            R.id.btn_open_music -> {
                val intent = Intent(MediaStore.INTENT_ACTION_MUSIC_PLAYER)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
//                val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//                try {
//                    startActivityForResult(takePictureIntent, 1)
//                } catch (e: Exception) {
//                    // display error state to the user
//                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100) {
            if (resultCode == Activity.RESULT_OK) {
                val username = data!!.getStringExtra("USERNAME")
                edtUsername.setText(username)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("DemoActivity", "onResume..................")
    }

    override fun onPause() {
        super.onPause()
        Log.d("DemoActivity", "onPause..................")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("DemoActivity", "onDestroy..................")
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Log.d("DemoActivity", "onBackPressed..................")
    }


}