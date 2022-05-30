package com.gildedrose.strategy;

import com.gildedrose.Item;

import java.util.List;

public final class UpdateStrategyService {

    private final List<UpdateStrategy> specificStrategies = List.of(
        new SulfurasUpdateStrategy(),
        new AgedBrieUpdateStrategy(),
        new BackstagePassesUpdateStrategy()
    );

    public UpdateStrategy findUpdateStrategyFor(final Item item) {
        return specificStrategies.stream()
            .filter(s-> s.isApplicable(item))
            .findFirst()
            .orElse(new DefaultUpdateStrategy());
    }
}
