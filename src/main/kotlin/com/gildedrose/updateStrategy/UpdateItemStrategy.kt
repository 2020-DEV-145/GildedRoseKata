package com.gildedrose.updateStrategy

import com.gildedrose.Item
import kotlin.math.max
import kotlin.math.min

interface UpdateItemStrategy {
    fun updateItem(item: Item)

    fun enforceQualityLevelLimits(item: Item) {
        item.quality = max(min(item.quality, MAX_STANDARD_QUALITY), MIN_QUALITY)
    }

    companion object {
        const val MAX_STANDARD_QUALITY = 50
        const val MIN_QUALITY = 0
    }
}