/**
  * Created by alessio on 04/07/16.
  */
object CSVtoDB extends App {

  def insertIntoDB(filePath: String) = {
    val bufferedSource = io.Source.fromFile("src/main/resources/airports.csv")
    for (line <- bufferedSource.getLines) {

      val cols = line.split(",").map(_.trim)
      // do whatever you want with the columns here
      println(s"${cols(0)}|${cols(1)}|${cols(2)}|${cols(3)}")
    }
    bufferedSource.close
  }
}
