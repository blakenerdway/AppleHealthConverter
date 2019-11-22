package blakenerdway.applehealthconverter.scala

object XMLUtils {
    def cleanString(xmlString: String) : String = {
        xmlString.replaceAll("\\sdevice=\"(.*?)\"", "")
            .replaceAll("\n", "").replaceAll("’", "'")
    }
}
