package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Lino on 25.06.2017.
 */
@Configuration
@ComponentScan(basePackages = "controller")
@EnableWebMvc
@Import(ThymeleafConfig.class)
public class WebConfig {

}
