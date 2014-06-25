package model

import net.liftweb.json.JsonAST._
import net.liftweb.json.Extraction._
import net.liftweb.json.Printer._

object LiftJsonConverterDecompose {

implicit val formats = net.liftweb.json.DefaultFormats

case class Mailserver2(url: String, username: String, password: String)

  def main(args: Array[String]) {
   
    // This starts with a Mailserver instance and creates JSON out of it.
    val m2 = Mailserver2("www.google.com", "myuser", "mypassword")
    println(pretty(render(decompose(m2))))
    
  }

}