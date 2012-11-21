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
import de.java.entities


/**
 *
 * Created with IntelliJ IDEA.
 * User: christian
 * Date: 11/20/12
 * Time: 5:31 PM
 * To change this template use File | Settings | File Templates.
 */
object Article {
	/*
	 *  sealed trait MenuSingleton extends AnyRef
   * 	def param[T <: AnyRef](name: String, linkText: LinkText[T], parser: (String) ⇒ Box[T], encoder: (T) ⇒ String): PreParamMenu[T]
	 */
	lazy val menu = Menu.param[de.java.entities.Article]("Article",
																	 										 "Reading an article",
	                                                     articleId => findArticleById(articleId),
	                                                     article => getIdForArticle(article)
																	 										) / "article" / *


	def findArticleById(articleId: String) : Box[de.java.entities.Article] = {
		val article = BlogJavaService.getArticle(articleId.toLong)

		/* TODO I dont think, that is the best solution to get the box instance - source:
			 https://github.com/d6y/london_class_march_2011_sitemap_css/blob/master/src/main/scala/code/model/Forum.scala -> def find
		 */
		val map = Map(articleId -> article)
		println("Found article=" + article + " for given id=" + articleId)
		val box = map.get(articleId)
		println("Returning created box=" + box)
		box
	}

	def getIdForArticle(article: de.java.entities.Article) : String = {
		val id = article.getId.toString
		println("Returning requested id=" + id + " of article=" + article)
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
class Article(articleId: Long)  extends CommonSnippet {

	def render = {
		val article = BlogJavaService.getArticle(articleId)
		"h1 *" #> article.getTitle & "@article-content" #> article.getContent
	}

}
