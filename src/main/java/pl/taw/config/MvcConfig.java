/**
 * Created by tomasz_taw
 * Date: 07.11.2023
 * Time: 14:36
 * Project Name: memotrGame
 * Description:
 */
package pl.taw.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/board").setViewName("board");
    }
}
