package com.example.healthcare

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class LabTestDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab_test_detail)
        val pckName:TextView=findViewById(R.id.labTestName);

        val totalCost:TextView=findViewById(R.id.ttCost);
        val data:EditText=findViewById(R.id.labTestDetails)
        data.keyListener=null;
        pckName.text=intent.getStringExtra("0");
        data.setText(intent.getStringExtra("1"));
        totalCost.text=intent.getStringExtra("2");
        val bk:Button=findViewById(R.id.btnBack);
        bk.setOnClickListener{
            intent= Intent(this,LabTestActivity::class.java)
            startActivity(intent);
        }
       val btnCart:Button=findViewById(R.id.btncart)
        btnCart.setOnClickListener{
            Log.i("Reach","Reach");

            val shrdp=getSharedPreferences("shrd", MODE_PRIVATE)
            val username=shrdp.getString("username","username").toString();
            val product:String=intent.getStringExtra("0").toString();

            val price:String=intent.getStringExtra("2").toString();


            val db = Database(this,"health care",null,1);

            val otype:String="lab";

           if(db.checkCart(username,product)){
                Log.i("Reach","Reach5");
                Toast.makeText(this,"Already exist in cart",Toast.LENGTH_SHORT).show();
            }else{
                db.addCart(username,product, price.toFloat(),otype);
                Log.i("Reach","Reach4");
                Toast.makeText(this,"Added to cart",Toast.LENGTH_SHORT).show();
            }
            intent= Intent(this,LabTestActivity::class.java);
           startActivity(intent);

        }


    }
}