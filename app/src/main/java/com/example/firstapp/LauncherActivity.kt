package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.firebase.auth.FirebaseAuth

class LauncherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        // objectives: 1. check if user logged in or not
        // i). logged in-> MainActivity
        // ii). not logged in-> LoginActivity
        //             2. delay the activity by few seconds

       val logo = findViewById<ImageView>(R.id.app_logo)

        logo.postDelayed({

              val user = FirebaseAuth.getInstance().currentUser
            if(user==null){
                val intent = Intent(this,LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(Intent(this,LoginActivity::class.java))
            }

            else{
                startActivity(Intent(this,MainActivity::class.java))
            }
        }, 5000)



    }
}