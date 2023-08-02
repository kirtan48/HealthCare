package com.example.healthcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
import androidx.activity.ComponentActivity

class DoctorDetailActivity : ComponentActivity() {
    private var data1 = arrayOf(arrayOf("Doctor Name:Ajit Saste","Hospital Addrress : adajan","Exp : 5 yrs","Mobile no: 1234569874","Fees :600/-"),
        arrayOf("Doctor Name:D2","Hospital Addrress : adajan","Exp : 4 yrs","Mobile no: 1234569874","Fees:700/-"),
        arrayOf("Doctor Name:D3","Hospital Addrress : adajan","Exp : 3 yrs","Mobile no: 1234569874","Fees:800/-"),
        arrayOf("Doctor Name:D4","Hospital Addrress : adajan","Exp : 2 yrs","Mobile no: 1234569874","Fees:900/-"),
        arrayOf("Doctor Name:D5","Hospital Addrress : adajan","Exp : 1 yrs","Mobile no: 1234569874","Fees:1000/-")

    )
    private var data2 = arrayOf(arrayOf("Doctor Name:D21","Hospital Addrress : adajan","Exp : 5 yrs","Mobile no: 1234569874","Fees : 600/-"),
        arrayOf("Doctor Name:D22","Hospital Addrress : adajan","Exp : 4 yrs","Mobile no: 1234569874","Fees : 700/-"),
        arrayOf("Doctor Name:D23","Hospital Addrress : adajan","Exp : 3 yrs","Mobile no: 1234569874","Fees : 800/-"),
        arrayOf("Doctor Name:D24","Hospital Addrress : adajan","Exp : 2 yrs","Mobile no: 1234569874","Fees : 900/-"),
        arrayOf("Doctor Name:D25","Hospital Addrress : adajan","Exp : 1 yrs","Mobile no: 1234569874","Fees : 1000/-")

    )
    private var data3 = arrayOf(arrayOf("Doctor Name:D31","Hospital Addrress : adajan","Exp : 5 yrs","Mobile no: 1234569874","Fees : 600/-"),
        arrayOf("Doctor Name:D32","Hospital Addrress : adajan","Exp : 4 yrs","Mobile no: 1234569874","Fees : 700/-"),
        arrayOf("Doctor Name:D33","Hospital Addrress : adajan","Exp : 3 yrs","Mobile no: 1234569874","Fees : 800/-"),
        arrayOf("Doctor Name:D34","Hospital Addrress : adajan","Exp : 2 yrs","Mobile no: 1234569874","Fees : 900/-"),
        arrayOf("Doctor Name:D35","Hospital Addrress : adajan","Exp : 1 yrs","Mobile no: 1234569874","Fees : 1000/-")

    )
    private var data4 = arrayOf(arrayOf("Doctor Name:D41","Hospital Addrress : adajan","Exp : 5 yrs","Mobile no: 1234569874","Fees : 600/-"),
        arrayOf("Doctor Name:D42","Hospital Addrress : adajan","Exp : 4 yrs","Mobile no: 1234569874","Fees : 700"),
        arrayOf("Doctor Name:D43","Hospital Addrress : adajan","Exp : 3 yrs","Mobile no: 1234569874","Fees : 800"),
        arrayOf("Doctor Name:D44","Hospital Addrress : adajan","Exp : 2 yrs","Mobile no: 1234569874","Fees : 900"),
        arrayOf("Doctor Name:D45","Hospital Addrress : adajan","Exp : 1 yrs","Mobile no: 1234569874","Fees : 1000")

    )
    private var data5 = arrayOf(arrayOf("Doctor Name:D51","Hospital Addrress : adajan","Exp : 5 yrs","Mobile no: 1234569874","Fees : 600/-"),
        arrayOf("Doctor Name:D52","Hospital Addrress : adajan","Exp : 4 yrs","Mobile no: 1234569874","Fees : 700/-"),
        arrayOf("Doctor Name:D53","Hospital Addrress : adajan","Exp : 3 yrs","Mobile no: 1234569874","Fees : 800/-"),
        arrayOf("Doctor Name:D54","Hospital Addrress : adajan","Exp : 2 yrs","Mobile no: 1234569874","Fees : 900/-"),
        arrayOf("Doctor Name:D55","Hospital Addrress : adajan","Exp : 1 yrs","Mobile no: 1234569874","Fees : 1000/-")

    )




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_detail)
        val tv:TextView=findViewById(R.id.FDtitle)
        var intent=getIntent();
        val title=intent.getStringExtra("title");
        tv.text = title;

        var arr = Array(5) { Array(5){""} };
        if(title=="Family Physician"){
            arr=data1;
        }
        else if(title=="Dietician")arr=data2
        else if(title=="Dentist")arr=data3
        else if(title=="Surgeon")arr=data4
        else if(title=="Cardiologist")arr=data5
        val btn:Button=findViewById(R.id.btnBack)
        btn.setOnClickListener{
            intent= Intent(this,findDoctorActivity::class.java)
            startActivity(intent)
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
        var sp=SimpleAdapter(this,list,R.layout.multine_lines,temp,temp2);
        val ls:ListView=findViewById(R.id.FDlist)
        ls.adapter=sp;
       ls.setOnItemClickListener{parent,view,position,id->
           intent= Intent(this,bookAppointmentActivity::class.java);
           intent.putExtra("title",title)
           intent.putExtra("0",arr[position][0])
           intent.putExtra("1",arr[position][1])

           intent.putExtra("3",arr[position][3])
           intent.putExtra("4",arr[position][4])
           startActivity(intent);


        }






    }


}