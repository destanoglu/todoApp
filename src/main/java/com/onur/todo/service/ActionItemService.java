package com.onur.todo.service;

import com.onur.todo.model.ActionItem;
import com.onur.todo.repository.ActionItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionItemService {
    private final static Logger log = LoggerFactory.getLogger(ActionItemService.class);
    @Autowired
    private ActionItemRepository actionItemRepository;

    public void Add(ActionItem item){
        log.info("Adding item " + item.toString());
        actionItemRepository.insert(item);
    }

    public List<ActionItem> List(String userName){
        log.info("Listing for user " + userName);
        return actionItemRepository.findByUserName(userName);
    }
}
