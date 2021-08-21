package ru.endroad.hakaton.feature.interactive.extension

import ru.endroad.hakaton.shared.spot.entity.PanoramaPhotoSpot
import ru.endroad.widget.panorama.TexturePathes

val PanoramaPhotoSpot.textures: TexturePathes
	get() = TexturePathes(
		top = "${path}top.jpg",
		bottom = "${path}bottom.jpg",
		right = "${path}right.jpg",
		left = "${path}left.jpg",
		front = "${path}front.jpg",
		back = "${path}back.jpg"
	)