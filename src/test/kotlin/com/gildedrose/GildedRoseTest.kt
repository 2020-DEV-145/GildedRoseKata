package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {
    @Test
    fun `At the end of each day our system lowers SellIn and Quality values for every item`() {
        val items = arrayOf<Item>(
                Item("Elixir of the Mongoose", 10, 10),
        )
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].quality)
        assertEquals(9, app.items[0].sellIn)
    }

    @Test
    fun `Once the sell by date has passed, Quality degrades twice as fast`() {
        val items = arrayOf<Item>(
                Item("Elixir of the Mongoose", 1, 10),
                Item("Elixir of the Mongoose", 0, 10),
                Item("Elixir of the Mongoose", -1, 10)
        )
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].quality)
        assertEquals(0, app.items[0].sellIn)
        assertEquals(8, app.items[1].quality)
        assertEquals(-1, app.items[1].sellIn)
        assertEquals(8, app.items[2].quality)
        assertEquals(-2, app.items[2].sellIn)
    }


    @Test
    fun `The Quality of an item is never negative`() {
        val items = arrayOf<Item>(
                Item("Elixir of the Mongoose", 1, 1),
                Item("Elixir of the Mongoose", 0, 1),
                Item("Elixir of the Mongoose", 0, 2)
        )
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
        assertEquals(0, app.items[0].sellIn)
        assertEquals(0, app.items[1].quality)
        assertEquals(-1, app.items[1].sellIn)
        assertEquals(0, app.items[2].quality)
        assertEquals(-1, app.items[2].sellIn)
    }

    @Test
    fun `"Aged Brie" actually increases in Quality the older it gets`() {
        val items = arrayOf<Item>(
                Item("Aged Brie", 1, 1),
                Item("Aged Brie", -1, 1),
        )
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(2, app.items[0].quality)
        assertEquals(0, app.items[0].sellIn)
        assertEquals(3, app.items[1].quality)
        assertEquals(-2, app.items[1].sellIn)
    }

    @Test
    fun `The Quality of an item is never more than 50`() {
        val items = arrayOf<Item>(
                Item("Aged Brie", -1, 49),
        )
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
        assertEquals(-2, app.items[0].sellIn)
    }

    @Test
    fun `"Sulfuras", being a legendary item, never has to be sold or decreases in Quality`() {
        val items = arrayOf<Item>(
                Item("Sulfuras, Hand of Ragnaros", -1, 80),
                Item("Sulfuras, Hand of Ragnaros", 0, 80),
                Item("Sulfuras, Hand of Ragnaros", 1, 80),
        )
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(80, app.items[0].quality)
        assertEquals(0, app.items[1].sellIn)
        assertEquals(80, app.items[1].quality)
        assertEquals(1, app.items[2].sellIn)
        assertEquals(80, app.items[2].quality)
    }

    @Test
    fun `Backstage passes", like aged brie, increases in Quality as its SellIn value approaches`() {
        val items = arrayOf<Item>(
                Item("Backstage passes to a TAFKAL80ETC concert", 20, 5),
        )
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(6, app.items[0].quality)
        assertEquals(19, app.items[0].sellIn)
    }

    @Test
    fun `"Backstage passes", Quality increases by 2 when there are 10 days or less`() {
        val items = arrayOf<Item>(
                Item("Backstage passes to a TAFKAL80ETC concert", 10, 40),
        )
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(42, app.items[0].quality)
        assertEquals(9, app.items[0].sellIn)
    }

    @Test
    fun `"Backstage passes", Quality increases by 3 when there are 5 days or less`() {
        val items = arrayOf<Item>(
                Item("Backstage passes to a TAFKAL80ETC concert", 5, 40),
        )
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(43, app.items[0].quality)
        assertEquals(4, app.items[0].sellIn)
    }

    @Test
    fun `"Backstage passes", Quality drops to 0 after the concert`() {
        val items = arrayOf<Item>(
                Item("Backstage passes to a TAFKAL80ETC concert", 0, 40),
        )
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
        assertEquals(-1, app.items[0].sellIn)
    }

    @Test
    fun `"Conjured" items degrade in Quality twice as fast as normal items`() {
        val items = arrayOf<Item>(
                Item("Conjured Mana Cake", 10, 10),
                Item("Conjured Mana Cake", 0, 6),
                Item("Conjured Mana Cake", 0, 0),
        )
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(8, app.items[0].quality)
        assertEquals(9, app.items[0].sellIn)
        assertEquals(4, app.items[0].quality)
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
        assertEquals(-1, app.items[0].sellIn)
    }
}


