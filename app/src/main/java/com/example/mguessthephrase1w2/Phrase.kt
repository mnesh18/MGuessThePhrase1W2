package com.example.mguessthephrase1w2

import android.util.Log
import kotlin.random.Random

class Phrase {

    private val phrasesList: List<String> = listOf(
            "Work hard",
            "Do not give up",
            "No pain no gain",
            "Everything will be OK",
            "Life is short stay awake for it"
    )

    private val phrase: String


    init {
        phrase = phrasesList[Random.nextInt(phrasesList.size)]
    }


    fun getPhrase(): String {
        return phrase
    }

     fun encodePhrase(): String {
        var encodedPhrase = ""
        for (character in phrase){
            encodedPhrase += if (character == ' ')
                character
            else
                '*'
        }
        return encodedPhrase
    }

    fun decodePhrase(encodedPhrase: String, letter: Char): String {
        var decodedPhrase = ""
        var encodedPhraseTrimmed = encodedPhrase.removePrefix("Phrase: ") // to avoid dealing with title
        for (character in phrase.indices){
            decodedPhrase += if (phrase[character].equals(letter, true)) {
                phrase[character]
            } else {
                encodedPhraseTrimmed[character]
            }
        }
        return decodedPhrase
    }

    fun letterOccurrences(letter: Char): Int {
       return phrase.filter { it.equals(letter, true) }.count()
    }
}