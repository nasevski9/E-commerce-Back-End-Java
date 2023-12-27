package com.example.ecommerce.controller;

import com.example.ecommerce.model.Tag;
import com.example.ecommerce.service.TagService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/tags")
    public List<Tag> findAll() {
        return tagService.findAll();
    }

    @GetMapping("/tag/{id}")
    public Optional<Tag> findById(@PathVariable Integer id) {
        return tagService.findById(id);
    }

    @PostMapping("/tag")
    public ResponseEntity<Tag> create(@RequestBody Tag tag){
        try {
            Tag createdTag = tagService.create(tag);
            return new ResponseEntity<>(createdTag, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/tag/{id}")
    public ResponseEntity<Tag> update(@PathVariable Integer id, @RequestBody Tag tag){
        try {
            Tag tagResult = tagService.update(tag.getId(), tag.getTag_name());
            return new ResponseEntity<>(tagResult, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/tag/{id}")
    public void delete(@PathVariable Integer id){
        tagService.delete(id);
    }
}
