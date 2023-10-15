package com.ourproject.testdrivendevelopment

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Test

class LoadCryptoFeedRemoteUseCase1 {
    fun load() {
        HttpClient.instance.getCount = 1
    }
}

class HttpClient private constructor() {
    companion object {
        var instance = HttpClient()
    }
    var getCount = 0
}

class LoadCryptoFeedRemoteUseCaseTest1 {

    @Test
    fun testInitDoesNotLoad() {
        val client = HttpClient.instance
        LoadCryptoFeedRemoteUseCase1()

        assertTrue(client.getCount == 0)
    }

    @Test
    fun testLoadRequestData() {
        val client = HttpClient.instance
        val sut = LoadCryptoFeedRemoteUseCase1()

        sut.load()

        assertEquals(1, client.getCount)
    }
}