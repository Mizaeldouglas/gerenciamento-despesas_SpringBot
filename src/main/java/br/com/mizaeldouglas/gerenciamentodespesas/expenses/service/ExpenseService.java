package br.com.mizaeldouglas.gerenciamentodespesas.expenses.service;

import br.com.mizaeldouglas.gerenciamentodespesas.expenses.exception.ExpenseNotFoundException;
import br.com.mizaeldouglas.gerenciamentodespesas.expenses.model.ExpenseModel;
import br.com.mizaeldouglas.gerenciamentodespesas.expenses.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<ExpenseModel> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public ExpenseModel createExpense(ExpenseModel expenseModel) {
        return expenseRepository.save(expenseModel);
    }

    public ExpenseModel getExpenseById(Long id){
        return expenseRepository.findById(id).orElseThrow(() -> new ExpenseNotFoundException("Expense not found with ID: " + id));
    }

    public void deleteExpense(Long id){
        expenseRepository.deleteById(id);
    }
    public ExpenseModel updateExpense(Long id, ExpenseModel expenseModel){
        ExpenseModel expense = expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Expense not found"));
        expense.setDescription(expenseModel.getDescription());
        expense.setDate(expenseModel.getDate());
        expense.setAmount(expenseModel.getAmount());
        return expenseRepository.save(expense);
    }
}
