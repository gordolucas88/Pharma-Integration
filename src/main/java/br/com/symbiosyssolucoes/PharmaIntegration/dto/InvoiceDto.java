package br.com.symbiosyssolucoes.PharmaIntegration.dto;


import br.com.symbiosyssolucoes.PharmaIntegration.entity.Invoice;
import br.com.symbiosyssolucoes.PharmaIntegration.entity.InvoiceItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {

    private Long Id;
    private String CustomerCNPJ;
    private String Number;
    private LocalDate Date;
    private String PurchaseType;
    private String ReturnType;
    private String PaymentTerms;
    private String CustomerInvoiceNumber;
    private String Deadline;
    private String AgentCode;
    private LocalDateTime OperationDate;
    private String Status;
    private Long IdPedidoPalm;
    private String ConnectionType;

    private List<InvoiceItemDto> Items;


    public InvoiceDto toDto(Invoice invoice) {
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setId(invoice.getId());
        invoiceDto.setCustomerCNPJ(invoice.getCustomerCNPJ());
        invoiceDto.setNumber(invoice.getNumber());
        invoiceDto.setDate(invoice.getDate());
        invoiceDto.setPurchaseType(invoice.getPurchaseType());
        invoiceDto.setReturnType(invoice.getReturnType());
        invoiceDto.setPaymentTerms(invoice.getPaymentTerms());
        invoiceDto.setCustomerInvoiceNumber(invoice.getCustomerInvoiceNumber());
        invoiceDto.setDeadline(invoice.getDeadline());
        invoiceDto.setAgentCode(invoice.getAgentCode());
        invoiceDto.setOperationDate(invoice.getOperationDate());
        invoiceDto.setStatus(invoice.getStatus());
        invoiceDto.setIdPedidoPalm(invoice.getIdPedidoPalm());
        invoiceDto.setConnectionType(invoice.getConnections().getOrigin().toString());

        List<InvoiceItemDto> itemsDtoList = new ArrayList<InvoiceItemDto>();

        invoice.getItems().forEach(item -> {
            InvoiceItemDto itemDto = new InvoiceItemDto();
            itemDto.setId(item.getId());
            itemDto.setItemCode(item.getItemCode());
            itemDto.setQuantity(item.getQuantity());
            itemDto.setDiscount(item.getDiscount());
            itemDto.setPaymentTerms(item.getPaymentTerms());
            itemDto.setInstallment(item.getInstallment());
            itemDto.setDiscountType(item.getDiscountType());
            itemDto.setInstallmentType(item.getInstallmentType());
            itemDto.setItemStatus(item.getItemStatus());
            itemDto.setSituacaoItemPedido(item.getSituacaoItemPedido());
            itemDto.setIdItemPedidoPalm(item.getIdItemPedidoPalm());
            itemDto.setIdItemConsys(item.getIdItemConsys());

            itemsDtoList.add(itemDto);

        });

        invoiceDto.setItems(itemsDtoList);

        return invoiceDto;


    }

    public Invoice dtoToinvoice(InvoiceDto invoiceDto){

        Invoice invoice = new Invoice();

        invoice.setId(invoiceDto.getId());
        invoice.setCustomerCNPJ(invoiceDto.getCustomerCNPJ());
        invoice.setNumber(invoiceDto.getNumber());
        invoice.setDate(invoiceDto.getDate());
        invoice.setReturnType(invoiceDto.getReturnType());
        invoice.setPaymentTerms(invoiceDto.getPaymentTerms());
        invoice.setCustomerInvoiceNumber(invoiceDto.getCustomerInvoiceNumber());
        invoice.setDeadline(invoiceDto.getDeadline());
        invoice.setAgentCode(invoiceDto.getAgentCode());
        invoice.setOperationDate(invoiceDto.getOperationDate());
        invoice.setStatus(invoiceDto.getStatus());
        invoice.setIdPedidoPalm(invoiceDto.getIdPedidoPalm());

        List<InvoiceItem> invoiceItems = new ArrayList<InvoiceItem>();

        invoiceDto.getItems().forEach(itemDto -> {

            InvoiceItem item = new InvoiceItem();

            item.setId(itemDto.getId());
            item.setItemCode(itemDto.getItemCode());
            item.setQuantity(itemDto.getQuantity());
            item.setDiscount(itemDto.getDiscount());
            item.setPaymentTerms(itemDto.getPaymentTerms());
            item.setInstallment(itemDto.getInstallment());
            item.setDiscountType(itemDto.getDiscountType());
            item.setInstallmentType(itemDto.getInstallmentType());
            item.setItemStatus(itemDto.getItemStatus());
            item.setSituacaoItemPedido(itemDto.getSituacaoItemPedido());
            item.setIdItemPedidoPalm(itemDto.getIdItemPedidoPalm());
            item.setIdItemConsys(itemDto.getIdItemConsys());

            invoiceItems.add(item);

        });

        invoice.setItems(invoiceItems);

        return invoice;



    }


}
