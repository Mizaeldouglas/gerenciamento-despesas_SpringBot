package br.com.mizaeldouglas.gerenciamentodespesas.income.controller;

import br.com.mizaeldouglas.gerenciamentodespesas.income.model.IncomeModel;
import br.com.mizaeldouglas.gerenciamentodespesas.income.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/income")
public class IncomeController {

    private final IncomeService incomeService;

    @Autowired
    public IncomeController(IncomeService incomeService){
        this.incomeService = incomeService;
    }

    @GetMapping
    public List<IncomeModel> getAllIncome(){
        return incomeService.getAllIncome();
    }

    @PostMapping
    public IncomeModel createIncome(@RequestBody IncomeModel income){
        return incomeService.createIncome(income);
    }

    @GetMapping("/{id}")
    public IncomeModel getIncomeById(@PathVariable Long id){
        return incomeService.getIncomeById(id);
    }

    @PutMapping("/{id}")
    public IncomeModel updateIncome(@PathVariable Long id, @RequestBody IncomeModel income){
        return incomeService.updateIncome(id,income);
    }
    @DeleteMapping("/{id}")
    public void deleteIncome(@PathVariable Long id){
        incomeService.deleteIncome(id);
    }
}
