package com.gildedrose.updateStrategy

import com.gildedrose.IsOutOfDate
import com.gildedrose.Item

class BasicUpdateStrategy : UpdateItemStrategy {
    override fun updateItem(item: Item) {
        item.sellIn -= 1
        item.quality -= if (item.IsOutOfDate) 2 else 1
        enforceQualityLevelLimits(item)
    }
}