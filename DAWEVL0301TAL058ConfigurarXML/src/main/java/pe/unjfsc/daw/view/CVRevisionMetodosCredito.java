package pe.unjfsc.daw.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.unjfsc.daw.entity.CECreditoProcesar;
import pe.unjfsc.daw.logical.CLCredito;

public class CVRevisionMetodosCredito {

	private static final Logger LOG = LoggerFactory.getLogger("CVRevisionMetodosCredito");
	
	public static void main(String[] args) {
		
		LOG.info("[DAW] Start CVMostrarCredito");
		
		ApplicationContext oCntx = new ClassPathXmlApplicationContext("context-credito.xml");
		LOG.info("[DAW] ApplicationContext : {}", oCntx);
		
		LOG.info("[DAW] Declarar el bean asociado a la entidad");
		
		CECreditoProcesar oCredito = oCntx.getBean("idCECreditoProcesar", CECreditoProcesar.class);
		
		LOG.info("[DAW] before : {}", oCredito);
		
		oCredito.setCargoOperacion(100);
		oCredito.setCreditoDisponible(200);
		oCredito.setCreditoProcesar(300);
		oCredito.setDisponibleRetiro(400);
		oCredito.setMoneda("s/");
		LOG.info("[DAW] after : {}", oCredito);
		
		CLCredito oResultado = oCntx.getBean("idCLCredito", CLCredito.class);
		
		double rpta = oResultado.resultadoSoles(oCredito);
		LOG.info("[DAW] Soles : {}", rpta);
		
		rpta = oResultado.resultadoNoSoles(oCredito);
		LOG.info("[DAW] No Soles : {}", rpta);
		
		((ConfigurableApplicationContext) oCntx).close();
		
	}
	
}
