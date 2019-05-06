package com.tolbier.gio.extensions

import java.math.BigDecimal


fun BigDecimal.percent(percentage: Int ) = this.multiply(percentage.bd).divide(100.bd)