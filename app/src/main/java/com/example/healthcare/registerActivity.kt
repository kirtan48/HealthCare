package com.example.healthcare

import android.content.Intent
import android.opengl.ETC1.isValid
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
fun isValids(pwd:String):Boolean {
    if(pwd.length<8)return false;
    var f1=0;var f2=0 ;var f3=0 ;
    for(i in pwd.indices){
        if(pwd[i].isLetter())f1=1;
        else if(pwd[i].isDigit())f2=1;
        else if(!pwd[i].isLetter() && !pwd[i].isDigit())f3=1;


    }
    return f1==1 && f2==1 && f3==1

}
fun isEmail(pwd:String):Boolean {
    var f1=0;
    for(i in pwd.indices){
        if(pwd[i]=='@'){
            f1=1;
            break;
        }
    }
    return f1==1
}
class registerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val edUserName: EditText =findViewById(R.id.editTextText);
        val edEmail:EditText=findViewById(R.id.editTextEmail)
        val edPassWord: EditText =findViewById(R.id.editTextPwd);
        val edCnfPassWord: EditText =findViewById(R.id.editTextCnfPwd);
        val btn: Button =findViewById(R.id.button);
        val tv: TextView =findViewById(R.id.tvNewUser);
        val db = Database(this,"health care",null,1);


        btn.setOnClickListener{
            val username = edUserName.text.toString()
            val email=edEmail.text.toString()
            val password = edPassWord.text.toString()
            val cnfPassword=edCnfPassWord.text.toString()

            if (username.isEmpty() || password.isEmpty() || email.isEmpty()|| cnfPassword.isEmpty()) {
                Toast.makeText(applicationContext, "Please Fill all details", Toast.LENGTH_SHORT).show()
            } else {
                if(!db.isUsername(username)){
                    Toast.makeText(applicationContext, "Username already exist", Toast.LENGTH_SHORT).show()

                }

                else if(password!=cnfPassword){
                    Toast.makeText(applicationContext, "password and confirm password must be same", Toast.LENGTH_SHORT).show()
                }
                else{
                    val x=isValids(password)
                    val y= isEmail(email)
                    if(!y) Toast.makeText(applicationContext, "Please write correct email", Toast.LENGTH_SHORT).show();
                    else if(x){

                        db.register(username,email,password);
                        Toast.makeText(applicationContext, "DATA INSERTED", Toast.LENGTH_SHORT).show();
                        intent= Intent(this,loginActivity::class.java)
                        startActivity(intent )
                    }
                    else Toast.makeText(applicationContext, "Password must of 8 letters and must contain one letter,one digit,onr special character", Toast.LENGTH_SHORT).show()

                }

            }
        }
        tv.setOnClickListener{
            intent= Intent(this,loginActivity::class.java)
            startActivity(intent )
        }

    }

}