package com.gildedrose.itemWrapper

import com.gildedrose.Item
import com.gildedrose.updateStrategy.BasicUpdateStrategy
import com.gildedrose.updateStrategy.EpicUpdateStrategy
import com.gildedrose.updateStrategy.UpdateItemStrategy

class Basic(item: Item) : ItemWrapper(item) {
    override val updateStrategy: UpdateItemStrategy = BasicUpdateStrategy()
}