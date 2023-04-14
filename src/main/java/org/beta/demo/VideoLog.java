package org.beta.demo;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Entity
public class VideoLog {
    @Id
    private String videoId;
    private String title;
    @Column(length=10000)
    private String description;

    public static VideoLog create(String videoId, String title, String description) {
        VideoLog videoLog = new VideoLog();
        videoLog.videoId = videoId;
        videoLog.title = title;
        videoLog.description = description;
        return videoLog;
    }
}
