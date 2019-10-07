package ru.skillbranch.devintensive.extensions

fun String.truncate(len: Int = 16): String {
    val result = this.trim()
    return when {
        result.length <= len -> result
        else -> "${result.take(len).trimEnd()}..."
    }
}

fun String.stripHtml(): String = this
    .replace(Regex("""<.*?>"""), "")
    .replace(Regex("""&(#\d+?|\w+?);"""), "")
    .replace(Regex(""" +"""), " ")