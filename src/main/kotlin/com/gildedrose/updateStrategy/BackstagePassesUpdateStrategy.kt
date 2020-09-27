package com.gildedrose.updateStrategy

import com.gildedrose.Item

class BackstagePassesUpdateStrategy : UpdateItemStrategy {
    override fun updateItem(item: Item) {
        item.sellIn -= 1
        item.quality = when {
            item.sellIn < 0 -> 0
            item.sellIn < 5 -> item.quality + 3
            item.sellIn < 10 -> item.quality + 2
            else -> item.quality + 1
        }
        enforceQualityLevelLimits(item)
    }
}