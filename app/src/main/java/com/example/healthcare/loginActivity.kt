package com.example.healthcare

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class loginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val edUserName: EditText =findViewById(R.id.editTextText);
         val edPassWord: EditText =findViewById(R.id.editTextPwd);
        val btn: Button =findViewById(R.id.button);
        val tv: TextView =findViewById(R.id.tvNewUser);

        btn.setOnClickListener(){
            val username = edUserName.text.toString()
            val password = edPassWord.text.toString()
            val db = Database(this,"health care",null,1);
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(applicationContext, "Fail", Toast.LENGTH_SHORT).show()
            } else {
                if(db.login(username,password)){

                    val shrdp=getSharedPreferences("shrd", MODE_PRIVATE)
                    val edit=shrdp.edit()
                    edit.putString("username",username);
                    edit.apply();


                    intent=Intent(this,homeActivity::class.java)
                    startActivity(intent)

                }
                else{
                    Toast.makeText(applicationContext, "username not registered", Toast.LENGTH_SHORT).show()
                }

            }
        }
        tv.setOnClickListener(){
            intent= Intent(this,registerActivity::class.java)
            startActivity(intent )
        }


    }
}