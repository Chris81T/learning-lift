package code.snippet

import net.liftweb._
import util._
import Helpers._
import de.java.services.BlogJavaService

/**
 * Created with IntelliJ IDEA.
 * User: christian
 * Date: 11/17/12
 * Time: 5:35 PM
 * To change this template use File | Settings | File Templates.
 */
class Tags extends CommonSnippet {

	def render = {
		val tags = asScalaList(BlogJavaService.getTags)
		print("render categories...")
		"* *" #> tags.map {tag =>
			"@tag-name" #> tag.getName &
			"a [href]" #> PreviewFilter.tagMenu.calcHref(Filter(tag.getName))
			}
		}
}
