package api.aplikasi_api.io;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ApiResponse {
    private List<TransactionResponse> data;
    private List<StatusResponse> status;
}
