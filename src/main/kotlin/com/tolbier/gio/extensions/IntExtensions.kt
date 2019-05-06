package com.tolbier.gio.extensions

import com.tolbier.gio.Money
import java.math.BigDecimal

val Int.bd: BigDecimal
    get() {
        return this.toBigDecimal()
    }

infix fun Int.percentOf(money:Money) =
    money.amount.multiply(this.bd).divide(100.bd)

