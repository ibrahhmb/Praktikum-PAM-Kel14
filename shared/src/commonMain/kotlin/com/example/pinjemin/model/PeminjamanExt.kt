package com.example.pinjemin.model

/**
 * Extension functions untuk format tampilan status dan ringkasan peminjaman
 */
fun StatusPeminjaman.label(): String {
    return when (this) {
        is StatusPeminjaman.Diajukan -> "Diajukan"
        is StatusPeminjaman.Disetujui -> "Disetujui (Batas: $batasPinjam, Petugas: $petugas)"
        is StatusPeminjaman.Ditolak -> "Ditolak (Alasan: $alasan)"
    }
}

fun Peminjaman.ringkas(): String {
    val infoCatatan = catatan ?: "Tidak ada catatan"
    return "#$id: $peminjam - ${buku.judul} | Status: ${status.label()} | Catatan: $infoCatatan"
}