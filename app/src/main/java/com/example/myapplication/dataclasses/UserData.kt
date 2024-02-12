// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package com.example.myapplication.dataclasses

import java.io.Serializable

data class UserData (
    val website: String,
    val address: Address,
    val phone: String,
    val name: String,
    val company: Company,
    val id: Long,
    val email: String,
    val username: String
):Serializable

data class Address (
    val zipcode: String,
    val geo: Geo,
    val suite: String,
    val city: String,
    val street: String
)

data class Geo (
    val lng: String,
    val lat: String
)

data class Company (
    val bs: String,
    val catchPhrase: String,
    val name: String
)
