package br.com.mizaeldouglas.gerenciamentodespesas.income.service;

import br.com.mizaeldouglas.gerenciamentodespesas.income.model.IncomeModel;
import br.com.mizaeldouglas.gerenciamentodespesas.income.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeService {
    private final IncomeRepository incomeRepository;

    @Autowired
    public IncomeService(IncomeRepository incomeRepository){
        this.incomeRepository = incomeRepository;
    }

    public List<IncomeModel> getAllIncome(){
        return incomeRepository.findAll();
    }

    public IncomeModel createIncome(IncomeModel incomeModel){
        return incomeRepository.save(incomeModel);
    }

    public IncomeModel updateIncome(Long id, IncomeModel incomeModel){
        IncomeModel income = incomeRepository.findById(id).orElseThrow(() -> new RuntimeException("income not found"));
        income.setName(incomeModel.getName());
        income.setDescription(incomeModel.getDescription());
        income.setAmount(incomeModel.getAmount());
        income.setDate(incomeModel.getDate());
        return  incomeRepository.save(income);

    }

    public IncomeModel getIncomeById(Long id){
        return incomeRepository.findById(id).orElse(null);
    }

    public void deleteIncome(Long id){
        incomeRepository.deleteById(id);
    }
}
