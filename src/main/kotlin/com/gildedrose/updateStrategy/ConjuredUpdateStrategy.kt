package com.gildedrose.updateStrategy

import com.gildedrose.IsOutOfDate
import com.gildedrose.Item

class ConjuredUpdateStrategy : UpdateItemStrategy {
    override fun updateItem(item: Item) {
        item.sellIn -= 1
        item.quality -= if (item.IsOutOfDate) 4 else 2
        enforceQualityLevelLimits(item)
    }
}