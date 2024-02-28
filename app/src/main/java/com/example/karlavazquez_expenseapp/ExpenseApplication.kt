package com.example.karlavazquez_expenseapp

import android.app.Application
import com.example.karlavazquez_expenseapp.ExpenseDatabaseImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import com.example.karlavazquez_expenseapp.ExpenseDao

class ExpenseApplication : Application(){

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { ExpenseDatabaseImpl.getDatabase(this,applicationScope) }
    val repository by lazy { ExpenseRepository(database.expenseDao()) }

}