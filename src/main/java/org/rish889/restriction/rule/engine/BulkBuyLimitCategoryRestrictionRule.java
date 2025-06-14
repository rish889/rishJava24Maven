package org.rish889.restriction.rule.engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BulkBuyLimitCategoryRestrictionRule implements RestrictionRule {
    private Map<Category, Integer> categoryToLimitMap;

    public BulkBuyLimitCategoryRestrictionRule(Map<Category, Integer> categoryToLimitMap) {
        this.categoryToLimitMap = categoryToLimitMap;
    }

    @Override
    public RestrictionStatus check(Cart cart) {
        List<Item> items = cart.getItems();
        Map<Category, Integer> categoryToQuantityMap = new HashMap<>();

        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (!categoryToQuantityMap.containsKey(item.getCategory())) {
                categoryToQuantityMap.put(item.getCategory(), 0);
            }

            categoryToQuantityMap.put(item.getCategory(), categoryToQuantityMap.get(item.getCategory()) + item.getQuantity());
        }


        for (Category category : Category.values()) {
            if (categoryToQuantityMap.get(category) > categoryToLimitMap.get(category)) {
                return RestrictionStatus.BREACHED;
            }
        }
        return RestrictionStatus.MET;
    }
}
