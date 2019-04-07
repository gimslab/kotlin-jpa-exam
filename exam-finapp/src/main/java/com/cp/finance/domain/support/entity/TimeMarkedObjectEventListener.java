package com.cp.finance.domain.support.entity;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Component
public class TimeMarkedObjectEventListener {

    @PrePersist
    public void setCreatedAt(TimeMarkedObject timeMarkedObject) {
        DateTime now = new DateTime();
        timeMarkedObject.setCreatedAt(now);
        timeMarkedObject.setModifiedAt(now);
    }

    @PreUpdate
    public void setModifiedAt(TimeMarkedObject timeMarkedObject) {
        DateTime now = new DateTime();
        timeMarkedObject.setModifiedAt(now);
    }
}
