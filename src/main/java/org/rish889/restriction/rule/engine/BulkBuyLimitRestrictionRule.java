package org.rish889.restriction.rule.engine;

public class BulkBuyLimitRestrictionRule implements RestrictionRule {
    private final Integer maxIndividualProductLimit;

    public BulkBuyLimitRestrictionRule(Integer maxIndividualProductLimit) {
        this.maxIndividualProductLimit = maxIndividualProductLimit;
    }

    @Override
    public RestrictionStatus check(Cart cart) {
        for (int i = 0; i < cart.getItems().size(); i++) {
            if (maxIndividualProductLimit < cart.getItems().get(i).getQuantity()) {
                return RestrictionStatus.BREACHED;
            }
        }
        return RestrictionStatus.MET;
    }
}
