package com.suheng.grow.classes

//继承：声明类时，在冒号(:)之后标明一个显式的父类型
class Father2(p: Int) : Grandfather2(p) //如果派生类有一个主构造函数，其基类型可以（并且必须）用基类的主构造函数参数就地初始化
/*class Base : Grandfather2 {
    //如果类没有主构造函数，那么每个次构造函数必须使用super关键字初始化其父类型或委托给另一个构造函数做到这一点
    constructor(p: Int) : super(p)
}*/
