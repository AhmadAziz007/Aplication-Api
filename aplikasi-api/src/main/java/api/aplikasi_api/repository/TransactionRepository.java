package api.aplikasi_api.repository;

import api.aplikasi_api.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
