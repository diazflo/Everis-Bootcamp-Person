package com.everis.person.service;

import com.everis.person.entity.Payment;
import com.everis.person.entity.Wallet;
import com.everis.person.kafka.kpayment.KafkaPayment;
import com.everis.person.repository.WalletRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Slf4j
@Service
public class WalletServiceImpl implements WalletService {

    private final WalletRepository repository;
    private final KafkaTemplate kafkaTemplate;
    private KafkaPayment kafkaPayment;

    @Autowired
    public WalletServiceImpl(WalletRepository repository, KafkaTemplate kafkaTemplate) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostConstruct
    public void init() {
        kafkaPayment = new KafkaPayment(kafkaTemplate);
    }

    @Override
    public Mono<Wallet> createWallet(Wallet wallet) {
        return Mono.just(wallet).flatMap(obj -> {
            obj.setId(UUID.randomUUID());
            return repository.save(obj);
        });
    }

    @Override
    public Mono<Wallet> getWalletByPerson(String request) {
        Mono<Wallet> walletMono;
        if (request.length() == 8) {
            walletMono = repository.findWalletByPersonDni(request);
        } else {
            walletMono = repository.findWalletByPersonPhoneNumber(request);
        }
        return walletMono;
    }

    @Override
    public Mono<Payment> getPayment() {
        return Mono.just(kafkaPayment.getPayment());
    }
}
