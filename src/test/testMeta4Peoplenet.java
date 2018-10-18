package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.common.globalSystems.login.logonMeta4;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)  //ejecucion por orden del nombre
public class testMeta4Peoplenet {

	logonMeta4 meta4 = new logonMeta4("3","","");
	String key= "";
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMeta401() {
		 this.key = meta4.logonSystem("JOSELBE", "JOSELBE", "123456");
		 assertNotEquals("Login Erroneo a Meta4",key,"");
	}

	@Test
	public void testMeta402() {
		
		 assertFalse("Echo to Meta4 Error",meta4.echoToSystemExternal(key));
	}
	
	@Test
	public void testMeta403() {
		meta4.logout(key);
	}
	
	
}
