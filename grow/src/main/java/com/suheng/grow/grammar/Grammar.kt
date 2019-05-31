package com.suheng.grow.grammar

class Grammar {
    private val pi = 3.14
    private var y: Int = 11
    private val items = listOf("kiwifruit", "apple", "banana")

    fun sum(a: Int, b: Int): Int { //定义函数：返回值类型为Int
        return a + b//可以不用写分号
    }

    fun sum(a: Int, b: Int, c: Int) = a + b + c //定义函数：表达式作为函数体，自动推断返回值类型（简写）

    private fun printUnit(a: Int, b: Int): Unit { //定义函数：返回值类型为无意义的值
        println("$a + $b = ${a + b}")
    }

    //定义函数：返回值类型为无意义的值，Unit可省且简写，“$对象”表示对对象引用，“{}”表示对象的运算，“()”表示数值的运算
    private fun printUnit(a: Int, b: Int, c: Int) =
        println("a, $a + $b + $c = ${a + b + c}, " + { a + b } + ", " + (a + b))

    private fun maxOf(a: Int, b: Float): Int { //if条件表达式
        if (a > b) {
            return a
        } else {
            return if (a > b) a else b.toInt()
        }
        //等价：return if (a > b) a else b.toInt()
    }

    private fun maxOf(a: Int, b: Double): Int { //if条件表达式
        return if (a > b) a else b.toInt()
    }

    private fun maxOf(a: Int, b: Int) = if (a > b) a else b //if条件表达式

    private fun parseInt(str: String): Int? { //当某个变量的值可以为null时，必须在声明处的类型后添加?来标识该引用可为空
        return str.toIntOrNull() //如果str的内容不是数字返回 null
    }

    private fun printProduct(arg1: String, arg2: String) {
        val x = parseInt(arg1)
        val y = parseInt(arg2)
        //println("$x * $y = ${x * y}") //直接使用'x * y'会导致编译错误，因为他们可能为null
        if (x != null && y != null) { //需进行非空判断
            println("$x * $y = ${x * y}") //在空检测后，x与y会自动转换为非空值（non-nullable）
        } else {
            println("either '$arg1' or '$arg2' is not a number")
        }
    }

    //'is'运算符检测表达式是否为某类型的实例：如果一个不可变的局部变量或属性已经判断出为某类型，
    // 那么检测后的分支中可以直接当作该类型使用，无需显式转换。
    private fun getStringLength(obj: Any): Int? {
        if (obj is String) {
            return obj.length //'obj'在该条件分支内自动转换成String
        }

        return null //在离开类型检测分支后，'obj'仍然是Any类型
    }

    private fun getStringLen(obj: Any): Int? {
        if (obj !is String) return null
        return obj.length //'obj'在这一分支内自动转换成String
    }

    private fun getStringLen2(obj: Any): Int? {
        //'obj'在'&&'的右边自动转换成String
        if (obj is String && obj.length > 0) {
            return obj.length
        }

        return null
    }

    private fun printLength(obj: Any) {
        println("'$obj' string length is ${getStringLength(obj) ?: "error, not a string"}")
    }

    //使用区间（range）:使用in运算符来检测某个数字是否在指定区间内
    private fun describeIn(x: Int) {
        val y = 11
        if (x in 4..y + 1) { //..区间运算符
            println("$x in range(4, ${y + 1})")
        }

        if (x !in 4..y + 1) {
            println("$x out range(4, ${y + 1})")
        }
    }

    //when表达式
    private fun chooseWhen(obj: Any): String =
        when (obj) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }

    //for循环
    private fun printForAndIteration() {
        for (item in items) { //集合迭代
            print("$item\t")
        }
        println()
        for (index in items.indices) { //区间迭代，list.indices：数组下标区间，items.size：数组长度
            println("item at $index is ${items[index]}, items.indices = ${items.indices}, items.size = ${items.size}")
        }

        print("数列迭代：")
        for (x in 1..9 step 3) { //数列迭代：从第一个开始，每三个输出一次（初始值为1差值为3的等差数列，下标从零开始）
            print("$x\t")
        }
        println()
        print("数列迭代：")
        for (x in 9 downTo 0 step 4) { //数列迭代：从第一个开始，每四个输出一次（初始值为9差值为4的等差数列，下标从零开始）
            print("$x\t")
        }
        println()

        when {
            "orange" in items -> println("juicy")
            "apple" in items -> println("apple is fine too")
        }

        items.filter { it.startsWith("b") }
            .map { it.toUpperCase() }
            .forEach { (println(it)) }
    }

    //while循环
    private fun printWhile() {
        var index = 0
        while (index < items.size) {
            println("while, item at $index is ${items[index++]}")
        }
    }
}
