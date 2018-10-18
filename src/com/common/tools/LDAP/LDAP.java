package com.common.tools.LDAP;

import java.io.IOException;

import org.apache.directory.api.ldap.model.exception.LdapException;
import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.ldap.client.api.LdapNetworkConnection;
import com.common.config.ParamsApp;
import com.common.tools.interfaces.iDisposable;

public class LDAP implements iDisposable {

	// Creating the LDAP connection.
		LdapConnection conexion = null;

		// constructor
		public LDAP() {
			// Giving the necessary params to the connection object
			this.conexion = new LdapNetworkConnection(ParamsApp.LDAP_SERVER_HOST, ParamsApp.LDAP_SERVER_PORT);
		}

		@Override
		public void Dispose() {

			// Question if connection isn't null. If true, it closes the user session.
			if (this.conexion != null) {
				try {
					this.conexion.unBind();
					this.conexion.close();
					this.conexion = null;
					
				} catch (LdapException | IOException e) {
					// Redirecting errors to external log file
					addLog("Dispose" + e.getMessage(), ParamsApp.LOG_TYPE_ERROR);
				}
			}

		}

		public Boolean login(String user, String password) {

			// Creating LDAP Connection String. This needs some params.
			String connectString = null;
			connectString = ParamsApp.LDAP_SERVER_CONNECTION_STRING;
			// It replaces the <USER> in connectString for the real user string
			String finalConnectString = connectString.replaceAll("<USER>", user);
			Boolean isOk = false;

			try {

				this.conexion.connect();
			} catch (LdapException e) {
				// error conexion al server
				addLog("login-Server Connect" + e.getMessage(), ParamsApp.LOG_TYPE_ERROR);
				return isOk;

			}
			try {
				//User Login
				this.conexion.bind(finalConnectString, password);
				
				if (this.conexion.isAuthenticated()) {
					try {
						//User Logout
						this.conexion.unBind();

					} catch (LdapException e) {
						addLog("login-User Logout" + e.getMessage(), ParamsApp.LOG_TYPE_ERROR);
					}
					try {
						//Server disconnect
						this.conexion.close();

					} catch (IOException e) {
						addLog("login-Server Disconnect" + e.getMessage(), ParamsApp.LOG_TYPE_ERROR);
					}
					isOk= true;
				}
			} catch (LdapException e) {

				addLog("login-User Login" + e.getMessage(), ParamsApp.LOG_TYPE_ERROR);
				return isOk;
			}

			return isOk;
		}

		private void addLog(String Message, int severity) {
			new ParamsApp().systemDebugExt(ParamsApp.LOG_LEVEL_SESSION, Message, severity);
		}
}
