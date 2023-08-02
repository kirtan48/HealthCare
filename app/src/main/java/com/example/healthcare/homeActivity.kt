package com.example.healthcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.cardview.widget.CardView
import androidx.compose.ui.text.toUpperCase

class homeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val shrdp=getSharedPreferences("shrd", MODE_PRIVATE)
        var msg=shrdp.getString("username","username").toString();
        msg="welcome "+msg;
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        var exit:CardView=findViewById(R.id.cardExit);
        exit.setOnClickListener{
            val edit=shrdp.edit();
            edit.clear();
            edit.apply();
            intent=Intent(this,loginActivity::class.java)
            startActivity(intent);
        }

        var findDoctor:CardView=findViewById(R.id.cardFindDoctor)
        findDoctor.setOnClickListener{
            intent=Intent(this,findDoctorActivity::class.java);
            startActivity(intent);
        }
        var labTest:CardView=findViewById(R.id.cardLabTest)
        labTest.setOnClickListener{
            intent=Intent(this,LabTestActivity::class.java)
            startActivity(intent)
        }
        var Cart:CardView=findViewById(R.id.cardOrederDetail)
        Cart.setOnClickListener{
            intent= Intent(this,orderDetailActivity::class.java)
            startActivity(intent);
        }
        var medicine:CardView=findViewById(R.id.cardBuyMedicine)
        medicine.setOnClickListener{
            intent=Intent(this,medicineDetailActivity::class.java);
            startActivity(intent);
        }




    }
}