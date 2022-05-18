# play-jsoniter

## Usage

```scala
import play.api.mvc.{Action, BaseController, ControllerComponents}
import javax.inject.{Inject, Singleton}
import scala.concurrent.ExecutionContext
import play.api.libs.jsoniter.Jsoniter

@Singleton
class UserController @Inject()(val controllerComponents: ControllerComponents)
                              (implicit executionContext: ExecutionContext)
  extends BaseController with Jsoniter {

  final case class User(id: Int, username: String)

  object User {
    import com.github.plokhotnyuk.jsoniter_scala.core._
    import com.github.plokhotnyuk.jsoniter_scala.macros._

    implicit val jsoniterCodec: JsonValueCodec[User] = JsonCodecMaker.make
  }

  def create(): Action[User] = Action(jsoniter.json[User]) { request =>
    Ok
  }
}
```