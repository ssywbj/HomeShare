package com.suheng.grow.classes

import com.suheng.grow.grammar.Grammar

//class Invoice private constructor(firstName: String) //类可以有一个主构造函数以及一个或多个次构造函数，构造函数用constructor声明
class Invoice(firstName: String) { //如果主构造函数没有任何注解或者可见性修饰符，可以省略constructor关键字，否则不能省
    //主构造函数不能包含任何的代码，初始化的代码可以放到以init关键字作为前缀的初始化块（initializer blocks）中
    init {
        println("First initializer block that prints $firstName") //主构造函数的参数可以在初始化块中使用
    }

    var firstProperty = "First property: $firstName".also(::println) //赋值并输出到控制台(Console)
    //调用主构造函数(String)时的执行顺序：顺序执行，即First init代码块-->firstProperty

    val thirdProperty = firstName.toUpperCase().also(::println) //主构造函数的参数也可以直接在类体内声明的属性初始化器中使用

    init {
        println("Second initializer block that prints ${firstName.length}")
    }

    val secondProperty = "Second property: ${firstName.length}"
    //调用主构造函数(String)时的执行顺序：顺序执行，即First init代码块-->firstProperty-->thirdProperty-->Second init代码块-->secondProperty

    /*如果类有主构造函数，那么每个次构造函数需要委托给主构造函数，可以直接委托或者通过别的次构造函数
    间接委托。委托到同一个类的另一个构造函数用this关键字即可*/
    constructor(firstName: String, grammar: Grammar) : this(firstName) { //声明次构造函数
        grammar.exchangeTwoValue()
    }
    /*初始化块（initializer blocks）中的代码实际上会成为主构造函数的一部分。委托给主构造函数会作为次构造函数的第一条语句，
    因此所有初始化块中的代码都会在次构造函数体之前执行。即使该类没有主构造函数，这种委托仍会隐式发生，并且仍会执行初始化块。
    因此调用次构造函数(String, Grammar)时的执行顺序：First init代码块-->firstProperty-->thirdProperty
    -->Second init代码块 -->secondProperty-->grammar.exchangeTwoValue()*/

    /*
    如果一个非抽象类没有声明任何（主或次）构造函数，那么它会有一个生成的不带参数的主构造函数，构造函数的
    可见性是 public。 如果不希望类有一个公有构造函数，那么需要声明一个带有非默认可见性的空的主构造函数：
    class DonCreateMe private constructor () { ...}
     */
}
