package org.beta.demo.thirdparty.google.youtube;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Service
public class YoutubeRequestClient {
    @Value("${app.youtube.api.key}")
    private String apiKey;

    @Value("${app.youtube.api.video.url}")
    private String requestUrl;

    public VideoResponse searchByVideoId(String videoId) {
        RestTemplate template = new RestTemplate();
        URI uri = UriComponentsBuilder.fromHttpUrl(requestUrl)
                .queryParam("id", videoId)
                .queryParam("part", "snippet")
                .queryParam("key", apiKey)
                .build().toUri();

        return template.getForObject(uri, VideoResponse.class);
    }




}
