package com.onur.todo.requestModel;

import java.util.Date;

public class CreationModel {
    private final String user;
    private final Date notificationDate;
    private final String message;

    public CreationModel(String user, Date notificationDate, String message) {
        this.user = user;
        this.notificationDate = notificationDate;
        this.message = message;
    }

    public Date getNotificationDate() {
        return notificationDate;
    }

    public String getMessage() {
        return message;
    }

    public String getUser() {
        return user;
    }
}
