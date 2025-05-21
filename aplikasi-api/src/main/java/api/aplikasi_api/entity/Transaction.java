package api.aplikasi_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_id")
    private String productID;

    @Column(name = "product_name")
    private String productName;

    private BigDecimal amount;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "status_id")
    private Integer status;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_on")
    private LocalDateTime createOn;
}
