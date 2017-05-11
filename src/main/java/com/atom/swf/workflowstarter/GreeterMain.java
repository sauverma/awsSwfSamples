package com.atom.swf.workflowstarter;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClient;
import com.atom.swf.workflow.GreeterWorkflowClientExternal;
import com.atom.swf.workflow.GreeterWorkflowClientExternalFactory;
import com.atom.swf.workflow.GreeterWorkflowClientExternalFactoryImpl;

/**
 * Created by saurabh.verma on 11/05/17.
 */

public class GreeterMain {

    public static void main(String[] args) throws Exception {
        ClientConfiguration config = new ClientConfiguration().withSocketTimeout(70*1000);

        String swfAccessId = System.getenv("AWS_ACCESS_KEY_ID");
        String swfSecretKey = System.getenv("AWS_SECRET_KEY");
        AWSCredentials awsCredentials = new BasicAWSCredentials(swfAccessId, swfSecretKey);

        AmazonSimpleWorkflow service = new AmazonSimpleWorkflowClient(awsCredentials, config);
        service.setEndpoint("https://swf.ap-south-1.amazonaws.com");

        String domain = "swftemp";

        GreeterWorkflowClientExternalFactory factory = new GreeterWorkflowClientExternalFactoryImpl(service, domain);
        GreeterWorkflowClientExternal greeter = factory.getClient("someID");
        greeter.greet();
    }
}