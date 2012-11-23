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

class Comments(articleId: ArticleId) extends CommonSnippet {

	def render = {
		val comments = asScalaList(BlogJavaService.getCommentsForArticle(articleId.id))
		println("started to render the comments=" + comments + " appropriate to article=" + articleId)
		"* *" #> comments.map{comment =>
			"@comment-title" #> comment.getTitle &
			"@comment-message" #> comment.getMessage &
			"#comment-author *+" #> comment.getAuthor
		}
	}
}
