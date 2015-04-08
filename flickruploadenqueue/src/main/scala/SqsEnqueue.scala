package com.riversapps.flickruploadenqueue
import awscala._, sqs._
import org.json4s._
import org.json4s.JsonDSL._
import org.json4s.jackson.JsonMethods._

object SqsEnqueue {
	implicit val sqs = SQS.at(Region.US_WEST_2)
    val hostname = java.net.InetAddress.getLocalHost.getHostName.replace(".","_")
    val queueName = "flickruploadfrom-" + hostname
    val queue: Queue = sqs.createQueueAndReturnQueueName(queueName)
	def addFullPath(path: String) {
    	val uploadableItemMessage = ("hostname" -> hostname) ~ ("fullPath" -> path)
    	val jsonPackage = compact(render(uploadableItemMessage))
    	queue.add(jsonPackage)
	}
}