import java.io.{BufferedReader, FileNotFoundException, FileReader}

import scala.collection.mutable.Set

/**
  * Created by alessio on 03/07/16.
  */
object Recovery {



  def recoveryFromCSV(csvFilePath: String): Option[Set[Seq[String]]] = {
    var storedRows = Set.empty[Seq[String]]
    try {
      val br = new BufferedReader(new FileReader(csvFilePath))
      var line = br.readLine()
      while (line != null) {
        val seq: Seq[String] = line.split(",").toSeq
        storedRows += seq
        line = br.readLine()
      }
      Some(storedRows)
    } catch {
      case e : FileNotFoundException => None
    }
  }
}
