package task.scheduler

import java.util.UUID

/**
 * A computational job that,
 * in order to be executed, needs some input
 * and returns some output.
 * @tparam Input Task given input.
 * @tparam Output Task expected output.
 */
trait Task[-Input, +Output] {

  val id: UUID = UUID.randomUUID()

  def perform(input: Input)(implicit ctx: TaskContext): Output

}
