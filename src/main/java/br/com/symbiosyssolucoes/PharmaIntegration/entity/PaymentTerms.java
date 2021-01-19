package br.com.symbiosyssolucoes.PharmaIntegration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Stack;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentTerms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Code;
    private String Description;
    private Integer InstallmentsNumber;
    private Double FinancialDiscount;
    private Integer Portion1;
    private Integer Portion2;
    private Integer Portion3;
    private Integer Portion4;
    private Integer Portion5;
    private Integer Portion6;
    private Double PercPortion1;
    private Double PercPortion2;
    private Double PercPortion3;
    private Double PercPortion4;
    private Double PercPortion5;
    private Double PercPortion6;

    @OneToOne
    private Invoice invoice;

}
