package com.example.healthcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.activity.ComponentActivity

class orderDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_detail)
        var db:Database=Database(applicationContext,"healthcare",null,1);
        val shrd=getSharedPreferences("shrd", MODE_PRIVATE);
        val username=shrd.getString("username","");
        var data=db.getOrderData(username);
        // var order_Detail=Array(data.size){""};
        val arr = Array(data.size) { Array(5){""} }
        Log.i("Checking",""+arr);

        var cnt=0;
        for( i in data){

            var temp=i.toString().split("$")
            Log.i("Checking",""+temp);
            arr[cnt][0]=temp[0];
            arr[cnt][1]=temp[1];
            arr[cnt][2]=temp[4];
            arr[cnt][3]=temp[5];
            arr[cnt][4]=temp[6];
            cnt += 1;
        }


        val list=ArrayList<HashMap<String,String>>();
        for(i in arr){
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
        var sp= SimpleAdapter(this,list,R.layout.multine_lines,temp,temp2);
        val ls: ListView =findViewById(R.id.orderList)
        ls.adapter=sp;
        /*ls.setOnItemClickListener{parent,view,position,id->
            intent= Intent(this,bookAppointmentActivity::class.java);
            startActivity(intent);


        }*/
    }
}