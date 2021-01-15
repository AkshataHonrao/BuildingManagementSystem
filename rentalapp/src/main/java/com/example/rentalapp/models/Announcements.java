package com.example.rentalapp.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Announcements {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int announcementId;

    @NotNull(message="Announcement cannot be null")
    @NotEmpty(message="Announcement cannot be empty")
    private String announcementContent;

    public int getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(int announcementId) {
        this.announcementId = announcementId;
    }

    public String getAnnouncementContent() {
        return announcementContent;
    }

    public void setAnnouncementContent(String announcementContent) {
        this.announcementContent = announcementContent;
    }

    public LocalDateTime getCreatedat() {
        return createdat;
    }

    public void setCreatedat(LocalDateTime createdat) {
        this.createdat = createdat;
    }

    @Column(name = "created_at")
    private LocalDateTime createdat;

    @PrePersist
    public void prePersist() {
        createdat = LocalDateTime.now();
    }
}
