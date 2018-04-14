package br.unb.cic.epl

class Height extends Visitor {
  var h: Int = 0 
  override def visit (exp: Literal) { h = 1 }
  override def visit (exp: Add) {
    exp.lhs.accept(this)
    val hl = 1 + h
    exp.rhs.accept(this)
    val hr = 1 + h
    h = if (hl > hr)
      hl
    else
      hr
  }
  override def visit (exp: Sub) {
    exp.lhs.accept(this)
    val hl = h
    exp.rhs.accept(this)
    val hr = h
    h = if (hl > hr)
      1 + hl
    else
      1 + hr
  }
  override def visit (exp: Mul) {
    exp.lhs.accept(this)
    val hl = 1 + h
    exp.rhs.accept(this)
    val hr = 1 + h
    h = if (hl > hr)
      hl
    else
      hr
  }
  def height() : Int = h
}
