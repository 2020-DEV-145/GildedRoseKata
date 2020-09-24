package com.gildedrose

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ItemTypeTest {
    @Test
    fun `Basic Item has a BASIC ItemType`() {
        assertEquals(Item("Elixir of the Mongoose", 10, 10).type, ItemType.BASIC)
    }

    @Test
    fun `Backstage passes Item has a BACKSTAGE_PASSES ItemType`() {
        assertEquals(Item("Backstage passes", 10, 10).type, ItemType.BACKSTAGE_PASSES)
    }

    @Test
    fun `Sulfuras Item has a SULFURAS ItemType`() {
        assertEquals(Item("Sulfuras, Hand of Ragnaros", 10, 10).type, ItemType.SULFURAS)
    }

    @Test
    fun `Aged Brie Item has a AGED_BRIE ItemType`() {
        assertEquals(Item("Aged Brie", 10, 10).type, ItemType.AGED_BRIE)
    }

    @Test
    fun `Conjured Item has a CONJURED ItemType`() {
        assertEquals(Item("Conjured Mana Cake", 10, 10).type, ItemType.CONJURED)
    }
}