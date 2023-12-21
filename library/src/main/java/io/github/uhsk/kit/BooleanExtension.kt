package io.github.uhsk.kit

fun Boolean.isTrue(block: () -> Unit) {
    if (this) {
        block()
    }
}
fun Boolean.isFalse(block: () -> Unit) {
    if (!this) {
        block()
    }
}