package test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.common.config.ParamsApp;
import com.common.globalSystems.login.logonCredencialProcess;
import com.common.hibernate.classes.tinnova.hb_main_tinnova;
import com.common.tools.excel.excelGenerate;
import com.common.webservices.WebServiceMobile;
import com.common.webservices.WebServiceNotifications;
import com.portalmobile.tinnova.hb_mobile_functions_tinnova;
import com.portalmobile.tinnova.hb_mobile_functions_tinnova_absences;

public class TestDesarrollo {

	public static void main(String[] args) throws Exception {
		
		boolean testpeoplenet = true; //indica si es Peoplenet o Tinnova
		boolean tiinovaLOCAL = false; //indica si login Local o Poeplenet para Tinnova
	
		// TEST DESARROLLO PEOPLENET / TINNOVA. VERIFICA EL FUNCIONAMIENTO DE CADA SISTEMA DE FORMA RAPIDA
		
		String PeoplenetCredential = "{Meta4@JOSELBE@123456@3@3@}"; //Full PeopleNet
		String TinnovaCredentialLocal = "{Meta4@00696826H@69888690111@3@3@}";  //Tiinova + LOCAL Login
		String TinnovaCredential = "{Meta4@JOSELBE@123456@3@3@}"; //Tinnova + Peoplenet Login
		
		//WebServiceNotifications ws = new WebServiceNotifications();
		WebServiceMobile ws = new WebServiceMobile();
		
		//cargamos configuracion web service correcta
		
		ParamsApp params;
		String key = "";
		
		if (testpeoplenet) {
			params = new ParamsApp("config.properties");
			 key = ws.controlSession("", PeoplenetCredential);
		}else {
			
			if (tiinovaLOCAL) {
				params = new ParamsApp("config3.properties");
				key = ws.controlSession("", TinnovaCredentialLocal);
			}else {
				params = new ParamsApp("config2.properties");
				key = ws.controlSession("", TinnovaCredential);
			}
			 
		}
		
		
		//ws.sendPushNotification(key, "JOSELBE", "Hola Mundo backend v2");
		
		
		
		//System.out.println("\n\n Mis noticias:\n"+ws.getEssMisNoticias(key) + "\n");
		
		
		//System.out.println(ws.meta4MssExecQuery(key, "0001", ""));
		
		
	//	String excelPath= "/Users/joseluisbustosesteban/backend_java_mac/temp/012018251601867CF231ECB81548C28401C231C3BE47DC1914521693735.xls";
		
	//	String ExcelBase64 = new ParamsApp().getValueFileBase64EncodeExtension(excelPath, "xls");
		
		
		/*
		hb_main_tinnova aux = new hb_main_tinnova();
		
		String str = "ID_SOCIEDAD,ID_EMPLEADO,FEC_ALTA_EMPLEADO,NOMBRE,FEC_BAJA,APELLIDO_1,APELLIDO_2";
		List<String> cols = Arrays.asList(str.split(","));
		
		List<?> data = null;
		String SQLReal = "SELECT * FROM MBL_EMPLEADOS_LISTA";
		data  = aux.getDataSQLNativo(SQLReal);
		
		excelGenerate excel = new excelGenerate();
		System.out.println("\n\n\n" + excel.generateExcelXLSXFile(key, data, cols));
	
		*/
		
	//	System.out.println("\n\n Lista archivos :\n"+ws.meta4GetListaFilesUser(key, 0));
	//	System.out.println("\n\n Lista archivos :\n"+ws.meta4GetRealFileUser(key, 2));
	//ws.meta4SaveFileLeido(key, 2);
	//ws.meta4DelFileUser(key, 2);
	//System.out.println("\n\n Lista archivos :\n"+ws.meta4GetListaFilesUser(key, 0));
		//System.out.println(ws.getMSSMisEmpleados(key, "","", 0));
		
		
	 //	System.out.println(ws.getEssWhoIsWho(key, "", 0));
		
		//System.out.println(ws.meta4GetListaEmpleados(key, "", 0));
		
		/*
		logonCredencialProcess session = ws.userConected;
		

		hb_mobile_functions_tinnova a = new hb_mobile_functions_tinnova();
		hb_mobile_functions_tinnova b = new hb_mobile_functions_tinnova();
		
		a.GetListaEmpleados(session, "", 0);
		List<?> data1 = a.log;
		b.GetListaEmpleados(session, "", 1);
		List<?> data2 = b.log;
		
		System.out.println("\n\n Pagina 1\n");
		pinta(data1);
		System.out.println("\n\n Pagina 2\n");
		pinta(data2);
		
		*/
		
		//System.out.println("\n\n\n Data:\n" + ws.getEssMisAbsentismos(key, "", 2016));
	
		//System.out.println("\n\n\n Data:\n" + ws.addEssNewSolAbsentismo(key, "0100016", "9", "2018-01-01", "2018-01-02", "Prueba 1 Java"));
		
		//System.out.println("\n\n\n Data:\n" + ws.essDelSolAbsentismo(key, "0100016", 13));
		
		//System.out.println("\n\n\n Data:\n" + ws.getMssListaSolicAbsentPorValidar(key, "", ""));
		
		
		//System.out.println("\n\n\n Data:\n" + ws.getEssRecibosNomina(key, "", 2016));
		
		//System.out.println("\n\n\n Data:\n" + ws.essDownloadReciboNomina(key, "", "2012-12-25", "2012-12-25"));
		
		//System.out.println("\n\n\n\n Serial del Login: "+key);
		
		//ws.meta4Logout(key);
		
		//informacion usuario conectado
		//System.out.println("\n\n usuario conectado:\n"+ws.meta4GetInfoUserApp(key));
		
		// Lista de Empleados
		//System.out.println("\n\n Lista de  mis Empleados:\n"+ ws.getMSSMisEmpleados(key, "", "", 0));
		
		
		//noticias
		//System.out.println("\n\n Mis noticias:\n"+ws.getEssMisNoticias(key) + "\n");
		
	
		//Solicito Imagen
		
	//	System.out.println("\n\n Imagen noticia:\n"+ws.meta4GetImageCache("0001_news_doc_4", ""));
		
	
		
		//System.out.println("\n\n usuario conectado:\n"+ws.meta4GetListaNotificaciones(key, 0));
		//System.out.println("\n\n:\n"+ws.getEssMisNoticias(key));
		//String file = ws.meta4GetImageCache("01_news_7", "");
		//System.out.println("\n\nfoto:" + file);
		
		
		// Lista de Empleados
	//	ws.meta4GetListaEmpleados(key, "", 0);

		//System.out.println("\n\n Lista de Empleados:\n"+ws.meta4GetListaEmpleados(key, "", 0));
		
		//ficha empleado
		//System.out.println("\n\n Ficha Empleado:\n"+ws.meta4GetFichaEmpleado(key, "0100004", ""));
		
		//foto del empleado
		//System.out.println("\n\n Foto empleado :\n"+ws.meta4GetImageCache("00696826H", ""));
		

	}
	
	
private static void pinta(List<?> data) {
		
		for (int i = 0; i < data.size(); i++) {
			Map row = (Map) data.get(i);
			System.out.println( "" + i + "   - " +  row.get("ID_EMPLEADO").toString() +  "");
		}
	}

}
