package blakenerdway.applehealthconverter.scala

import java.io.{File, FileInputStream, IOException, InputStreamReader}
import java.security.MessageDigest

import javax.xml.parsers.SAXParserFactory

import org.junit.BeforeClass
import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.junit.runners.Suite.SuiteClasses
import org.xml.sax.InputSource

import scala.util.Try

object CVSTestSuite {
    private[this] var _healthData: HealthData = _
    def healthData: HealthData = {
        if (_healthData == null){
            _healthData = new HealthData

            val factory = SAXParserFactory.newInstance
            val saxParser = factory.newSAXParser

            val recordHandler = new RecordHandler(healthData)
            val inputStream = new FileInputStream(new File(getClass.getClassLoader.getResource("test.xml").getFile))
            val reader = new InputStreamReader(inputStream, "UTF-8")

            val is = new InputSource(reader)
            is.setEncoding("UTF-8")

            saxParser.parse(is, recordHandler)
        }

        _healthData
    }

    @BeforeClass
    def setup(): Unit = {
        xmlChecksum()
    }
    
    private def xmlChecksum(): Unit ={
        // Check the the original XML file is the original valid one
        val mdXML = MessageDigest.getInstance("MD5")
        val origXML = new File(getClass.getClassLoader.getResource("test.xml").getFile)
        val xmlMD5 = getFileChecksum(mdXML, origXML)

        val actualXMLMD5 = "D4F522DD21E6968038089CFACACE0221"
        println(s"MD5 checksum: $xmlMD5, compare to: $actualXMLMD5")
        if (!xmlMD5.equalsIgnoreCase(actualXMLMD5)){
            throw new AssertionError("Incorrect checksum on XML file. Data may not be valid and subsequent tests may fail")
        }
    }


    @throws[IOException]
    private def getFileChecksum(digest: MessageDigest, file: File): String = { //Get file input stream for reading the file content
        val fis = new FileInputStream(file)
        //Create byte array to read data in chunks
        val byteArray = new Array[Byte](1024)
        var bytesCount: Int = fis.read(byteArray)

        //Read file data and update in message digest
        while (bytesCount != -1) {
            digest.update(byteArray, 0, bytesCount)
            bytesCount = fis.read(byteArray)
        }

        //close the stream; We don't need it now.
        fis.close()
        //Get the hash's bytes
        val bytes = digest.digest
        //This bytes[] has bytes in decimal format;
        //Convert it to hexadecimal format
        val sb = new StringBuilder
        var i = 0
        while (i < bytes.length) {
            sb.append(Integer.toString((bytes(i) & 0xff) + 0x100, 16).substring(1))
            i += 1
        }
        //return complete hash
        sb.toString
    }
}

@RunWith(classOf[Suite])
@SuiteClasses(Array(classOf[CSVMakerTest], classOf[HealthDataTest], classOf[RecordTest], classOf[MetadataEntryTest], classOf[DateUtilsTest]))
class CVSTestSuite {

}
