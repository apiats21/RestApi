package com.andrey.restapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "event")
public class Event {

    @Id
    private Long id;

    private Date date;

    @OneToOne(fetch = FetchType.LAZY)
    private File file;

    @JoinTable(
            name = "users_event",
            joinColumns = @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "events_id",
                    referencedColumnName = "id"
            )
    )
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


    public Event() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", file=" + file +
                '}';
    }
}
