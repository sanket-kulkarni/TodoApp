package com.eldmandate.todoapp.listeners;

import com.eldmandate.todoapp.model.User;

public interface UserAction {

    void onCardClick(User item, int index);
}
