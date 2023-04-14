package org.beta.demo;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
public class ChatLog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String userId;

    @Column(length = 10000)
    private String rawMessage;
    private LocalDateTime receiveDateTime;

    public static ChatLog create(String username, String userId, String rawMessage, LocalDateTime receiveDateTime) {
        ChatLog chatLog = new ChatLog();
        chatLog.username = username;
        chatLog.userId = userId;
        chatLog.rawMessage = rawMessage;
        chatLog.receiveDateTime = receiveDateTime;
        return chatLog;
    }
}
