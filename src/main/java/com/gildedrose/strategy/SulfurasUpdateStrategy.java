package com.gildedrose.strategy;

import com.gildedrose.Item;

class SulfurasUpdateStrategy implements UpdateStrategy {

    @Override
    public void update(Item item) {
        //DO NOTHING - Sulfuras never has to be sold or decreases in quality
    }
}
