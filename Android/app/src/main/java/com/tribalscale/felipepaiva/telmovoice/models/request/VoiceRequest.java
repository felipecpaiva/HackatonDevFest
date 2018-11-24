package com.tribalscale.felipepaiva.telmovoice.models.request;

public class VoiceRequest {

    private String data;

    private String text = "balance";

    private String id;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
