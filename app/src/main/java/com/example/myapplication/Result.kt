package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Result : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result)

        val bmi = intent.getFloatExtra("BMI_VALUE", 0.0f)

        val bmiTextView = findViewById<TextView>(R.id.bmi_text_view)
        val tipsTextView = findViewById<TextView>(R.id.tips_text_view)
        val shareButton = findViewById<Button>(R.id.share_button)
        val infoButton = findViewById<Button>(R.id.info_button)

        bmiTextView.text = "Your BMI is: %.1f".format(bmi)

        tipsTextView.text = when {
            bmi < 18.5 -> "skinny ahh"
            bmi in 18.5..24.9 -> "decent!"
            bmi in 25.0..29.9 -> "fattie"
            else -> "so fat"
        }

        shareButton.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "My BMI is %.1f".format(bmi))
            startActivity(Intent.createChooser(shareIntent, "Share BMI via"))
        }

        infoButton.setOnClickListener {
            val url = "https://www.cdc.gov/bmi/about/index.html#:~:text=BMI%20as%20a%20measure,their%20height%20(in%20meters).&text=Although%20BMI%20does%20not%20directly,and%20distribution%20of%20body%20fat."
            val infoIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(infoIntent)
        }
    }
}
