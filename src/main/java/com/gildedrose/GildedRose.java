package com.gildedrose;

import com.gildedrose.strategy.UpdateStrategy;
import com.gildedrose.strategy.UpdateStrategyService;

class GildedRose {
    Item[] items;
    private final UpdateStrategyService updateStrategyService;
    public GildedRose(Item[] items) {
        this.items = items;
        this.updateStrategyService = new UpdateStrategyService();
    }

    public void updateQuality() {
        for (Item item : items) {
            UpdateStrategy strategy = updateStrategyService.findUpdateStrategyFor(item);
            strategy.update(item);
        }
    }
}
