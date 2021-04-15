package br.com.symbiosyssolucoes.PharmaIntegration.entity;

import br.com.symbiosyssolucoes.PharmaIntegration.dto.InvoiceDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(indexes = {@Index(name = "registro_duplicado", columnList = "number,customercnpj", unique = true)})
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20)
    private String customerCNPJ;

    private String number;
    private LocalDate date;
    private String purchaseType;
    private String returnType;
    private String paymentTerms;
    private String customerInvoiceNumber;
    private String deadline;
    private String agentCode;
    private LocalDateTime operationDate;
    private String status;
    private Long idPedidoPalm;

    @ManyToOne
    Connections connections;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)//(mappedBy = "invoice", fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id",  referencedColumnName = "id")
    private List<InvoiceItem> items;

    public Invoice (InvoiceDto invoiceDto){

        this.setId(invoiceDto.getId());
        this.setCustomerCNPJ(invoiceDto.getCustomerCNPJ());
        this.setNumber(invoiceDto.getNumber());
        this.setDate(invoiceDto.getDate());
        this.setReturnType(invoiceDto.getReturnType());
        this.setPaymentTerms(invoiceDto.getPaymentTerms());
        this.setCustomerInvoiceNumber(invoiceDto.getCustomerInvoiceNumber());
        this.setDeadline(invoiceDto.getDeadline());
        this.setAgentCode(invoiceDto.getAgentCode());
        this.setOperationDate(invoiceDto.getOperationDate());
        this.setStatus(invoiceDto.getStatus());
        this.setIdPedidoPalm(invoiceDto.getIdPedidoPalm());

        if(invoiceDto.getItems().size() > 0) {

            List<InvoiceItem> invoiceItems = new ArrayList<InvoiceItem>();

            invoiceDto.getItems().forEach(itemDto -> {

                InvoiceItem item = new InvoiceItem(itemDto);

                invoiceItems.add(item);

            });

            this.setItems(invoiceItems);
        }




    }


}
