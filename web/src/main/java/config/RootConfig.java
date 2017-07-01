package config;

import configuration.ServiceConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by User on 29.06.2017.
 */
@Configuration
@Import(ServiceConfig.class)
@ComponentScan
public class RootConfig {
}
