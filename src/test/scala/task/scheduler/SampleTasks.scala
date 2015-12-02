package task.scheduler

trait SampleTasks {

  case object DoNothing extends Task[Unit, Unit] {

    override def perform(input: Unit): Unit = ()
  }

}
