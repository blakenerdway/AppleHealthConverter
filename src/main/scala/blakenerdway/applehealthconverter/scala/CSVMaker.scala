package blakenerdway.applehealthconverter.scala

import java.nio.file.{Files, Path}
import java.util.concurrent.ConcurrentLinkedQueue


import java.io.FileWriter
import java.io.IOException
import scala.collection.JavaConversions._

object CSVMaker {
    def writeCSV(healthData: HealthData, file: Path): Unit ={
        val start = System.currentTimeMillis()
        val records: ConcurrentLinkedQueue[String] = new ConcurrentLinkedQueue[String]()

        records.add(columns)
        healthData.records.par.foreach(record => {
            records.add(recordCSV(record))
        })
        println(s"Time to create strings: ${(System.currentTimeMillis() - start) / 1000f}s")

        writeRaw(records, file)
        println(s"Time to complete: ${(System.currentTimeMillis() - start) / 1000f}s")
    }

    def columns: String = {
        "Type,SourceName,CreationDate,CreationTime,StartDate,StartTime,EndDate,EndTime,Unit,Value"
    }

    def recordCSV(record: Record): String ={
        s"\n${record.recordType},${record.sourceName},${record.creationDate},${record.creationTime},${record.startDate},${record.startTime}," +
            s"${record.endDate},${record.endTime},${record.unit},${record.value}"
    }

    @throws[IOException]
    private def writeRaw(records: ConcurrentLinkedQueue[String], file: Path): Unit = {
        var writer: FileWriter = null
        try {
            writer = new FileWriter(file.toFile)
            for (record <- records) {
                writer.write(record)
            }
        } finally {
            writer.flush()
        }
        writer.close()
    }
}
