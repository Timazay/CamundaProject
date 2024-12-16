package com.example.camundaproject.util;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigValueFactory;

import java.util.List;

public interface ConfigProvider {
    static final String CHILD_QUEUE_TASK = "CHILD_QUEUE_TASK_";

    static Config createChildDayConf(String title, String description) {
        Config config = ConfigFactory.empty()
                .withValue("title", ConfigValueFactory.fromAnyRef(title))
                .withValue("description", ConfigValueFactory.fromAnyRef(description));
        return config;
    }

}
