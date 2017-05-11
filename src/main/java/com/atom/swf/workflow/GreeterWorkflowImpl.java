package com.atom.swf.workflow;

import com.amazonaws.services.simpleworkflow.flow.core.Promise;
import com.atom.swf.activities.GreeterActivitiesClient;
import com.atom.swf.activities.GreeterActivitiesClientImpl;

/**
 * Created by saurabh.verma on 11/05/17.
 */
public class GreeterWorkflowImpl implements GreeterWorkflow {
    private GreeterActivitiesClient operations = new GreeterActivitiesClientImpl();

    public void greet() {
        Promise<String> name = operations.getName();
        Promise<String> greeting = operations.getGreeting(name);
        operations.say(greeting, name);
    }
}
