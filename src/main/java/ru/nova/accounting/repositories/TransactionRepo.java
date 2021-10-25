package ru.nova.accounting.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nova.accounting.models.Transaction;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {

    Optional<List<Transaction>> findByType(String type);

    Optional<List<Transaction>> findByDate(String type, Date date);
}
