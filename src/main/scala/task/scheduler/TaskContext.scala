package task.scheduler

trait TaskContext {

  def execute[T](t: => T): T

}
