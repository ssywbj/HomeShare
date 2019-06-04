package com.suheng.grow.classes

open class Grandfather { //使用open关键字声明的类才能被继承，否则它默认是一个终态类，无法被继承
    open fun nv() = println("Grandfather, nv()") //使用open关键字声明的方法才能被子类覆写，否则它默认是一个终态方法，无法被覆写

    fun v() {} //该方法没有使用open关键字声明，故它不能被覆写而且其子类中不允许定义相同签名的函数

    open fun finalCc() = println("Grandfather, finalCc()")

    //属性覆盖与方法覆盖类似：在超类中声明然后在派生类中重新声明的属性必须以override开头并且它们必须具有兼容的类型
    open val x: Int = 21
    val y: Int = 31
    open val z: Int = 41
}