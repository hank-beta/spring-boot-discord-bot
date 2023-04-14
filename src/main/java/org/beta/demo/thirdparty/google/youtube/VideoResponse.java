package org.beta.demo.thirdparty.google.youtube;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/*
{
      "id": "ha9O-ZODvvE",
      "snippet": {
        "title": "𝑷𝒍𝒂𝒚𝒍𝒊𝒔𝒕 | 블루 아카이브 피아노 ost 모음 | Relaxing Piano Music (Blue Archive)",
        "description": "#블루아카이브 \n#피아노 \n#piano \n#playlist",
        "thumbnails": {
          "default": {
            "url": "https://i.ytimg.com/vi/ha9O-ZODvvE/default.jpg",
            "width": 120,
            "height": 90
          }
        }
      }
    }
 */
@Data
public class VideoResponse {
    private List<Items> items = new ArrayList();


    @Data
    public static class Items {
        private String id;
        private Snippet snippet;
    }


    @Data
    public static class Snippet {
        private String title;
        private String description;
        private Thumbnails thumbnails;
    }

    @Data
    public static class Thumbnails {
        @JsonAlias("defalut")
        private DefaultThumbnail defaultThumbnail;
    }

    @Data
    public static class DefaultThumbnail {
        private String url;
        private Integer width;
        private Integer height;
    }
}
