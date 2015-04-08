package com.riversapps.flickruploadenqueue
import com.typesafe.config.ConfigFactory

object Config {
	val config = ConfigFactory.load();
	val configSourcePathString = config.getString("flickruploadenqueue.imageSourceDirectory")
	def imageSourceDirectory = configSourcePathString
}