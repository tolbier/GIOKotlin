package com.tolbier.gio

// class  UserResult{
// open class  UserResult {
sealed class  UserResult{
    data class Success(val users: List<User>): UserResult()
    data class Failure(val message: String): UserResult()
}


fun retrieveUsers():UserResult{
    return try {
        UserResult.Success(usersFromJSONFile("users2.json"))
    }catch (e: Exception){
        UserResult.Failure(e.message?:"")
    }

}