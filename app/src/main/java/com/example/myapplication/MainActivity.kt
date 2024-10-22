package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.TextView
import android.util.Log


class MainActivity : AppCompatActivity() {
    private lateinit var calculateButton: Button
    private lateinit var editTextAge: EditText
    private lateinit var editTextHeight: EditText
    private lateinit var editTextWeight: EditText
    private lateinit var bmiResultTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.v("MainActivity", "Verbose: onCreate called")
        Log.d("MainActivity", "Debug: onCreate called")
        Log.i("MainActivity", "Info: onCreate called")
        Log.w("MainActivity", "Warning: onCreate called")
        Log.e("MainActivity", "Error: onCreate called")

        calculateButton = findViewById(R.id.calculate_button)
        editTextAge = findViewById(R.id.edit_text_age)
        editTextHeight = findViewById(R.id.edit_text_height)
        editTextWeight = findViewById(R.id.edit_text_weight)
        bmiResultTextView = findViewById(R.id.bmi_result)


        calculateButton.setOnClickListener {
            val heightInMeters = editTextHeight.text.toString().toFloat() / 100
            val weight = editTextWeight.text.toString().toFloat()
            val bmi = weight / (heightInMeters * heightInMeters)
            Log.d("MainActivity", "Height: $heightInMeters, Weight: $weight, BMI: $bmi")

            bmiResultTextView.text = getString(R.string.your_bmi_is_2f).format(bmi)
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy called")
    }

}
