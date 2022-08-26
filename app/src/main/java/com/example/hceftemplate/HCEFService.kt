package com.example.hceftemplate

import android.nfc.cardemulation.HostNfcFService
import android.os.Bundle

class HCEFService : HostNfcFService() {
    override fun processNfcFPacket(commandPacket: ByteArray, extras: Bundle?): ByteArray {
        return ByteArray(0)
    }

    override fun onDeactivated(reason: Int) {
    }
}