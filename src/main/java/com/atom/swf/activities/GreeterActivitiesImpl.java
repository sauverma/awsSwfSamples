package com.atom.swf.activities;

/**
 * Created by saurabh.verma on 11/05/17.
 */
public class GreeterActivitiesImpl implements GreeterActivities {
    public String getName() {
        return "World!";
    }

    public String getGreeting(String name) {
        return "Hello " + name;
    }

    public void say(String greeting, String name) {
        System.out.println(greeting + name);
    }
}
