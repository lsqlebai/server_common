package com.iflytek.yaya.common.controller

import org.springframework.beans.factory.InitializingBean
import org.springframework.web.bind.annotation.*

abstract class DefaultCURDServiceImpl<Item> : CURDService<Item>, InitializingBean {

    lateinit var curdMapper: CURDMapper<Item>

    fun init(mapper: CURDMapper<Item>) {
        this.curdMapper = mapper
    }

    @GetMapping("/")
    override fun listAll(): List<Item> {
        return curdMapper.listAll()
    }

    @GetMapping("/list/{id}")
    override fun listByParent(@PathVariable id: Int): List<Item> {
        return curdMapper.listByParent(id)
    }

    @DeleteMapping("/{id}")
    override fun delete(@PathVariable id: Int) {
        return curdMapper.delete(id)
    }

    @PutMapping("/")
    override fun update(@RequestBody item: Item): Item? {
        curdMapper.update(item)
        return item
    }

    @PostMapping("/")
    override fun create(@RequestBody item: Item): Item? {
        curdMapper.create(item)
        return item
    }

    @GetMapping("/{id}")
    override fun one(@PathVariable id: Int): Item? {
        return curdMapper.one(id)
    }
}