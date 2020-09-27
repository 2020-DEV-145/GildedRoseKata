package com.gildedrose.updateStrategy

import com.gildedrose.Item
import kotlin.math.max
import kotlin.math.min

interface UpdateItemStrategy {
    fun updateItem(item: Item)

    fun enforceQualityLevelLimits(item: Item) {
        item.quality = max(min(item.quality, Item.MAX_STANDARD_QUALITY), Item.MIN_QUALITY)
    }
}