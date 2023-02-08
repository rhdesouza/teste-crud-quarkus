package org.rh.test.infrastructure.conf;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.core.Application;
@OpenAPIDefinition(
        info = @Info(
                title="Exemplo de Api com Quarkus",
                version = "1.0.1",
                contact = @Contact(
                        name = "GitHub",
                        url = "https://github.com/rhdesouza",
                        email = "rhdesouza@hotmail.com"),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html"))
)
public class SwaggerConfig extends Application {
}
