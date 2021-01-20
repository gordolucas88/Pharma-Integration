package br.com.symbiosyssolucoes.PharmaIntegration.models;

import br.com.symbiosyssolucoes.PharmaIntegration.entity.Invoice;
import br.com.symbiosyssolucoes.PharmaIntegration.entity.InvoiceItem;

import java.util.List;

public class ConsysInvoice {
    private Invoice invoice;
    private List<InvoiceItem> details;
}
//
//class consysInvoice {
//    Origem = "CONSYS";
//    Cliente;
//    IdPedido;
//    CNPJ;
//    Data;
//    Hora;
//    Produtos = [];
//
//}