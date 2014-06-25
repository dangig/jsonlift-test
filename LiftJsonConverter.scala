package model

import net.liftweb.json._
import net.liftweb.json.JsonDSL._

object LiftJsonConverter {

  implicit val formats = DefaultFormats
  case class Mailserver(url: String, username: String, password: String)

  def main(args: Array[String]) {

    val mailserverjson = parse(
    """
	{ 
	  "url": "imap.yahoo.com",
	  "username": "myusername!",
	  "password": "mypassword!"
	}
	""")

    // This will convert "json" defined above, into a Mailserver instance.  
    val m = mailserverjson.extract[Mailserver]
    println(m.url)
    println(m.username)
    println(m.password)

    // This is a way to convert from an object to JSON but requires manual parsing.
    val m2 = Mailserver("www.google.com", "myuser", "mypassword")

    val m2Json =
      ("m2url" -> m2.url) ~
        ("m2user" -> m2.username) ~
        ("m2password" -> m2.password)

    println(compact(render(m2Json)))
    println("***")
    println(render(m2Json))
    println("***")
    println(pretty(render(m2Json)))
  }

}