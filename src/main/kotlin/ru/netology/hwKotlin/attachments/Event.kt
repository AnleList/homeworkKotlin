package ru.netology.hwKotlin.attachments

interface Event {
    val id: Int
    val time: Int
    val memberStatus: Int
    val isFavorite: Boolean
    val address: String
    val text: String
    val buttonText: String
    val friends: Array<Int>?

}