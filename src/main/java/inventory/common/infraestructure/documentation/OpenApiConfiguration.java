package inventory.common.infraestructure.documentation;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static inventory.common.application.utils.Constants.*;


@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title(TITLE)
                        .version(APP_VERSION)
                        .description(APP_DESCRIPTION)
                        .termsOfService(TERMS_OF_SERVICE)
                        .license(new License().name(NAME_LICENSE).url(URL_LICENSE)));
    }
}
