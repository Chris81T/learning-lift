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
 * Created with IntelliJ IDEA.
 * User: christian
 * Date: 11/12/12
 * Time: 8:32 PM
 * To change this template use File | Settings | File Templates.
 */
class ArticlePreviews(filter: Filter) extends CommonSnippet {

	def this() = {
		this(Filter(""))
	}

  def render = {
		var articles : List[de.java.entities.ArticlePreview] = Nil

		S.attr("filter") match {
			case Full(name) => {
				println("Received filter attribute with value = " + name)
				name match {
					case "category" => {
						articles = asScalaList(BlogJavaService.getArticlePreviewsOfCategory(filter.value))
						println("category - value of received filter=" + filter)
					}
					case "tag" => {
						articles = asScalaList(BlogJavaService.getArticlePreviewsOfTag(filter.value))
						println("tag - value of received filter=" + filter)
					}
					case _ => articles = asScalaList(BlogJavaService.getAllArticlePreviews)
				}
			}
			case Empty|Failure => {
				println("!! Something went wrong. Please fix missing attribute from the html !!")
				"* *" #> "Could not load article-previews. Please try again later."
			}
		}

		"* *" #> articles.map {article =>
			"@article-title" #> article.getTitle &
			"a [href]" #> Article.menu.calcHref(ArticleId(article.getArticleId))
		}
  }

}
