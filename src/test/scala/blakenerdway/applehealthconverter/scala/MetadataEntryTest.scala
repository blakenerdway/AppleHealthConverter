package blakenerdway.applehealthconverter.scala

import org.junit.Assert._
import org.junit.Test


class MetadataEntryTest {
    @Test
    def fromXMLTest(): Unit = {
        val healthData = CVSTestSuite.healthData
        val entry = healthData.records.head.metadataEntries.head

        assertNotNull(entry)
        assertEquals("HKWasUserEntered", entry.key)
        assertEquals("1", entry.value)
        assertEquals(1, entry.recordID)
    }
}
