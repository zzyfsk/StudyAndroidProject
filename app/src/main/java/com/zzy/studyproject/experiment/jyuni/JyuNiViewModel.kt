package com.zzy.studyproject.experiment.jyuni

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.io.PrintWriter
import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.Socket

class JyuNiViewModel : ViewModel() {
    private val TAG = "Viewmodel"
    var socket: Socket? = null

    var socketAddress: InetSocketAddress? = null

    var input: BufferedReader? = null
    var output: PrintWriter? = null

    var port by mutableStateOf("9999")
    var ip by mutableStateOf("")

    val textList = mutableStateListOf<String>()

    suspend fun toggleConnection() {
        ip = "here"
        if (socket == null || socket!!.isClosed) {
            connectToServer()
        }
    }

    private suspend fun connectToServer() {
        try {
            socket = Socket()
            withContext(Dispatchers.IO) {
                Log.d(TAG, "connectToServer: ")
                socketAddress = InetSocketAddress(InetAddress.getLocalHost(), port.toInt())
                socket?.connect(socketAddress, 1000)
                input = BufferedReader(InputStreamReader(socket?.getInputStream()))
                output = PrintWriter(OutputStreamWriter(socket?.getOutputStream()))
                while (true) readMessage()
            }

        } catch (e: IOException) {
            println(e.localizedMessage)
        }
    }

    private suspend fun readMessage() {
        Log.d("TAG", "readMessage: ")
        withContext(Dispatchers.IO) {
            while (true) {
                Log.d(TAG, "readMessage: ")
                if (input?.readLine().also {
                        if (it != null) {
                            textList.add(it)
                        }
                    } == null) {
                    continue
                }
                Log.e(TAG, "readMessage: ${textList.size}")
            }
        }
    }
}