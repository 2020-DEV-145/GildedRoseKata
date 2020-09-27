package com.gildedrose.itemWrapper

import com.gildedrose.Item

class ItemWrapperFactory {
    fun getItemWrapper(item: Item): ItemWrapper = when {
        item.name == "Sulfuras, Hand of Ragnaros" -> Sulfuras(item)
        item.name == "Aged Brie" -> AgedBrie(item)
        item.name.contains("Backstage passes") -> BackstagePasses(item)
        item.name.contains("Conjured") -> Conjured(item)
        else -> Basic(item)
    }
}