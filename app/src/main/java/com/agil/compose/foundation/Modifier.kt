package com.agil.compose.foundation

open class Modifier {

    val styles = mutableMapOf<String, Any>()

    val attributes = mutableMapOf<String, Any>()

    val events = mutableMapOf<String, (params: Any) -> Unit>()

}