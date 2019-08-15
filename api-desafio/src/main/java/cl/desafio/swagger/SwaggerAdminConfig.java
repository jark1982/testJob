package cl.desafio.swagger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerAdminConfig {

    /**
     * Controller filter package to expose in swagger.
     */
    public static final String CONTROLLER = "cl.desafio.controller";

    /**
     * Default Contact Information.
     */
    public static final String DEFAULT_CONTACT = "Juan Rios C. +56 9 7970 2192";

    /**
     * Project Version.
     */
    public static final String PROJECT_VERSION = "1.0.0";

    /**
     * SPF Title.
     */
    public static final String TITLE = "Desafio Rest";

    /**
     * Project Description.
     */
    public static final String DESCRIPTION = "Esta página lista todas las REST API para " + TITLE;

    /**
     * Default Format.
     */
    protected static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<>(
            Arrays.asList("application/json"));

    /**
     * ApiInfo with all atributes to show Swagger endpoints for service.
     *
     * @return ApiInfo
     */
    protected ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(TITLE).description(DESCRIPTION).version(PROJECT_VERSION)
                .build();
    }

    /**
     *
     * Seagger bean enable.
     *
     * @return Docket
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES).select()
                .apis(RequestHandlerSelectors.basePackage(CONTROLLER))
                .build()
                .directModelSubstitute(java.time.LocalDate.class, java.util.Date.class)
                .directModelSubstitute(java.time.OffsetDateTime.class, java.util.Date.class)
                .apiInfo(apiInfo());
    }
    
    
   /* @Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                    .apis(RequestHandlerSelectors.basePackage(CONTROLLER))
                    .build()
                .directModelSubstitute(java.time.LocalDate.class, java.util.Date.class)
                .directModelSubstitute(java.time.OffsetDateTime.class, java.util.Date.class)
                .apiInfo(apiInfo());
    }
    */
    
       

}
