package blakenerdway.applehealthconverter.scala

import org.xml.sax.{Attributes, SAXException}
import org.xml.sax.helpers.DefaultHandler

class RecordHandler(val healthData: HealthData) extends DefaultHandler {

    private var record : Record = _
    private var entry: MetadataEntry = _
    private var currRecordCount = 0

    @throws[SAXException]
    override def startElement(uri: String, localName: String, qName: String, attributes: Attributes): Unit = {
        if (qName == "Record"){
            record = new Record(getAndIncrement)
            record.creationTime = attributes.getValue("creationDate")
            record.creationDate = attributes.getValue("creationDate")
            record.startDate = attributes.getValue("startDate")
            record.startTime = attributes.getValue("startDate")
            record.endDate = attributes.getValue("endDate")
            record.endTime = attributes.getValue("endDate")
            record.recordType = attributes.getValue("type")
            record.sourceName = attributes.getValue("sourceName")
            record.unit = attributes.getValue("unit")
            record.value = attributes.getValue("value")
        }
        else if (qName == "MetadataEntry") {
            entry = new MetadataEntry(currRecordCount)
            entry.key = attributes.getValue("key")
            entry.value = attributes.getValue("value")
            record.addEntry(entry)
        }
    }

    @throws[SAXException]
    override def endElement(uri: String, localName: String, qName: String): Unit = {
        if (qName == "Record"){
            healthData.addRecord(record)
        }
    }

    @throws[SAXException]
    override def characters(ch: Array[Char], start: Int, length: Int): Unit = {
    }

    def getAndIncrement = {
        val curr = currRecordCount
        currRecordCount += 1
        curr
    }
}
