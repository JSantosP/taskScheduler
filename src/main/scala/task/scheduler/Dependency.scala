package task.scheduler

case class Dependency(
                       taskNode: TaskNode,
                       dependencyType: Dependency.Type) {
  override def toString(): String =
  s"$dependencyType at $taskNode"
}

object Dependency {

  //  Dependency type: When to consider that a dependency is satisfied.
  sealed trait Type

  case object Completed extends Dependency.Type

  case object Succeeded extends Dependency.Type

  case object Failed extends Dependency.Type

}