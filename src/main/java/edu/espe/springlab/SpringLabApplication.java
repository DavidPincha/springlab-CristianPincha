package edu.espe.springlab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
//public class SpringLabApplication {
//	public static void main(String[] args) {
		//SpringApplication.run(SpringLabApplication.class, args);
	//}
//}


@SpringBootApplication
public class SpringLabApplication {

    public static void main(String[] args) {
        // FORZAR UN FALLO PARA PROBAR EL ROLLBACK
        // Esta línea hará que el deploy en Render falle, pero los tests pasarán.
        throw new RuntimeException("Fallo de despliegue forzado para probar el rollback");

        // La aplicación nunca llegará a esta línea
        // SpringApplication.run(SpringlabApplication.class, args);
    }
}