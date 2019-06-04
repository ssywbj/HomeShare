package com.suheng.grow.classes

class Children : Father() {
    override fun nv() = println("Children, nv()") //覆写父类的方法时必须需要关键字override，否则编译器会报错。

    /*override fun v() { //该方法在父类中没有使用open关键字声明，故它不能被覆写，而且也不能存在与其同名且同参数类型的方法
        super.v()
    }*/

    fun v(b: Int) {
        super.v()
    }
}