package com.gildedrose.strategy;

import com.gildedrose.Item;

public class ConjuredUpdateStrategy implements UpdateStrategy {

    @Override
    public boolean isApplicable(Item item) {
        return "Conjured Mana Cake".equals(item.name);
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
