package br.com.symbiosyssolucoes.PharmaIntegration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Connections {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Description;
    @Enumerated(EnumType.STRING)
    private ConnectionsTypes Origin;
    private String FTP;
    private String Active;
    private String Home;
    private String Login;
    private String Password;
    private String FTPImpPath;
    private String FTPRetPath;
    private String LocalImpPath;
    private String LocalPedPath;
    private String LocalRetPath;

}
