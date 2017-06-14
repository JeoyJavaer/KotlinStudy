package lech.kotlinstudy.tst

import junit.framework.Assert.*

/**
 * Created by Android_61 on 2017/6/14.
 * Description
 * Others
 */
class FiledOperator {


    fun test() {
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        //包含
        assertTrue(list.contains(2))

        //返回给定位置的元素，越界抛异常
        assertEquals(2, list.elementAt(1))

        //返回给定位置的元素，如果越界则返回默认
        assertEquals(2, list.elementAtOrElse(10, { 2 * it }))

        //返回给定位置的元素，如果越界则返回null
        assertNull(list.elementAtOrNull(10))

        //返回第一个给定条件的元素，如果没有则返回null
        assertNull(list.firstOrNull() { it % 7 == 0 })

        //返回指定元素的第一个index。没有则返回-1
        assertEquals(3, list.indexOf(4))

        //返回第一个符合给定函数条件的的元素index，如果没有则返回-1
        assertEquals(1, list.indexOfFirst { it % 2 == 0 })

        //返回最后一个符合给定函数条件的元素的index，如果没有则返回-1
        assertEquals(5, list.indexOfLast { it % 2 == 0 })

        //返回最后个符合给定条件的元素
        assertEquals(6, list.last { it % 2 == 0 })

        //返回指定元素的最后一个index  如果不存在，返回-1
        assertEquals(5, list.lastIndexOf(6))

        //返回符合给定函数条件的最后一个元素，如果没有则返回null
        assertNull(list.lastOrNull { it % 7 == 0 })

        //返回符合给定函数的单个元素，如果没有或者超过一个则跑出异常
        assertEquals(5,list.single { it %5==0 })

        //返回符合给定函数的单个元素，如果没有符合或者超过一个则返回null
        assertEquals(5,list.singleOrNull { it%5==0 })


    }
}