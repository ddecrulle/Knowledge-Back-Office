package fr.insee.knowledge.configuration;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;

import java.util.Arrays;
import java.util.stream.StreamSupport;

@Slf4j
public class PropertiesLogger implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesLogger.class);

    @Override
    public void onApplicationEvent(@NonNull ApplicationEnvironmentPreparedEvent event) {
        final Environment env = event.getEnvironment();
        LOGGER.info("====== Environment and configuration ======");
        LOGGER.info("Active profiles: {}", Arrays.toString(env.getActiveProfiles()));
        final MutablePropertySources sources = ((AbstractEnvironment) env).getPropertySources();
        StreamSupport.stream(sources.spliterator(), false)
                .filter(ps -> ps instanceof EnumerablePropertySource)
                .map(ps -> ((EnumerablePropertySource) ps).getPropertyNames())
                .flatMap(Arrays::stream)
                .distinct()
                .filter(prop -> !(prop.contains("credentials") || prop.contains("password")))
                .sorted()
                .forEach(prop -> LOGGER.info("{}: {}", prop, env.getProperty(prop)));
        LOGGER.info("===========================================");
    }

}
