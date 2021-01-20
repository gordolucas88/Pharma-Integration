package br.com.symbiosyssolucoes.PharmaIntegration.services;

import br.com.symbiosyssolucoes.PharmaIntegration.entity.Audit;
import br.com.symbiosyssolucoes.PharmaIntegration.repository.AuditRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AuditService {

    private AuditRepository auditRepository;

    public AuditService(AuditRepository auditRepository){
        this.auditRepository = auditRepository;
    }

    public void insertAudit(String app, String action, String user, LocalDateTime operationDate){

        Audit audit = new Audit();

        audit.setApp(app);
        audit.setAction(action);
        audit.setUserAudit(user);
        audit.setOperationDate(operationDate);

        this.auditRepository.save(audit);

    }

    private Optional<List<Audit>> listAllAudit(){
        Optional<List<Audit>> audits = Optional.ofNullable(this.auditRepository.findAll());

        return audits;

    }



}
