package task.scheduler.dsl

import task.scheduler._

/**
 * Aggregate some task nodes completion.
 * @param task Task to be executed when dependencies are satisfied.
 * @param dependencies Dependencies to be satisfied.
 * @tparam I Input task type.
 * @tparam O Output task type.
 */
case class When[I, O](
                       task: Task[I, O],
                       dependencies: Seq[Dependency]) extends TaskNode

object When {

  type WhenDefinition[I, O] = Task[I, O] => When[I, O]

  def apply[I, O](
                   taskNode1: TaskNode,
                   tasks: TaskNode*): Dependency.Type => WhenDefinition[I, O] = { completionType =>
    (task: Task[I, O]) => {
      new When(task, (taskNode1 +: tasks).map(tn => Dependency(tn, completionType)))
    }
  }
}
