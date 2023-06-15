package com.example.passingdatabetweenactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var showText: TextView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        showText = findViewById(R.id.tvPerson)
        backButton = findViewById(R.id.btnBack)


        val name = intent.getStringExtra("EXTRA_NAME")
        val age = intent.getIntExtra("EXTRA_AGE",0)     // if age does not exist then default age is set in case of nullability
        val country = intent.getStringExtra("EXTRA_COUNTRY")


//        val personString = "$name is $age years old and lives in $country"
//        showText.text = personString


        // in case if we want to get data from activity using data class

        val person = intent.getSerializableExtra("EXTRA_PERSON") as Person
        showText.text = person.toString()


        backButton.setOnClickListener {
            finish()
        }
    }
}