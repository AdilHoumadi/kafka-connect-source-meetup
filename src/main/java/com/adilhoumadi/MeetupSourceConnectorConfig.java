package com.adilhoumadi;

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;

import java.util.Map;

public class MeetupSourceConnectorConfig extends AbstractConfig {

    private static final String TOPIC_CONFIG = "topic";
    private static final String TOPIC_DOC = "Topic where data will be pushed.";

    public MeetupSourceConnectorConfig(Map<String, String> props) {
        this(newConf(), props);
    }

    public MeetupSourceConnectorConfig(ConfigDef definition, Map<?, ?> originals) {
        super(definition, originals);
    }

    public static ConfigDef newConf() {
        return new ConfigDef()
                .define(TOPIC_CONFIG, ConfigDef.Type.STRING, ConfigDef.Importance.HIGH, TOPIC_DOC);
    }

    public String getTopic() {
        return this.getString(TOPIC_CONFIG);
    }
}
