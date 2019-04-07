package com.cp.finance.domain.support.entity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class MarkedObjectEventListener {
    @PrePersist
    public void setCreatedAt(Object entity) {
        if (entity instanceof MarkedObject) {
            MarkedObject markedObject = (MarkedObject) entity;
            if (markedObject.isIgnoreModified()) {
                return;
            }
            markedObject.setCreatedBy("test");
            markedObject.setModifiedBy("test");
        }
    }

    @PreUpdate
    public void setUpdateAt(Object entity) {
        if (entity instanceof MarkedObject) {
            MarkedObject markedObject = (MarkedObject) entity;
            if (markedObject.isIgnoreModified()) {
                return;
            }
            markedObject.setModifiedBy("test");
        }
    }
}
