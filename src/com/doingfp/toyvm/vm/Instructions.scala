package com.doingfp.toyvm.vm

import vm._

/**
  * Instruction format
  */
// todo it may have Register or Address
case class Instruction (
  commad: Command,
  op1: Option[Register],
  op2: Option[Register],
  dest: Option[Register]
)


sealed trait Command

// Memory Operations
case object Mov extends Command


case object Nop extends Command
case object Hlt extends Command

// Arithmetic
case object Add extends Command
case object Sub extends Command
case object Mul extends Command
case object Div extends Command

// Logical
case object Neg extends Command
case object And extends Command
case object Or  extends Command
case object Xor extends Command


// Shift operations
case object Shl extends Command
case object Shr extends Command


// Comparisson / flow
case object Jbe extends Command
case object Jae extends Command
case object Ja  extends Command
case object Je  extends Command
case object Jb  extends Command

case object Jmp extends Command

