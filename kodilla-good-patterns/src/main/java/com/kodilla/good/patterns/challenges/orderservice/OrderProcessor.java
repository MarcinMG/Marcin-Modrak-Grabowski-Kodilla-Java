package com.kodilla.good.patterns.challenges.orderservice;

public class OrderProcessor {

    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

     public OrderProcessor(final InformationService informationService, final OrderService orderService,
                           final OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isOrdered = orderService.order(orderRequest.getName(), orderRequest.getSurName(),
                orderRequest.getProductName(), orderRequest.getProductOrderDate());

        if(isOrdered){
            informationService.inform(orderRequest.getName(), orderRequest.getName());
            orderRepository.createOrder(orderRequest.getName(), orderRequest.getSurName(), orderRequest.getProductName(),
                    orderRequest.getProductOrderDate());
            return new OrderDto(orderRequest.getName(), orderRequest.getSurName(), true);
        } else {
            return new OrderDto(orderRequest.getName(), orderRequest.getSurName(), false);
        }
    }
}
