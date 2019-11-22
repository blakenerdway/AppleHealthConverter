# AppleHealthConverter
This project takes your apple health information and converts it to a CSV file. After importing, certain data can be converted based on the recognized fields. Each XML record is exported to a single CSV record.
## How it works
An AppleHealth export file (*export.xml*) is passed to the program's main function. The file is read via a SAX parser and converted into in-memory objects and then the collection of objects is converted into Strings and written to a CSV file. The CSV file's location is placed in `%HOME_DIR%/csv/export.csv` where `%HOME_DIR%` is the location of `export.xml` like such: `%HOME_DIR%/export.xml`
### Future work
In the future, one thing that could be done is instead of keeping each record in memory and then parsing them all at once, is to convert them to strings at the time of reading the XML. In this way, large XML files will not consume all of the memory.
## Why did I do this?
Well, I wanted to learn Scala, and I wanted to convert my Apple health information to a CSV file that can be connected to the MyFitnessPal CSV food data, so I decided to write my own application for that. It gives me experience in Scala, and it lets me have control over the data. 


> Written with [StackEdit](https://stackedit.io/).