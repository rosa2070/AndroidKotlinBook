package com.asiae.retrofit2again

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    val retrofit: Retrofit
        get() = Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    var networkService: INetworkService = retrofit.create(INetworkService::class.java)

    var userListCall = networkService.doGetUserList("1")

    // 오류 뜸..원인?
//    userListCall.enqueue(object : Callback<UserListModel> {
//        override fun onResponse(call: Call<UserListModel>,
//                                response: Response<UserListModel>) {
//            val userList = response.body()
//
//        }
//        override fun onFailure(call: Call<UserListModel>, t: Throwable) {
//            call.cancel()
//        }
//    })

    // 이 아래로 다 오류
    val call:Call<UserModel> = networkService.test1()

    val call:Call<UserModel> = networkService.test2("10", "kkang")

    val call:Call<UserModel> = networkService.test3("age", "kkang")

    val call: Call<UserModel> = networkService.test4(mapOf<String, String>("one" to "hello", "two" to "world"), "kkang")

    val call: Call<UserModel> = networkService.test5(
        UserModel(id="1", firstName="gildong", lastName="hong", avatar="someurl"),
        "kkang"
    )

    val call: Call<UserModel> = networkService.test6(
        "gildong 길동",
        "hong 홍",
        "kkang"
    )

    val list: MutableList<String> = ArrayList()
    list.add("홍길동")
    list.add("류현진")
    val call = networkService.test7(list)

    val call = networkService.test9("http://www.google.com", "kkang")
}