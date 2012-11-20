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
 * Date: 11/17/12
 * Time: 5:35 PM
 * To change this template use File | Settings | File Templates.
 */
class Categories extends CommonSnippet {

	def render = {
		val mainCategories = asScalaList(BlogJavaService.getMainCategories)

		"* *" #> mainCategories.map {mainCategory =>
			"@main-category-name" #> mainCategory.getName &
			"#sub-category li" #> asScalaList(BlogJavaService.getSubCategories(mainCategory.getId)).map {subCategory =>
				"@sub-category-name" #> subCategory.getName
			}
		}
	}
}
