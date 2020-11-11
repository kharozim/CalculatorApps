package id.refactory.calculatorapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity(), Calculator {

    //    private lateinit var binding: ActivityMainBinding
    lateinit var tvInput: TextView
    lateinit var tvHasil: TextView

    var lastNumeric: Boolean = false
    var stateError: Boolean = false
    var lastDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvInput = findViewById(R.id.tvExpression)
        tvHasil = findViewById(R.id.tvResult)
    }

    override fun onDigit(view: View) {
        if (stateError) {
            tvInput.text = (view as TextView).text
            stateError = false
        } else {
            tvInput.append((view as TextView).text)

        }
        //set the flag
        lastNumeric = true
    }

    override fun onOperator(view: View) {
        if (lastNumeric && !stateError) {
            tvInput.append((view as TextView).text)
            lastNumeric = false
            lastDot = false    // Reset the DOT flag
        }
    }

    override fun onClear(view: View) {
        this.tvInput.text = ""
        this.tvHasil.text = ""
        lastNumeric = false
        stateError = false
        lastDot = false
    }

    override fun onEqual(view: View) {

        // If the current state is error, nothing to do.
        // If the last input is a number only, solution can be found.
        if (lastNumeric && !stateError) {
            // Read the expression
            val txt = tvInput.text.toString()
            // Create an Expression (A class from exp4j library)
            val expression = ExpressionBuilder(txt).build()
            try {
                // Calculate the result and display
                val result = expression.evaluate()
                tvHasil.text = result.toString()
                lastDot = true // Result contains a dot
            } catch (ex: ArithmeticException) {
                // Display an error message
                tvInput.text = "Error"
                stateError = true
                lastNumeric = false
            }
        }
    }

    override fun onBracketStrat(view: View) {
        tvInput.append("(")
    }

    override fun onvBracketEnd(view: View) {
        tvInput.append(")")
    }

    override fun onDecimal(view: View) {
        tvInput.append(".")
    }

    override fun onDelete(view: View) {
        val resultAfterDelete: String = tvInput.text.toString()
        if (resultAfterDelete.isNotEmpty()) {
            tvInput.text = resultAfterDelete.dropLast(n = 1)

        } else {
            tvInput.text = "0"
        }

    }


}