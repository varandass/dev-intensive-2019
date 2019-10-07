package ru.skillbranch.devintensive.utils

object Utils {

    fun parseFullName(fullName: String?): Pair<String?, String?> {

        val parts = fullName?.split(" ")

        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)

        if (firstName == "") firstName = null
        if (lastName == "") lastName = null

        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
        val mapLetter = mapOf(
            "а" to "a",
            "б" to "b",
            "в" to "v",
            "г" to "g",
            "д" to "d",
            "е" to "e",
            "ё" to "e",
            "ж" to "zh",
            "з" to "z",
            "и" to "i",
            "й" to "i",
            "к" to "k",
            "л" to "l",
            "м" to "m",
            "н" to "n",
            "о" to "o",
            "п" to "p",
            "р" to "r",
            "с" to "s",
            "т" to "t",
            "у" to "u",
            "ф" to "f",
            "х" to "h",
            "ц" to "c",
            "ч" to "ch",
            "ш" to "sh",
            "щ" to "sh'",
            "ъ" to "",
            "ы" to "i",
            "ь" to "",
            "э" to "e",
            "ю" to "yu",
            "я" to "ya",
            " " to divider
        )
        val result = StringBuilder()
        payload.forEach { char ->
            if (char.isUpperCase()) {
                val lowChar = char.toLowerCase()
                if (lowChar.toString() in mapLetter) {
                    result.append(mapLetter[lowChar.toString()]?.capitalize())
                } else result.append(char)
            } else {
                if (char.toString() in mapLetter) {
                    result.append(mapLetter[char.toString()])
                } else result.append(char)
            }

        }

        return "$result"
    }

    fun toInitials(firstName: String?, lastName: String?) = when {
        (firstName.isNullOrBlank() && lastName.isNullOrBlank()) -> null
        firstName.isNullOrBlank() -> "${lastName?.trim()?.get(0)}".toUpperCase()
        lastName.isNullOrBlank() -> "${firstName.trim()[0]}".toUpperCase()
        else -> "${firstName.trim()[0]}${lastName.trim()[0]}".toUpperCase()
    }
}