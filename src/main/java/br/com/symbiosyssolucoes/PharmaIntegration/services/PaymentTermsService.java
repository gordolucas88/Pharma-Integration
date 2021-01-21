package br.com.symbiosyssolucoes.PharmaIntegration.services;

import br.com.symbiosyssolucoes.PharmaIntegration.entity.PaymentTerms;
import br.com.symbiosyssolucoes.PharmaIntegration.repository.PaymentTermsRepository;

import java.util.Optional;

public class PaymentTermsService {

    private PaymentTermsRepository paymentTermsRepository;

    public PaymentTermsService(PaymentTermsRepository paymentTermsRepository){
        this.paymentTermsRepository = paymentTermsRepository;
    }

    public void insertPaymentTerms(PaymentTerms paymentTerms){
        this.paymentTermsRepository.save(paymentTerms);
    }

    public Optional<PaymentTerms> listPaymentTermsById(Long id){
        Optional<PaymentTerms> paymentTerms = this.paymentTermsRepository.findById(id);
        return paymentTerms;
    }

}
