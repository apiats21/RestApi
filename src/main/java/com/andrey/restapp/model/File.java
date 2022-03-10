package com.andrey.restapp.model;

import javax.persistence.*;

@Entity
@Table(name = "files")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "filename")
    private String fileName;

    @JoinTable(
            name = "event_file",
            joinColumns = @JoinColumn(
                    name = "event_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "file_id",
                    referencedColumnName = "id"
            )
    )
    @OneToOne(fetch = FetchType.LAZY)
    private Event event;

    public File() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", fileName=" + fileName +
                '}';
    }
}
