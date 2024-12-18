package com.example.camundaproject.util;

import com.example.camundaproject.entity.Task;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigValueFactory;

import java.util.List;

public interface ConfigProvider {
    static final String CHILD_QUEUE_TASK = "CHILD_QUEUE_TASK";

    static Config createChildDayConf(long id, String title, String description) {
        Config config = ConfigFactory.empty()
                .withValue("id", ConfigValueFactory.fromAnyRef(id))
                .withValue("title", ConfigValueFactory.fromAnyRef(title))
                .withValue("description", ConfigValueFactory.fromAnyRef(description));
        return config;
    }
    static Config readChildDayConf(String msg) {
        Config config = ConfigFactory.parseString(msg);
        return config;
    }

}
