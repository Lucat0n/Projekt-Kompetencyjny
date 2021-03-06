package com.waga.waga01


import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView

class MainActivity : CallBack, AppCompatActivity() {
    override fun UpdateMyText(mystr: String) {
        val textView = findViewById<View>(R.id.textView2) as TextView
        textView.text = mystr
    }

    val products : ArrayList<Produkt> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connect()
    }

    fun setValue (view: View){
        val textView = findViewById<TextView>(R.id.textView)
        val editText = findViewById<EditText>(R.id.editText)

        textView.text = editText.text.toString()
    }

    fun resetValue (view: View){
        println("hello")
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = "0"
    }

    fun updateValue (view: View) {
        val table = findViewById<TableLayout>(R.id.table)
        products.forEach{prod ->
            val row = TableRow(this)
            val label1 = TextView(this)
            val label2 = TextView(this)
            val label3 = TextView(this)

            label1.text = prod.id.toString()
            label2.text = prod.name
            label3.text = prod.category.toString()

            label1.setTextColor(Color.parseColor("#FFFFFF"))
            label2.setTextColor(Color.parseColor("#FFFFFF"))
            label3.setTextColor(Color.parseColor("#FFFFFF"))

            label1.setTextSize(TypedValue.COMPLEX_UNIT_DIP,24F)
            label2.setTextSize(TypedValue.COMPLEX_UNIT_DIP,24F)
            label3.setTextSize(TypedValue.COMPLEX_UNIT_DIP,24F)

            row.addView(label1)
            row.addView(label2)
            row.addView(label3)

            table.addView(row)
        }
    }

    fun connect(){
        val reg = Doregister(this, products,  object : CallBack {
            override fun UpdateMyText(mystr: String) {
                val textView = findViewById<View>(R.id.textView2) as TextView
                textView.text = mystr
            }
        })
        reg.execute()
        products.addAll(reg.getProducts())
    }
}

