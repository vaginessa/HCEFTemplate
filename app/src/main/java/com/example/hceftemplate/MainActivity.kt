package com.example.hceftemplate

import android.content.ComponentName
import android.nfc.NfcAdapter
import android.nfc.cardemulation.NfcFCardEmulation
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var nfcFCardEmulation: NfcFCardEmulation? = null

    // TODO change to your own package name
    private val myComponentName = ComponentName(
        "com.example.hceftemplate",
        "com.example.hceftemplate.HCEFService"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nfcAdapter = NfcAdapter.getDefaultAdapter(this)

        nfcFCardEmulation = NfcFCardEmulation.getInstance(nfcAdapter)

        // if nfcFCardEmulation is null, HCE-F is not supported
    }

    override fun onResume() {
        super.onResume()
        nfcFCardEmulation?.enableService(this, myComponentName)
    }

    override fun onPause() {
        super.onPause()
        nfcFCardEmulation?.disableService(this)
    }

}