package blakenerdway.applehealthconverter.scala

import java.io.File
import java.nio.file.Files

import org.junit.Test
import org.junit.Assert._

import scala.util.Try
import scala.collection.JavaConversions._

class CSVMakerTest {
    @Test
    def toCSVTest(): Unit = {
//        val healthData = CVSTestSuite.healthData
//        val csvString = new StringBuffer(CSVMaker.columns)
//
//
//
//        healthData.records.par.foreach(record => {
//            csvString.append()
//        })
//
//        var correctCSV = ""
//        val file: File = new File(getClass.getClassLoader.getResource("converted.csv").getFile)
//
//        val lines = Try{Files.readAllLines(file.toPath)}
//        if (lines.get.size != 0) {
//            lines.get.foreach(line => correctCSV += line)
//        }
//
//        assertEquals(correctCSV, csvString.toString.replaceAll("\\n?\\r?", ""))
    }
}
