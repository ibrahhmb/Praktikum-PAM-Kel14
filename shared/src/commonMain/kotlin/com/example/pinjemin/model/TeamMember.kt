package com.example.pinjemin.model

/**
 * Data model untuk anggota tim Kelompok 14 - Pinjem.in.
 */
data class TeamMember(
    val id: Int,
    val name: String,
    val nim: String,
    val githubUsername: String,
    val initials: String
)


val teamMembers = listOf(
    TeamMember(
        id = 1,
        name = "Ibrahim Budi Satria",
        nim = "123140097",
        githubUsername = "github.com/ibrahhmb",
        initials = "IBS"
    ),

    TeamMember(
        id = 2,
        name = "",
        nim = "",
        githubUsername = "github.com/",
        initials = ""
    ),

    TeamMember(
        id = 3,
        name = "",
        nim = "",
        githubUsername = "github.com/",
        initials = ""
    ),

    TeamMember(
        id = 4,
        name = "",
        nim = "",
        githubUsername = "github.com/",
        initials = ""
    ),

    TeamMember(
        id = 5,
        name = "",
        nim = "",
        githubUsername = "github.com/",
        initials = ""
    )
)
