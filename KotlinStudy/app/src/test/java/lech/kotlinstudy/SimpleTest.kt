package lech.kotlinstudy

import junit.framework.Assert.assertEquals
import org.junit.Test

/**
 * Created by Android_61 on 2017/6/20.
 * Description
 * Others
 */
class SimpleTest {
    @Test fun unitTestingWorks(){
        assert(true)
    }


    @Test fun testLongToDateString() {
        assertEquals("Oct 19, 2015", 1445275635000L.toDouble())
    }
}