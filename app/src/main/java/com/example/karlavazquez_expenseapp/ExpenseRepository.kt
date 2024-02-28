package com.example.karlavazquez_expenseapp

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.karlavazquez_expenseapp.Expense
import com.example.karlavazquez_expenseapp.ExpenseDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ExpenseRepository(private val expenseDAO: ExpenseDao) {

    val allExpenses: LiveData<List<Expense>> = expenseDAO.getAllExpenses()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(expense: Expense) {
        expenseDAO.insert(expense)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(expense: Expense) {
        expenseDAO.delete(expense)
    }
    fun getExpenseById(id: Int): LiveData<Expense> {
        return expenseDAO.getExpenseById(id)
    }
    suspend fun update(expense: Expense) {
        expenseDAO.update(expense)
    }
    fun filterByCategory(category: String): LiveData<List<Expense>>{
        return expenseDAO.filterByCategory(category)
    }

}
