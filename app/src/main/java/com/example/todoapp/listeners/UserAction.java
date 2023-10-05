package com.example.todoapp.listeners;

import com.example.todoapp.model.User;

public interface UserAction {

    void onCardClick(User item, int index);
}
