package com.adilhoumadi;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.source.SourceConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeetupSourceConnector extends SourceConnector {

    private static final Logger LOG = LoggerFactory.getLogger(MeetupSourceConnector.class);
    private MeetupSourceConnectorConfig config;
    private Map<String, String> configProps;

    public MeetupSourceConnector() {
        // Nothing to do
    }

    // For testing
    public MeetupSourceConnector(MeetupSourceConnectorConfig config) {
        this.config = config;
    }

    @Override
    public void start(Map<String, String> props) {
        config = new MeetupSourceConnectorConfig(props);
        configProps = new HashMap<>(props);
        LOG.info("Starting Meetup source connector");
    }

    @Override
    public Class<? extends Task> taskClass() {
        return MeetupSourceTask.class;
    }

    @Override
    public List<Map<String, String>> taskConfigs(int maxTasks) {
        Map<String, String> taskProps = new HashMap<>(configProps);
        List<Map<String, String>> taskConfigs = new ArrayList<>(maxTasks);
        for (int i = 0; i < maxTasks; i++) {
            taskConfigs.add(taskProps);
        }
        return taskConfigs;
    }


    @Override
    public ConfigDef config() {
        return MeetupSourceConnectorConfig.newConf();
    }

    @Override
    public void stop() {
        LOG.info("Shutting down Meetup source connector");
    }

    @Override
    public String version() {
        return MeetupVersion.getCurrentVersion();
    }
}
