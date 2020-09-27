package com.gildedrose.itemWrapper

import com.gildedrose.Item
import com.gildedrose.updateStrategy.BackstagePassesUpdateStrategy
import com.gildedrose.updateStrategy.UpdateItemStrategy

class BackstagePasses(item: Item) : ItemWrapper(item) {
    override val updateStrategy: UpdateItemStrategy = BackstagePassesUpdateStrategy()
}