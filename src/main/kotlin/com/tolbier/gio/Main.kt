package com.tolbier.gio

import com.tolbier.gio.extensions.bd
import com.tolbier.gio.extensions.percent
import com.tolbier.gio.extensions.percentOf
import java.lang.IllegalArgumentException
import java.math.BigDecimal

fun sum(x: Int, y: Int) = x + y

fun sendPayment(money: Money, message: String = ""){
    println("Sending ${money.amount} $message")
}

fun convertToDollars(money: Money) =
    when (money.currency){
        "$"     ->  money
        "EUR"   ->  Money(money.amount * BigDecimal(1.10),"EUR")
        else  ->  throw IllegalArgumentException("not the currency you're interested in")
    }


fun javaMoney(money: JavaMoney?){
    println("${money?.amount} is valid")


    if (money != null ){
        println("${money.amount} is valid")
    }
    money?.let {
        println("${it.amount} is valid")
    }

    try {
        println("${money?.amount ?: throw IllegalArgumentException()}  is valid")
    }catch (ex: IllegalArgumentException){
        println("EXCEPTION: money is null")
    }

    println("${money!!.amount} is valid")

}


fun main(args: Array<String>) {
    val tickets = Money(100, "$")
    val popcorn = Money(100, "$")
    if (popcorn != tickets) {
        println("they are different")
    }

    val aJavaMoney = JavaMoney(100, "EUR")

    //sendPayment(tickets)
    sendPayment(money = tickets, message = "GoodLuck")
    sendPayment(tickets)

    println(50.toBigDecimal().percent(7))


    println(50.bd.percent(7))

    println(7.percentOf(popcorn))
    println(7 percentOf popcorn)


    val costs = tickets + popcorn


//    val train = Money(100, "$")
//    train = null


    var train: Money? = Money(100, "$")
    train = null

    javaMoney(aJavaMoney)
    //javaMoney(null)


    val users = usersFromJSONFile("users.json")

    val dotComUsers =
        users.filter {
             it.email.endsWith(".com")
        }.sortedBy {
            it.id
        }.map{
            it.email to it.username
        }
    val (id,_,_,role) =  //Multiple Assignment
        users.filter {
            it.email.endsWith(".com")
        }.sortedBy {
            it.id
        }.first()

    ///---
    var result = retrieveUsers()
    when (result) {
        is UserResult.Success -> result.users.forEach { println (it.username) }
        is UserResult.Failure -> println(result.message)
    }


    //----

    var values = generateSequence (1){
        it * 10
    }

    values.take(10).forEach { println(it) }

    //--

    val usersSeq = usersFromJSONFile("users.json").asSequence()


    usersSeq.take(10).forEach { println(it) }
}





