package com.gildedrose.itemWrapper

import com.gildedrose.Item
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ItemWrapperFactoryTest {

    private val itemWrapperFactory = ItemWrapperFactory()

    @Test
    fun `Basic Item is wrapped with a BasicItemWrapper`() {
        val item = Item("Elixir of the Mongoose", 10, 10)
        assertTrue(itemWrapperFactory.getItemWrapper(item) is Basic)
    }

    @Test
    fun `Backstage passes is wrapped with a BackstagePasses`() {
        val item = Item("Backstage passes", 10, 10)
        assertTrue(itemWrapperFactory.getItemWrapper(item) is BackstagePasses)
    }

    @Test
    fun `Sulfuras Item is wrapped with a Sulfuras`() {
        val item = Item("Sulfuras, Hand of Ragnaros", 10, 10)
        assertTrue(itemWrapperFactory.getItemWrapper(item) is Sulfuras)
    }

    @Test
    fun `Aged Brie Item is wrapped with a AgedBrie`() {
        val item = Item("Aged Brie", 10, 10)
        assertTrue(itemWrapperFactory.getItemWrapper(item) is AgedBrie)
    }

    @Test
    fun `Conjured Item is wrapped with a Conjured`() {
        val item = Item("Conjured Mana Cake", 10, 10)
        assertTrue(itemWrapperFactory.getItemWrapper(item) is Conjured)
    }
}