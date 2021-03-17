package br.com.symbiosyssolucoes.PharmaIntegration.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PedidoPalm {

    private Integer IdPedidoPalm;
    private String Origem;
    private String CodFilial = "01";
    private Integer IdEmpresa = 1;
    private String NumPedidoPalm;
    private String CodVendedor;
    private String CodCliFor;
    private String CnpjCpfCliFor;
    private LocalDateTime DataPedido;
    private BigDecimal PercComissao;
    private String CodCondPag;
    private String CodPortador;
    private Float  PercDesconto;
    private BigDecimal TotalPedido;
    private LocalDateTime DataEntrega;
    private String Observacoes;
    private Integer IdExpedicao;
    private LocalDateTime DataProxVisita;
    private String SituacaoPedido = "P";
    private String NumNF;
    private String LogImportacao;
    private String StatusRetorno;
    private String CodRetorno;
    private String DscRetorno;
    private String NumPedidoCRONOS;
    private String ArqRetPed;
    private String ArqRetNF;
    private String ArqRet2Ped;
    private String VerLayout;
    private String NumPedidoPalmAux;
    private String IdUsuario = "SYM";
    private LocalDateTime DataOperacao = LocalDateTime.now();


    private List<ItemPedidoPalm> itemPedidoPalmList;


    private Long invoiceId;

    public Integer itensConfirmados(){

        Integer qtd = 0;

        for(int i = 0; i < getItemPedidoPalmList().size(); i++){

            if(getItemPedidoPalmList().get(i).getQtdConfirmada().compareTo(new BigDecimal(0)) == 1 ){

                qtd ++;
            }
        }

        return qtd;

    }

    public Integer itensNaoConfirmados(){

        Integer qtd = 0;

        for(int i = 0; i < getItemPedidoPalmList().size(); i++){

            if(getItemPedidoPalmList().get(i).getQtdConfirmada().compareTo(new BigDecimal(0)) <= 0 ){

                qtd ++;
            }
        }

        return qtd;

    }


}

