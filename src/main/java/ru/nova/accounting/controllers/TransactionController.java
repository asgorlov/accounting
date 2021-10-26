package ru.nova.accounting.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nova.accounting.models.SearchFilter;
import ru.nova.accounting.models.Transaction;
import ru.nova.accounting.services.TransactionService;

import java.util.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransaction(@PathVariable("id") Long id) {
        Transaction transactions = transactionService.getTransaction(id);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction) {
        Transaction savedTransaction = transactionService.saveTransaction(transaction);
        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Transaction> updateTransaction(@RequestBody Transaction transaction) {
        Transaction updatedTransaction = transactionService.saveTransaction(transaction);
        return new ResponseEntity<>(updatedTransaction, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeTransaction(@PathVariable("id") Long id) {
        transactionService.removeTransaction(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/find")
    public ResponseEntity<List<Transaction>> findTransactions(@RequestBody SearchFilter searchFilter) {
        List<Transaction> transactions;

        String type = searchFilter.getType();
        Calendar date = searchFilter.getDate();
        if (type != null && !type.isEmpty()) {
            if (date != null) {
                transactions = transactionService.findTransactions(type, date);
            } else {
                transactions = transactionService.findTransactions(type);
            }
        } else {
            transactions = Collections.emptyList();
        }

        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
}
