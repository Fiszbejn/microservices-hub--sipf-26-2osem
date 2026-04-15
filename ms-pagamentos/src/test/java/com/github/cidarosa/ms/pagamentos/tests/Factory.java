package com.github.cidarosa.ms.pagamentos.tests;

import com.github.cidarosa.ms.pagamentos.entities.Pagamento;
import com.github.cidarosa.ms.pagamentos.entities.Status;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Factory {

    public static Pagamento createPagamento() {

        Pagamento pagamento = new Pagamento(
                1L,
                BigDecimal.valueOf(32.25),
                "Brienne de Tarth",
                "3654789632145698",
                "07/15",
                "354",
                Status.CRIADO,
                1L
        );

        return pagamento;
    }

    public static Pagamento createPagamentoSemId() {

        Pagamento pagamento = createPagamento();
        pagamento.setId(null);

        return pagamento;
    }
}
