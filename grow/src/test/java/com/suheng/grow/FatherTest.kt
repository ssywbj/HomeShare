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
        grandfather.printWValue()
        grandfather = Father(522)
        grandfather.nv() //调用的是子类覆写后的方法2
        grandfather.printWValue()
        /*因为Father在主构造函数已经给属性初始化，所以可以不用传参进行初始化属性值；如果没有默认初始化，则必须要传参进去，
         具体可对比以下Grandfather3Shorthand类创建类实例时的代码*/
        grandfather = Father()
        grandfather.printWValue()
        grandfather = Children()
        grandfather.nv() //调用的是子类覆写后的方法
        grandfather.printWValue()
    }

    @Test
    fun testGrandfather2() {
        var grandfather3 = Grandfather3()
        println("firstName = ${grandfather3.firstName}, lastName = ${grandfather3.lastName}, age = ${grandfather3.age}")
        var shorthand = Grandfather3Shorthand("Wei", "Bangjie", 29) //没有在主构造函数中为其属性赋值时，必须传参进去
        println("firstName = ${shorthand.firstName}, lastName = ${shorthand.lastName}, age = ${shorthand.age}")
        //var Grandfather3Shorthand2 = Grandfather3Shorthand()错误的实例化方式，因为它在声明时并没有在主构造函数中为其属性赋值

    }
}