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
class ArticlePreviews extends CommonSnippet {

  def render = {

		/*
		TODO:
			- adapt class to support filtering by category
			- add dynamic href article url
		 */


		/*
			it is not necessary to return all real articles including content. It should be overhead. Only the complete
			article is requested, if the visitor wants to read the article

			--> An articlePreview knows the id of the article
		 */
		val articles = asScalaList(BlogJavaService.getAllArticlePreviews)
		"* *" #> articles.map {article =>
			"@article-title" #> article.getTitle
		}
  }

}
