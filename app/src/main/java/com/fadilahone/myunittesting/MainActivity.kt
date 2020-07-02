package com.fadilahone.myunittesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btnSave :Button
    lateinit var btnCalculateVolume :Button
    lateinit var btnCalculateSurfaceArea :Button
    lateinit var btnCalculateCircumFerence :Button
    lateinit var editHeight :EditText
    lateinit var editLength :EditText
    lateinit var editWidth :EditText
    lateinit var textResult :TextView
    lateinit var mainViewModel :MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editHeight = findViewById(R.id.edit_height)
        editLength = findViewById(R.id.edit_length)
        editWidth = findViewById(R.id.edit_width)
        btnSave = findViewById(R.id.btn_save)
        btnCalculateVolume = findViewById(R.id.btn_calcu_volume)
        btnCalculateSurfaceArea = findViewById(R.id.btn_calcu_surface_area)
        btnCalculateCircumFerence = findViewById(R.id.btn_calcu_circum_preferenc)
        textResult = findViewById(R.id.text_result)

        btnSave.setOnClickListener(this)
        btnCalculateVolume.setOnClickListener(this)
        btnCalculateSurfaceArea.setOnClickListener(this)
        btnCalculateCircumFerence.setOnClickListener(this)

        mainViewModel = MainViewModel(CuboyModel())
    }

    override fun onClick(v: View) {
        val length = editLength.text.toString().trim()
        val width = editWidth.text.toString().trim()
        val height = editHeight.text.toString().trim()
        when {
            length.isEmpty() -> editLength.error = "Field ini tidak boleh kosong"
            width.isEmpty() -> editWidth.error = "Field ini tidak boleh kosong"
            height.isEmpty() -> editHeight.error = "Field ini tidak boleh kosong"
            else -> {
                val l = length.toDouble()
                val w = width.toDouble()
                val h = height.toDouble()
                when {
                    v.id == R.id.btn_save -> {
                        mainViewModel.save(l, w, h)
                        visible()
                    }
                    v.id == R.id.btn_calcu_circum_preferenc -> {
                        textResult.text = mainViewModel.getCircumPreferen().toString()
                        gone()
                    }
                    v.id == R.id.btn_calcu_surface_area -> {
                        textResult.text = mainViewModel.getSurfaceArea().toString()
                        gone()
                    }
                    v.id == R.id.btn_calcu_volume -> {
                        textResult.text = mainViewModel.getVolume().toString()
                        gone()
                    }
                }
            }
        }
    }
    private fun visible() {
        btnCalculateVolume.visibility = View.VISIBLE
        btnCalculateCircumFerence.visibility = View.VISIBLE
        btnCalculateSurfaceArea.visibility = View.VISIBLE
        btnSave.visibility = View.GONE
    }
    private fun gone() {
        btnCalculateVolume.visibility = View.GONE
        btnCalculateCircumFerence.visibility = View.GONE
        btnCalculateSurfaceArea.visibility = View.GONE
        btnSave.visibility = View.VISIBLE
    }
}