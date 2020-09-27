package com.gildedrose

import com.gildedrose.itemWrapper.ItemWrapperFactory

class GildedRose(var items: Array<Item>) {
    private val itemWrapperFactory = ItemWrapperFactory()

    fun updateQuality() {
        items.forEach { item ->
            itemWrapperFactory.getItemWrapper(item).updateItem()
        }
    }
}

