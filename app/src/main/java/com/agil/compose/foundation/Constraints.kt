package com.agil.compose.foundation

fun ConstraintsModifier.center(): ConstraintsModifier {
    styles["startToStart"] = "parent"
    styles["topToTop"] = "parent"
    styles["endToEnd"] = "parent"
    styles["bottomToBottom"] = "parent"
    return this
}