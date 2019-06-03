package com.suheng.grow.grammar

class Grammar {
    private val pi = 3.14 //语句结束不用写分号
    private var y: Int = 11
    private val items = listOf("kiwifruit", "apple", "banana")
    private val list = listOf(5, -1, 0, 9, 13)
    private val map = mapOf("a" to 1, "b" to 2, "c" to 3) //to用于(key, value)映射

    fun assignment() {
        //val：定义只读变量且只能赋值一次
        val a: Int = 1 //定义Int变量并赋值
        //a = 35; error: Val cannot be reassigned
        val b = 2 //定义变量并赋值，省略Int，根据数值“2”自动推断出类型
        val c: Int //如果只定义变量但未赋值，不能省略类型
        c = 3 //明确赋值

        //var：定义可变变量
        var x = 45
        x = 3
        println("val: a = $a, b = $b, c = $c, π = $pi, var: x = $x, ++y = ${++y}")

        //字符串
        val s1 = "x is $x"
        x = 56
        val s2 = "${s1.replace("is", "was")}, but now is $x"
        println("$s1; $s2") //$变量或表示式的引用方式被称为字符串内插
    }

    fun sum(a: Int, b: Int): Int { //定义函数：返回值类型为Int
        return a + b
    }

    //定义函数：表达式作为函数体，自动推断返回值类型（简写）
    fun sum(a: Int, b: Int, c: Int) = a + b + c //Only expressions are allowed here

    fun printUnit(a: Int, b: Int): Unit { //定义函数：返回值类型为无意义的值
        println("$a + $b = ${a + b}")
    }

    //定义函数：返回值类型为无意义的值，Unit可省且简写，“$对象”表示对对象引用，“{}”表示对象的运算，“()”表示数值的运算
    fun printUnit(a: Int, b: Int, c: Int) =
        println("a, $a + $b + $c = ${a + b + c}, " + { a + b } + ", " + (a + b))

    fun maxOf(a: Int, b: Float): Int { //if条件表达式
        if (a > b) {
            return a
        } else {
            return if (a > b) a else b.toInt()
        }
        //等价：return if (a > b) a else b.toInt()
    }

    fun maxOf(a: Int, b: Double): Int { //if条件表达式
        return if (a > b) a else b.toInt()
    }

    fun maxOf(a: Int, b: Int) = if (a > b) a else b //if条件表达式

    private fun parseInt(str: String): Int? { //当某个变量的值可以为null时，必须在声明处的类型后添加?来标识该引用可为空
        return str.toIntOrNull() //如果str的内容不是数字返回 null
    }

    fun printParseInt(arg1: String, arg2: String) {
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

    fun printLength(obj: Any) {
        println("'$obj' string length is ${getStringLength(obj) ?: "error, not a string"}")
    }

    //使用区间（range）:使用in运算符来检测某个数字是否在指定区间内
    fun describeIn(x: Int) {
        val y = 11
        if (x in 4..y + 1) { //..：闭区间运算符，包含(y+1)。闭区间，[a,b]={a<=x<=b}；开区间，(a,b)={a<x<b}。
            println("'..', $x in range[4, ${y + 1}]")
        }

        if (x in 4 until y + 1) { //until：半开区间运算符，不包含(y+1)。左闭右开区间，[a,b)={a<=x<b}；左开右闭区间，(a,b]={a<x<=b}。
            println("'until', $x in range(4, ${y + 1}]")
        }

        if (x !in 4..y + 1) {
            println("$x out range(4, ${y + 1})/]")
        }
    }

    //when表达式
    fun chooseWhen(obj: Any): String =
        when (obj) { //使用when进行类型判断
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }

    //for循环
    fun printForAndIteration() {
        for (item in items) { //集合迭代
            print("$item\t")
        }
        println()
        for (index in items.indices) { //区间迭代，list.indices：数组下标区间，items.size：数组长度
            println("item at $index is ${items[index]}, items.indices = ${items.indices}, items.size = ${items.size}")
        }

        print("数列迭代：")
        for (x in 1..9 step 3) { //数列迭代：从第一个开始，每三个输出一次（初始值为1差值为3的递增等差数列，下标从零开始）
            print("$x\t")
        }
        println()
        print("数列迭代：")
        for (x in 9 downTo 0 step 4) { //数列迭代：从第一个开始，每四个输出一次（初始值为9差值为4的递减等差数列，下标从零开始）
            print("$x\t")
        }
        println()

        when {
            "orange" in items -> println("juicy")
            "apple" in items -> println("apple is fine too")
        }

        items.filter { it.startsWith("b") } //filter过滤list
            .map { it.toUpperCase() }
            .forEach { (println(it)) }

        list.filter { x -> x > 0 } //filter过滤list
        //list.filter { it > 0 } //或这样简写
    }

    //while循环
    fun printWhile() {
        var index = 0
        while (index < items.size) {
            println("while, item at $index is ${items[index++]}")
        }
    }

    //创建DTOs（POJOs/POCOs）：加data
    data class Customer(val name: String, val email: String)

    //函数的默认参数
    private fun foo(a: Int = 0, b: String = "5") = a + b.toInt()

    //访问或遍历map/pair，key、value可以改成任意名字
    fun traversalMap() {
        for ((key, value) in map) { //遍历map
            print("($key, $value)\t")
        }
        println()
        println(map["a"]) //访问map，输出单个value
        println(map["b"].toString() + "\t" + map["g"]) //访问map，输出单个value
        println("$map") //访问map，输出map结构{key1=value1, key2=value2, ...}
    }

    //If not null 缩写
    fun ifNullAbbreviation() {
        val x = parseInt("13")
        println(x?.times(2)) //如果x为空，那么输出null；否则乘以2后输出
        println(parseInt("3g")?.times(3)) //输出null
        //如果x为空，那么输出null；否则判断乘以2后是否为空，空则输出null，非空则输出比较结果（等于为0，大于为1，小于为-1）
        println(x?.times(2)?.compareTo(27))
    }

    //返回when表达式，全写
    /*private fun transformWhen(a: Int): String? {
        return when (a) {
            1 -> "one"
            2 -> "Twoqwe"
            3 -> "3"
            -1 -> "smaller than 0"
            else -> null
        }
    }*/

    //返回when表达式，简写
    private fun transform(a: Int): String? = when (a) {
        1 -> "one"
        2 -> "Twoqwe"
        3 -> "3"
        -1 -> "smaller than 0"
        else -> null
    }

    fun subSequence() {
        //subSequence(startIndex: Int, endIndex: Int)：[startIndex, endIndex)，从第startIndex个开始(包括)，
        // 到第endIndex个结束（不包括），可能会报数组越界异常
        println(transform(1)?.subSequence(1, 3)?.toString()) //one->ne
        println(transform(2)?.subSequence(1, 4)?.toString()) //Twoqwe->woq
        println(transform(3)?.subSequence(0, 1)?.toString()) //3->3
        println(transform(-1)?.subSequence(1, 4)?.toString())
        println(transform(0)?.subSequence(1, 4)?.toString())
    }

    fun exchangeTwoValue() {
        var a = 11
        var b = 22
        println("before exchange: a = $a, b = $b")
        a = b.also { b = a }
        println("after exchange: a = $a, b = $b")
    }
}
