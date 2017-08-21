package com.doingfp.toyvm.vm

import com.typesafe.scalalogging.LazyLogging

import MemoryMeasurements._


package object vm {
  import java.nio.ByteBuffer

  // Defines machine word that can be easily replaced
  // with Long, Short or any arbitrary type
  type Word = Int
  val bytesInWord = 4


  def wordAsBytes (w: Word): Array[Byte] = {
    val buffer = ByteBuffer allocate bytesInWord
    buffer putInt w
    buffer.array
  }


  def bytesAsWord (bytes: Array[Byte]): Word = {
    val buffer = ByteBuffer wrap bytes
    buffer.getInt
  }

  //////////////////////////////////

  case class Address (val value: Word) extends AnyVal
  implicit def addressToWord (a: Address) = a.value


  // The size of a register is one word
  case class Register (val value: Word) extends AnyVal

  object Register {
    def empty = new Register(0)
  }

  type Stack = List[Word]

  object Stack {
    def empty = Nil
  }

  implicit class StackOps (stack: Stack) {
    def push (item: Word) = item :: stack
    def pop: Option[Word] = stack.headOption
  }


  object Vm extends LazyLogging {
    def create (memSize: MemoryMeasurementUnit) =
      new RegisterVM(memSize)
  }
}


/////////////////////////////////////////////////////////

import vm._
import Memory._

// Virtual machine state
class RegisterVM (val memSize: MemoryMeasurementUnit) {
  // Registers:
  private var R0: Register = Register.empty
  private var R1: Register = Register.empty
  private var R2: Register = Register.empty

  // Instruction pointer:
  private var IP: Register = Register.empty

  private val memory = Memory of memSize


  def run(): Unit = {
    while (true) {
      // no op
    }
  }


  override
  def toString = s"3 register vm with $memSize of ram"
}

