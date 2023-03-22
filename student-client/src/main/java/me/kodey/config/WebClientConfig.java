package me.kodey.config;

import me.kodey.service.StudentClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient studentsWebClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:8080")
                .build();
    }

    @Bean
    public StudentClientService studentClientService() {
        return HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(studentsWebClient()))
                .build()
                .createClient(StudentClientService.class);
    }
}
