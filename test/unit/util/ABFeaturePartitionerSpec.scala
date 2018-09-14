package unit.util

import org.scalatest.{Matchers, WordSpec}

trait Feature {
  val name: String
}
trait FeaturePartitioner[F <: Feature] {
  def partition(valueToHash: Any): F
}

// Encapsulates a specific A/B testing use case. e.g. Version1 / Version2
sealed trait ABFeature extends Feature
case object AFeature extends ABFeature {
  override val name: String = "AFeature"
}
case object BFeature extends ABFeature {
  override val name: String = "BFeature"
}

// A partitioner unique to the ABFeature above.
class ABFeaturePartitioner(threshold: Int, aFeature: ABFeature, bFeature: ABFeature) extends FeaturePartitioner[ABFeature] {
  override def partition(valueToHash: Any): ABFeature = {
    if (valueToHash.hashCode % 100 < threshold) aFeature else bFeature
  }
}

class ABFeaturePartitionerSpec extends WordSpec with Matchers {
  "FeaturePartitioner" should {
    val testInstance: FeaturePartitioner[ABFeature] = new ABFeaturePartitioner(threshold = 50, AFeature, BFeature)

    "choose feature A" in {
      testInstance.partition(149) shouldBe AFeature
    }

    "choose feature B" in {
      testInstance.partition(151) shouldBe BFeature
    }
  }
}
