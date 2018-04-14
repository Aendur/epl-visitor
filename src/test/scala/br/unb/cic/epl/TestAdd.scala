package br.unb.cic.epl

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter


class TestAdd extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "An Add expression"

  var literalX: Literal = _
  var literalY: Literal = _

  before {
    literalX = new Literal(100) 
    literalY = new Literal(200) 
  }

  it should "return String (100 + 200) when we call Add(Literal(100), Literal(200)).print()" in {
    val add = new Add(literalX, literalY)
  
    add.print() should be ("(100 + 200)")
  }

  it should "return 300 when we call Add(Literal(100), Literal(200)).eval()" in {
    val eval = new Eval()
    val add = new Add(literalX, literalY)

    add.accept(eval)

    eval.result() should be (300)
  }

  it should "return 2 when we call Add(Literal(100), Literal(200)).height()" in {
    val height = new Height()
    val add = new Add(literalX, literalY)
    add.accept(height)
    height.height() should be (2)
  }
  it should "return 3 when we call Add(Add(Literal(100), Literal(200)), Literal(200)).height()" in {
    val height = new Height()
    val add = new Add(new Add(literalX, literalY), literalY)
    add.accept(height)
    height.height() should be (3)
  }
  it should "return 3 when we call Add(Literal(100), Add(Literal(100), Literal(200))).height()" in {
    val height = new Height()
    val add = new Add(literalX, new Add(literalX, literalY))
    add.accept(height)
    height.height() should be (3)
  }
}
