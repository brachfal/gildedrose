package com.gildedrose.strategy;

import com.gildedrose.Item;

public interface UpdateStrategy {
    boolean isApplicable(Item item);

    void update(Item item);
}
