package com.example.healthcare

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.activity.ComponentActivity
private var data= arrayOf(arrayOf("Dollo 650","Exp:2/2026","1000"),arrayOf("vicks Action 500","Exp:2/2026","500"))
class medicineDetailActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medicine_detail)

        var arr = Array(data.size) { Array(3){""} };
        val list=ArrayList<HashMap<String,String>>();
        for(i in arr){
            val item=HashMap<String,String>();
            item.put("line1",i[0])
            item.put("line2",i[1])
            item.put("line3",i[2])
            list.add(item);
        }
        val temp= arrayOf("line1","line2","line3");
        val temp2= intArrayOf(R.id.linea,R.id.lineb,R.id.linec,)
        var sp= SimpleAdapter(this,list,R.layout.medicine_detail,temp,temp2);
        val ls: ListView =findViewById(R.id.avaMedicine)
        ls.adapter=sp;
        //val add
       /* ls.setOnItemClickListener{parent,view,position,id->
            intent= Intent(this,bookAppointmentActivity::class.java);
            intent.putExtra("title",title)
            intent.putExtra("0",arr[position][0])
            intent.putExtra("1",arr[position][1])

            intent.putExtra("3",arr[position][3])
            intent.putExtra("4",arr[position][4])
            startActivity(intent);


        }*/
    }
}