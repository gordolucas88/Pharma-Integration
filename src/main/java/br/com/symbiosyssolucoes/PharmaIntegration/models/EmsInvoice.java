package br.com.symbiosyssolucoes.PharmaIntegration.models;

import br.com.symbiosyssolucoes.PharmaIntegration.entity.*;
import jdk.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmsInvoice {

    private Invoice invoice;
    private PaymentTerms paymentTerms;
    private List<InvoiceItem> details;



}
//
//class emsInvoice {
//    Origem = "EMS"
//    Header;
//    Invoice;
//    Deadline;
//    Items = [];
//    Trailer;
//
//    invoiceNumber() {
//
//        return this.Invoice.substr(16, 9).trim()
//
//    }