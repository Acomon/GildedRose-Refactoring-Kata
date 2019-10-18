package com.gildedrose;

import static org.junit.Assert.*;

import com.gildedrose.model.Item;
import org.junit.Before;
import org.junit.Test;

public class GildedRoseTest {
    private GildedRose app;

    @Before
    public void setup() {
        Item[] items = new Item[] {
                new Item("foo", 0, 0),
                new Item("foo", 1, 1),
                new Item("foo", 0, 10),
                new Item("Aged Brie", 1, 49),
                new Item("Aged Brie", 0, 8),
                new Item("Sulfuras, Hand of Ragnaros", 10, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 12, 1),
                new Item("Backstage passes to a TAFKAL80ETC concert", 1, 7),
                new Item("Conjured", 1, 20),
        };
        app = new GildedRose(items);
    }

    @Test
    public void foo() {
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void sellInLowers() {
        app.updateQuality();
        assertEquals(0, app.items[1].sellIn);
    }

    @Test
    public void qualityLowers() {
        app.updateQuality();
        assertEquals(0, app.items[1].quality);
    }

    @Test
    public void qualityNotUnderZero() {
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void qualityLowersDouble() {
        app.updateQuality();
        assertEquals(8, app.items[2].quality);
    }

    @Test
    public void agedBrieIncreases() {
        app.updateQuality();
        assertEquals(50, app.items[3].quality);
    }

    @Test
    public void agedBrieDoubleIncreases() {
        app.updateQuality();
        assertEquals(10, app.items[4].quality);
    }

    @Test
    public void itemQualityNotOver50() {
        app.updateQuality();
        app.updateQuality();
        assertEquals(50, app.items[3].quality);
    }

    @Test
    public void sulfurasNotLowering() {
        app.updateQuality();
        assertEquals(80, app.items[5].quality);
        assertEquals(10, app.items[5].sellIn);
    }

    @Test
    public void backstagePassesIncreasingInValue() {
        app.updateQuality();
        assertEquals(2, app.items[6].quality);
    }

    @Test
    public void backstagePassesDoubleIncreasingInValue() {
        app.updateQuality();
        app.updateQuality();
        assertEquals(4, app.items[6].quality);
    }

    @Test
    public void backstagePassesTripleIncreasingInValue() {
        app.updateQuality();
        assertEquals(10, app.items[7].quality);
    }

    @Test
    public void backstagePassesToZero() {
        app.updateQuality();
        app.updateQuality();
        assertEquals(0, app.items[7].quality);
    }

    @Test
    public void conjuredItemsDegradingTwiceFast() {
        app.updateQuality();
        assertEquals(18, app.items[8].quality);
        app.updateQuality();
        assertEquals(14, app.items[8].quality);
    }

}
