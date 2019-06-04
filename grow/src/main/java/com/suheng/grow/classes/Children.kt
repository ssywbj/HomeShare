package com.suheng.grow.classes

class Children : Father() {

    override fun nv() = println("Children, nv()")

    //父类中的finalCc()也是override，但是被使用final标记了，所以其子类无法再覆写它
    //override fun finalCc() = println("Children, finalCc()")

    //属性覆盖与方法覆盖类似。
    override var x: Int = 23
    /*可以用var属性覆盖val属性，但反之则不行(其父类中'x'被重新定义为var，在此想重新修改为val是不允许的)。
    因为一个val属性本质上声明了一个 getter 方法，而将其覆盖为var只是在子类中额外声明一个setter方法*/
    //override val x: Int = 23
    //override val z: Int = 43
}