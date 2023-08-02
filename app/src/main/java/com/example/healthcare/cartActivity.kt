package com.example.healthcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity

class cartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        var db:Database= Database(applicationContext,"healthcare",null,1);
        var shrd=getSharedPreferences("shrd", MODE_PRIVATE);
        var username=shrd.getString("username"," ").toString()

        var TotalAmount:Float=0f;

        var arry=db.getCartData(username,"lab");
        Toast.makeText(this,username+""+arry,Toast.LENGTH_SHORT).show();
        val cBk:Button=findViewById(R.id.cartBack);
        cBk.setOnClickListener{
            intent= Intent(this,LabTestActivity::class.java)
            startActivity(intent);
        }
        val cCheck:Button=findViewById(R.id.cartOrder);
        cCheck.setOnClickListener{
            intent=Intent(this,bookActivity::class.java);
            startActivity(intent);
        }
    }
}