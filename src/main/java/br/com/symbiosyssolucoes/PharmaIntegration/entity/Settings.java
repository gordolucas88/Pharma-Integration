package br.com.symbiosyssolucoes.PharmaIntegration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Settings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Enumerated(EnumType.ORDINAL)
    private TrueFalse ComercialBloq;
    @Enumerated(EnumType.ORDINAL)
    private TrueFalse FinancialBloq;
    @Enumerated(EnumType.ORDINAL)
    private TrueFalse ExecRules;

    @OneToOne()
    private Company company;


}
