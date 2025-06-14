package org.rish889.restriction.rule.engine;

public interface RestrictionRule {
    RestrictionStatus check(Cart cart);
}
