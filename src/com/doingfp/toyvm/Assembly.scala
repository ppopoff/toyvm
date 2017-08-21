package com.doingfp.toyvm;

import com.typesafe.scalalogging.LazyLogging


object Assembly extends App with LazyLogging {

  import vm._
  import vm.Vm
  import MemoryMeasurements._

  logger info "Starting the vm"

  val machine = Vm.create(2048.words)

  println(s"Started: $machine")

}
