package com.doingfp.toyvm.vm


object MemoryMeasurements {

  sealed trait MemoryMeasurementUnit

  case class Words (val value: Int) extends MemoryMeasurementUnit {
    override def toString = s"$value words"
  }

  case class Bytes (val value: Int) extends MemoryMeasurementUnit {
    override def toString = s"$value bytes"
  }

  implicit class IntToMemorySize (val i: Int) {
    def words = Words(i)
    def bytes = Bytes(i)
  }
}
