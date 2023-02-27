package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var equalPressed = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val txtField:TextView = findViewById(R.id.textView1)
        val clear: Button = findViewById(R.id.btnClear)
        val equals:Button = findViewById(R.id.btnEqual)
        val btn0:Button = findViewById(R.id.btn0)
        val btn1:Button = findViewById(R.id.btn1)
        val btn2:Button = findViewById(R.id.btn2)
        val btn3:Button = findViewById(R.id.btn3)
        val btn4:Button = findViewById(R.id.btn4)
        val btn5:Button = findViewById(R.id.btn5)
        val btn6:Button = findViewById(R.id.btn6)
        val btn7:Button = findViewById(R.id.btn7)
        val btn8:Button = findViewById(R.id.btn8)
        val btn9:Button = findViewById(R.id.btn9)
        val btnPlus:Button = findViewById(R.id.btnPlus)
        val btnMinus:Button = findViewById(R.id.btnMinus)
        val btnMultiply:Button = findViewById(R.id.btnMultiply)
        val btnDivide:Button = findViewById(R.id.btnDivide)


        clear.setOnClickListener {
            txtField.text = ""
        }
        equals.setOnClickListener {
            txtField.text = "idk yet"
            equalPressed = true
        }

        btn0.setOnClickListener{
            appendButtonText(txtField, btn0)
        }
        btn1.setOnClickListener{
            appendButtonText(txtField, btn1)
        }
        btn2.setOnClickListener{
            appendButtonText(txtField, btn2)
        }
        btn3.setOnClickListener{
            appendButtonText(txtField, btn3)
        }
        btn4.setOnClickListener{
            appendButtonText(txtField, btn4)
        }
        btn5.setOnClickListener{
            appendButtonText(txtField, btn5)
        }
        btn6.setOnClickListener{
            appendButtonText(txtField, btn6)
        }
        btn7.setOnClickListener{
            appendButtonText(txtField, btn7)
        }
        btn8.setOnClickListener{
            appendButtonText(txtField, btn8)
        }
        btn9.setOnClickListener{
            appendButtonText(txtField, btn9)
        }
        btnPlus.setOnClickListener{
            appendButtonText(txtField, btnPlus)
        }
        btnMinus.setOnClickListener{
            appendButtonText(txtField, btnMinus)
        }
        btnMultiply.setOnClickListener{
            appendButtonText(txtField, btnMultiply)
        }
        btnDivide.setOnClickListener{
            appendButtonText(txtField, btnDivide)
        }
    }

  fun appendButtonText(view: TextView, button: Button) {
      if(equalPressed) {
          view.text = ""
          equalPressed = false
      }
      view.append(button.text)
  }


}

//class testThing:OnClickListener {
//    override fun onClick(p0: View?) {
//        MainActivity.appendButtonText(MainActivity.txtField,p0)
//    }
//}