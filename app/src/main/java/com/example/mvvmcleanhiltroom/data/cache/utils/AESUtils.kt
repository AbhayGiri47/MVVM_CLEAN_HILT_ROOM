package com.example.mvvmcleanhiltroom.data.cache.utils

import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

object AESUtils {

    private const val ALGORITHM = "AES"

    private val keyValue = byteArrayOf(
        'c'.code.toByte(),
        'o'.code.toByte(),
        'd'.code.toByte(),
        'i'.code.toByte(),
        'n'.code.toByte(),
        'g'.code.toByte(),
        'a'.code.toByte(),
        'f'.code.toByte(),
        'f'.code.toByte(),
        'a'.code.toByte(),
        'i'.code.toByte(),
        'r'.code.toByte(),
        's'.code.toByte(),
        'c'.code.toByte(),
        'o'.code.toByte(),
        'm'.code.toByte()
    )

    @Throws(Exception::class)
    fun encrypt(cleartext: String?): String? {
        if(cleartext.isNullOrEmpty()) return cleartext
        val rawKey = rawKey
        val result = encrypt(rawKey, cleartext.toByteArray())
        return toHex(result)
    }

    @Throws(Exception::class)
    fun decrypt(encrypted: String?): String? {
        if(encrypted.isNullOrEmpty()) return encrypted
        val enc = toByte(encrypted)
        val result = decrypt(enc)
        return String(result)
    }

    @get:Throws(Exception::class)
    private val rawKey: ByteArray
        get() {
            val key: SecretKey = SecretKeySpec(keyValue, ALGORITHM)
            return key.encoded
        }

    @Throws(Exception::class)
    private fun encrypt(raw: ByteArray, clear: ByteArray): ByteArray {
        val skeySpec: SecretKey = SecretKeySpec(raw, ALGORITHM)
        val cipher = Cipher.getInstance(ALGORITHM)
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec)
        return cipher.doFinal(clear)
    }

    @Throws(Exception::class)
    private fun decrypt(encrypted: ByteArray): ByteArray {
        val skeySpec: SecretKey = SecretKeySpec(keyValue, ALGORITHM)
        val cipher = Cipher.getInstance(ALGORITHM)
        cipher.init(Cipher.DECRYPT_MODE, skeySpec)
        return cipher.doFinal(encrypted)
    }

    private fun toByte(hexString: String): ByteArray {
        val len = hexString.length / 2
        val result = ByteArray(len)
        for (i in 0 until len) result[i] = Integer.valueOf(
            hexString.substring(2 * i, 2 * i + 2),
            16
        ).toByte()
        return result
    }

    private fun toHex(buf: ByteArray?): String {
        if (buf == null) return ""
        val result = StringBuffer(2 * buf.size)
        for (b in buf) {
            appendHex(result, b)
        }
        return result.toString()
    }

    private const val HEX = "0123456789ABCDEF"
    private fun appendHex(sb: StringBuffer, b: Byte) {
        sb.append(HEX[b.toInt() shr 4 and 0x0f]).append(HEX[b.toInt() and 0x0f])
    }
}