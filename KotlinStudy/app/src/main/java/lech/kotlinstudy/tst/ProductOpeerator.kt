package lech.kotlinstudy.tst

import junit.framework.Assert.assertEquals

/**
 * Created by Android_61 on 2017/6/14.
 * Description
 * Others
 */
class ProductOpeerator {


    fun test() {
        val list = listOf(1, 2, 3, 4, 5, 6)
        val listRepeated = listOf(2, 2, 3, 4, 5, 5, 6)


//        assertEquals(listOf(3,4,6,8,10,11), list.merge(listRepeated){ it1, it2 ->it1+it2})
        //把一个给定的集合分割成两个，第一个集合由原集合每一 线匹配给定函数条件返回true，第二天个集合返回false的元素组成
        assertEquals(
                Pair(listOf(2, 4, 6), listOf(1, 3, 5)), list.partition { it % 2 == 0 }
        )

        //两个集合的交集
        assertEquals(
                listOf(1, 2, 3, 4, 5, 6, 7, 8), list + listOf(7, 8)
        )
        //返回由pair组成的List，每个pair由两个集合相同的index的元素组成，这个返回的list大小由最想的那个集合决定
        assertEquals(listOf(Pair(1, 7), Pair(2, 8)),
                list.zip(listOf(7, 8))
        )
        //从包含pair的list中生成包含list的pair
        assertEquals(Pair(listOf(5,6), listOf(7,8)),
                listOf(Pair(5,7),Pair(6,8)).unzip()

        )


    }

}