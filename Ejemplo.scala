import akka.actor.ActorSystem
import akka.stream.{ActorMaterializer, Materializer}
import akka.stream.scaladsl._

object Ejemplo extends App {
  // Crea un sistema de actores de Akka
  implicit val sistema = ActorSystem("SistemaReactivo")
  implicit val materializador: Materializer = ActorMaterializer()

  // Define un flujo de datos
  val fuente = Source(1 to 5)

  // Aplica una transformación (multiplicar por 2) al flujo
  val flujoTransformado = fuente.map(x => x * 2)

  // Define un consumidor que imprime los elementos del flujo transformado
  val consumidor = Sink.foreach[Int](println)

  // Conecta el flujo transformado con el consumidor
  flujoTransformado.runWith(consumidor)

  // Cierra el sistema de actores
  sistema.terminate()
}

