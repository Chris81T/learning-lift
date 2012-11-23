package code.snippet

import net.liftweb._
import common._
import http._
import sitemap._
import util._
import mapper._
import Helpers._

case class Filter(value: String)

/**
 * Created with IntelliJ IDEA.
 * User: christian
 * Date: 11/22/12
 * Time: 7:28 PM
 * To change this template use File | Settings | File Templates.
 */
object PreviewFilter {

	lazy val categoryMenu = Menu.param[Filter]("Category Filter",
																				 		 "Category Filter Menu",
																						 categoryName => getBoxIncludingName(categoryName),
																						 filter => getFilterValAsString(filter)
																						) / "blog" / "category" / *

	lazy val tagMenu = Menu.param[Filter]("Tag Filter",
																				"Tag Filter Menu",
																				tagName => getBoxIncludingName(tagName),
																				filter => getFilterValAsString(filter)
																			 ) / "blog" / "tag" / *

	private def getBoxIncludingName(name: String) : Box[Filter] = {
		val box = new Full[Filter](Filter(name))
		println("Returning a box including the name")
		box
	}

	private def getFilterValAsString(filter: Filter) : String = {
		println("Returning value of filter=" + filter.value)
		filter.value
	}
}
