package br.com.symbiosyssolucoes.PharmaIntegration.entity;

import br.com.symbiosyssolucoes.PharmaIntegration.dto.InvoiceItemDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    public InvoiceItem (InvoiceItemDto invoiceItemDto) {


        this.setId(invoiceItemDto.getId());
        this.setItemCode(invoiceItemDto.getItemCode());
        this.setQuantity(invoiceItemDto.getQuantity());
        this.setDiscount(invoiceItemDto.getDiscount());
        this.setPaymentTerms(invoiceItemDto.getPaymentTerms());
        this.setInstallment(invoiceItemDto.getInstallment());
        this.setDiscountType(invoiceItemDto.getDiscountType());
        this.setInstallmentType(invoiceItemDto.getInstallmentType());
        this.setItemStatus(invoiceItemDto.getItemStatus());
        this.setSituacaoItemPedido(invoiceItemDto.getSituacaoItemPedido());
        this.setIdItemPedidoPalm(invoiceItemDto.getIdItemPedidoPalm());
        this.setIdItemConsys(invoiceItemDto.getIdItemConsys());

    }


}
