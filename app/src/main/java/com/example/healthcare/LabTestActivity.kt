package com.example.healthcare

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.activity.ComponentActivity
import androidx.cardview.widget.CardView

class LabTestActivity : ComponentActivity() {
    private var Hpackages = arrayOf(arrayOf("package 1:Full Body Check Up","","","","999"),
        arrayOf("package 2:Blood Glucose Fasting","","","","299"),
        arrayOf("package 3:Covid 19","","","","899"),
        arrayOf("package 4:Thyroid Check","","","","499"),
        arrayOf("package 5:Immunity Check","","","","699")

    );
    private var pDetails= arrayOf("1\n"+"2\n"+"3\n","1\n"+"2\n"+"3\n","1\n"+"2\n"+"3\n","1\n"+"2\n"+"3\n","1\n"+"2\n"+"3\n");
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab_test)
        val list=ArrayList<HashMap<String,String>>();

        for(i in Hpackages ){
            val item=HashMap<String,String>();
            item.put("line1",i[0])
            item.put("line2",i[1])
            item.put("line3",i[2])
            item.put("line4",i[3])
            item.put("line5",i[4])
            list.add(item);
        }
        val temp= arrayOf("line1","line2","line3","line4","line5");
        val temp2= intArrayOf(R.id.linea,R.id.lineb,R.id.linec,R.id.lined,R.id.linee)
        var sp= SimpleAdapter(this,list,R.layout.package_detail,temp,temp2);
        val ls: ListView =findViewById(R.id.packageList)
        ls.adapter=sp;
        ls.setOnItemClickListener{parent,view,position,id->
            intent= Intent(this, LabTestDetailActivity::class.java);
            intent.putExtra("0",Hpackages[position][0])
            intent.putExtra("1",pDetails[position])
            intent.putExtra("2",Hpackages[position][4])

            startActivity(intent);


        }

        var btnbk:Button=findViewById(R.id.btnBack);
        btnbk.setOnClickListener{
            intent= Intent(this,homeActivity::class.java)
            startActivity(intent)
        }
        var Cart: Button =findViewById(R.id.btnGotocart)
        Cart.setOnClickListener{
            intent= Intent(this,cartActivity::class.java)
            startActivity(intent);
        }
    }
}