package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class ProductOrderService {

    public static void main(String[] args) {

        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve("Marcin", "Modrak", "Kapcie",
                LocalDate.of(2018, 01,01));

        OrderProcessor orderProcessor = new OrderProcessor(new MailService(), new ShoesService(), new ShoesOrderRepository());
        orderProcessor.process(orderRequest);

    }
}

