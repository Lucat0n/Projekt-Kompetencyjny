package com.waga.waga01

import android.os.StrictMode
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class Connect() {
    fun initConnection(): Connection? {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        var conn: Connection? = null
        val ConnURL: String
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver")
            ConnURL = String.format(
                "jdbc:jtds:sqlserver://kuchnia.database.windows.net:1433/Produkty;" +
                        "user=SzefKuchni;password=Mudz!n1337;encrypt=true;" +
                        "trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;"
            )

            conn = DriverManager.getConnection(ConnURL)

        } catch (e: SQLException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return conn
    }
}