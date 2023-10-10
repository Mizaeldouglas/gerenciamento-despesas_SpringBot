package br.com.mizaeldouglas.gerenciamentodespesas.expenses.controller;

import br.com.mizaeldouglas.gerenciamentodespesas.expenses.model.ExpenseModel;
import br.com.mizaeldouglas.gerenciamentodespesas.expenses.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }
    @GetMapping
    public List<ExpenseModel> getAllExpenses(){
        return expenseService.getAllExpenses();
    }

    @PostMapping
    public ExpenseModel createExpense(@RequestBody ExpenseModel expenseModel){
        return expenseService.createExpense(expenseModel);
    }

    @GetMapping("/{id}")
    public ExpenseModel getExpenseById(@PathVariable Long id){
        return expenseService.getExpenseById(id);
    }

    @PutMapping("/{id}")
    public ExpenseModel updateExpense(@PathVariable Long id, @RequestBody ExpenseModel expenseModel){
        return expenseService.updateExpense(id, expenseModel);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id){
        expenseService.deleteExpense(id);
    }
}
