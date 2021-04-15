package br.com.symbiosyssolucoes.PharmaIntegration.services;

import br.com.symbiosyssolucoes.PharmaIntegration.entity.Invoice;
import br.com.symbiosyssolucoes.PharmaIntegration.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;


    public Optional<Invoice> listInvoiceById(Long id){

        Optional<Invoice> invoice = this.invoiceRepository.findById(id);

        return invoice;
    }

    public List<Invoice> listInvoices(){
        Iterable<Invoice> invoices = this.invoiceRepository.findAll();

        return (List<Invoice>) invoices;
    }





    public Invoice insertInvoice(Invoice invoice){
        this.invoiceRepository.save(invoice);

        return invoice;
    }

    public List<Invoice> listInvoicesNotExported(){
        Optional<List<Invoice>> optional =  this.invoiceRepository.findByStatus("1");
        List<Invoice> invoices = new ArrayList<>();
        if(optional.isPresent()){
            invoices = optional.get();
            return invoices;
        } else {
            return invoices;
        }
    }

}
