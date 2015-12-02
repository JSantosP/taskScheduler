package task.scheduler

import task.scheduler.dsl._
import task.scheduler.Dependency._

object SmoothTest extends App with SampleTasks {

  val t1 = Launch(DoNothing)

  val t2 = Launch(DoNothing)

  val t3 = When(t1,t2)(Succeeded)(DoNothing)

  println

}
