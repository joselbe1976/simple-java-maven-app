package com.common.saas;

import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;

import com.common.globalSystems.login.logonCommon;
import com.common.hibernate.classes.hb_users;
import com.common.hibernate.classes.tinnova.hb_dynamic_actions;
import com.common.hibernate.entidades.VinUsers;
import com.common.saas.hibernate.hb_main_server;

public class saas_login_operations extends hb_main_server {

	
	
	//Constructor
	public saas_login_operations() {
		
	}
	
	
	// Functions
	public void updateUserDataSaas(String IdEmployee, String idOrganization, String userLocal) {
		
		hb_users usrDB;
		logonCommon comTool;
		VinUsers usr;
		VinUsers usrAux;
		SQLQuery query = null;
		List<?> data = null;
		
		try {
				//get connected user
				String localUser =  userLocal;
				usrDB = new hb_users();
				usrAux =  usrDB.getUser(localUser); //get the MySql User
				
				if (usrAux == null) {
					//not exist usser in MYSQL Local
					comTool = new logonCommon();
					comTool.autoGenUserExternal(localUser, "Meta4"); 
					usrAux =  usrDB.getUser(localUser); 
				}
				
				String IdSoc   = idOrganization;
				String idEmp = IdEmployee;

				usrAux = null;
				
				
				//Find Employee as Id Legal by this DataBase View
				String SQL = "SELECT id_organization, id_employee, nm_employee, ssn_employee,  dt_start, dt_end, active from global_employees  where id_organization = :Idsoc and id_employee = :idEmployee and active = :active";
				query  = getSqlQuery(SQL);
				query.setParameter("Idsoc", IdSoc);
				query.setParameter("idEmployee", idEmp);
				query.setParameter("active", 1); //Filter by active == 1
				
				data = this.getDataFromQuery(query);
				
				
				// have data, employee exist by Id Legal
				if (data.size() > 0) {
					Map row = (Map)data.get(0); //Extract the row
				
					// Update in MySql (Users)
					usr =  usrDB.getUser(localUser);
					if (usr != null) {
						
						usr.setUserName(row.get("nm_employee").toString());
						usr.setNif(row.get("ssn_employee").toString()); //NIF
						usr.setIdEmpleadoRrhh(row.get("id_employee").toString());
						usr.setFaseAltaRrhh(row.get("dt_start").toString());
						usr.setIdOrganization(row.get("id_organization").toString());
						usr.setComment("Update Data from Saas Data Employee");
						usr.setBloq(0); //Unlock
						
						//Save
						usrDB.updateRecord(usr);
						
					}
					
				}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			usrDB=null;
			comTool=null;
			usr=null;
			usrAux=null;
			query = null;
		}
	}
	

	
}
