package blakenerdway.applehealthconverter.scala

import org.junit.Assert.assertEquals
import org.junit.Test

class DateUtilsTest {
    @Test
    def convertDateTest(): Unit = {
        assertEquals("2018-12-11", DateUtils.dateToSimpleDate("2018-12-11 20:16:19 -0500"))
        assertEquals("20:16:19", DateUtils.dateToTime("2018-12-11 20:16:19 -0500"))
    }
}
