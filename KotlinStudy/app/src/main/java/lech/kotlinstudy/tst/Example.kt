package lech.weatherapp.tst

import junit.framework.Assert.*
import kotlin.properties.Delegates


/**
 * Created by Android_61 on 2017/6/8.
 * Description
 * Others
 */
class Example {
    var p: String by Delegates.notNull<String>()

    fun contaions(): Boolean {
        val list = listOf(1, 2, 3, 4, 5)
        var result: Boolean

        //至少一个元素符合判定条件
        assertTrue(list.any { it % 2 == 0 })
        assertFalse(list.any { it > 10 })
        //所有元素符合判定条件
        assertTrue(list.all { it < 10 })
        assertFalse(list.all { it % 2 == 0 })
        //统计符合判定条件的个数
        assertEquals(3, list.count { it % 2 == 0 })
        //从第一元素开始有指定值每一项通过函数操作的结果
        assertEquals(25, list.fold(4) { total, next -> total + next })

        //从最后一个元素开始的有指定值的每一项操作的结果
        assertEquals(25, list.foldRight(4) { total, next -> total + next })

        //增强for循环
        list.forEach { print(it.toString()) }
        //含有index的增强for循环
        list.forEachIndexed { index, value -> print("position $index contaions a $value") }
        // 最大值
        assertEquals(6, list.max())

        //通过某种操作的最大值
        assertEquals(1, list.maxBy { -it })
        //最小指
        assertEquals(-1, list.min())
        //通过某种操作的最小值
        assertEquals(6, list.minBy { it * 4 + 5 })
        //没有符合条件的返回true
        assertTrue(list.none { it % 7 == 0 })
        //不能指定初始值的，每项操作
        assertEquals(25, list.reduce { acc, i -> acc + i })
        //不能指定初始值的，最后开始的操作结果
        assertEquals(15, list.reduceRight { total, next -> total + next })

        //每一项通过操作后的总和
        assertEquals(3, list.sumBy { it / 5 })
        //去掉前n个元素的集合
        assertEquals(listOf(4, 5), list.drop(4))
        //从第一项开始去掉满足某个条件的集合
        assertEquals(listOf(4, 5, 6), list.dropWhile { it < 3 })
        //从最后一项开始去掉满足条件的集合
        assertEquals(listOf(3, 4, 5), list.dropLastWhile { it > 10 })
        //过滤所有符合条件的集合
        assertEquals(listOf(4, 6), list.filter { it % 2 == 0 })
        //过滤所有不符合条件的集合
        assertEquals(listOf(1, 3, 5), list.filterNot { it % 2 == 1 })
        //过滤非空元素的集合
        assertEquals(listOf(1, 2, 3, 4), list.filterNotNull())
        //过滤指定位置的元素
        assertEquals(listOf(1, 2, 3), list.slice(listOf(2, 3)))

        //返回从第一个开始的n个元素
        assertEquals(listOf(1, 2, 3, 4), list.take(4))
        //返回从最后一个开始的n个元素
        assertEquals(listOf(2, 3, 4, 5), list.takeLast(4))
        //返回从第一个开始符合给定函数条件的元素
        assertEquals(listOf(1, 2), list.takeWhile { it < 3 })
        //返回从最后一个开始符合给定函数条件的元素
        assertEquals(listOf(4, 5), list.takeLastWhile { it > 3 })

        return true
    }


}
