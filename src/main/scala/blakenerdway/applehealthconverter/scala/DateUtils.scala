package blakenerdway.applehealthconverter.scala

import java.text.SimpleDateFormat

object DateUtils {
    def dateToSimpleDate(origDate: String): String = {
        val oldDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z").parse(origDate)
        val newDate = new SimpleDateFormat("yyyy-MM-dd").format(oldDate)

        newDate.toString
    }

    def dateToTime(origDate: String): String = {
        val oldDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(origDate)
        val newDate = new SimpleDateFormat("HH:mm:ss").format(oldDate)

        newDate.toString
    }
}
