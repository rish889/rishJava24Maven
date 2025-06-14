package org.rish889.restriction.rule.engine;

public class Item {
    private String productId;
    private Category category;
    private Integer quantity;

    public Item(String productId, Category category, Integer quantity) {
        this.productId = productId;
        this.category = category;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public Category getCategory() {
        return category;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
