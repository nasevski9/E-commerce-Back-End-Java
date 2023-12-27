package com.example.ecommerce.service;

import com.example.ecommerce.model.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {
    List<Tag> findAll();
    Optional<Tag> findById(Integer id);

    Tag create(Tag tag);

    Tag update(Integer id , String tag_name);
    void delete(Integer id);

}
