package com.example.pinjemin.model

class Peminjaman {
    val id: Int,
    val peminjam: String,
    val buku: Buku,
    val tanggalPinjam: String,
    val catatan: String? = null,
    val status: StatusPeminjaman = StatusPeminjaman.Diajukan
}