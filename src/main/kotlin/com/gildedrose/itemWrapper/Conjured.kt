package com.gildedrose.itemWrapper

import com.gildedrose.Item
import com.gildedrose.updateStrategy.ConjuredUpdateStrategy
import com.gildedrose.updateStrategy.UpdateItemStrategy

class Conjured(item: Item) : ItemWrapper(item) {
    override val updateStrategy: UpdateItemStrategy = ConjuredUpdateStrategy()
}