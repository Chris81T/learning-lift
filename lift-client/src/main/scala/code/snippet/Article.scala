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


/**
 *
 *  sealed trait MenuSingleton extends AnyRef
 * 	def param[T <: AnyRef](name: String, linkText: LinkText[T], parser: (String) ⇒ Box[T], encoder: (T) ⇒ String): PreParamMenu[T]
 *
 * Created with IntelliJ IDEA.
 * User: christian
 * Date: 11/20/12
 * Time: 5:31 PM
 * To change this template use File | Settings | File Templates.
 */
object Article {
//	lazy val menu = Menu.param[Long]("Article",
//																	 Loc.LinkText(id => "ArticleLink" + id),
//
//																	 )
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
