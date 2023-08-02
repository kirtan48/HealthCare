package com.example.healthcare

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.content.SharedPreferences
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import java.util.Calendar

class bookActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)
        val name:EditText=findViewById(R.id.fullName)
        val contact:EditText=findViewById(R.id.contactNumber)
        val address:EditText=findViewById(R.id.adress)
        val pin:EditText=findViewById(R.id.pincode)

        val c=Calendar.getInstance();
        val year=c.get(Calendar.YEAR)
        val month=c.get(Calendar.MONTH);
        val day=c.get(Calendar.DAY_OF_MONTH);
        val hour=c.get(Calendar.HOUR_OF_DAY)
        val minute=c.get(Calendar.MINUTE);
        val btnDate: Button =findViewById(R.id.date)
        val shrd=getSharedPreferences("shrd", MODE_PRIVATE);
        val username=shrd.getString("username","");



        btnDate.text="Select Date"
        btnDate.setOnClickListener{
            val dpd=DatePickerDialog(this,DatePickerDialog.OnDateSetListener{view,myear,mmonth,mday ->

                val str:String="$mday/${mmonth+1}/$myear"
                btnDate.text=str

            },year,month,day)
            c.add(Calendar.DATE,+1)
            dpd.datePicker.minDate=c.timeInMillis;

            dpd.show();
            Log.i("Values",""+username+name.text.toString()+address.text.toString()+contact.text.toString()+pin.text.toString()+btnDate.text.toString()+1000.0f+"lab");

        }
        val back:Button=findViewById(R.id.bk);
        back.setOnClickListener {
            intent= Intent(this,cartActivity::class.java);
            startActivity(intent);
        }
        val btn:Button=findViewById(R.id.Order);
        btn.setOnClickListener {
            if(btnDate.text=="Select Date"){
                Toast.makeText(this,"Please select a valid date",Toast.LENGTH_SHORT).show();

            }
            else{
                var db:Database=Database(applicationContext,"healthcare",null,1);

              //  username text,fullname String,address text,contact text,pincode int,date text,amount float ,otype text

                db.addOrder(username,name.getText().toString(),address.text.toString(),contact.text.toString(),pin.text.toString().toInt(),btnDate.text.toString(),1000.0f,"lab");
                Toast.makeText(this,"Order Successfull",Toast.LENGTH_SHORT).show()
                db.removeCart(username,"lab");

                intent=Intent(this,homeActivity::class.java);
                startActivity(intent);
            }
        }
    }
}