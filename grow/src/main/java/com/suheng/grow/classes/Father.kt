package com.suheng.grow.classes

//属性覆盖：可以在主构造函数中直接使用override关键字覆盖父类的属性。
open class Father(override val w: Int = 52) : Grandfather() { //覆盖属性w并直接赋值
    override fun nv() = println("Father, nv()") //覆写父类的方法时必须需要关键字override，否则编译器会报错。

    /*override fun v() { //该方法在父类中没有使用open关键字声明，故它不能被覆写而且也不允许定义相同签名的函数
        super.v()
    }*/

    fun v(b: Int) {
        super.v()
    }

    //标记为override的成员本身是开放的，也就是说它可以在子类中覆盖。如果想禁止再次覆盖，可以使用final关键字
    final override fun finalCc() = println("Father, finalCc()")

    //属性覆盖与方法覆盖类似
    override var x: Int = 22 //可以用var属性覆盖val属性(其父类中'x'被val，但是在此被修改为var)
    //override val y: Int = 32
    final override val z: Int = 42
}