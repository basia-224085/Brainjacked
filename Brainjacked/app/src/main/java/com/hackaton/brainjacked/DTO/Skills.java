package com.hackaton.brainjacked.DTO;

public class Skills {
    Emotion emotion;

    public Skills() {
    }

    public Skills(Emotion emotion) {
        this.emotion = emotion;
    }

    public Emotion getEmotion() {
        return emotion;
    }

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }
}
