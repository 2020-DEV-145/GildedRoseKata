package com.gildedrose

import com.gildedrose.updateStrategy.UpdateStrategyFactory

class GildedRose(var items: Array<Item>) {
    private val updateStrategyFactory = UpdateStrategyFactory()

    fun updateQuality() {
        items.forEach { item ->
            updateStrategyFactory.getUpdateStrategy(item.type).updateItem(item)
        }
    }
}

