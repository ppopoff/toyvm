package com.doingfp.toyvm.vm.asm

object FileReader {
  import scala.io.Source.fromFile


  def readFile(filename: String) =
    fromFile(filename)

}


class Parser {

}
