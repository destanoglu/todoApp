package com.onur.todo.ActionItemRepositoryShould;

import com.onur.todo.repository.ActionItemRepository;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class AddAnActionItem {
    @Autowired
    private ActionItemRepository actionItemRepository;

    @BeforeClass
    public void SetUp(){

    }
}
