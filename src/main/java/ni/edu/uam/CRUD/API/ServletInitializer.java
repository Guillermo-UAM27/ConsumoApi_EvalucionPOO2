package ni.edu.uam.CRUD.API;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
    // Configura la app cuando se despliega como WAR.
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ni.edu.uam.CRUD.API.CrudApiApplication.class);
	}

}
