package api.api

import api.api.TransactionType.LOCAL

object TransactionType extends Enumeration {
  type TransactionType = Value
  val LOCAL,XA, BASE = Value

  def isDistributedTransaction(transactionType: TransactionType): Boolean = {
    transactionType == XA || transactionType == BASE
  }
}



object Test {
  def main(args: Array[String]): Unit = {
    println(TransactionType.isDistributedTransaction(LOCAL))
  }
}