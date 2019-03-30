package com.onur.todo.repository;

import com.onur.todo.model.ActionItem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ActionItemRepository extends MongoRepository<ActionItem, String> {
    List<ActionItem> findByUserName(String userName);
}
