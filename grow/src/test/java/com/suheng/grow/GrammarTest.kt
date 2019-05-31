package com.suheng.grow

import com.suheng.grow.grammar.Grammar
import org.junit.After
import org.junit.Before
import org.junit.Test

class GrammarTest {

    @Before
    fun start() {
        println("unit test start")
    }

    @After
    fun finish() = println("unit test finish")

    @Test
    fun testSum() {
        val grammar = Grammar()
        println("sum two = " + grammar.sum(3, 6))
        println("sum three = ${grammar.sum(3, 6, 9)}")
    }

}