package com.example.samplecalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private var result: Int = 0
    private var operand: Int = 0
    private var operator: String = ""
    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCE: Button = findViewById(R.id.buttonCE)
        buttonCE.setOnClickListener { actCE() }
        val buttonC: Button = findViewById(R.id.buttonC)
        buttonC.setOnClickListener { actC() }
        val buttonBS: Button = findViewById(R.id.buttonBS)
        buttonBS.setOnClickListener { actBS() }
        val buttonDivide: Button = findViewById(R.id.buttonDivide)
        buttonDivide.setOnClickListener { actOperator("Divide") }
        val button7: Button = findViewById(R.id.button7)
        button7.setOnClickListener { actNumber(7) }
        val button8: Button = findViewById(R.id.button8)
        button8.setOnClickListener { actNumber(8) }
        val button9: Button = findViewById(R.id.button9)
        button9.setOnClickListener { actNumber(9) }
        val buttonMulti: Button = findViewById(R.id.buttonMulti)
        buttonMulti.setOnClickListener { actOperator("Multi") }
        val button4: Button = findViewById(R.id.button4)
        button4.setOnClickListener { actNumber(4) }
        val button5: Button = findViewById(R.id.button5)
        button5.setOnClickListener { actNumber(5) }
        val button6: Button = findViewById(R.id.button6)
        button6.setOnClickListener { actNumber(6) }
        val buttonMinus: Button = findViewById(R.id.buttonMinus)
        buttonMinus.setOnClickListener { actOperator("Minus") }
        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener { actNumber(1) }
        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener { actNumber(2) }
        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener { actNumber(3) }
        val buttonPlus: Button = findViewById(R.id.buttonPlus)
        buttonPlus.setOnClickListener { actOperator("Plus") }
        val buttonSign: Button = findViewById(R.id.buttonSign)
        buttonSign.setOnClickListener { actSign() }
        val button0: Button = findViewById(R.id.button0)
        button0.setOnClickListener { actNumber(0) }
        val buttonEqual: Button = findViewById(R.id.buttonEqual)
        buttonEqual.setOnClickListener { actOperator("Equal") }
    }

    private fun actCE() {
        if (operand != 0) {
            operand = 0
            show(0)
        }
    }

    private fun actC() {
        result = 0
        operand = 0
        count = 0
        show(0)
    }

    private fun actBS() {
        if (operand != 0) {
            operand /= 10
            show(operand)
        }
    }

    private fun actOperator(tmp: String) {
        if (count != 0) {
            if (operator == "Divide") {
                if (operand == 0) {
                    val textView: TextView = findViewById(R.id.result)
                    textView.text = "Infinity"
                    result = 0
                } else {
                    result /= operand
                    show(result)
                }
            } else if (operator == "Multi") {
                result *= operand
                show(result)
            } else if (operator == "Minus") {
                result -= operand
                show(result)
            } else if (operator == "Plus") {
                result += operand
                show(result)
            } else if (operator == "Equal") {
                operator = tmp
                return
            }
        } else result = operand
        ++count
        operand = 0
        operator = tmp
    }

    private fun actNumber(tmp: Int) {
        if (operator == "equal") {
            result = 0
            count = 0
        }
        operand *= 10
        operand += tmp
        show(operand)
    }

    private fun actSign() {
        if (operand != 0) {
            operand *= -1
            show(operand)
        } else {
            result *= -1
            show(result)
        }
    }

    private fun show(tmp: Int) {
        val textView: TextView = findViewById(R.id.result)
        textView.text = tmp.toString()
    }
}
