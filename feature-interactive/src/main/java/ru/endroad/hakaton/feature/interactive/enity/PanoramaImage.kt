package ru.endroad.hakaton.feature.interactive.enity

import ru.endroad.widget.panorama.TexturePathes
import java.io.Serializable

@JvmInline
value class PanoramaImage(val path: String) : Serializable

internal val PanoramaImage.textures: TexturePathes
	get() = TexturePathes(
		top = "${path}top.jpg",
		bottom = "${path}bottom.jpg",
		right = "${path}right.jpg",
		left = "${path}left.jpg",
		front = "${path}front.jpg",
		back = "${path}back.jpg"
	)