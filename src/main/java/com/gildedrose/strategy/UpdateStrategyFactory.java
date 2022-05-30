package com.gildedrose.strategy;

import java.util.Map;

public final class UpdateStrategyFactory {

    private final Map<String, UpdateStrategy> strategyMap = Map.of(
        "Sulfuras, Hand of Ragnaros", new SulfurasUpdateStrategy(),
        "Aged Brie", new AgedBrieUpdateStrategy(),
        "Backstage passes to a TAFKAL80ETC concert", new BackstagePassesUpdateStrategy(),
        "Conjured Mana Cake", new ConjuredUpdateStrategy()
    );

    public UpdateStrategy createUpdateStrategy(final String name) {
        return strategyMap.getOrDefault(name, new DefaultUpdateStrategy());
    }
}
