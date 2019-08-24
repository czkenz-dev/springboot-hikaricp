package com.example

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class RecordedSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8080")
    .inferHtmlResources()
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("PostmanRuntime/7.15.2")

  val scn = scenario("RecordedSimulation")
    .exec(http("request_0")
      .get("/user/articles"))

  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
