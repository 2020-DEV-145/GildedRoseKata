package com.gildedrose

import kotlin.math.max
import kotlin.math.min

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        items.forEach { item ->
            when (item.type) {
                ItemType.BASIC -> updateBasicItemQuality(item)
                ItemType.AGED_BRIE -> updateAgedBrieItemQuality(item)
                ItemType.BACKSTAGE_PASSES -> updateBackstagePassesItemQuality(item)
                ItemType.CONJURED -> updateConjuredItemQuality(item)
                ItemType.SULFURAS -> Unit
            }
            fixQualityLevelLimits(item)
        }
    }

    private fun fixQualityLevelLimits(item: Item) {
        if (item.type != ItemType.SULFURAS) {
            item.quality = max(min(item.quality, Item.MAX_STANDARD_QUALITY), Item.MIN_QUALITY)
        }
    }

    private fun updateBasicItemQuality(item: Item) {
        item.sellIn = item.sellIn - 1
        item.quality = if (item.IsOutOfDate) item.quality - 2 else item.quality - 1
    }

    private fun updateAgedBrieItemQuality(item: Item) {
        item.sellIn = item.sellIn - 1
        item.quality = if (item.IsOutOfDate) item.quality + 2 else item.quality + 1
    }

    private fun updateBackstagePassesItemQuality(item: Item) {
        item.sellIn = item.sellIn - 1
        item.quality = when {
            item.sellIn < 0 -> 0
            item.sellIn < 5 -> item.quality + 3
            item.sellIn < 10 -> item.quality + 2
            else -> item.quality + 1
        }
    }

    private fun updateConjuredItemQuality(item: Item) {
        item.sellIn = item.sellIn - 1
        item.quality = if (item.IsOutOfDate) item.quality - 4 else item.quality - 2
    }

}

