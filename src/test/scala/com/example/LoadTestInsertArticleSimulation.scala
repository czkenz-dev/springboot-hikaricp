package com.example

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class LoadTestInsertArticleSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8080")
    .inferHtmlResources()
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate")
    .contentTypeHeader("application/json")
    .userAgentHeader("PostmanRuntime/7.15.2")


  val scn = scenario("LoadTestInsertArticleSimulation")
    .exec(http("request_0")
      .post("/user/article")
      .body(StringBody("{\n\t\"title\":\"Spring REST Security using Hibernate\",\n\t\"category\":\"Spring\"\n}")))

  setUp(scn.inject(constantUsersPerSec(1000) during (1))).protocols(httpProtocol)
}
