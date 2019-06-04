package com.suheng.grow

import com.suheng.grow.classes.Invoice
import com.suheng.grow.grammar.Grammar
import org.junit.After
import org.junit.Before
import org.junit.Test

class InvoiceTest {

    @Before
    fun start() {
        println("unit test start")
    }

    @After
    fun finish() = println("unit test finish")

    @Test
    fun testInvoice() {
        val invoice = Invoice("Wei")
        println(invoice.secondProperty)
    }

    @Test
    fun testConstructors() {
        Invoice("Wei", Grammar())
    }

}