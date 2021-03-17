package br.com.symbiosyssolucoes.PharmaIntegration.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ItemPedidoPalm {
    private Integer IdItemPedidoPalm;
    private Integer IdPedidoPalm;
    private Integer Item;
    private Integer IdEmpresa = 1;
    private String CodProdutoArq;
    private Integer IdProduto;
    private String CodProduto;
    private BigDecimal Qtd;
    private BigDecimal QtdConfirmada;
    private String IdPrecoTabela;
    private BigDecimal PrecoUnit;
    private Float PercDescontoItem;
    private BigDecimal PercComissaoItem;
    private String SituacaoItemPedido;
    private String LogImportacao;
    private String CodRetornoItem;
    private String DscRetornoItem;
    private String IdUsuario = "SYM";
    private LocalDateTime DataOperacao;

    private Long invoiceItemId;

    public BigDecimal qtdNaoAtendida(){
        BigDecimal qtdNAtend =  getQtd().subtract(getQtdConfirmada());
        return qtdNAtend;
    }



}
