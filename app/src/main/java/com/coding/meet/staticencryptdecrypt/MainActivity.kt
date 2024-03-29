package com.coding.meet.staticencryptdecrypt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import java.nio.charset.StandardCharsets

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val randomKeyBtn = findViewById<Button>(R.id.randomKeyBtn)
        randomKeyBtn.setOnClickListener {
            val securityManager = SecurityManager()

            // Generate a random key for encryption
            val randomKey = securityManager.generateRandomKey()
            Log.d("randomKey", String(randomKey))
        }


        val encDecryBtn = findViewById<Button>(R.id.encDecryBtn)
        encDecryBtn.setOnClickListener {

            val securityManager = SecurityManager()

//            // Generate a random key for encryption
//            val randomKey = securityManager.generateRandomKey()
//            Log.d("randomKey", String(randomKey))

            // Replace with actual external key
            val externalKey = "750GdiCY1GWXzRjH2W9esuGDGAzNNvbVbxfAAAN65mt5WrZwlz49KgpYzFhLQejd".toByteArray(StandardCharsets.UTF_8)
            Log.d("externalKey",String(externalKey))


            // Replace with your static string or Api key, URL
            val valueToEncrypt = "DevCoding123Meet"

            // Encrypt the string using the random key
            val encryptedString = securityManager.encryptStringWithKey(externalKey,valueToEncrypt)

            // Decrypt the Encrypted string using the same random key
            securityManager.decryptStringWithKey(externalKey,encryptedString)


        }

        val externalEncDecryBtn = findViewById<Button>(R.id.externalEncDecryBtn)
        externalEncDecryBtn.setOnClickListener {

            val securityManager = SecurityManager()

            // Replace with actual external key
            val externalKey = "LcYPI8pffXE3p9xrPf4uNOz4vuMhWqOwyTWqmqij36mWWdcaGYVxFRrP8PAA8H9d".toByteArray(StandardCharsets.UTF_8)
            Log.d("externalKey",String(externalKey))

            // Replace with actual encrypted Key
            val externalEncryptedString = "AAEBQAwAAAAQAAAAHgAAAGAjUeM37mcAHKoul6BenIxfm/QXrVdn/tUW3Eb2BCEA87kDKsYFZAVD3ZeIGjXCaZausUTSJMHWKO4="
            Log.d("externalEncryptedString",externalEncryptedString)

            // Decrypt the External Encrypted string using the external key
            securityManager.decryptStringWithKey(externalKey,externalEncryptedString)
        }
    }
}