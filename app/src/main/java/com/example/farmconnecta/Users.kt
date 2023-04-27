package com.example.farmconnecta

data class Users(
    val fName: String = "",
    val lName: String = "",
    val email: String = "",
    val password: String = "",
    val phoneNumber: String = "",
    val location: String = ""
) {
    constructor() : this("", "", "", "", "", "")
}