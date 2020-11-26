package id.ginanjar.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class AuthenticationApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(AuthenticationApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... strings) throws Exception {
		log.info("Creating tables");
		jdbcTemplate.execute("DROP TABLE pengguna IF EXISTS");
		jdbcTemplate.execute("CREATE TABLE pengguna(" + "username VARCHAR(255), password VARCHAR (255))");
	}
}
