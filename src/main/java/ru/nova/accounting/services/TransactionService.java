package ru.nova.accounting.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nova.accounting.exeptions.TransactionNotFoundException;
import ru.nova.accounting.models.Transaction;
import ru.nova.accounting.repositories.TransactionRepo;

import java.util.Date;
import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepo transactionRepo;

    @Autowired
    public TransactionService(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    public void saveTransaction(Transaction transaction) {
        transactionRepo.save(transaction);
    }

    public Transaction getTransaction(Long id) {
        return transactionRepo
                .findById(id)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction not found"));
    }

    public void removeTransaction(Long id) {
        transactionRepo.deleteById(id);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepo.findAll();
    }

    public List<Transaction> findTransactions(String type) {
        return transactionRepo
                .findByType(type)
                .orElseThrow(() -> new TransactionNotFoundException("Transactions not found"));
    }

    public List<Transaction> findTransactions(String type, Date date) {
        return transactionRepo
                .findByDate(type, date)
                .orElseThrow(() -> new TransactionNotFoundException("Transactions not found"));
    }
}
