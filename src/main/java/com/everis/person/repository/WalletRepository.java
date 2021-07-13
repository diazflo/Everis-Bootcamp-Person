package com.everis.person.repository;

import com.everis.person.entity.Wallet;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WalletRepository extends ReactiveMongoRepository<Wallet, UUID> {

}
