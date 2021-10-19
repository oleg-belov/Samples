package com.example.inventory.api

import akka.{Done, NotUsed}
import com.lightbend.lagom.scaladsl.api.transport.Method
import com.lightbend.lagom.scaladsl.api.{Service, ServiceCall}

/**
  * The inventory service interface.
  *
  * This describes everything that Lagom needs to know about how to serve and
  * consume the inventory service.
  */
trait InventoryService extends Service {

  /**
    * Get the inventory level for the given product id.
    */
  def get(productId: String): ServiceCall[NotUsed, Int]

  /**
    * Add inventory to the given product id.
    */
  def add(productId: String): ServiceCall[Int, Done]

  override final def descriptor = {
    import Service._

    named("inventory")
      .withCalls(
        restCall(Method.GET, "/inventory/:productId", get _),
        restCall(Method.POST, "/inventory/:productId", add _)
      ).withAutoAcl(true)
  }
}

