package com.onur.todo;

import com.onur.todo.model.ActionItem;
import com.onur.todo.repository.ActionItemRepository;
import com.onur.todo.service.ActionItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class ActionItemServiceShould {

    @Autowired
    private ActionItemService service;

    @MockBean
    private ActionItemRepository mockRepository;

    @Test
    public void addGivenActionItemToRepository(){
        ActionItem newItem = new ActionItem("TestUser", "Test message", new Date());
        service.Add(newItem);

        verify(mockRepository).insert(newItem);
    }

    @Test
    public void listRequestedActionItems(){
        String testUser = "Onur";
        List<ActionItem> actionList = new ArrayList<ActionItem>();
        actionList.add(new ActionItem(testUser, "testMessage", new Date()));
        actionList.add(new ActionItem(testUser, "testMessage_1", new Date()));

        when(mockRepository.findByUserName(testUser)).thenReturn(actionList);

        List<ActionItem> returnedActionList = service.List(testUser);

        assertTrue(actionList.size() == returnedActionList.size());
    }

}
