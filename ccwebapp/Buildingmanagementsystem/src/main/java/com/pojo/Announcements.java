package com.pojo;

import javax.persistence.Entity;



import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Announcements {
    public int getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(int announcementId) {
        this.announcementId = announcementId;
    }

    public LocalDateTime getCreatedat() {
        return createdat;
    }

    public void setCreatedat(LocalDateTime createdat) {
        this.createdat = createdat;
    }

    public String getAnnouncementContent() {
        return announcementContent;
    }

    public void setAnnouncementContent(String announcementContent) {
        this.announcementContent = announcementContent;
    }

    public Announcements() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int announcementId;

    @NotNull(message="Announcement cannot be null")
    @NotEmpty(message="Announcement cannot be empty")
    private String announcementContent;

    @Column(name = "created_at")
    private LocalDateTime createdat;

    @PrePersist
    public void prePersist() {
        createdat = LocalDateTime.now();
    }
}