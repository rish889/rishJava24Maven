package org.rish889.restriction.rule.engine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestrictionRuleEngineRunner {
    public static void main(String args[]) {
        RestrictionRule rule1 = new BulkBuyLimitRestrictionRule(10);

        Map<Category, Integer> categoryToLimitMap = new HashMap<>();
        categoryToLimitMap.put(Category.Paracetamol, 4);
        categoryToLimitMap.put(Category.analgesic, 3);
        categoryToLimitMap.put(Category.chocolate, 14);
        RestrictionRule rule2 = new BulkBuyLimitCategoryRestrictionRule(categoryToLimitMap);

        List<RestrictionRule> rules = Arrays.asList(rule1, rule2);
        RestrictionRuleEngine restrictionRuleEngine = new RestrictionRuleEngine(rules);

        Cart cart = new Cart();
        Item item1 = new Item("1", Category.Paracetamol, 3);
        Item item2 = new Item("2", Category.analgesic, 3);
        Item item3 = new Item("3", Category.chocolate, 8);
        Item item4 = new Item("4", Category.Paracetamol, 2);
        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        cart.addItem(item4);

        System.out.println(restrictionRuleEngine.check(cart));


    }
}
