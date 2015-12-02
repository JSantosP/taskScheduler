package task.scheduler.dsl.eventlike

import task.scheduler.{Task, TaskNode}

/**
 * Just create a [[TaskNode]] without dependencies.
 * @param task Task to be executed.
 * @tparam I Task input type.
 * @tparam O Task output type.
 */
case class Launch[I,O](task: Task[I,O]) extends TaskNode {

  val dependencies = Seq()

}
