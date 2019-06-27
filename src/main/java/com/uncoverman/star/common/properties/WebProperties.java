package com.uncoverman.star.common.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author nfl
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:web.properties"})
@ConfigurationProperties(prefix = "app")
public class WebProperties {

    private ShiroProperties shiro = new ShiroProperties();
    private boolean openAopLog = true;
}
