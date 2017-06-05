package com.example.bookstore.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// klasa pozwala dobrac sie do wybranej czesci Jasona
@JsonIgnoreProperties(ignoreUnknown = true)
public class LipsumDto {
    private FeedDto feed;

    public LipsumDto(@JsonProperty("fedd") FeedDto feed) {
        this.feed = feed;
    }

    public FeedDto getFeed() {
        return feed;
    }

    public static class FeedDto {
        private String lipsum;

        public FeedDto(@JsonProperty("lipsum") String lipsum){
            this.lipsum = lipsum;
        }

        public String getLipsum(){
            return lipsum;
        }
    }
}
