package com.example.shoppingcart.impl

import akka.management.cluster.bootstrap.ClusterBootstrap
import akka.management.scaladsl.AkkaManagement
import com.lightbend.lagom.scaladsl.persistence.jdbc.JdbcPersistenceComponents
import com.lightbend.lagom.scaladsl.server._
import com.lightbend.lagom.scaladsl.devmode.LagomDevModeComponents
import play.api.libs.ws.ahc.AhcWSComponents
import com.example.shoppingcart.api.ShoppingCartService
import com.lightbend.lagom.scaladsl.akka.discovery.AkkaDiscoveryComponents
import com.lightbend.lagom.scaladsl.broker.kafka.LagomKafkaComponents
import com.softwaremill.macwire._
import play.api.db.HikariCPComponents

class ShoppingCartLoader extends LagomApplicationLoader {

  override def load(context: LagomApplicationContext): LagomApplication =
    new ShoppingCartApplication(context) with AkkaDiscoveryComponents {
      AkkaManagement(actorSystem).start()
      ClusterBootstrap(actorSystem).start()
    }

  override def loadDevMode(context: LagomApplicationContext): LagomApplication =
    new ShoppingCartApplication(context) with LagomDevModeComponents

  override def describeService = Some(readDescriptor[ShoppingCartService])
}

abstract class ShoppingCartApplication(context: LagomApplicationContext)
  extends LagomApplication(context)
    with JdbcPersistenceComponents
    with HikariCPComponents
    with LagomKafkaComponents
    with AhcWSComponents {

  // Bind the service that this server provides
  override lazy val lagomServer = serverFor[ShoppingCartService](wire[ShoppingCartServiceImpl])

  // Register the JSON serializer registry
  override lazy val jsonSerializerRegistry = ShoppingCartSerializerRegistry

  // Register the ShoppingCart persistent entity
  persistentEntityRegistry.register(wire[ShoppingCartEntity])
}
