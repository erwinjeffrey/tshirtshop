package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import springfox.documentation.spring.web.plugins.Docket;


@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
   public Docket api(){
       return new Docket(DocumentationType.SWAGGER_2)
               .select()
               .apis(RequestHandlerSelectors.basePackage("com.turing.tshirtshop.controller"))
               .paths(PathSelectors.regex("/.*"))
               .build()
               .apiInfo(apiEndPointsInfo());
   }

   private ApiInfo apiEndPointsInfo(){

      /* return new ApiInfo(
               "Turing ECommerce API",
               "",
               "",
               "",
               new Contact("","",""),
               "","", Collections.emptyList()


       );*/
      return new ApiInfoBuilder().title("Spring Boot Rest API")
               .description("Ecommerce Rest API")
               .contact(new Contact("Erwin Bastardo","","erwinjefly@gmail.com"))
               .build();
   }
}
