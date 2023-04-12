package org.beta.demo.command;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import org.beta.demo.command.mylove.HelloMyLove;
import org.beta.demo.command.mylove.MyLove;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

@Component
public class MyLoveCommand implements Commandable {
    // 스테이지 저장
    private List<MyLove> stages = new ArrayList<>();
    // 유저 스테이지 저장,userId => stages Index
    private Map<String, Integer> userStageMap = new HashMap<>();

    public MyLoveCommand() {
        stages.add(new HelloMyLove());
    }

    @Override
    public void doCommand(MessageChannel channel, User user, String userMessage) {
        String userId = user.getId();
        Integer choice = null;
        Integer stageStep = 0;
        Boolean hasUserStage = userStageMap.containsKey(userId);

        // MyLove 실행 전
        try {
            choice = Integer.parseInt(userMessage);
        } catch (NumberFormatException e) {
            userStageMap.put(userId, 0);
            stages.get(0).runScenario(channel, user, choice);
            return;
        }

        if (hasUserStage) {
            stageStep = userStageMap.get(userId);
        }

        // MyLove Class 실행 구간
        MyLove mylove = stages.get(stageStep);
        mylove.runScenario(channel, user, choice);
        if (mylove.completeFinalStep()) {
            userStageMap.put(userId, stageStep + 1);
        }
        stages.get(stageStep).runScenario(channel, user, choice);

    }

    @Override
    public CommandType getCommandType() {
        return CommandType.MYLOVE;
    }
}
