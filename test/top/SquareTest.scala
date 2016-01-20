package top

import org.specs2.mutable.Specification

import scala.concurrent.Await
import scala.concurrent.duration._

class SquareTest extends Specification {

  val timeout = 30.seconds

  "blocking" in {
    val result = Square.blocking(10)

    println("===============call returned================")

    result mustEqual 100
  }

  "async" in {

    val resultF = Square.async(10)

    println("===============call returned================")

    Await.result(resultF, 10.seconds) mustEqual 100
  }

  "nonBlocking" in {

    val resultF = Square.nonBlocking(10)

    println("===============call returned================")

    Await.result(resultF, 10.seconds) mustEqual 100
  }
}
