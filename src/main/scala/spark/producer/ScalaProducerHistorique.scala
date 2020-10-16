package fr.esgi.training.spark


import java.io.BufferedReader
import java.io.FileReader

import producer.ClassProducerHistorique

import scala.annotation.tailrec
import scala.io.Source

object ScalaProducerHistorique {
  def main(args: Array[String]): Unit = {

    val listFile = List(
      "../../../resources/data/NameFile.xlsx"
    )

    def runProducer(x: String): Any = {

      val input = Source.fromFile(x).getLines()
      input.next()
      val producer = new ClassProducerHistorique
      producer.produce(input)

    }

    @tailrec
    def matchCsv(x: List[String]): Any = x match {
      case head::tail => runProducer(head);matchCsv(tail)
      case head::Nil => runProducer(head)
      case _ => println("error")
    }

    matchCsv(listFile)


  }
}