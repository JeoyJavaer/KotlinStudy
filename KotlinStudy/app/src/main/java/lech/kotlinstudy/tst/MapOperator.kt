package lech.kotlinstudy.tst

import junit.framework.Assert.assertEquals


/**
 * Created by Android_61 on 2017/6/14.
 * Description
 * Others
 */

class MapOperator {


    fun test() {
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        //遍历所有元素，为每个创建一个集合，最后把所有的集合放在一个集合中
        val flatMap = list.flatMap { listOf(it, it + 1) }

        //返回根据给定函数分组后的map
        assertEquals(mapOf("odd" to listOf(1, 3, 5), "event" to listOf(2, 4, 6)), list.groupBy { if (it % 2 == 0) "event" else "odd" })

        //返回一个每个元素根据给定的函数转换所组成的集合
        assertEquals(listOf(1, 2, 3, 4), list.map { it * 2 })

        //返回一个每一个元素根据给定的包含元素index的函数转换所组成的list
        assertEquals(listOf(0,2,6,12,20,30),list.mapIndexed { index, it -> index*it })

        //返回一个每一个非空元素根据给定的函数转换所组成的list
        assertEquals(listOf(2,4,6,8),list.mapNotNull { it * 2 })



    }

}
