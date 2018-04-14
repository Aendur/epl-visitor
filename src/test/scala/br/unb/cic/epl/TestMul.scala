package br.unb.cic.epl

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

class TestMul extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "A Mul expression"

  var literalX: Literal = _
  var literalY: Literal = _

  before {
    literalX = new Literal(10) 
    literalY = new Literal(20) 
  }

  it should "return String (10 * 20) when we call Mul(Literal(10), Literal(20)).print()" in {
    val mul = new Mul(literalX, literalY)
    mul.print() should be ("(10 * 20)")
  }

  it should "return 200 when we call Mul(Literal(10), Literal(20)).eval()" in {
    val eval = new Eval()
    val mul = new Mul(literalX, literalY)
    mul.accept(eval)
    eval.result() should be (200)
  }

  it should "return 2 when we call Mul(Literal(10), Literal(20)).height()" in {
    val height = new Height()
    val mul = new Mul(literalX, literalY)
    mul.accept(height)
    height.height() should be (2)
  }
  it should "return 3 when we call Mul(Mul(Literal(10), Literal(20)), Literal(20)).height()" in {
    val height = new Height()
    val mul = new Mul(new Mul(literalX, literalY), literalY)
    mul.accept(height)
    height.height() should be (3)
  }
  it should "return 3 when we call Mul(Literal(10), Mul(Literal(10), Literal(20))).height()" in {
    val height = new Height()
    val mul = new Mul(literalX, new Mul(literalX, literalY))
    mul.accept(height)
    height.height() should be (3)
  }
}
