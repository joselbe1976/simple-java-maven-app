package com.common.pushnotifications.pushy;

public class PushyPushRequest {
	public Object data;
    public String[] registration_ids;
    public Object notification;

    public PushyPushRequest(Object data, String[] registrationIDs, Object notification) {
        this.data = data;
        this.registration_ids = registrationIDs;
        this.notification = notification;
    }
}
