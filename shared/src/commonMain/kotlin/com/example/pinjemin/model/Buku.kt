package com.example.pinjemin.model

/**
 * Entitas Pendukung: Buku Perpustakaan
 *
 * @property id Identifier unik buku
 * @property judul Judul lengkap buku
 * @property penulis Penulis atau pengarang buku
 * @property isbn Nomor standar internasional buku (ISBN)
 * @property kategori Kategori/genre buku (tipe nullable jika belum ditentukan)
 */
data class Buku(
    val id: Int,
    val judul: String,
    val penulis: String,
    val isbn: String,
    val kategori: String? = null
)
