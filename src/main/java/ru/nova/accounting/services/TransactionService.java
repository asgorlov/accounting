package ru.nova.accounting.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nova.accounting.exeptions.TransactionNotFoundException;
import ru.nova.accounting.models.Transaction;
import ru.nova.accounting.repositories.TransactionRepository;

import java.util.Calendar;
import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepo;

    @Autowired
    public TransactionService(TransactionRepository transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepo.save(transaction);
    }

    public Transaction updateTransaction(Transaction transaction) {
        if (!transactionRepo.existsById(transaction.getId())) {
            throw new TransactionNotFoundException("Transaction not found");
        }

        return saveTransaction(transaction);
    }

    public Transaction getTransaction(Long id) {
        return transactionRepo
                .findById(id)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction not found"));
    }

    public void removeTransaction(Long id) {
        transactionRepo.deleteById(id);
    }

    public void removeAllTransactions() {
        transactionRepo.deleteAll();
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepo.findAll();
    }

    public List<Transaction> findTransactions(String type) {
        return transactionRepo
                .findByType(type)
                .orElseThrow(() -> new TransactionNotFoundException("Transactions not found"));
    }

    public List<Transaction> findTransactions(String type, Calendar date) {
        return transactionRepo
                .findByTypeAndDate(type, date)
                .orElseThrow(() -> new TransactionNotFoundException("Transactions not found"));
    }
}
