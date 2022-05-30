package com.gildedrose.strategy;

import com.gildedrose.Item;

class AgedBrieUpdateStrategy implements UpdateStrategy {

    @Override
    public boolean isApplicable(Item item) {
        return "Aged Brie".equals(item.name);
    }

    @Override
    public void update(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }

        item.sellIn--;

        if (item.sellIn < 0 && item.quality < 50) {
            item.quality++;
        }
    }
}
