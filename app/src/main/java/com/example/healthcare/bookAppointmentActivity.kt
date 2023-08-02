package com.example.healthcare

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import java.util.Calendar

class bookAppointmentActivity : ComponentActivity()  {
   // private val timings= arrayOf("11:00-12:00","12:00-1:00");
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_appointment)

        val btnBack:Button=findViewById(R.id.buttonBack)
        var pname:EditText=findViewById(R.id.pName)
        var padress:EditText=findViewById(R.id.pAdrress)
        var pcontact:EditText=findViewById(R.id.pContact)
        var pfees:EditText=findViewById(R.id.pFees)
        var tv:TextView=findViewById(R.id.textView2)
        pname.keyListener = null
        padress.keyListener = null
        pcontact.keyListener = null
        pfees.keyListener = null
        var it= intent
        var titles=it.getStringExtra("title")
        var name=it.getStringExtra("0").toString()
        var address=it.getStringExtra("1")
        var contact=it.getStringExtra("3")
        var fees=it.getStringExtra("4")
        tv.text=titles
        pname.setText(name)
        padress.setText(address)
        pcontact.setText(contact)
        pfees.setText(fees)
        val c=Calendar.getInstance();
        val year=c.get(Calendar.YEAR)
        val month=c.get(Calendar.MONTH);
        val day=c.get(Calendar.DAY_OF_MONTH);
        val hour=c.get(Calendar.HOUR_OF_DAY)
        val minute=c.get(Calendar.MINUTE);
        val btnDate:Button=findViewById(R.id.datebtn)
        /*val ddtime:AutoCompleteTextView=findViewById(R.id.timeDD)*/
        val str:String="$day/${month+1}/$year"
        btnDate.text=str
        btnDate.setOnClickListener{
            val dpd=DatePickerDialog(this,DatePickerDialog.OnDateSetListener{view,myear,mmonth,mday ->

                val str:String="$mday/${mmonth+1}/$myear"
                btnDate.text=str

            },year,month,day)
            c.add(Calendar.DATE,+1)
            dpd.datePicker.minDate=c.timeInMillis;

            dpd.show();
        }
        val spinner: Spinner =findViewById(R.id.Drop)
       val timings=resources.getStringArray(R.array.timings)
        val sp= ArrayAdapter<String>(this,R.layout.drop_down,timings);
        spinner.adapter=sp;

        spinner.onItemSelectedListener= object :
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(applicationContext, timings[position], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }



    /*    val spinner:Spinner=findViewById(R.id.SpinnerDD)
        val sp= ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,timings);
        spinner.adapter=sp;
        spinner.onItemClickListener=object:AdapterView.OnItemClickListener{
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(applicationContext,"selected ${timings[position]}",Toast.LENGTH_SHORT).show()

            }

        }*/



        btnBack.setOnClickListener{
            intent= Intent(this,findDoctorActivity::class.java)
            startActivity(intent)
        }
    }
}