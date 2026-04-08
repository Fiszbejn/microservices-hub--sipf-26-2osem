package com.github.cidarosa.ms.pagamentos.service;

import com.github.cidarosa.ms.pagamentos.exceptions.ResourceNotFoundException;
import com.github.cidarosa.ms.pagamentos.repository.PagamentoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PagamentoServiceTest {

    @Mock
    private PagamentoRepository pagamentoRepository;

    @InjectMocks
    private PagamentoService pagamentoService;

    private Long existingId;
    private Long nonExistingId;

    @BeforeEach
    void setUp(){

        existingId = 1L;
        nonExistingId = Long.MAX_VALUE;
    }

    @Test
    void deleteByIdShouldDeleteWhenIdExists(){

        Mockito.when(pagamentoRepository.existsById(existingId)).thenReturn(true);

        pagamentoService.deletePagamentoById(existingId);

        Mockito.verify(pagamentoRepository).existsById(existingId);

        Mockito.verify(pagamentoRepository, Mockito.times(1)).deleteById(existingId);
    }

    @Test
    void deletePagamentoByIdShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist(){

        Mockito.when(pagamentoRepository.existsById(nonExistingId)).thenReturn(false);

        Assertions.assertThrows(ResourceNotFoundException.class,
                () -> {
                    pagamentoService.deletePagamentoById(nonExistingId);
                }
                );

        Mockito.verify(pagamentoRepository).existsById(nonExistingId);
        Mockito.verify(pagamentoRepository, Mockito.never()).deleteById(nonExistingId);
    }
}
