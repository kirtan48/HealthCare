package com.example.healthcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.cardview.widget.CardView
import android.widget.Toast

class findDoctorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_doctor)
        val back:CardView=findViewById(R.id.BACK)
        back.setOnClickListener{
            intent= Intent(this,homeActivity::class.java)
            startActivity(intent);

        }
        val familyPhysician:CardView=findViewById(R.id.cardFamilyPhysician)
        familyPhysician.setOnClickListener{
            intent= Intent(this,DoctorDetailActivity::class.java)
            intent.putExtra("title","Family Physician")
            startActivity(intent)
        }
        val dietician:CardView=findViewById(R.id.cardDietician)
        dietician.setOnClickListener{
            intent= Intent(this,DoctorDetailActivity::class.java)
            intent.putExtra("title","Dietician")
            startActivity(intent)
        }
        val Dentist:CardView=findViewById(R.id.cardDentist)
        Dentist.setOnClickListener{
            intent= Intent(this,DoctorDetailActivity::class.java)
            intent.putExtra("title","Dentist")
            startActivity(intent)
        }
        val surgeon:CardView=findViewById(R.id.cardSurgeon)
        surgeon.setOnClickListener{
            intent= Intent(this,DoctorDetailActivity::class.java)
            intent.putExtra("title","Surgeon")
            startActivity(intent)
        }
        val cardiologist:CardView=findViewById(R.id.cardCardiologist)
        cardiologist.setOnClickListener{
            intent= Intent(this,DoctorDetailActivity::class.java)
            intent.putExtra("title","Cardiologist")
            startActivity(intent)
        }
    }
}