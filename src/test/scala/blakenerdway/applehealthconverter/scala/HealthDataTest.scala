package blakenerdway.applehealthconverter.scala

import org.junit.Test
import org.junit.Assert._

class HealthDataTest {
    @Test
    def fromXMLTest(): Unit = {
        val healthData = CVSTestSuite.healthData
        assertEquals(healthData.records.size, 13)
    }
}
