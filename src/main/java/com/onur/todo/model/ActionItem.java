package com.onur.todo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Document
@CompoundIndex(def = "{'userName':1, 'notificationDate':1}", background = true)
public class ActionItem {
    @Id
    public String id;

    @Indexed(background = true)
    public String userName;

    public String message;
    public Date creationDate;

    public Date notificationDate;

    public ActionItem(){}

    public ActionItem(String username, String message, Date notificationDate){
        this.creationDate = new Date();
        this.userName = username;
        this.notificationDate = notificationDate;
        this.message = message;
    }

    @Override
    public String toString(){
        DateFormat formatter = new SimpleDateFormat("dd MMM yyyy HH:mm:ss z");
        return String.format("Action Item id = %s, user = %s, message = %s, createAt = %s, notificationAt = %s", id, userName, message, formatter.format(creationDate), notificationDate == null ? "Not Set" : formatter.format(notificationDate));
    }
}
