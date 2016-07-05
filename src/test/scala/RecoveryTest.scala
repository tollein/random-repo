import org.scalatest._

/**
  * Created by alessio on 03/07/16.
  */
class RecoveryTest extends FlatSpec with Matchers {

  "Recovery " should "thrown FileNotFound excep" in {
    val result = Recovery.recoveryFromCSV("src/test/resources/example.txt")
    result shouldBe None
  }
//
//  "Recovery " should "return data " in{
//    val result = Recovery.recoveryFromCSV("src/test/resources/example.csv")
//    assert(result.isInstanceOf[Some])
//  }
}
