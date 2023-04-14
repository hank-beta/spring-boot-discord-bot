package org.beta.demo.command;

import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import org.beta.demo.ChatLogRepository;
import org.beta.demo.VideoLog;
import org.beta.demo.VideoLogRepository;
import org.beta.demo.thirdparty.google.youtube.VideoResponse;
import org.beta.demo.thirdparty.google.youtube.YoutubeRequestClient;
import org.springframework.stereotype.Component;

import static org.beta.demo.command.CommandMessageDirector.sendEmbeds;

@RequiredArgsConstructor
@Component
public class SaveMusicCommand implements Commandable {
    private final VideoLogRepository videoLogRepository;
    private final YoutubeRequestClient youtubeRequestClient;

    @Override
    public void doCommand(MessageChannel channel, User user, String userMessage) {
        String videoId = userMessage.split("v=")[1];
        VideoResponse response = youtubeRequestClient.searchByVideoId(videoId);
        VideoResponse.Items item = response.getItems().get(0);
        String title = item.getSnippet().getTitle();
        String description = item.getSnippet().getDescription();

        videoLogRepository.saveAndFlush(VideoLog.create(
            videoId,
            title,
            description
        ));

        channel.sendMessage("노래가 저장되셨습니다~").queue();
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.SAVE_MUSIC;
    }
}
