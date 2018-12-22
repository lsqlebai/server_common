package com.sqluo.common.controller

import org.springframework.beans.factory.InitializingBean
import org.springframework.web.bind.annotation.*

abstract class CURDController<Item>: InitializingBean {
    lateinit var curdService: CURDService<Item>
    fun init(service: CURDService<Item>) {
        this.curdService = service
    }

    @GetMapping("/list/{id}")
    fun listByParent(@PathVariable id: Int): List<Item> {
        return curdService.listByParent(id)
    }

    @GetMapping("/{id}")
    fun one(@PathVariable id: Int): Item? {
        return curdService.one(id)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) {
        return curdService.delete(id)
    }

    @GetMapping
    fun listAll(): List<Item> {
        return curdService.listAll()
    }

    @PutMapping
    fun update(@RequestBody item: Item): Item? {
        return curdService.update(item)
    }

    @PostMapping
    fun create(@RequestBody item: Item): Item? {
        return curdService.create(item)
    }
}