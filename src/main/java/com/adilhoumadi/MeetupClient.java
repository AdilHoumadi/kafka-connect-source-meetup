package com.adilhoumadi;

import com.adilhoumadi.meetup.Event;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.reactivex.netty.protocol.http.client.HttpClient;
import io.reactivex.netty.protocol.http.client.HttpClientResponse;
import rx.Observable;
import rx.observables.StringObservable;

import java.io.IOException;
import java.util.Objects;

import static java.nio.charset.StandardCharsets.UTF_8;

public class MeetupClient {

    private static final String MEETUP_DOMAIN = "stream.meetup.com";
    private static final String MEETUP_OPEN_EVENT = "/2/open_events";
    private static final int MEETUP_PORT = 80;

    public Observable<Event> pollEvent() {
        final Observable<String> chunks = HttpClient
                .newClient(MEETUP_DOMAIN, MEETUP_PORT)
                .createGet(MEETUP_OPEN_EVENT)
                .flatMap(HttpClientResponse::getContent)
                .take(5)
                .map(bb -> bb.toString(UTF_8));
        return StringObservable.byLine(chunks)
                .map(MeetupClient::parseEventJson)
                .filter(Objects::nonNull);
    }

    private static Event parseEventJson(String jsonStr) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonStr, Event.class);
        } catch (IOException e) {
            return null;
        }
    }
}
