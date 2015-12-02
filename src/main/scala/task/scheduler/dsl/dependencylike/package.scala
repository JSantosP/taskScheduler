package task.scheduler.dsl

import scala.language.implicitConversions

import task.scheduler.Dependency._
import task.scheduler._

package object dependencylike {

  implicit class DependencyHelper[I, O](task: Task[I, O]) {
    helper =>

    def dependsOn(tn1: TaskNode, tnRest: TaskNode*): TaskNode =
      new TaskNode {
        val task = helper.task
        val dependencies = (tn1 +: tnRest).map(tn => Dependency(tn, Completed))
      }

    def dependsOn(dep1: Dependency, depRest: Dependency*): TaskNode =
      new TaskNode {
        val task = helper.task
        val dependencies = dep1 +: depRest
      }

    def isRootTask: TaskNode =
      new TaskNode {
        val task = helper.task
        val dependencies = Seq()
      }
  }

  implicit def nodeToDependency(node: TaskNode): Dependency =
    Dependency(node, Completed)

  object Success {

    def apply(node: TaskNode) = Dependency(node, Succeeded)
  }

  object Failure {

    def apply(node: TaskNode) = Dependency(node, Failed)
  }

}
