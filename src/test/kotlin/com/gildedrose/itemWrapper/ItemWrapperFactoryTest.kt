package com.gildedrose.itemWrapper

import com.gildedrose.Item
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ItemWrapperFactoryTest {

    private val itemWrapperFactory = ItemWrapperFactory()

    @Test
    fun `Basic Item has a BASIC ItemType`() {
        val item = Item("Elixir of the Mongoose", 10, 10)
        assertTrue(itemWrapperFactory.getItemWrapper(item) is Basic)
    }

    @Test
    fun `Backstage passes Item has a BACKSTAGE_PASSES ItemType`() {
        val item = Item("Backstage passes", 10, 10)
        assertTrue(itemWrapperFactory.getItemWrapper(item) is BackstagePasses)
    }

    @Test
    fun `Sulfuras Item has a SULFURAS ItemType`() {
        val item = Item("Sulfuras, Hand of Ragnaros", 10, 10)
        assertTrue(itemWrapperFactory.getItemWrapper(item) is Sulfuras)
    }

    @Test
    fun `Aged Brie Item has a AGED_BRIE ItemType`() {
        val item = Item("Aged Brie", 10, 10)
        assertTrue(itemWrapperFactory.getItemWrapper(item) is AgedBrie)
    }

    @Test
    fun `Conjured Item has a CONJURED ItemType`() {
        val item = Item("Conjured Mana Cake", 10, 10)
        assertTrue(itemWrapperFactory.getItemWrapper(item) is Conjured)
    }
}