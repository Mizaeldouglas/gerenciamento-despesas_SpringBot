package br.com.mizaeldouglas.gerenciamentodespesas.expenses.repository;

import br.com.mizaeldouglas.gerenciamentodespesas.expenses.model.ExpenseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<ExpenseModel, Long> {
}
