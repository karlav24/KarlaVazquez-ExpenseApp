package com.example.karlavazquez_expenseapp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Expense::class], version = 1, exportSchema = false)
abstract class ExpenseRoomDatabase : RoomDatabase() {
    abstract fun expenseDao(): ExpenseDao
}
