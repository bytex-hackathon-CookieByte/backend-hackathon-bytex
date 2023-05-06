package ro.fiipractic.hackathon.jobyfier.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class OpenApi {

    @Bean
    public OpenAPI customOpenAPI(@Value("${application-description}") String appDescription,
                                 @Value("${application-version}") String appVersion) {
        return new OpenAPI()
                .info(new Info()
                        .title("JOBIFY REST API")
                        .version(appVersion)
                        .description(appDescription));
    }
}