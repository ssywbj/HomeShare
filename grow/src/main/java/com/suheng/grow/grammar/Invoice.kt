package com.suheng.grow.grammar

//class Invoice private constructor(firstName: String) //类可以有一个主构造函数以及一个或多个次构造函数，主构造函数constructor声明
class Invoice(firstName: String) { //如果主构造函数没有任何注解或者可见性修饰符，可以省略constructor关键字，否则不能省
    //主构造函数不能包含任何的代码。初始化的代码可以放到以init关键字作为前缀的初始化块（initializer blocks）中
    init {
        println("First initializer block that prints $firstName")
    }

    //执行顺序：先输出init代码块，再输出firstProperty
    var firstProperty = "First property: $firstName".also(::println) //赋值并输出到控制台(Console)

    init {
        println("Second initializer block that prints ${firstName.length}")
    }

    val secondProperty = "Second property: ${firstName.length}"

    constructor(firstName: String, grammar: Grammar) : this(firstName) {
        grammar.exchangeTwoValue()
    }
}
