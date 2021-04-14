package br.com.symbiosyssolucoes.PharmaIntegration.dto;


import br.com.symbiosyssolucoes.PharmaIntegration.entity.Invoice;
import br.com.symbiosyssolucoes.PharmaIntegration.entity.InvoiceItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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

    private String PedidoReturnFile;
    private String NFReturnFile;
    private String PedidoCanceladoReturnFile;

    public InvoiceDto (Invoice invoice) {

        this.setId(invoice.getId());
        this.setCustomerCNPJ(invoice.getCustomerCNPJ());
        this.setNumber(invoice.getNumber());
        this.setDate(invoice.getDate());
        this.setPurchaseType(invoice.getPurchaseType());
        this.setReturnType(invoice.getReturnType());
        this.setPaymentTerms(invoice.getPaymentTerms());
        this.setCustomerInvoiceNumber(invoice.getCustomerInvoiceNumber());
        this.setDeadline(invoice.getDeadline());
        this.setAgentCode(invoice.getAgentCode());
        this.setOperationDate(invoice.getOperationDate());
        this.setStatus(invoice.getStatus());
        this.setIdPedidoPalm(invoice.getIdPedidoPalm());
        this.setConnectionType(invoice.getConnections().getOrigin().toString());

        if(invoice.getItems().size() > 0) {
            List<InvoiceItemDto> itemsDtoList = new ArrayList<InvoiceItemDto>();

            invoice.getItems().forEach(item -> {
                InvoiceItemDto itemDto = new InvoiceItemDto(item);

                itemsDtoList.add(itemDto);

            });

            this.setItems(itemsDtoList);
        }


    }


}
