package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//Annotations used for manual approach
//@ComponentScan
//@EnableAutoConfiguration
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    //manual style which starts the application AND KEEPS it running
   /* public static void main(String[] args) {

        LOGGER.info("INIT CONTEXT");
//        CREATE SPRING -CAMEL CONTEXT(PROPERTIES REPLACEMENT, AUTOLOADING COMPONENTS,...)
        ConfigurableApplicationContext cAC = SpringApplication.run(RebeatPrototype.class, args);
        CamelSpringBootApplicationController cSACC = cAC.getBean(CamelSpringBootApplicationController.class);

//        START APPLICATION
        LOGGER.info("START MAIN THREAD");
        cSACC.blockMainThread();
    }
    */
}
