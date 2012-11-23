package code.snippet

import net.liftweb._
import common._
import http._
import sitemap._
import util._
import mapper._
import Helpers._
import scala.xml.Text
import de.java.services.BlogJavaService

object ComposeComment {
	var id = 100

	def getId = {
		id = id + 1 // ++ or += also possible?
		id
	}
}

class ComposeComment(articleId: ArticleId) extends CommonSnippet {

	private object title extends RequestVar("")
	private object message extends RequestVar("")
	private object author extends RequestVar("")

	//  private object whence extends RequestVar(S.referer openOr "/")

	private def process() = {
		println("Do process current submit. Title=" + title +
			", message=" + message +
			", author=" + author)
		val comment = new de.java.entities.Comment(ComposeComment.getId,
																							 articleId.id,
																							 author,
																							 message,
																							 title)
		BlogJavaService.addComment(comment)
	}

	def render = {
		//    val w = whence.is
		"id=compose-title" #> SHtml.textElem(title) &
			"id=compose-message" #> SHtml.textareaElem(message) &
			"id=compose-author" #> SHtml.textElem(author) &
			"type=submit" #> SHtml.onSubmitUnit(process)
	}

}

// Version 1:
//class ComposeComment(articleId: ArticleId) extends StatefulSnippet {
//  
//  private var title = ""
//  private var message = ""
//  private var author = ""
//  
//  private val whence = S.referer openOr "/"
//  
//  def dispatch = {
//    case "render" => render     
//  }
//  
//  private def process() = {
//    println("Do process current submit. Title=" + title +
//            ", message=" + message +
//            ", author=" + author)
//    val comment = new de.java.entities.Comment(ComposeComment.getId, 
//                                               title, 
//                                               message, 
//                                               author, 
//                                               articleId.id)    
//    BlogJavaService.addComment(comment)
//  }
//  
//  def render = {
//    "id=compose-title" #> SHtml.text(title, title = _, "id" -> "the_title") &
//    "id=compose-message" #> SHtml.textarea(message, message = _) &
//    "id=compose-author" #> SHtml.text(author, author = _) &
//    "type=submit" #> SHtml.onSubmitUnit(process)
//  }
//}
