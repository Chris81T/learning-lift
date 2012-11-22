package code.snippet

import net.liftweb._
import common._
import http._
import sitemap._
import util._
import mapper._
import Helpers._
import de.java.services.BlogJavaService


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
		val box = Map(articleId -> ArticleId(articleId.toLong)).get(articleId)
		println("Returning a box including the article id=" + box)
		box
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
class Article(articleId: ArticleId)  extends CommonSnippet {

	def render = {
		val article = BlogJavaService.getArticle(articleId.id)
		"h1 *" #> article.getTitle & "@article-content" #> article.getContent
	}

}
