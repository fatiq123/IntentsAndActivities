package com.example.passingdatabetweenactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var nameField: EditText
    private lateinit var ageField: EditText
    private lateinit var countryField: EditText
    private lateinit var nextButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        nameField = findViewById(R.id.etName)
        ageField = findViewById(R.id.etAge)
        countryField = findViewById(R.id.etCountry)
        nextButton = findViewById(R.id.btnApply)

        nextButton.setOnClickListener {

            val name = nameField.text.toString()
            val age = ageField.text.toString().toInt()
            val country = countryField.text.toString()

            val person = Person(name,age,country)
            Intent(this,SecondActivity::class.java).also {
//                it.putExtra("EXTRA_NAME", name)
//                it.putExtra("EXTRA_AGE", age)
//                it.putExtra("EXTRA_COUNTRY", country)

                it.putExtra("EXTRA_PERSON",person)      // in case if we want to send data through class i.e data class with serializable
                startActivity(it)
            }
        }
    }
}