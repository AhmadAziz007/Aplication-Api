package api.aplikasi_api.controller;

import api.aplikasi_api.io.ApiResponse;
import api.aplikasi_api.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping
    public ResponseEntity<ApiResponse> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllData());
    }
}
