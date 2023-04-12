package com.example.assign2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var firstNumberSpinner: Spinner
    private lateinit var secondNumberSpinner: Spinner
    private lateinit var operationSpinner: Spinner
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstNumberSpinner = findViewById(R.id.firstNumberSpinner)
        secondNumberSpinner = findViewById(R.id.secondNumberSpinner)
        resultTextView = findViewById(R.id.textView)

        val numbers = arrayOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, numbers)
        firstNumberSpinner.adapter = adapter
        secondNumberSpinner.adapter = adapter

        val operations = arrayOf("+", "-", "*", "/", "%")
        val operationAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, operations)
        operationSpinner.adapter = operationAdapter

        val addButton = findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener {
            performCalculation { a, b -> a + b }
        }

        val subtractButton = findViewById<Button>(R.id.subtractButton)
        subtractButton.setOnClickListener {
            performCalculation { a, b -> a - b }
        }
        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        multiplyButton.setOnClickListener {
            performCalculation { a, b -> a * b }
        }

        val divideButton = findViewById<Button>(R.id.divideButton)
        divideButton.setOnClickListener {
            performCalculation { a, b -> a / b }
        }

        val modButton = findViewById<Button>(R.id.modButton)
        modButton.setOnClickListener {
            performCalculation { a, b -> a % b }
        }




    }
    private fun performCalculation(operation: (Int, Int) -> Int) {
        val firstNumber = firstNumberSpinner.selectedItem.toString().toInt()
        val secondNumber = secondNumberSpinner.selectedItem.toString().toInt()
        val result = operation(firstNumber, secondNumber)
        resultTextView.text = result.toString()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.mymenu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_item1 -> {
                val fragment = MyFrag()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}