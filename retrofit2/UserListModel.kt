package com.asiae.retrofit2again

import com.google.gson.annotations.SerializedName

class UserListModel (
    var page: String,
    @SerializedName("per_page")
    var perPage: String,
    var total: String,
    @SerializedName("total_pages")
    var totalPages: String,
    var data: List<UserModel>?

)