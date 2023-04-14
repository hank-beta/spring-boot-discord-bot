package org.beta.demo.handler;

import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.beta.demo.ChatLog;
import org.beta.demo.ChatLogRepository;
import org.beta.demo.command.CommandHolder;
import org.beta.demo.command.CommandType;
import org.beta.demo.utils.BotEventUtils;
import org.springframework.stereotype.Service;


import java.util.Arrays;

@RequiredArgsConstructor
@Service
public class MessageReceiveHandler extends ListenerAdapter {
    private final CommandHolder holder;
    private final ChatLogRepository chatLogRepository;

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (BotEventUtils.isBot(event)) {
            return;
        }

        String message = BotEventUtils.extractRawMessage(event);

        chatLogRepository.saveAndFlush(ChatLog.create(
                event.getAuthor().getName(),
                event.getAuthor().getId(),
                message,
                event.getMessage().getTimeCreated().toLocalDateTime()
        ));


        if (message.startsWith("+play")) {
            playPrefixProcess(event, message);
            return;
        }

        String userMessage = message.substring(2);
        String[] splitedUserMessage = userMessage.split(" ");
        String[] stringWithoutCommand = Arrays.copyOfRange(splitedUserMessage, 1, splitedUserMessage.length);
        String command = splitedUserMessage[0];

        CommandType commandType = CommandType.from(command);
        String optionCommand = String.join(" ", stringWithoutCommand);
        String optionMessage = optionCommand.length() > 0 ? optionCommand : command;

        holder.getCommandableMap()
                .get(commandType)
                .doCommand(event.getChannel(), event.getAuthor(), String.join(" ", optionMessage));
    }

    private void nonePrefixProcess(MessageReceivedEvent event, String message) {
        CommandType reactionCommand = CommandType.from(message);
        holder.getCommandableMap().get(reactionCommand).doCommand(event.getChannel(), event.getAuthor(), message);
    }

    private void playPrefixProcess(MessageReceivedEvent event, String message) {
        String[] messageList = message.split(" ");
        String command = messageList[0];
        String videoUrl = messageList[1];
        CommandType saveMusicCommand = CommandType.from(command);

        holder.getCommandableMap().get(saveMusicCommand).doCommand(event.getChannel(), event.getAuthor(), videoUrl);
    }
}
