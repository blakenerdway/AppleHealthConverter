package blakenerdway.applehealthconverter.scala

class MetadataEntry(val recordID: Int){
    private[this] var _key: String = ""
    def key: String = _key
    def key_=(newKey: String): Unit = {
        _key = newKey
    }

    private[this] var _value: String = ""
    def value: String = _value
    def value_=(newValue: String): Unit = {
        _value = newValue
    }
}
