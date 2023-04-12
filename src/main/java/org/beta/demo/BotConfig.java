package org.beta.demo;

import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.beta.demo.handler.MessageReceiveHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.security.auth.login.LoginException;

@Configuration
public class BotConfig {

    private final String botKey;
    private final MessageReceiveHandler messageReceiveHandler;

    public BotConfig(@Value("${app.bot_key}") String botKey, MessageReceiveHandler messageReceiveHandler) {
        this.botKey = botKey;
        this.messageReceiveHandler = messageReceiveHandler;
    }

    @PostConstruct
    public void init() {
        try {
            JDABuilder
                    .createDefault(botKey)
                    .enableIntents(GatewayIntent.GUILD_MESSAGES)
                    .setActivity(Activity.playing("JAVA"))
                    .addEventListeners(messageReceiveHandler)
                    .build();
        } catch (LoginException e) {
            e.printStackTrace();
        }

    }
}
