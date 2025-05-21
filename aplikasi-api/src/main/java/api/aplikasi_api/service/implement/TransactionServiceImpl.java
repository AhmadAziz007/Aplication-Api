package api.aplikasi_api.service.implement;

import api.aplikasi_api.entity.Status;
import api.aplikasi_api.entity.Transaction;
import api.aplikasi_api.io.ApiResponse;
import api.aplikasi_api.io.StatusResponse;
import api.aplikasi_api.io.TransactionResponse;
import api.aplikasi_api.repository.StatusRepository;
import api.aplikasi_api.repository.TransactionRepository;
import api.aplikasi_api.service.TransactionService;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final StatusRepository statusRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository, StatusRepository statusRepository) {
        this.transactionRepository = transactionRepository;
        this.statusRepository = statusRepository;
    }

    @Override
    public ApiResponse getAllData() {
        List<Transaction> transactions = transactionRepository.findAll();
        List<Status> statuses = statusRepository.findAll();

        List<TransactionResponse> transactionResponses = transactions.stream()
                .map(this::convertToTransactionResponse)
                .collect(Collectors.toList());

        List<StatusResponse> statusResponses = statuses.stream()
                .map(status -> new StatusResponse(status.getId(), status.getName()))
                .collect(Collectors.toList());

        return new ApiResponse(transactionResponses, statusResponses);
    }

    private TransactionResponse convertToTransactionResponse(Transaction transaction) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return new TransactionResponse(
                transaction.getId(),
                transaction.getProductID(),
                transaction.getProductName(),
                transaction.getAmount().toString(),
                transaction.getCustomerName(),
                transaction.getStatus(),
                transaction.getTransactionDate().format(formatter),
                transaction.getCreateBy(),
                transaction.getCreateOn().format(formatter)
        );
    }
}
