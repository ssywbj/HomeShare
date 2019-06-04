package com.suheng.grow

import com.suheng.grow.classes.Children
import com.suheng.grow.classes.Father
import org.junit.After
import org.junit.Before
import org.junit.Test

class ChildrenTest {

    @Before
    fun start() {
        println("unit test start")
    }

    @After
    fun finish() = println("unit test finish")

    @Test
    fun testNv() {
        var father = Father()
        father.nv() //调用的是父类的方法
        father = Children()
        father.nv() //调用的是子类覆写后的方法
    }

}