package id.refactory.calculatorapps

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import id.refactory.calculatorapps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //    private lateinit var binding: ActivityMainBinding
    var etShowNumber = findViewById<EditText>(R.id.etShowNumber)
    val bt0 = findViewById<Button>(R.id.bu0)
    val bt1 = findViewById<Button>(R.id.bu1)
    val bt2 = findViewById<Button>(R.id.bu2)
    val bt3 = findViewById<Button>(R.id.bu3)
    val bt4 = findViewById<Button>(R.id.bu4)
    val bt5 = findViewById<Button>(R.id.bu5)
    val bt6 = findViewById<Button>(R.id.bu6)
    val bt7 = findViewById<Button>(R.id.bu7)
    val bt8 = findViewById<Button>(R.id.bu8)
    val bt9 = findViewById<Button>(R.id.bu9)
    val btDot = findViewById<Button>(R.id.buDot)

    val btPlusMinus = findViewById<Button>(R.id.buPlusMinus)

    val btMul = findViewById<Button>(R.id.buMul)
    val btDiv = findViewById<Button>(R.id.buDiv)
    val btSub = findViewById<Button>(R.id.buSub)
    val btSum = findViewById<Button>(R.id.buSum)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
//        setContentView(binding.root)

    }

    var isNewOp = true
    var dot = false
    fun buNumberEvent(view: View) {
        if (isNewOp) {
            etShowNumber.setText("")
        }
        isNewOp = false
        val buSelect = view as Button
        var buClickValue: String = etShowNumber.text.toString()
        when (buSelect.id) {
            bt0.id -> {
                buClickValue += "0"
            }
            bt1.id -> {
                buClickValue += "1"
            }
            bt2.id -> {
                buClickValue += "2"
            }
            bt3.id -> {
                buClickValue += "3"
            }
            bt4.id -> {
                buClickValue += "4"
            }
            bt5.id -> {
                buClickValue += "5"
            }
            bt6.id -> {
                buClickValue += "6"
            }
            bt7.id -> {
                buClickValue += "7"
            }
            bt8.id -> {
                buClickValue += "8"
            }
            bt9.id -> {
                buClickValue += "9"
            }
            btDot.id -> {
                if (dot == false) {
                    buClickValue += "."
                }
                dot = true
            }
            btPlusMinus.id -> {
                buClickValue = "-$buClickValue"
            }
        }
        etShowNumber.setText(buClickValue)
    }

    var op = "X"
    var oldNumber = ""

    fun buOpEvent(view: View) {
        val buSelect = view as Button
        when (buSelect.id) {
            btMul.id -> {
                op = "X"
            }
            btDiv.id -> {
                op = "÷"
            }
            btSub.id -> {
                op = "-"
            }
            btSum.id -> {
                op = "+"
            }
        }
        oldNumber = etShowNumber.text.toString()
        isNewOp = true
        dot = false
    }

    fun buEqualEvent(view: View) {
        val newNumber = etShowNumber.text.toString()
        var finalNumber: Double? = null
        when (op) {
            "X" -> {
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "÷" -> {
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }
            "-" -> {
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
            "+" -> {
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }
        }
        etShowNumber.setText(finalNumber.toString())
        isNewOp = true
    }

    fun buPercentEvent(view: View) {
        val number = (etShowNumber.text.toString().toDouble()) / 100
        etShowNumber.setText(number.toString())
        isNewOp = true
    }

    fun buCleanEvent(view: View) {
        etShowNumber.setText("")
        isNewOp = true
        dot = false
    }
}