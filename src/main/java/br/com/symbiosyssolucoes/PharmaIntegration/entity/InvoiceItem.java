package br.com.symbiosyssolucoes.PharmaIntegration.entity;

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

    @ManyToOne()
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoice;

}
