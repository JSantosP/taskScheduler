package task.scheduler

/**
 * Represents a node in the dependency graph.
 */
trait TaskNode {

  /**
   * Task to be executed
   */
  val task: Task[_, _]

  /**
   * Dependencies to be satisfied in order
   * to execute this node's task.
   */
  val dependencies: Seq[Dependency]
}
