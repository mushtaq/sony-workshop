package top

import akka.stream.scaladsl.Sink
import org.specs2.mutable.Specification
import utils.Config.executionContext
import utils.Config.mat

import scala.concurrent.Await
import scala.concurrent.duration._

class SquaresTest extends Specification {

  val timeout = 30.seconds

  "blocking" in {
    val result = Squares.blocking(1 to 10)
    println("===============call returned================")
    println(result)

    1 mustEqual 1
  }


  "async" in {
    val resultF = Squares.async(1 to 20)
    println("===============call returned================")
    resultF.onComplete(println)

    Await.ready(resultF, timeout)
    1 mustEqual 1
  }


  "nonBlocking" in {
    val resultF = Squares.nonBlocking(1 to 20)
    println("===============call returned================")
    resultF.onComplete(println)

    Await.ready(resultF, timeout)
    1 mustEqual 1
  }

  "streaming" in {
    val resultF = Squares.streaming(1 to 20).runWith(Sink.ignore)
    println("===============call returned================")

    resultF.onComplete(println)

    Await.ready(resultF, timeout)
    1 mustEqual 1
  }
}
