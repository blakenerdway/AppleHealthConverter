package blakenerdway.applehealthconverter.scala

import org.xml.sax.helpers.DefaultHandler

import scala.collection.mutable.ArrayBuffer

class Record(val id: Int) {
    private[this] var _recordType: String = ""

    def recordType: String = _recordType

    def recordType_=(value: String): Unit = {
        _recordType = value
    }

    private[this] var _unit: String = ""

    def unit: String = _unit

    def unit_=(value: String): Unit = {
        _unit = value
    }

    private[this] var _value: String = ""

    def value: String = _value

    def value_=(value: String): Unit = {
        _value = value
    }

    private[this] var _sourceName: String = ""

    def sourceName: String = _sourceName

    def sourceName_=(value: String): Unit = {
        _sourceName = value
    }

    private[this] var _creationDate: String = ""

    def creationDate: String = _creationDate

    def creationDate_=(value: String): Unit = {
        _creationDate = DateUtils.dateToSimpleDate(value)
    }

    private[this] var _startDate: String = ""

    def startDate: String = _startDate

    def startDate_=(value: String): Unit = {
        _startDate = DateUtils.dateToSimpleDate(value)
    }

    private[this] var _endDate: String = ""

    def endDate: String = _endDate

    def endDate_=(value: String): Unit = {
        _endDate = DateUtils.dateToSimpleDate(value)
    }

    private[this] var _endTime: String = ""

    def endTime: String = _endTime

    def endTime_=(value: String): Unit = {
        _endTime = DateUtils.dateToTime(value)
    }

    private[this] var _creationTime: String = ""

    def creationTime: String = _creationTime

    def creationTime_=(value: String): Unit = {
        _creationTime = DateUtils.dateToTime(value)
    }

    private[this] var _startTime: String = ""

    def startTime: String = _startTime

    def startTime_=(value: String): Unit = {
        _startTime = DateUtils.dateToTime(value)
    }

    // Pointer to the metadata ID entry
    // TODO parse these values
    private[this] val _metadataEntries: ArrayBuffer[MetadataEntry] = ArrayBuffer.empty[MetadataEntry]
    def metadataEntries: ArrayBuffer[MetadataEntry] = _metadataEntries

    def addEntry(entry: MetadataEntry): Unit ={
        _metadataEntries.append(entry)
    }

    override def toString = s"Record($recordType, $unit, $value, $sourceName, $creationDate, $startDate, $endDate)"
}
