package blakenerdway.applehealthconverter.scala

import java.io.File

import javax.xml.parsers.SAXParserFactory
import java.nio.file.{Files, Paths}
import java.io.FileInputStream
import java.io.InputStreamReader

import org.xml.sax.InputSource

object Launcher {
    def main(args: Array[String]): Unit ={
        val startTime = System.currentTimeMillis()

        val factory = SAXParserFactory.newInstance
        val saxParser = factory.newSAXParser
        val healthData = new HealthData

        val recordHandler = new RecordHandler(healthData)
        val origXML = new File(args.head)

        val exportCSVStr = getCSVFolder(args.head)

        val parseStart = System.currentTimeMillis()

        val inputStream = new FileInputStream(origXML)
        val reader = new InputStreamReader(inputStream, "UTF-8")

        val is = new InputSource(reader)
        is.setEncoding("UTF-8")

        saxParser.parse(is, recordHandler)
        println(s"Parse time: ${(System.currentTimeMillis() - parseStart) / 1000.00}s")

        val resultFolderPath = Paths.get(exportCSVStr)
        if (!Files.exists(resultFolderPath)) {
            Files.createDirectory(resultFolderPath)
        }

        val temp = exportCSVStr + File.separator + "export.csv"

        val resultFilePath = Paths.get(temp)
        if (Files.exists(resultFilePath)) {
            Files.delete(resultFilePath)
        }

        val resultFile = Files.createFile(resultFilePath)

        val convertStart = System.currentTimeMillis()
        CSVMaker.writeCSV(healthData,resultFile)

        println(s"CSV make time: ${(System.currentTimeMillis() - convertStart) / 1000f}s")

        println(s"Total execution time: ${(System.currentTimeMillis() - startTime) / 1000f}s")
    }

    def getCSVFolder(origin: String): String = {
        val splitFolderLoc = origin.split("[\\\\|/]")
        val file = splitFolderLoc(splitFolderLoc.size - 1)
        if (!file.endsWith("xml")){
            System.err.println("Please use an XML file for parsing")
            System.err.println("EXITING")
            System.exit(0)
        }
        val dest = origin.substring(0, origin.indexOf(file)) + "csv"

        dest
    }
}