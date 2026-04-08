package com.github.cidarosa.ms.pagamentos.service;

import com.github.cidarosa.ms.pagamentos.dto.PagamentoDTO;
import com.github.cidarosa.ms.pagamentos.entities.Pagamento;
import com.github.cidarosa.ms.pagamentos.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Transactional(readOnly = true)
    public List<PagamentoDTO> findAllPagamentos(){

        List<Pagamento> pagamentos = pagamentoRepository.findAll();

        return pagamentos.stream()
                .map(PagamentoDTO::new)
                .toList();
    }
}
