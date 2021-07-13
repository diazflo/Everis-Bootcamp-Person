package com.everis.person.service;

import com.everis.person.entity.Wallet;
import com.everis.person.repository.WalletRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
@Service
public class WalletServiceImpl implements WalletService {

    private final WalletRepository repository;

    @Autowired
    public WalletServiceImpl(WalletRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Wallet> createWallet(Wallet wallet) {
        return Mono.just(wallet).flatMap(obj ->{
           obj.setId(UUID.randomUUID());
           return repository.save(obj);
        });
    }

}
