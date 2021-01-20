package br.com.symbiosyssolucoes.PharmaIntegration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false,length = 20)
    private String Origin;
    @Column(length = 20)
    private String CustomerCNPJ;
    @Column(nullable = false)
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

    @OneToOne
    private Company company;

    @OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY)
    private List<InvoiceItem> items;



}
