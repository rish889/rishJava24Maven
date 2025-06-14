package org.rish889.restriction.rule.engine;

import java.util.List;

public class RestrictionRuleEngine {
    private List<RestrictionRule> rules;

    public RestrictionStatus check(Cart cart) {
        for (int j = 0; j < rules.size(); j++) {
            if (RestrictionStatus.BREACHED.equals(rules.get(j).check(cart))) {
                return RestrictionStatus.BREACHED;
            }
        }
        return RestrictionStatus.MET;
    }

    public RestrictionRuleEngine(List<RestrictionRule> rules) {
        this.rules = rules;
    }

}
