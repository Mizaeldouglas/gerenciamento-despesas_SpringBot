package br.com.mizaeldouglas.gerenciamentodespesas.expenses.exception;

public class ExpenseNotFoundException extends  RuntimeException{
    public ExpenseNotFoundException(String message) {
        super(message);
    }
}
