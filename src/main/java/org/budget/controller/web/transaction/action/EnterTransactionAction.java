package org.budget.controller.web.transaction.action;


import org.budget.controller.web.transaction.dto.TransactionDto;
import org.springframework.http.ResponseEntity;

import java.util.stream.Stream;

public interface EnterTransactionAction {

    ResponseEntity<String> execute(Stream<TransactionDto> transactionDtos);
}
