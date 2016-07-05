import java.sql._
import java.util.Random

/**
  * Created by alessio on 04/07/16.
  */
object DBWizard extends App{
  //  val JDBC_DRIVER: String = "com.mysql.jdbc.Driver"
  //    static final String JDBC_DRIVER = "org.postgresql.Driver"
  val JDBC_DRIVER = "org.h2.Driver"
  val DB_URL: String = "jdbc:mysql://localhost/assessment"
  val USER: String = "root"
  val PASS: String = "root"

  def extractFromCSV(filePath: String) : String = {
    val bufferedSource = io.Source.fromFile("src/main/resources/countries.csv")
    for (line <- bufferedSource.getLines) {

      val cols = line.split(",").map(_.trim)
      // do whatever you want with the columns here
//      var add : String = null
//      for (i <- 0 to cols.size) {
//      add += cols(i)
//      }
      println(s"${cols(0)}|${cols(1)}|${cols(2)}|${cols(3)}")
      val add = s"insert into airports values (${cols(0)},${cols(1)},${cols(2)},${cols(3)},${cols(4)},${cols(5)})"
    }
    bufferedSource.close
  }

//  def main(args: Array[String]) {
    val rnd: Random = new Random
    try {
      Class.forName(JDBC_DRIVER)
      val conn: Connection = DriverManager.getConnection(DB_URL, USER, PASS)
      System.out.println("Connected to database.")
      val stmt: Statement = conn.createStatement
      val aggiunta: String =
        """insert into Flussi values (" +
          |id_flusso + "," + id_flusso + "," + "'" + System.currentTimeMillis + "'," + "'" + System.currentTimeMillis + "'," + "'c://amon/fake/exercise');"""".stripMargin
      stmt.executeUpdate(aggiunta)




      val controlla: String = "select * from Flussi;"
      var cont: Int = 0
//      while (cont < 20) {
//        if (cont % 5 == 0 && cont > 1) {
//          val eliminare: Int = rnd.nextInt(cont - 1)
//          System.out.println("record con id " + eliminare + " " + "da eliminare!")
//          stmt.executeUpdate("delete from Flussi " + "where id_flusso=" + eliminare + ";")
//          cont += 1
//        }
//        else {
//          id_flusso += 1


          val rs: ResultSet = stmt.executeQuery(controlla)
          while (rs.next) {
            val flusso: String = rs.getString("id_flusso")
            System.out.print(flusso + " ")
          }
          System.out.println
          Thread.sleep(2000)
          cont += 1
        }
//      }
      stmt.close
      conn.close
    }
    catch {
      case se: SQLException => {
        se.printStackTrace
      }
      case e: Exception => {
        e.printStackTrace
      }
        println("CIAO")
    }
//  }
}
