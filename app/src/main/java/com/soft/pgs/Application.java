package com.soft.pgs;

import org.eclipse.paho.client.mqttv3.*;

public class Application implements MqttCallback {

    private MqttClient client;

    private static final String SUBSCRIBER_URI= "mqtt.subscriber_uri";
    private static final String SUBSCRIBER_CLIENT_ID = "mqtt.subscriber_client_id";
    private static final String SUBSCRIBER_TOPIC = "mqtt.subscriber_topic";

    private Application() {}

    public static void main(String[] args) {
        new Application().run();
    }

    private void run() {
        Utils.loadProperties();

        String subscriberUri = System.getProperty(SUBSCRIBER_URI);
        String subscriberClientId = System.getProperty(SUBSCRIBER_CLIENT_ID);
        String subscriberTopic = System.getProperty(SUBSCRIBER_TOPIC);

        try {
            client = new MqttClient(subscriberUri, subscriberClientId);
            client.connect();
            client.setCallback(this);
            client.subscribe(subscriberTopic);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void connectionLost(Throwable throwable) {

    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        System.out.println(mqttMessage);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}

