package com.avsc.laboratorio_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var btnFiveCents: ImageView
    private lateinit var btnTenCents: ImageView
    private lateinit var btnDollarCents: ImageView
    private lateinit var btnQuarterCents: ImageView
    private lateinit var tvCont: TextView

    private val five = 0.05
    private val ten = 0.10
    private val quarter = 0.25
    private val dollar = 1.00
    private var cont_aux = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        clickListenersFunction()
    }

    private fun bind(){
        btnFiveCents = findViewById(R.id.image_five_cents)
        btnTenCents = findViewById(R.id.ten_cents)
        btnQuarterCents = findViewById(R.id.quarter_cents)
        btnDollarCents = findViewById(R.id.one_dollar)

        tvCont =findViewById(R.id.cont)
    }

    private fun clickListenersFunction(){
        btnFiveCents.setOnClickListener{
            cont_aux += five
            cont_aux = String.format("%.2f",cont_aux).toDouble()
            tvCont.text ="$${cont_aux}"
        }

        btnTenCents.setOnClickListener{
            cont_aux += ten
            cont_aux = String.format("%.2f",cont_aux).toDouble()
            tvCont.text ="$${cont_aux}"
        }

        btnQuarterCents.setOnClickListener{
            cont_aux += quarter
            cont_aux = String.format("%.2f",cont_aux).toDouble()
            tvCont.text ="$${cont_aux}"
        }

        btnDollarCents.setOnClickListener{
            cont_aux += dollar
            cont_aux = String.format("%.2f",cont_aux).toDouble()
            tvCont.text ="$${cont_aux}"
        }
    }
}