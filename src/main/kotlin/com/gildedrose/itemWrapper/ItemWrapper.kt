package com.gildedrose.itemWrapper

import com.gildedrose.Item
import com.gildedrose.updateStrategy.UpdateItemStrategy

abstract class ItemWrapper(private val item: Item) {
    abstract val updateStrategy: UpdateItemStrategy
    fun updateItem() = updateStrategy.updateItem(item)
}