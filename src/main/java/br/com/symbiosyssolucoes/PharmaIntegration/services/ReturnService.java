package br.com.symbiosyssolucoes.PharmaIntegration.services;

import br.com.symbiosyssolucoes.PharmaIntegration.entity.Company;
import br.com.symbiosyssolucoes.PharmaIntegration.entity.Connections;
import br.com.symbiosyssolucoes.PharmaIntegration.models.ItemPedidoPalm;
import br.com.symbiosyssolucoes.PharmaIntegration.models.PedidoPalm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ReturnService {

    @Autowired
    private CompanyService company;
    @Autowired
    private FileService file;
    @Autowired
    private ConnectionsService conn;


    public PedidoPalm emsReturn(PedidoPalm pedidoPalm){

        String date = LocalDateTime.now().toString();
        String dateOp = pedidoPalm.getDataOperacao().toString();
        Optional<Company> optional = this.company.listCompanyById(1L);
        Company company = optional.get();

        String R0 = "0" + "RETORNO PED OL " + "0" + company.getCNPJ() +
                date.substring(8,10) + date.substring(5,7) + date.substring(0,4) + date.substring(11,13) + date.substring(14,16) + date.substring(17,19) + date.substring(20,22) + "\n";
        String R1 = "1" + "0" + pedidoPalm.getCnpjCpfCliFor() + StringUtils.rightPad(pedidoPalm.getNumPedidoPalm(),12, " ") + dateOp.substring(8,10) + dateOp.substring(5,7) + dateOp.substring(0,4) +
                dateOp.substring(11,13) + dateOp.substring(14,16) + dateOp.substring(17,19) + dateOp.substring(20,22) +
                pedidoPalm.getNumPedidoCRONOS() + pedidoPalm.getCodRetorno() + "\n" ;
        String R2 = "";
        for(int i = 0; i < pedidoPalm.getItemPedidoPalmList().size(); i++){
            ItemPedidoPalm item = pedidoPalm.getItemPedidoPalmList().get(i);
            R2 += "2" + item.getCodProdutoArq() + StringUtils.rightPad(pedidoPalm.getNumPedidoPalm(),12, " ") + "0" + StringUtils.leftPad(item.getQtdConfirmada().toString(),5,"0")
                    + item.getPercDescontoItem().toString().replace(".", "")
                    + "00030"
                    + StringUtils.leftPad(item.qtdNaoAtendida().toString(), 5, "0") +
                item.getCodRetornoItem() + item.getDscRetornoItem().trim() + "\n";
        }
        String lines = R0+R1+R2;
        String R3 = "3" + StringUtils.rightPad(pedidoPalm.getNumPedidoPalm(),12, " ") + StringUtils.leftPad(String.valueOf((StringUtils.countMatches(lines,"\n") + 1)),5, "0")
                + StringUtils.leftPad(pedidoPalm.itensConfirmados().toString(),5,"0") + StringUtils.leftPad(pedidoPalm.itensNaoConfirmados().toString(),5,"0") + "\n";

        String file = R0+R1+R2+R3;
        String filename = "RETEMS_" + company.getCNPJ() + "_" + date.substring(0,4) + date.substring(5,7) +  date.substring(8,10) + date.substring(11,13) + date.substring(14,16) + date.substring(17,19) + ".txt";

        Connections connections = this.conn.listConnectionsById(1L);
        try {
            this.file.mkFile(connections.getLocalRetPath() + filename, file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        pedidoPalm.setArqRetPed(filename);



        return pedidoPalm;

    }

}
