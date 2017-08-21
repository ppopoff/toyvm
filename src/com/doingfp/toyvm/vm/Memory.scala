package com.doingfp.toyvm.vm

import vm._
import MemoryMeasurements._

import com.typesafe.scalalogging.LazyLogging


object Memory extends LazyLogging {

  type Memory = Array[Byte]

  def of (measure: MemoryMeasurementUnit): Memory = new Memory (
    measure match {
      case Bytes (amount) => amount
      case Words (words)  =>
        val sizeInBytes = words.toLong * bytesInWord

        if (sizeInBytes >= Integer.MAX_VALUE) {
          logger warn (
            "The specified size exceeds the limit. Using 2^31-1 as default")

          Integer.MAX_VALUE
        } else {
          words * bytesInWord
        }
    }
  )



  // todo: handle the exceptions
  implicit class MemoryOps (memory: Memory) extends LazyLogging {

    // Writes a sigle byte to the given address
    def write (address: Address, byte: Byte) =
      if (address.value > memory.length)
        logger error "Address exceeds given amount of memory"
      else
        memory(address.value) = byte


    def read (address: Address, byte: Byte): Byte =
      if (address.value > memory.length) {
        logger error "Address exceeds given amount of memory"
        0.toByte
      } else {
        memory(address.value)
      }


    def writeWord (address: Address, word: Word): Unit =
      wordAsBytes(word).zipWithIndex.map { case (byte, offset) =>
        write(Address(address.value + offset), byte)
      }


    def readWord (address: Address, word: Word): Word =
      bytesAsWord(memory.slice(address.value, address.value + bytesInWord))

  }
}
