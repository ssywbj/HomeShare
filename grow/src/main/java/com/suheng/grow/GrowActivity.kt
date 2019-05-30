package com.suheng.grow

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class GrowActivity : AppCompatActivity() {

    private val pi = 3.14
    private var y: Int = 11

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grow)
        println("sum two = " + sum(3, 6))
        println("sum three = ${sum(3, 6, 9)}")
        printUnit(4, 2)
        printUnit(4, 2, 90)

        //val：定义只读变量且只能赋值一次
        val a: Int = 1 //定义Int变量并赋值
        //a = 35; error: Val cannot be reassigned
        val b = 2 //定义变量并赋值，省略Int，根据数值“2”自动推断出类型
        val c: Int //如果只定义变量但未赋值，不能省略类型
        c = 3 //明确赋值

        //var：定义可变变量
        var x = 45
        x = 3
        println("val - a = $a, b = $b, c = $c, π = $pi, var - x = $x, ++y = ${++y}")

        //字符串
        val s1 = "x is $x"
        x = 56
        val s2 = "${s1.replace("is", "was")}, but now is $x"
        println("$s1; $s2")

        println("max 0f is ${maxOf(3, 8.6f)}")
        println("max 0f is " + maxOf(5, 9.63))
        println("max 0f is ${maxOf(13, 9)}")

        printProduct("34", "2")
        printProduct("3E4", "8")
        printProduct("34", "Rr")
    }

    private fun sum(a: Int, b: Int): Int { //定义函数：返回值类型为Int
        return a + b//可以不用写分号
    }

    private fun sum(a: Int, b: Int, c: Int) = a + b + c //定义函数：表达式作为函数体，自动推断返回值类型（简写）

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
            return obj.length //'obj'在该条件分支内自动转换成'String'
        }

        return null //在离开类型检测分支后，'obj'仍然是'Any'类型
    }
}
