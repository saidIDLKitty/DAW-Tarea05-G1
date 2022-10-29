package pe.unjfsc.daw.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.unjfsc.daw.entity.CECreditoProcesar;

public class CVMostrarCredito {

	private static final Logger LOG = LoggerFactory.getLogger("DAW-Sesion03");
	
	public static void main(String[] args) {
		
		LOG.info("[EVL] Iniciando CVContextCreditoProcesar");
		ApplicationContext oCntx = new ClassPathXmlApplicationContext("context-credito.xml");
		
		CECreditoProcesar oCredito = oCntx.getBean("idCECreditoProcesar", CECreditoProcesar.class);
		LOG.info("[EVL] Objeto Credito Procesar : " + oCredito.toString());
		
		LOG.info("[EVL] Cerrando el context : " + oCntx);
		((ConfigurableApplicationContext) oCntx).close();
		
	}
	
}