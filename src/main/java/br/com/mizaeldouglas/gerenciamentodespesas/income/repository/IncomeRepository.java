package br.com.mizaeldouglas.gerenciamentodespesas.income.repository;

import br.com.mizaeldouglas.gerenciamentodespesas.income.model.IncomeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<IncomeModel, Long> {
}
