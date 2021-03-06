package pe.gob.igp.almacen;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class AlmacenApplicationTests {

	Logger logger = LoggerFactory.getLogger(AlmacenApplicationTests.class);

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	void contextLoads() {
		String clave = "secret";
		String claveEncriptada = encoder.encode(clave);
		//$2a$10$dbAnQXcVvSdCBmAREoItCek3SPt3ey4Lz9/V3dMZ02QDS/M0QpD0q


		//throw url for monitoring app http://localhost:8080/actuator/health
	}

}
