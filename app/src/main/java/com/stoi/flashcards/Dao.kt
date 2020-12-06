package com.stoi.flashcards

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FlashCardsDao {
    @Query("SELECT * FROM Card ORDER BY front ASC")
    fun getCards(): LiveData<List<Card>>

    @Query("SELECT * FROM Card WHERE id = :id")
    fun getCard(id: String): LiveData<Card>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(card: Card)

    @Query("DELETE FROM Card WHERE id = :id")
    suspend fun delete(id: String)

    @Query("DELETE FROM Card")
    suspend fun deleteAll()
}