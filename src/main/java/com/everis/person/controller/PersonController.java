package com.everis.person.controller;

import com.everis.person.entity.Wallet;
import com.everis.person.service.WalletService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/person")
public class PersonController {

    private final WalletService service;

    @Autowired
    public PersonController(WalletService service) {
        this.service = service;
    }

    @PostMapping("/createWallet")
    public Mono<Wallet> createPago(@RequestBody Wallet request){
        return service.createWallet(request);
    }

    @GetMapping("/retrieveWalletByPerson/{dni}")
    public Mono<Wallet> getWalletByPerson(@PathVariable("dni") String dni){
        return service.getWalletByPerson(dni).switchIfEmpty(Mono.error(new Exception()));
    }


}
