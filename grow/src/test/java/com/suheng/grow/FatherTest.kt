package com.suheng.grow

import com.suheng.grow.classes.*
import org.junit.After
import org.junit.Before
import org.junit.Test

class FatherTest {

    @Before
    fun start() {
        println("unit test start")
    }

    @After
    fun finish() = println("unit test finish")

    @Test
    fun testNv() {
        var grandfather = Grandfather()
        grandfather.nv() //调用的是父类的方法
        grandfather = Father()
        grandfather.nv() //调用的是子类覆写后的方法
        grandfather = Children()
        grandfather.nv() //调用的是子类覆写后的方法
    }

    @Test
    fun testGrandfather2() {
        var grandfather3 = Grandfather3()
        var Grandfather3Shorthand = Grandfather3Shorthand("", "", 0)
    }
}