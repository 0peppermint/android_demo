package com.demo.mashiro

import android.content.Intent
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.demo.flow.FlowTestActivity
import com.demo.multifragment.useViewPager2.MultiFragmentActivityV2
import com.demo.nativecrash.MyCrashActivity
import com.demo.proxy.sample.ProxyInstance
import kotlinx.android.synthetic.main.activity_main.*
import java.nio.charset.StandardCharsets
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_transition_experiment.setOnClickListener {
            val intent = Intent(this, MultiFragmentActivityV2::class.java)
            this.startActivity(intent)
        }

        btn_native_crash.setOnClickListener {
            val intent = Intent(this, MyCrashActivity::class.java)
            this.startActivity(intent)
        }
        btn_proxy.setOnClickListener{
            ProxyInstance.getMyProxy()
        }
        btn_decrpyto.setOnClickListener {
            decrypto()
        }
        btn_flow.setOnClickListener {
            val intent = Intent(this, FlowTestActivity::class.java)
            startActivity(intent)
        }
    }

    private fun decrypto(){
        val enc = "bKhM9b9mSM2Xff4XgzzrYUXhKwfBxzUd30bdW3sOxpClsxmuVh04Ny7VAQhbjKui"
        val key = "yuNttCSojTyxZods"
        val encbyte = Base64.decode(enc, Base64.NO_WRAP)
        val cipher: Cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING")
        cipher.init(Cipher.DECRYPT_MODE, SecretKeySpec(key.toByteArray(), "AES"), IvParameterSpec(ByteArray(16)))
        val ciphertext: ByteArray = cipher.doFinal(encbyte)
        Log.d("zyc", String(ciphertext))
    }
}