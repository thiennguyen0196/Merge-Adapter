package com.example.merge_adapter.data

import com.example.merge_adapter.R
import com.example.merge_adapter.data.model.Banner
import com.example.merge_adapter.data.model.User
import java.util.UUID

object DataFactory {

    fun getUser() = ArrayList<User>().apply {
        add(User(UUID.randomUUID().toString(), "Bruce Wayne", "Batman", "https://s3.amazonaws.com/uifaces/faces/twitter/sunlandictwin/128.jpg"))
        add(User(UUID.randomUUID().toString(), "Clark Kent", "Superman", "https://s3.amazonaws.com/uifaces/faces/twitter/mufaddal_mw/128.jpg"))
        add(User(UUID.randomUUID().toString(), "Diana Prince", "Wonder Woman", "https://s3.amazonaws.com/uifaces/faces/twitter/allfordesign/128.jpg"))
    }

    fun getBanner(seed: Int = 0) = when (seed) {
        0 -> arrayListOf(Banner(UUID.randomUUID().toString(), R.drawable.im_banner_1))
        else -> arrayListOf(Banner(UUID.randomUUID().toString(), R.drawable.im_banner_2))
    }
}