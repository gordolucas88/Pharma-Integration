package br.com.symbiosyssolucoes.PharmaIntegration.services;

import br.com.symbiosyssolucoes.PharmaIntegration.entity.InvoiceItem;
import br.com.symbiosyssolucoes.PharmaIntegration.repository.InvoiceItemRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InvoiceItemService {

    private InvoiceItemRepository invoiceItemRepository;

    public InvoiceItemService (InvoiceItemRepository invoiceItemRepository){
        this.invoiceItemRepository = invoiceItemRepository;
    }




    public Optional<InvoiceItem> listInvoiceItemById(Long id){

        Optional<InvoiceItem> invoiceItem = this.invoiceItemRepository.findById(id);
        return invoiceItem;
    }

    public void updateItem(InvoiceItem invoiceItem){

        this.invoiceItemRepository.save(invoiceItem);
    }

}
