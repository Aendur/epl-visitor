package br.unb.cic.epl

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter


class TestMul extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "A Mul expression"

  var literal10: Literal = _
  var literal20: Literal = _

  before {
    literal10 = new Literal(10) 
    literal20 = new Literal(20) 
  }

  it should "return String (10 * 20) when we call Mul(Literal(10), Literal(20)).print()" in {
    val mul = new Mul(literal10, literal20)
    mul.print() should be ("(10 * 20)")
  }

  it should "return 200 when we call Mul(Literal(10), Literal(20)).eval()" in {
    val eval = new Eval()
    val mul = new Mul(literal10, literal20)
    mul.accept(eval)
    eval.result() should be (200)
  }
}
