package api.spi

import api.api.TransactionType
import api.api.TransactionType.TransactionType

import java.sql.Connection

trait TransactionManager extends AutoCloseable {

  def init(databaseTypes: Map[String, DatabaseType], dataSources: Map[String, DataSource], providerType: String): Unit

  def getTransactionType: TransactionType

  def isInTransaction: Boolean

  def getConnection(databaseName: String, dataSourceName: String): Connection

  def begin(): Unit

  def begin(timeout: Int): Unit

  def commit(rollbackOnly:Boolean): Unit

  def rollback(): Unit

  def containsProviderType(providerType: String): Boolean = {
    true
  }

  def close(): Unit


}
