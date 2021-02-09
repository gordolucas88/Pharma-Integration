package br.com.symbiosyssolucoes.PharmaIntegration.services;

import br.com.symbiosyssolucoes.PharmaIntegration.entity.Invoice;
import br.com.symbiosyssolucoes.PharmaIntegration.entity.InvoiceItem;
import br.com.symbiosyssolucoes.PharmaIntegration.repository.InvoiceItemRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceItemService {

    private InvoiceItemRepository invoiceItemRepository;

    public InvoiceItemService (InvoiceItemRepository invoiceItemRepository){
        this.invoiceItemRepository = invoiceItemRepository;
    }




    private Optional<InvoiceItem> listInvoiceItemById(long id){

        Optional<InvoiceItem> invoiceItem = this.invoiceItemRepository.findById(id);
        return invoiceItem;
    }

}
