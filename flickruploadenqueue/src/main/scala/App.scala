package com.riversapps.flickruploadenqueue

object App {
	def main(args: Array[String]) {
	    println("Listing upload directory.")
	    val configSourcePathString = Config.imageSourceDirectory
	    println(configSourcePathString)
	    val fileListing = FlickrUploadableFiles.getUploadableFilePathsForPath(configSourcePathString)
	    
	    println("Creating queued upload tasks.")
	    var fileCount : Int = 0
	    for (filePath <- fileListing) {
	    	fileCount += 1
	    	SqsEnqueue.addFullPath(filePath)
	    }
	    println(s"Queued tasks for $fileCount media files.")
	}
}