package me.senob.java8study.optional;

import java.time.Duration;

public class Progress {

    private boolean finished;

    private Duration studyDuration;

    public Duration getStudyDuration() {
        return studyDuration;
    }

    public void setStudyDuration(Duration studyDuration) {
        this.studyDuration = studyDuration;
    }
}
