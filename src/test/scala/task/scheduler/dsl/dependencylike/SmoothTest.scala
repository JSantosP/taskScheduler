package task.scheduler.dsl.dependencylike

import scala.language.postfixOps

import task.scheduler.SampleTasks

object SmoothTest extends App with SampleTasks {

  val t1 = DoNothing isRootTask

  val t2 = GenerateMagicNumber isRootTask

  val t3 = PrintSquare dependsOn (Success(t1), Failure(t2))

  println(t3)

}
