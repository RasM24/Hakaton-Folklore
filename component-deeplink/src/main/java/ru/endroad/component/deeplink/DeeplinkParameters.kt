package ru.endroad.component.deeplink

typealias DeeplinkParameters = Map<String, String?>

fun DeeplinkParameters.requireLong(key: String): Long =
	get(key)?.toLong().let(::requireNotNull)

fun DeeplinkParameters.requireInt(key: String): Int =
	get(key)?.toInt().let(::requireNotNull)

fun DeeplinkParameters.requireString(key: String): String =
	get(key).let(::requireNotNull)

fun DeeplinkParameters.requireBoolean(key: String): Boolean =
	get(key)?.toBoolean().let(::requireNotNull)

//Типичные аргументы
val DeeplinkParameters.id: Long get() = requireLong("id")