package br.com.symbiosyssolucoes.PharmaIntegration.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(indexes = {@Index(name = "registro_duplicado", columnList = "number,customercnpj", unique = true)})
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(length = 20)
    private String CustomerCNPJ;
   // @Column(nullable = false)
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

    @ManyToOne()
    Connections connections;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)//(mappedBy = "invoice", fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id",  referencedColumnName = "id")
    private List<InvoiceItem> items;



}
