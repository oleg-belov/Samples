package com.obelov.kotlin

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class KotlinApplicationTests {

	data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

	fun evaluateGuess(secret: String, guess: String): Evaluation {

		val rightPositions = secret.zip(guess).count { p -> p.first == p.second }

		val commonLetters = "ABCDEF".sumBy { ch ->

			Math.min(secret.count { it == ch }, guess.count { it == ch })
		}
		return Evaluation(rightPositions, commonLetters - rightPositions)
	}

	fun String?.isEmptyOrNull(): Boolean = this?.isNullOrEmpty() ?: true

	@Test
	fun contextLoads() {
		val s1: String? = null
		val s2: String? = ""
		s1.isEmptyOrNull() eq true
		s2.isEmptyOrNull() eq true

		val s3 = "   "
		s3.isEmptyOrNull() eq false
	}

}
