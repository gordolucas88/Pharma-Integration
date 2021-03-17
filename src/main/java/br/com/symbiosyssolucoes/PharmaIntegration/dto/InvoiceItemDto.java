package br.com.symbiosyssolucoes.PharmaIntegration.dto;

import br.com.symbiosyssolucoes.PharmaIntegration.entity.InvoiceItem;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceItemDto {
    private Long Id;
    private String ItemCode;
    private Double Quantity;
    private Double Discount;
    private String PaymentTerms;
    private Integer Installment;
    private String DiscountType;
    private String InstallmentType;
    private String ItemStatus;
    private String SituacaoItemPedido;
    private Long IdItemPedidoPalm;
    private String IdItemConsys;


    public InvoiceItemDto (InvoiceItem invoiceItem){

        this.setId(invoiceItem.getId());
        this.setItemCode(invoiceItem.getItemCode());
        this.setQuantity(invoiceItem.getQuantity());
        this.setDiscount(invoiceItem.getDiscount());
        this.setPaymentTerms(invoiceItem.getPaymentTerms());
        this.setInstallment(invoiceItem.getInstallment());
        this.setDiscountType(invoiceItem.getDiscountType());
        this.setInstallmentType(invoiceItem.getInstallmentType());
        this.setItemStatus(invoiceItem.getItemStatus());
        this.setSituacaoItemPedido(invoiceItem.getSituacaoItemPedido());
        this.setIdItemPedidoPalm(invoiceItem.getIdItemPedidoPalm());
        this.setIdItemConsys(invoiceItem.getIdItemConsys());

    }

}
