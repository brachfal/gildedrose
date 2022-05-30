package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }
    @Test
    void shouldQualityNeverBeNegative() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 2, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("+5 Dexterity Vest", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    }
    @Test
    void shouldAgedBrieIncreaseQualityWhenGetsOlder() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(1, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);

        app.updateQuality();

        assertEquals(0, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }
    @Test
    void shouldBackstagePassesIncreaseQualityWhenGetsOlder() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(14, app.items[0].sellIn);
        assertEquals(21, app.items[0].quality);

        app.updateQuality();

        assertEquals(13, app.items[0].sellIn);
        assertEquals(22, app.items[0].quality);
    }

    @Test
    void shouldBackstagePassesIncreaseQualityBy2When10DaysOrLessToSell() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(22, app.items[0].quality);
    }

    @Test
    void shouldBackstagePassesIncreaseQualityBy3When5DaysOrLessToSell() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(23, app.items[0].quality);
    }

    @Test
    void shouldBackstagePassesQualityDropsTo0AfterConcert() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(23, app.items[0].quality);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
    @Test
    void shouldQualityBeLessOrEqual50() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(50, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);
    }
    @Test
    void shouldSulfurasNeverHasToBeSoldOrDecreasesInQuality() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 80) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(80, app.items[0].quality);
        assertEquals(10, app.items[0].sellIn);
    }
    @Test
    void shouldQualityDegradesTwiceWhenSellDatePasses() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 0, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Elixir of the Mongoose", app.items[0].name);
        assertEquals(8, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

}
