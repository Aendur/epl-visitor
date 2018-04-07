package br.unb.cic.epl

class Sub(val lhs: Expression, val rhs: Expression) extends Expression {
  override def print() : String = "(" + lhs.print() + " - " + rhs.print() + ")"
  override def accept(v: Visitor) { v.visit(this) }
}
