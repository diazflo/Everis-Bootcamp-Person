package com.everis.person.service;

import com.everis.person.entity.Wallet;
import reactor.core.publisher.Mono;

public interface WalletService {

    public Mono<Wallet> createWallet(Wallet wallet);
}
