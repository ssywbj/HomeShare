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
    fun testAssignment() {
        Grammar().assignment()
    }

    @Test
    fun testSum() {
        val grammar = Grammar()
        println("sum two = " + grammar.sum(3, 6))
        println("sum three = ${grammar.sum(3, 6, 9)}")
    }

    @Test
    fun testPrintUnit() {
        val grammar = Grammar()
        grammar.printUnit(4, 2)
        grammar.printUnit(4, 2, 90)
    }

    @Test
    fun testMaxOf() {
        val grammar = Grammar()
        println("max 0f is ${grammar.maxOf(3, 8.6f)}")
        println("max 0f is " + grammar.maxOf(5, 9.63))
        println("max 0f is ${grammar.maxOf(13, 9)}")
    }

    @Test
    fun testPrintProduct() {
        val grammar = Grammar()
        grammar.printProduct("34", "2")
        grammar.printProduct("3E4", "8")
        grammar.printProduct("34", "Rr")
    }

    @Test
    fun testPrintLength() {
        val grammar = Grammar()
        grammar.printLength("suheng")
        grammar.printLength(1000)
        grammar.printLength(listOf(Any()))
    }

    @Test
    fun testDescribeIn() {
        val grammar = Grammar()
        grammar.describeIn(3)
        grammar.describeIn(4)
        grammar.describeIn(7)
        grammar.describeIn(12)
        grammar.describeIn(13)
    }

    @Test
    fun testChooseWhen() {
        val grammar = Grammar()
        println(grammar.chooseWhen(1))
        println(grammar.chooseWhen("Hello"))
        println(grammar.chooseWhen(1000L))
        println(grammar.chooseWhen(2))
        println(grammar.chooseWhen(2.9f))
        println(grammar.chooseWhen("other"))
    }

    @Test
    fun testForWhile() {
        val grammar = Grammar()
        grammar.printForAndIteration()
        grammar.printWhile()
    }
}