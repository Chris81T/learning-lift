package code.snippet

import net.liftweb._
import common._
import http._
import sitemap._
import util._
import mapper._
import Helpers._
import de.java.services.BlogJavaService
import xml.NodeSeq


/**
 * Menu.param[Long] is not possible -> using a case class instead
 * @param id knows the article id
 */
case class ArticleId(id: Long)

/**
 *
 * Created with IntelliJ IDEA.
 * User: christian
 * Date: 11/20/12
 * Time: 5:31 PM
 * To change this template use File | Settings | File Templates.
 */
object Article {

	lazy val menu = Menu.param[ArticleId]("Article",
																	 		  "Reading an article",
	                                      idAsString => getBoxIncludingId(idAsString),
	                                      articleId => getIdForArticle(articleId)
																	 		 ) / "blog" / "article" / *


	def getBoxIncludingId(articleId: String) : Box[ArticleId] = {
		try {
			val box = new Full[ArticleId](ArticleId(articleId.toLong))
			println("Returning a Full box including the article id=" + box)
			box
		} catch {
				case e : Exception => {
					println("Something went wrong while trying to convert given id=" + articleId)
					return new Full[ArticleId](ArticleId(-1)) // <--- there should be a better solution for it ?!
				}
		}
	}

	def getIdForArticle(articleId: ArticleId) : String = {
		val id = articleId.id.toString
		println("Returning requested article id=" + id)
		id
	}
}


/**
 * Created with IntelliJ IDEA.
 * User: christian
 * Date: 11/20/12
 * Time: 5:31 PM
 * To change this template use File | Settings | File Templates.
 */
class Article(articleId: ArticleId) extends CommonSnippet {

	def render() : CssSel = {
		val article = BlogJavaService.getArticle(articleId.id)

		// in real world exception handling should be the better choice
		if (article != null) {
			return "h1 *" #> article.getTitle & "@article-content" #> article.getContent
		}
		println("article not found! Given id=" + articleId.id)
		S.redirectTo("/blog")
	}

}
