package com.onur.todo.controller;

import com.onur.todo.model.ActionItem;
import com.onur.todo.requestModel.CreationModel;
import com.onur.todo.service.ActionItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("list")
public class ListController {

    @Autowired
    private ActionItemService actionItemService;

    @PostMapping(value = "/add")
    public void AddListElement(@RequestBody CreationModel createMessage, HttpServletResponse response) {

        ActionItem newItem = new ActionItem(createMessage.getUser(), createMessage.getMessage(), createMessage.getNotificationDate());

        actionItemService.Add(newItem);

        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    @GetMapping("/{userName}")
    public @ResponseBody List<ActionItem> GetListElements(@PathVariable(value="userName") String userName, HttpServletResponse response){
        List<ActionItem> items = actionItemService.List(userName);

        if (items.size() == 0){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

        return items;
    }
}
