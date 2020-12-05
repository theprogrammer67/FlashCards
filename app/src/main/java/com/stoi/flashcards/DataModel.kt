package com.stoi.flashcards

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Card(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val front: String,
    val back: String
)
