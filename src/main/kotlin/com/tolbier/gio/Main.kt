package com.tolbier.gio

import com.tolbier.gio.UserResult.Failure
import com.tolbier.gio.UserResult.Success
import com.tolbier.gio.extensions.bd
import com.tolbier.gio.extensions.percent
import com.tolbier.gio.extensions.percentOf
import java.lang.IllegalArgumentException
import java.math.BigDecimal

fun main(args: Array<String>) {
    val tickets = Money(100, "$")
    val popcorn = tickets.copy(amount= 200.bd)
    if (popcorn != tickets) {
        println("they are different")
    }

    val aJavaMoney = JavaMoney(100, "EUR")

    //sendPayment(tickets)
    sendPayment(money = tickets, message = "GoodLuck")
    sendPayment(tickets)


    val bd = BigDecimal(50)
    val percentage = bd.percent(7)

    println(50.toBigDecimal().percent(7))


    println(50.bd.percent(7))

    println(7.percentOf(popcorn))
    println(7 percentOf popcorn)


    val costs = tickets + popcorn


//    val train: Money = Money(100, "$")
//    train = null


    var train: Money? = Money(100, "$")
    train = null

    javaMoney(aJavaMoney)
    //javaMoney(null)


    val users = usersFromJSONFile("users.json")
    //findEmails(users, {value -> value.endsWith(".com")})
    val dotComUsers0 = findEmails(users) {
            it.endsWith(".com")
    }
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
        is Success -> result.users.forEach { println (it.username) }
        is Failure -> println(result.message)
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

fun sum(x: Int, y: Int) = x + y

fun sendPayment(money: Money, message: String = ""){
    println("Sending ${money.amount} $message")
}

fun convertToDollars(money: Money) =
    when (money.currency){
        "$"     ->  money
        "EUR"   ->  Money(money.amount * BigDecimal(1.10),"$")
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



