package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            String name = items[i].name;
            if (name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }
            if (name.equals("Aged Brie")) {
                if (items[i].quality < 50) {
                    items[i].quality++;
                }
            } else if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality < 50) {
                    items[i].quality++;
                }
                if (items[i].quality < 50 && items[i].sellIn < 11) {
                    items[i].quality++;
                }
                if (items[i].quality < 50 && items[i].sellIn < 6) {
                    items[i].quality++;
                }
            } else {
                if (items[i].quality > 0) {
                    items[i].quality--;
                }
            }

            items[i].sellIn--;

            if (sellDatePassed(i)) {
                if (name.equals("Aged Brie") && items[i].quality < 50) {
                    items[i].quality++;
                } else if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    items[i].quality = 0;
                } else {
                    if (items[i].quality > 0) {
                        items[i].quality--;
                    }
                }
            }
        }
    }

    private boolean sellDatePassed(int i) {
        return items[i].sellIn < 0;
    }
}