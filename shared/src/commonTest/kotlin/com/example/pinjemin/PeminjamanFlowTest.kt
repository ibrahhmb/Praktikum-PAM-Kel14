package com.example.pinjemin

import com.example.pinjemin.data.SumberPeminjamanPalsu
import com.example.pinjemin.model.StatusPeminjaman
import com.example.pinjemin.model.label
import com.example.pinjemin.model.ringkas
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class PeminjamanFlowTest {

    private val sumber = SumberPeminjamanPalsu()

    /**
     * Menguji Flow peminjaman lengkap dengan operator:
     * - filter: hanya loloskan semua status (tanpa filter khusus)
     * - map: ubah Peminjaman menjadi string ringkas
     * - onEach: cetak log setiap emisi
     * - collect: tampilkan hasil akhir ke konsol
     */
    @Test
    fun testFlowPeminjamanLengkap() = runBlocking {
        println("=== Flow Peminjaman Lengkap ===")

        sumber.pantau(1)
            .onEach { println("Log: ${it.ringkas()}") }
            .map { it.ringkas() }
            .collect { println("Tampilan: $it") }

        println("=== Selesai ===")
    }

    /**
     * Menguji Flow status peminjaman dengan operator filter, map, onEach, collect.
     * - filter: hanya loloskan status yang BUKAN Diajukan (status sudah diproses)
     * - map: ubah StatusPeminjaman menjadi teks menggunakan .label()
     * - onEach: cetak log setiap emisi
     * - collect: tampilkan hasil akhir ke konsol
     */
    @Test
    fun testFlowStatusDenganFilter() = runBlocking {
        println("=== Flow Status Peminjaman (Filter: bukan Diajukan) ===")

        sumber.pantauStatus(1)
            .filter { it !is StatusPeminjaman.Diajukan }
            .map { it.label() }
            .onEach { println("Log: $it") }
            .collect { println("Tampilan: $it") }

        println("=== Selesai ===")
    }

    /**
     * Menguji Flow status peminjaman tanpa filter
     * untuk memastikan output tercetak dari status awal hingga akhir.
     */
    @Test
    fun testFlowStatusTanpaFilter() = runBlocking {
        println("=== Flow Status Peminjaman (Semua Status) ===")

        sumber.pantauStatus(1)
            .map { it.label() }
            .onEach { println("Log: $it") }
            .collect { println("Tampilan: $it") }

        println("=== Selesai ===")
    }
}
