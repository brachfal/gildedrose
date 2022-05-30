package com.gildedrose;

import com.gildedrose.strategy.UpdateStrategy;
import com.gildedrose.strategy.UpdateStrategyFactory;

class GildedRose {
    Item[] items;
    private final UpdateStrategyFactory updateStrategyFactory;
    public GildedRose(Item[] items) {
        this.items = items;
        this.updateStrategyFactory = new UpdateStrategyFactory();
    }

    public void updateQuality() {
        for (Item item : items) {
            UpdateStrategy strategy = updateStrategyFactory.createUpdateStrategy(item.name);
            strategy.update(item);
        }
    }
}
