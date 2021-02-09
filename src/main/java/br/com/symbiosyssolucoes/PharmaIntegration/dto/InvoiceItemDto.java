package br.com.symbiosyssolucoes.PharmaIntegration.dto;

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

}
