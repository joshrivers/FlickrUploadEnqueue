package com.riversapps.flickruploadenqueue
import scala.collection.JavaConversions._
import java.io.File

object FlickrUploadableFiles {
	def getUploadableFilePathsForPath(root: String) : Stream[String] = {
		val sourcePath = new File(root)
		println(root)
		return getFileTree(sourcePath).filter(isSupportedFlickrType(_)).map(_.getAbsolutePath)
	}

	def getFileTree(root: File, skipHidden: Boolean = false): Stream[File] = 
		if (!root.exists || (skipHidden && root.isHidden)) Stream.empty 
		else root #:: (
		root.listFiles match {
			case null => Stream.empty
			case files => files.toStream.flatMap(getFileTree(_, skipHidden))
		})

	def isSupportedFlickrType(f: File) : Boolean = {
		println(f.getAbsolutePath())
		val lowerName = f.getName().toLowerCase()
		return lowerName.endsWith(".png") ||
			lowerName.endsWith(".jpg") ||
			lowerName.endsWith(".jpeg") ||
			lowerName.endsWith(".tif") ||
			lowerName.endsWith(".tiff") ||
			lowerName.endsWith(".mp4") ||
			lowerName.endsWith(".mov") ||
			lowerName.endsWith(".wmv") ||
			lowerName.endsWith(".mov") ||
			lowerName.endsWith(".mpeg")
	}
}