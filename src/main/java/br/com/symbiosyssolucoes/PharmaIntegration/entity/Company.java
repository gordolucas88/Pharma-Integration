package br.com.symbiosyssolucoes.PharmaIntegration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false)
    private Integer GroupCode;
    @Column(nullable = false)
    private String Name;
    @Column(nullable = false, unique = true, length = 14)
    private String CNPJ;


}
