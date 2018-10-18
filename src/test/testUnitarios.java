package test;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Iterator;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.common.config.*;
import com.common.globalSystems.applyValueParams;
import com.common.globalSystems.globalToolsData;
import com.common.globalSystems.paramsSystem;
import com.common.globalSystems.login.credentialUsers;
import com.common.globalSystems.login.logonCommon;
import com.common.globalSystems.login.logonCredencialData;
import com.common.globalSystems.login.logonCredencialProcess;
import com.common.globalSystems.login.logonData;
import com.common.globalSystems.login.logonLocal;
import com.common.globalSystems.login.logonMain;
import com.common.globalSystems.login.logonMeta4;
import com.common.hibernate.HibernateUtil;
import com.common.hibernate.classes.hb_dynamic_actions;
import com.common.hibernate.classes.hb_main;
import com.common.meta4.meta4ImagesCache;
import com.common.pushnotifications.Parse.parseOperations;
import com.common.tools.DatesTools;
import com.common.tools.Imagesbase64;
import com.common.tools.cache.documentsCache;
import com.common.tools.encript.Base64Tools;
import com.common.tools.encript.encriptAES;
import com.common.tools.xml.XmlHelper;
import com.common.webservices.controller.WebController;

import static org.junit.Assert.assertNotEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)  //ejecucion por orden del nombre
public class testUnitarios {
	ParamsApp params = new ParamsApp();
	
	
	
	@Before
	public void setUp() throws Exception {
	}

	// Controlamos algunos parametros que deben estar rellenos ----
	@Test
	public void testParams1() {
		assertNotNull("Directorio cache no parametrizado",ParamsApp.SYSTEM_CACHE_DIRECTORY);
	}
	
	@Test
	public void testParams2() {
		assertNotNull("Servidor meta4 no parametrizado",ParamsApp.META4_WEB_SERVER);
	}

	@Test
	public void testParams3() {
		assertNotNull("Servidor ID no parametrizado",ParamsApp.SYSTEM_SERVER_ID);
	}
	
	@Test
	public void testParams4() {
		assertNotNull("Servidor ID no parametrizado",ParamsApp.SYSTEM_SSOO);
	}
	
	
	
	// Test de hibernate ----------------------------------------------
	public hb_main hb = new hb_main();
	
	@Test
	public void testHibernateSession1() {
		 assertNotNull("Sesion Hibernate Incorrecta",hb);
	}
	
	@Test
	public void testHibernateSession2() {
		 assertTrue("Sesion esta cerrada y debe estar abierta",hb.isOpen());
	}
	
	@Test
	public void testHibernateSession3() {
		hb.controlClose();
		 assertFalse("La sesion debe estar Cerrada",hb.isOpen());
	}	
	
	
	@Test
	public void testHibernateSession4() {
		hb.controlOpen();
		 assertTrue("Sesion esta cerrada y debe estar abierta",hb.isOpen());
	}
	
	@Test
	public void testHibernateSession5() {
		hb.close_session_user();
		hb = null;
		assertNull("Hibernate object debe ser null",hb);
	}
	
	
	
	// --- test clases instanciacion y pruebas varias de auxiliares
	
	
	@Test
	public void testAuxiliarObjects1() {
		documentsCache obj = new documentsCache();
		assertNotNull("Objeto documentsCache no debe ser nulo",obj);
	}
	
	@Test
	public void testAuxiliarObjects2() {
		applyValueParams obj = new applyValueParams();
		assertNotNull("Objeto applyValueParams no debe ser nulo",obj);
	}
	
	@Test
	public void testAuxiliarObjects3() {
		globalToolsData obj = new globalToolsData();
		assertNotNull("Objeto globalToolsData no debe ser nulo",obj);
	}
	
	@Test
	public void testAuxiliarObjects4() {
		paramsSystem obj = new paramsSystem();
		assertNotNull("Objeto paramsSystem no debe ser nulo",obj);
	}
	
	@Test
	public void testAuxiliarObjects5() {
		credentialUsers obj = new credentialUsers();
		assertNotNull("Objeto credentialUsers no debe ser nulo",obj);
	}
	
	@Test
	public void testAuxiliarObjects6() {
		logonCommon obj = new logonCommon();
		assertNotNull("Objeto logonCommon no debe ser nulo",obj);
	}
	
	@Test
	public void testAuxiliarObjects7() {
		logonCredencialData obj = new logonCredencialData();
		assertNotNull("Objeto logonCredencialData no debe ser nulo",obj);
	}
	
	@Test
	public void testAuxiliarObjects8() {
		logonCredencialProcess obj = new logonCredencialProcess();
		assertNotNull("Objeto logonCredencialProcess no debe ser nulo",obj);
	}
	
	@Test
	public void testAuxiliarObjects9() {
		logonCredencialProcess obj = new logonCredencialProcess();
		assertEquals("Credenciales debe ser 0",obj.getCount(),0);
	}
	
	@Test
	public void testAuxiliarObjects10() {
		logonData obj = new logonData();
		assertNotNull("Objeto logonData no debe ser nulo",obj);
	}
	
	@Test
	public void testAuxiliarObjects11() {
		logonLocal obj = new logonLocal();
		assertNotNull("Objeto logonLocal no debe ser nulo",obj);
	}
	
	@Test
	public void testAuxiliarObjects12() {
		logonMain obj = new logonMain();
		assertNotNull("Objeto logonMain no debe ser nulo",obj);
	}
	
	@Test
	public void testAuxiliarObjects13() {
		logonMeta4 obj = new logonMeta4();
		assertNotNull("Objeto logonMeta4 no debe ser nulo",obj);
	}
	
	@Test
	public void testAuxiliarObjects14() {
		meta4ImagesCache obj = new meta4ImagesCache();
		assertNotNull("Objeto meta4ImagesCache no debe ser nulo",obj);
	}
	
	@Test
	public void testAuxiliarObjects15() {
		meta4ImagesCache obj = new meta4ImagesCache();
		assertEquals("Base64 de la imagen no debe existir. Debe ser cadena vacia",obj.getImageEmpleadoBase64("jlsdaskdja"),"");
	}
	
	@Test
	public void testAuxiliarObjects16() {
		parseOperations obj = new parseOperations();
		assertNotNull("Objeto parseOperations no debe ser nulo",obj);
	}
	
	@Test
	public void testAuxiliarObjects17() {
		Base64Tools obj = new Base64Tools();
		assertNotNull("Objeto Base64Tools no debe ser nulo",obj);
	}
	
	@Test
	public void testAuxiliarObjects18() throws Exception {
		Base64Tools obj = new Base64Tools();
		String aux = obj.encode_string("test");
		String aux2 = obj.decode_string(aux);
		assertEquals("Codificacion/Decodicicacion Base64 erronea",aux2,"test");
	}

	@Test
	public void testAuxiliarObjects19() throws Exception {
		Base64Tools obj = new Base64Tools();
		String aux = obj.encode_string("camión&");
		String aux2 = obj.decode_string(aux);
		assertEquals("Codificacion/Decodicicacion Base64 erronea",aux2,"camión&");
	}
	
	@Test
	public void testAuxiliarObjects20() {
		DatesTools obj = new DatesTools();
		assertNotNull("Objeto DatesTools no debe ser nulo",obj);
	}
	
	@Test
	public void testAuxiliarObjects21() {
		encriptAES obj = new encriptAES();
		assertNotNull("Objeto encriptAES no debe ser nulo",obj);
	}
	
	@Test
	public void testAuxiliarObjects22() {
		Imagesbase64 obj = new Imagesbase64();
		assertNotNull("Objeto Imagesbase64 no debe ser nulo",obj);
	}
	
	@Test
	public void testAuxiliarObjects23() {
		XmlHelper obj = new XmlHelper();
		assertNotNull("Objeto XmlHelper no debe ser nulo",obj);
	}
	
	@Test
	public void testController01() {
		WebController obj = new WebController();
		assertNotNull("Objeto WebController no debe ser nulo",obj);
	}
	
	@Test
	public void testController02() {
		WebController obj = new WebController();
		assertNotNull("Objeto getUserActives no debe devolver ser nulo",obj.getUserActives());
	}
	
	
	
	// New Test Sever 2.0.0
	@Test
	public void testParamsV2M01() {
		assertNotNull("JobScheduler Indicator not should be null",ParamsApp.JOBSCHEDULER_ACTIVATE);
	}
	@Test
	public void testParamsV2M02() {
		assertNotNull("JobScheduler Frecuency not should be null",ParamsApp.JOBSCHEDULER_FRECUENCY);
	}	
	@Test
	public void testParamsV2M03() {
		assertNotNull("Service Executor Max not should be null",ParamsApp.SERVICE_EXECUTOR_MAX_EXECUTORS);
		assertNotNull("Service Executor Max not should be null",ParamsApp.SERVICE_EXECUTOR_DELAY_TIME);
		assertNotNull("Service Executor Max not should be null",ParamsApp.SERVICE_EXECUTOR_DEBUG);
	}		
	
}
