package com.example.ecommerce.service.impl;

import com.example.ecommerce.model.Tag;
import com.example.ecommerce.service.TagService;
import com.example.ecommerce.repository.TagRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public Optional<Tag> findById(Integer id) {
        return tagRepository.findById(id);
    }

    @Override
    public Tag create(Tag tag) {
        if(tag.getTag_name().isEmpty()) {
            throw new IllegalArgumentException();
        }


        return tagRepository.save(tag);
    }

    @Override
    public Tag update(Integer id, String tag_name) {
        if (id == null || tag_name.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Tag existingTag = tagRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Tag with given id does not exist"));

        existingTag.setTag_name(tag_name);

        tagRepository.save(existingTag);
        return existingTag;
    }

    @Override
    public void delete(Integer id) {
        tagRepository.deleteById(id);
    }
}
