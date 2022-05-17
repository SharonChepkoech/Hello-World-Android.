package com.example.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalculateBmiActivity : AppCompatActivity() {
    lateinit var btnCalculate: Button
    lateinit var etWeight: EditText
    lateinit var etHeight: EditText
    lateinit var tvBmi: TextView
    lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate_bmi)
        btnCalculate = findViewById(R.id.btnCalculate)
        etWeight = findViewById(R.id.etWeight)
        etHeight = findViewById(R.id.etHeight)
        tvBmi = findViewById(R.id.tvBMI)
        tvStatus = findViewById(R.id.tvStatus)

        btnCalculate.setOnClickListener {
            var weight = etWeight.text.toString()
            var height = etHeight.text.toString()
            if (weight.isBlank()) {
                etWeight.error = "Weight is required"
                return@setOnClickListener
            }
            if (height.isBlank()) {
                etHeight.error = "Height is required"
                return@setOnClickListener
            }
            calculateBmi(weight.toDouble(), height.toInt())
        }
    }
    fun calculateBmi(weight: Double, height: Int){
        var heightMeters = height/100.0
        val bmi = weight/(heightMeters*heightMeters)
        tvBmi.text = bmi.toString()
        if(bmi<= 25.0){
            tvStatus.text = ("Normalweight")
        }
        else if (bmi<= 30.0){
            tvStatus.text = ("Overrweight")
        }
        else if (bmi<18.5){
            tvStatus.text = ("Underweight")
        }
        else {
            tvStatus.text = ("Obese")
        }
    }

}