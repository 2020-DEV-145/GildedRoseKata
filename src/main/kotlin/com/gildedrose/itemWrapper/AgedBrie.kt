package com.gildedrose.itemWrapper

import com.gildedrose.Item
import com.gildedrose.updateStrategy.AgedBrieUpdateStrategy
import com.gildedrose.updateStrategy.UpdateItemStrategy

class AgedBrie(item: Item) : ItemWrapper(item) {
    override val updateStrategy: UpdateItemStrategy = AgedBrieUpdateStrategy()
}