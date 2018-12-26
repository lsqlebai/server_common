package com.github.lsqlebai.curd

import org.springframework.web.bind.annotation.*

interface CURDService<Item> {

    @GetMapping("/")
    fun listAll(): List<Item>

    @GetMapping("/list/{id}")
    fun listByParent(@PathVariable id: Int): List<Item>

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int)

    @PutMapping("/")
    fun update(@RequestBody item: Item): Item?

    @PostMapping("/")
    fun create(@RequestBody item: Item): Item?

    @GetMapping("/{id}")
    fun one(@PathVariable id:Int): Item?

}