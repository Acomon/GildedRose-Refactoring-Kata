package com.gildedrose;

class AdjustValueService {
    void removeSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    void removeQuality(Item item, int amount) {
        item.quality = Math.max((item.quality - amount), 0);
    }

    void addQuality(Item item, int amount) {
        item.quality = Math.min((item.quality + amount), 50);
    }
}
