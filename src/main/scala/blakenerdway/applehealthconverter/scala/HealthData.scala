package blakenerdway.applehealthconverter.scala

import java.io.File

import scala.collection.mutable.ArrayBuffer


class HealthData {

    private val _records : ArrayBuffer[Record] = ArrayBuffer.empty[Record]
    def records: ArrayBuffer[Record] = _records

    def printRecords(): Unit = _records.foreach({println})
    def recordCount(): Unit = println(_records.size)
    def addRecord(record: Record): Unit ={
        _records.append(record)
    }

    def getRecordsOfType(recType: String) : ArrayBuffer[Record] = {
        for (record <- _records if record.recordType == recType)
            yield record
    }
}
