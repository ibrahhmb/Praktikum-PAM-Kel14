package com.example.pinjemin.data

import com.example.pinjemin.model.Buku
import com.example.pinjemin.model.Peminjaman
import com.example.pinjemin.model.StatusPeminjaman
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SumberPeminjamanPalsu : Sumber<Peminjaman> {

    override suspend fun ambil(id: Int): Peminjaman {
        delay(1000)
        return Peminjaman(
            id = id,
            peminjam = "Saya Santoso",
            buku = Buku(
                id = 1,
                judul = "Pemrograman Kotlin Multiplatform",
                penulis = "Jane Doe",
                isbn = "978-602-0000-00-0",
                kategori = "Teknologi"
            ),
            tanggalPinjam = "2026-11-08",
            catatan = "Dipinjam untuk tugas praktikum",
            status = StatusPeminjaman.Diajukan
        )
    }

    override fun pantau(id: Int): Flow<Peminjaman> = flow {
        val peminjamanAwal = ambil(id)
        emit(peminjamanAwal.copy(status = StatusPeminjaman.Diajukan))
        delay(1500)
        emit(peminjamanAwal.copy(status = StatusPeminjaman.Disetujui("7 Hari", "Petugas Perpus")))
    }

    fun pantauStatus(id: Int): Flow<StatusPeminjaman> = flow {
        emit(StatusPeminjaman.Diajukan)
        delay(1500)
        emit(StatusPeminjaman.Disetujui("7 Hari", "Petugas Perpus"))
    }
}
