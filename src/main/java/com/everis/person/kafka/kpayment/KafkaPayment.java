package com.everis.person.kafka.kpayment;

import com.everis.person.entity.Payment;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaPayment {

    private KafkaTemplate kafkaTemplate;
    @Getter@Setter
    private Payment payment;

    public KafkaPayment(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "t-send-payment", groupId = "g_send_payment", containerFactory = "paymentConcurrentKafkaListenerContainerFactory")
    public void receiverPayment(Payment payment) {
        log.info("payment " + payment.getAmountPayment());
        setPayment(payment);
    }
}
