package br.unb.cic.epl

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

class TestLiteral extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {
  behavior of "A Literal"
  var literalX: Literal = _

  before {
    literalX = new Literal(-5) 
  }

  it should "return String -5 when we call Literal(-5).print()" in {
    literalX.print() should be ("-5")
  }

  it should "return -5 when we call Literal(-5).eval()" in {
    val eval = new Eval()
    literalX.accept(eval)
    eval.result() should be (-5)
  }

  it should "return 1 we call Literal(-5).height()" in {
    val height = new Height()
    literalX.accept(height)
    height.height() should be (1)
  }

}
