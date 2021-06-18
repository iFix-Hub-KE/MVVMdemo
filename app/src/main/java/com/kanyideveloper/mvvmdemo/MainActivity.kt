package com.kanyideveloper.mvvmdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addButton: Button = findViewById(R.id.addButton)
        val num1EditText: EditText = findViewById(R.id.num1)
        val num2EditText: EditText = findViewById(R.id.num2)
        val answerTextView: TextView = findViewById(R.id.textViewSum)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        addButton.setOnClickListener {
            if (num1EditText.text.toString().isEmpty() || num2EditText.text.toString().isEmpty()) {
                return@setOnClickListener
            } else {
                viewModel.addTwoNums(
                    num1EditText.text.toString().toInt(),
                    num2EditText.text.toString().toInt()
                )
                //answerTextView.text = addTwoNums(num1EditText.text.toString().toInt(),num2EditText.text.toString().toInt()).toString()
            }
        }

        viewModel.result.observe(this, Observer {
            answerTextView.text = it.toString()
        })
    }
}