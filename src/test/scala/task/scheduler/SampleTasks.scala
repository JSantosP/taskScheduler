package task.scheduler

import scala.util.Random

trait SampleTasks {

  case object DoNothing extends Task[Unit, Unit] {

    override def perform(input: Unit)(implicit ctx: TaskContext): Unit =
      ctx.execute {
        ()
      }
  }

  case object PrintSomething extends Task[Unit, Unit] {

    override def perform(input: Unit)(implicit ctx: TaskContext): Unit =
      ctx.execute {
        println("hi")
      }
  }

  case object GenerateMagicNumber extends Task[Unit, Int] {

    override def perform(input: Unit)(implicit ctx: TaskContext): Int =
      ctx.execute {
        Random.nextInt(100)
      }
  }

  case object PrintSquare extends Task[Int, Unit] {

    override def perform(input: Int)(implicit ctx: TaskContext): Unit =
      ctx.execute {
        println(input * input)
      }
  }

}
