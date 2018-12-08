package com.waga.waga01

import android.content.Context
import android.widget.Toast
import android.os.AsyncTask




class Doregister(val context: Context, val products : ArrayList<Produkt>,  val callBack: CallBack) : AsyncTask<String, String, String>() {

    internal var z = "komunikat"

    internal var isSuccess = false

    override fun onPreExecute() {
        this.callBack.UpdateMyText("Loading...")
    }

    override fun doInBackground(vararg params: String): String {

        try {
            val con = Connect().initConnection()
            if (con == null) {
                z = "nie udalo sie  płaczyć niestety xD"
            }else {
                isSuccess = true

                val query = " select * from Produkty "
                val stmt = con.createStatement()
                val rs = stmt.executeQuery(query)
                while(rs.next()) {
                    val product = Produkt(rs.getInt(1), rs.getString(2), rs.getInt(3))
                    products.add(product)
                }
            }
        } catch (ex: Exception) {
            isSuccess = false
            z = "Exceptions: $ex"
        }

       // this.callBack.UpdateMyText(z)
        return z
    }

    override fun onPostExecute(s: String) {

        Toast.makeText(context, "" + z, Toast.LENGTH_LONG).show()

        if (isSuccess) {
            //startActivity(new Intent(MainActivity.this,Main2Activity.class));
            Toast.makeText(context, "Połączono z bazą", Toast.LENGTH_LONG).show()
        }

       this.callBack.UpdateMyText("")
    }

    fun getProducts(): MutableList<Produkt>{
        return products
    }
}