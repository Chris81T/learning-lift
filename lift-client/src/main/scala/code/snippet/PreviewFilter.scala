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
																						 categoryName => {
																						 	val box = Map(categoryName -> Filter(categoryName)).get(categoryName)
																							println("Returning a box including the category name")
																							box
																						 },
																						 filter => {
																							println("Returning value of filter=" + filter.value)
																							filter.value
																						 }
																						) / "blog" / "category" / *

	lazy val tagMenu = Menu.param[Filter]("Tag Filter",
																				"Tag Filter Menu",
																				tagName => {
																					val box = Map(tagName -> Filter(tagName)).get(tagName)
																					println("Returning a box including the tag name")
																					box
																				},
																				filter => {
																					println("Returning value of filter=" + filter.value)
																					filter.value
																				}
																			 ) / "blog" / "tag" / *

}
