package com.andrey.restapp;

import com.andrey.restapp.utils.HibernateUtils;
//import com.andrey.restapp.view.UserView;

public class Main {
    public static void main(String[] args) {
        HibernateUtils.getSessionFactory();

//        UserView userView = new UserView();

//        userView.getAllUsers();
//        userView.createUser();

    }
}
