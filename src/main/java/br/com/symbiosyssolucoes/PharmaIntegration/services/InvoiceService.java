package br.com.symbiosyssolucoes.PharmaIntegration.services;

import br.com.symbiosyssolucoes.PharmaIntegration.entity.ConnectionsTypes;
import br.com.symbiosyssolucoes.PharmaIntegration.entity.Invoice;
import br.com.symbiosyssolucoes.PharmaIntegration.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    private InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository){
        this.invoiceRepository = invoiceRepository;
    }

    private Optional<Invoice> listInvoiceById(Long id){

        Optional<Invoice> invoice = this.invoiceRepository.findById(id);

        return invoice;
    }

    private Optional<List<Invoice>> listInvoices(){

        Optional<List<Invoice>> invoices = Optional.ofNullable(this.invoiceRepository.findAll());
        return  invoices;
    }

    private Optional<List<Invoice>> listInvoiceByCompanyId(Long id){

        Optional<List<Invoice>> invoices = Optional.ofNullable(this.invoiceRepository.findByCompany(id));

        return  invoices;
    }

    private Optional<List<Invoice>> listInvoiceByNumber(String number){

        Optional<List<Invoice>> invoices = Optional.ofNullable(this.invoiceRepository.findByNumber(number));

        return invoices;
    }

    private Optional<List<Invoice>>  listInvoiceByOrigin(ConnectionsTypes connectionsTypes){

        Optional<List<Invoice>> invoices = Optional.ofNullable(this.invoiceRepository.findByOrigin(connectionsTypes));
        return invoices;

    }


    private void insertInvoice(Invoice invoice){
        this.invoiceRepository.save(invoice);

    }

}
