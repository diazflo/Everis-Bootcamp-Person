package com.everis.person.service;

import com.everis.person.entity.Payment;
import com.everis.person.entity.Wallet;
import reactor.core.publisher.Mono;

public interface WalletService {

    Mono<Wallet> createWallet(Wallet wallet);

    Mono<Wallet> getWalletByPerson(String dni);

    Mono<Payment> getPayment();
}
