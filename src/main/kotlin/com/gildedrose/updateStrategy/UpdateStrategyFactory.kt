package com.gildedrose.updateStrategy

import com.gildedrose.ItemType

class UpdateStrategyFactory {
    fun getUpdateStrategy(itemType: ItemType) = when (itemType) {
        ItemType.BASIC -> BasicUpdateStrategy()
        ItemType.AGED_BRIE -> AgedBrieUpdateStrategy()
        ItemType.BACKSTAGE_PASSES -> BackstagePassesUpdateStrategy()
        ItemType.CONJURED -> ConjuredUpdateStrategy()
        ItemType.SULFURAS -> EpicUpdateStrategy()
    }
}