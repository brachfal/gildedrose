package com.gildedrose.strategy;

import com.gildedrose.Item;

class GenericUpdateStrategy implements UpdateStrategy {

    @Override
    public boolean isApplicable(Item item) {
        return true;
    }

    @Override
    public void update(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
        item.sellIn--;
        if (item.quality > 0) {
            item.quality--;
        }
    }
}
