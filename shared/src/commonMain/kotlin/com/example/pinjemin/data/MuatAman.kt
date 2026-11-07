package com.example.pinjemin.data

import kotlinx.coroutines.CancellationException

suspend fun <T> muatAman(id: Int, sumber: Sumber<T>): String =
    try {
        require(id > 0) { "ID harus positif" }
        val data = sumber.ambil(id)
        "Berhasil memuat data: $data"
    } catch (e: CancellationException) {
        throw e
    } catch (e: Exception) {
        "Gagal memuat data untuk ID #$id: ${e.message}"
    }