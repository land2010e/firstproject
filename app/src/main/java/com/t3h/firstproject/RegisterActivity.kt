package com.t3h.firstproject

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.t3h.firstproject.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity(), View.OnClickListener {
//    private lateinit var edtUsername: EditText
//    private lateinit var edtPassword: EditText
//    private lateinit var edtConfirmPassword: EditText
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_register
        )


//        setContentView(R.layout.activity_register)
//        edtUsername = findViewById(R.id.edt_username)
//        edtPassword = findViewById(R.id.edt_password)
//        edtConfirmPassword = findViewById(R.id.edt_confirm_password)
        //lay intent den ra(thuyen)
//        val username = intent.getStringExtra("USERNAME")
//        val password = intent.getStringExtra("PASSWORD")

        //cac 2: dung applicationcontext
        val username = (applicationContext as MyApp).account?.username
        val password = (applicationContext as MyApp).account?.password
        (applicationContext as MyApp).account = null
        binding.edtUsernameAhihiDoNgoc.setText(username)
        binding.edtPassword.setText(password)

//        findViewById<View>(R.id.btn_register).setOnClickListener(this)
        binding.btnRegister.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_register -> {
                if (binding.edtConfirmPassword.text.toString().equals(
                        binding.edtPassword.text.toString()
                    )
                ) {
                    val intent = Intent()
                    intent.putExtra("USERNAME", binding.edtUsernameAhihiDoNgoc.text.toString())
                    //cho intent tra ve
                    setResult(Activity.RESULT_OK, intent)
                } else {
                    setResult(Activity.RESULT_CANCELED)
                }
                finish()
            }
        }
    }
}