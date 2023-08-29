package com.coding.meet.staticencryptdecrypt

import android.util.Base64
import android.util.Log
import com.cossacklabs.themis.SecureCell
import com.cossacklabs.themis.SymmetricKey
import java.nio.charset.StandardCharsets
import kotlin.random.Random


class SecurityManager {

    // Generates a random key for encryption
    fun generateRandomKey(): ByteArray {
        val charPool = ('a' .. 'z') + ('A' .. 'Z') + ('0' .. '9')
        val keySize = 64
        val key = (1 .. keySize)
            .map { Random.nextInt(0,charPool.size).let { charPool[it] } }
            .joinToString("")

        return key.toByteArray(StandardCharsets.UTF_8)
    }

    // Encrypts a String using the provided key
    fun encryptStringWithKey(key :ByteArray, value: String):String{

        val symmetricKey = SymmetricKey(key)
        val secureCell =  SecureCell.SealWithKey(symmetricKey)


        val encryptedData = secureCell.encrypt(value.toByteArray())
        val encryptedString = Base64.encodeToString(encryptedData,Base64.DEFAULT)

        Log.d("encryptedString",encryptedString)

        return encryptedString

    }

    // Decrypts a encrypted string using provided key
    fun decryptStringWithKey(key: ByteArray,encryptedString:String){

        val symmetricKey = SymmetricKey(key)
        val secureCell =  SecureCell.SealWithKey(symmetricKey)

        val decodedData = Base64.decode(encryptedString,Base64.DEFAULT)
        val decryptedString = String(secureCell.decrypt(decodedData))

        Log.d("decryptedString",decryptedString)
    }

}