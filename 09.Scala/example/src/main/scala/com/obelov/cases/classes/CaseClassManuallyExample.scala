package com.obelov.cases.classes

class CaseClassManuallyExample (
                                 val hour: Int = CaseClassManuallyExample.DEFAULT_HOUR,
                                 val minutes: Int = CaseClassManuallyExample.DEFAULT_MINUTES
                               ) {
  // Step 1 - proper signature for `canEqual`
  // Step 2 - compare `a` to the current class
  def canEqual(a: Any) = a.isInstanceOf[CaseClassManuallyExample]

  // Step 3 - proper signature for `equals`
  // Steps 4 thru 7 - implement a `match` expression
  override def equals(that: Any): Boolean =
    that match {
      case that: CaseClassManuallyExample => {
        that.canEqual(this) &&
          this.hour == that.hour &&
          this.minutes == that.minutes
      }
      case _ => false
    }

  // Step 8 - implement a corresponding hashCode c=method
  override def hashCode: Int = {
    val prime = 31
    var result = 1
    result = prime * result + hour;
    result = prime * result + (if (minutes == null) 0 else minutes.hashCode)
    result
  }

  override def toString: String = s"CaseClassManuallyExample(${this.hour},${this.minutes})"

  def copy(hour: Int = this.hour, minutes: Int = this.minutes): CaseClassManuallyExample =
    new CaseClassManuallyExample(hour, minutes)
}

object CaseClassManuallyExample {
  private val DEFAULT_HOUR = 0
  private val DEFAULT_MINUTES = 0

  def apply(hour: Int = DEFAULT_HOUR, minutes: Int = DEFAULT_MINUTES): CaseClassManuallyExample =
    new CaseClassManuallyExample(hour, minutes)

  def apply(hour: Int): CaseClassManuallyExample = new CaseClassManuallyExample(hour, DEFAULT_MINUTES)

  def apply(): CaseClassManuallyExample = new CaseClassManuallyExample(DEFAULT_HOUR, DEFAULT_MINUTES)
}
