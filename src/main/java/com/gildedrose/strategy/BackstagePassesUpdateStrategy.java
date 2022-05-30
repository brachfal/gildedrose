package com.gildedrose.strategy;

import com.gildedrose.Item;

class BackstagePassesUpdateStrategy implements UpdateStrategy {

    @Override
    public boolean isApplicable(Item item) {
        return "Backstage passes to a TAFKAL80ETC concert".equals(item.name);
    }

    @Override
    public void update(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
        if (item.quality < 50 && item.sellIn < 11) {
            item.quality++;
        }
        if (item.quality < 50 && item.sellIn < 6) {
            item.quality++;
        }

        item.sellIn--;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
