package com.tolbier.gio

import java.math.BigDecimal

//data class Money(val amount:Int, val currency: String)
data class Money(val amount:BigDecimal, val currency: String){
    constructor(amount:Int, currency: String) : this(amount.toBigDecimal(),currency)
}

operator fun Money.plus(other: Money) =
    if (this.currency == other.currency){
        this.copy(other.amount)
    }else{
        this
    }
