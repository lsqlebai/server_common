package com.iflytek.yaya.common.controller

interface CURDMapper<Item> {
    fun create(item: Item)
    fun update(item: Item)
    fun delete(id: Int)
    fun listByParent(id: Int): List<Item>
    fun one(id: Int): Item?
    fun listAll(): List<Item>
    fun list(): List<Item>

}