package play.api.libs.jsoniter

import akka.stream.scaladsl.{Flow, Sink, Keep}
import akka.util.ByteString
import com.github.plokhotnyuk.jsoniter_scala.core.JsonValueCodec
import play.api.libs.json.{JsObject, JsString}
import play.api.libs.streams.Accumulator
import play.api.mvc.{BodyParser, Results}

import scala.concurrent.ExecutionContext

trait Jsoniter {
  object jsoniter {
    def json[T: JsonValueCodec](implicit ec: ExecutionContext): BodyParser[T] = BodyParser { req =>
      import com.github.plokhotnyuk.jsoniter_scala.core._

      Accumulator(Flow[ByteString].toMat(Sink.fold(ByteString.empty)(_ ++ _))(Keep.right))
        .map { byteStrings =>
          try {
            Right(readFromArray[T](byteStrings.toArray))
          } catch {
            case e: Throwable =>
              Left(Results.BadRequest(JsObject(Seq("error" -> JsString(e.getMessage)))))
          }
        }
    }
  }
}
