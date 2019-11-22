package blakenerdway.applehealthconverter.scala

import org.junit.Test
import org.junit.Assert._

class RecordTest {
    @Test
    def fromXMLTest(): Unit = {
        val healthData = CVSTestSuite.healthData
        val record = healthData.records.head

        assertEquals("HKQuantityTypeIdentifierBodyMass", record.recordType)
        assertEquals("Health", record.sourceName)
        assertEquals("lb", record.unit)
        assertEquals("171", record.value)
        assertEquals("2018-12-11", record.creationDate)
        assertEquals("2018-12-11", record.startDate)
        assertEquals("2018-12-11", record.endDate)
        assertEquals("20:16:19", record.creationTime)
        assertEquals("20:16:00", record.startTime)
        assertEquals("20:16:00", record.endTime)
        assertEquals(1, record.metadataEntries.size)

    }
}
