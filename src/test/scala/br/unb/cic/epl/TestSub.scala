package br.unb.cic.epl

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter


class TestSub extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "A Sub expression"

  var literal20: Literal = _
  var literal30: Literal = _

  before {
    literal20 = new Literal(20) 
    literal30 = new Literal(30) 
  }

  it should "return String (20 - 30) when we call Sub(Literal(20), Literal(30)).print()" in {
    val sub = new Sub(literal20, literal30)
    sub.print() should be ("(20 - 30)")
  }

  it should "return -10 when we call Sub(Literal(20), Literal(30)).eval()" in {
    val eval = new Eval()
    val sub = new Sub(literal20, literal30)
    sub.accept(eval)
    eval.result() should be (-10)
  }
}
