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


        assertEquals(listOf(3,4,6,8,10,11), list.merge(listRepeated){ it1, it2 ->it1+it2})
    }

}