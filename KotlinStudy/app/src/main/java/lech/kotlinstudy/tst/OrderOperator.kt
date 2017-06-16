package lech.kotlinstudy.tst

import junit.framework.Assert.assertEquals

/**
 * Created by Android_61 on 2017/6/16.
 * Description
 * Others
 */
class OrderOperator {

    fun test() {
        val unsortedList = listOf(3, 2, 7, 5)


        //返回指定集合反序的list
        assertEquals(listOf(5, 7, 2, 3), unsortedList.reversed())

        //返回自然排序的list
        assertEquals(listOf(2, 3, 5, 7), unsortedList.sorted())

        //返回根据指定函数排序后的list
        assertEquals(listOf(3, 7, 2, 5), unsortedList.sortedBy { it % 3 })

        //返回一个降序排序后的list
        assertEquals(listOf(7, 5, 3, 2), unsortedList.sortedDescending())

        //返回根据指定排序函数排序降序后的list
        assertEquals(listOf(2, 5, 7, 3), unsortedList.sortedByDescending { it % 3 })



    }


}