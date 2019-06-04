package com.suheng.grow.classes

open class Father { //使用open关键字声明的类才能被继承，否则它默认是一个终态类，无法被继承
    open fun nv() = println("Father, nv()") //使用open关键字声明的方法才能被子类覆写，否则它默认是一个终态方法，无法被覆写

    fun v() {} //该方法没有使用open关键字声明，故它不能被覆写，子类中也不能存在与其同名且同参数类型的方法
}