package br.unb.cic.epl

trait Visitor {
  def visit(exp: Literal) : Unit
  def visit(exp: Add) : Unit
  def visit(exp: Mul) : Unit
  def visit(exp: Sub) : Unit
}
