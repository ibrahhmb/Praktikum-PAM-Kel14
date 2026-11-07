package com.example.pinjemin.model

/**
 * Sealed class untuk status peminjaman buku dengan 3 kondisi:
 * 1. [Diajukan]: Pengajuan awal peminjaman buku oleh anggota perpustakaan.
 * 2. [Disetujui]: Peminjaman telah diverifikasi dan disetujui petugas.
 * 3. [Ditolak]: Peminjaman ditolak dengan alasan tertentu.
 */
sealed class StatusPeminjaman {
    data object Diajukan : StatusPeminjaman()

    data class Disetujui(
        val batasPinjam: String,
        val petugas: String
    ) : StatusPeminjaman()

    data class Ditolak(
        val alasan: String
    ) : StatusPeminjaman()
}
