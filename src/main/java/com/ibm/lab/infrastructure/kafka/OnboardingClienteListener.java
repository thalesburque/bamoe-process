package com.ibm.lab.infrastructure.kafka;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.kie.kogito.process.Process;
import org.kie.kogito.process.ProcessInstance;
import org.kie.kogito.process.Processes;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.lab.Onboard_clienteModel;

import io.smallrye.reactive.messaging.annotations.Blocking;

@ApplicationScoped
public class OnboardingClienteListener {

    @Inject
    Processes processes;

    @Inject
    ObjectMapper objectMapper;

    //@Incoming("onboarding-client")
    //@Blocking
    public void onMessage(String message) {
        try {
            // Parse the JSON message into a JsonNode
            JsonNode eventData = objectMapper.readTree(message);

            // Convert the JSON to an OnboardingCliente object
            Onboard_clienteModel onboardingClienteModel = objectMapper.treeToValue(eventData, Onboard_clienteModel.class);

            // Retrieve the specific process by ID
            Process<?> process = processes.processById("bamoe_process.onboard_cliente");

            if (process != null) {
                // Create a new process instance with the OnboardingCliente object
                ProcessInstance<?> processInstance = process.createInstance(onboardingClienteModel);

                // Start the process instance
                processInstance.start();

                if (processInstance.status() == ProcessInstance.STATE_ERROR) {
                    // Handle error state if needed
                    System.err.println("Error starting process instance: " + processInstance.error());
                }
            } else {
                System.err.println("Process with ID 'onboard_cliente' not found");
            }

        } catch (Exception e) {
            // Handle exception
            e.getMessage();
        }
    }
}
