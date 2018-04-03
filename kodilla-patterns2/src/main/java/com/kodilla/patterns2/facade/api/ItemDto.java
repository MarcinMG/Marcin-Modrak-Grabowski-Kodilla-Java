package com.kodilla.patterns2.facade.api;

public final class ItemDto {
    private final Long productId;
    private final Double quantity;

    public ItemDto(final Long productId, final Double quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public Double getQuantity() {
        return quantity;
    }

}
