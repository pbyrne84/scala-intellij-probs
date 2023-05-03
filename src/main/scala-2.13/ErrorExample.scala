import ErrorExample.TestClient
import play.api.http.HeaderNames.ACCEPT
import uk.gov.hmrc.http.HeaderCarrier
import uk.gov.hmrc.play.audit.http.HttpAuditing
import uk.gov.hmrc.play.bootstrap.config.ServicesConfig
import uk.gov.hmrc.play.bootstrap.http.DefaultHttpClient

import scala.concurrent.ExecutionContext

object ErrorExample {

  val configuration: play.api.Configuration = ???
  val httpAuditing: HttpAuditing = ???
  val wsClient: play.api.libs.ws.WSClient = ???
  val actorSystem: akka.actor.ActorSystem = ???

  // This is likely to do with the GUICE constructor magic in DefaultHttpClient()(a, b ,c ,d)
  class TestClient extends DefaultHttpClient(configuration, httpAuditing, wsClient, actorSystem)
}

class ErrorExample(val servicesConfig: ServicesConfig) {

  // Compiles fine
  private val url: String = servicesConfig.baseUrl("url")
  private val client: TestClient = new TestClient

  implicit val hc: HeaderCarrier = ???
  implicit val ec: ExecutionContext = ???

  client.GET[String](
    url = s"aaaa",
    headers = Seq(ACCEPT -> "cat-edibles"),
    queryParams = Seq()
  )

}
