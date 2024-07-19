package org.budget.controller.web.transaction;

import org.budget.controller.web.transaction.action.EnterTransactionAction;
import org.budget.controller.web.transaction.dto.TransactionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transaction")
@CrossOrigin
public class TransactionController {

    private final EnterTransactionAction enterTransactionAction;

    public TransactionController(EnterTransactionAction enterTransactionAction) {
        this.enterTransactionAction = enterTransactionAction;
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody List<TransactionDto> transactionDtos) {
        transactionDtos.forEach(System.out::println);
        return enterTransactionAction.execute(transactionDtos.stream());
    }

}
