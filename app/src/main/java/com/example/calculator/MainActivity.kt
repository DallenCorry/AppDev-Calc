package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.room.Room
import com.example.calculator.database.EntryDB
import com.example.calculator.database.Entry

class MainActivity : AppCompatActivity() {
    var equalPressed = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //DB stuff
        val db = Room.databaseBuilder(
            applicationContext,
            EntryDB::class.java, //gives the schema
            "entry"//the name of the table in the database
        ).build()


        val testDao = db.entryDao()
        //add to database. Setting it to 0 will allow autogeneration of keys.
        testDao.insertAll(Entry(0, "Test4", 14.0))

        //retreive from database
        val entryList: List<Entry> = testDao.getAll()
        val prevEntries:TextView = findViewById(R.id.previousFormulae)
        prevEntries.text = entryList.toString()


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
            try {
                txtField.text = "${eval(txtField.text)}"
            }
            catch (ex: BadEvalException) {
                txtField.text = "Error: ${ex.message}"
            }
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


    class BadEvalException(message: String): Exception(message) {

    }


    fun eval(s: CharSequence): Double {
        var finalVal = 0.0
        if (finalVal == 0.0) {
            throw BadEvalException("Class \"kotlin.js.eval\" Not found")
        }
        return finalVal
    }

  fun appendButtonText(view: TextView, button: Button) {
      if(equalPressed) {
          view.text = ""
          equalPressed = false
      }
      //If it's an operation, only allow one to be put at a time
      if(
          button.id == R.id.btnPlus ||
          button.id == R.id.btnMinus ||
          button.id == R.id.btnMultiply ||
          button.id == R.id.btnDivide
      ) {
          println("${view.length()!=0}")
          if (view.length()!=0) {
              if (
                  view.text.endsWith('+') ||
                  view.text.endsWith('-') ||
                  view.text.endsWith('*') ||
                  view.text.endsWith('/')
              ) {
//              val temp = view.text.substring(0, view.text.length - 1)
                  view.text = view.text.substring(0, view.text.length - 1)
              }
              view.append(button.text)
          }
      } else {
          view.append(button.text)
      }
  }
}