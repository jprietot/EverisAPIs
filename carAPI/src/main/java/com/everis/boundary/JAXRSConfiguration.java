package com.everis.boundary;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
	    info = @Info(
	        title = "carAPI",
	        version = "0.0.1",
	        description = "Cars API",
	        license = @License(name = "Apache 2.0"),
	        contact = @Contact(name = "Juan Jose Prieto Talavero", email = "jprietot@everis.com")
	    )
)
@ApplicationPath("/")
public class JAXRSConfiguration extends Application{
	
}
