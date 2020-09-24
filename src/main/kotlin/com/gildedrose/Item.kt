package com.gildedrose

open class Item(var name: String, var sellIn: Int, var quality: Int) {
    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }

    companion object {
        const val MAX_STANDARD_QUALITY = 50
        const val MIN_QUALITY = 0
    }
}

val Item.IsOutOfDate: Boolean
    get() = sellIn < 0

val Item.type: ItemType
    get() = when {
        name == "Sulfuras, Hand of Ragnaros" -> ItemType.SULFURAS
        name == "Aged Brie" -> ItemType.AGED_BRIE
        name.contains("Backstage passes") -> ItemType.BACKSTAGE_PASSES
        name.contains("Conjured") -> ItemType.CONJURED
        else -> ItemType.BASIC
    }
