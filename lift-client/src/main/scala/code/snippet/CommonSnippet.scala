package code.snippet

import collection.JavaConversions

/**
 * Created with IntelliJ IDEA.
 * User: christian
 * Date: 11/20/12
 * Time: 8:10 PM
 * To change this template use File | Settings | File Templates.
 */
trait CommonSnippet {
	def asScalaList[A](javaList: java.util.List[A]) : List[A] = {
		return JavaConversions.asScalaBuffer(javaList).toList
	}

}
