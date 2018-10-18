<%@include file="../globales/globalAllPages.jsp" %>
<%@include file="../login/seguridad_view_menu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.common.hibernate.classes.hb_users" %>
<%@ page import="com.common.hibernate.entidades.VinUsers" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>equilibRHa mobile</title>
<%@include file="../globales/scriptsgrids.jsp" %>
</head>
<body>

    <form id="Form1LoadMenu" action="main.jsp" method="POST" >
        <input type="hidden" id="paginaWeb" name="paginaWeb" value="url">
        <input type="hidden" id="titleOption" name="titleOption" value="nada">
        <input type="hidden" id="optLoad" name="optLoad" value="0">
    </form>


<%
	//request del menu
String pageJava="";
String titleOpt="";
String optLoad="0";
pageJava = request.getParameter("paginaWeb")==null?"":request.getParameter("paginaWeb");
titleOpt = request.getParameter("titleOption")==null?"":request.getParameter("titleOption");
optLoad = request.getParameter("optLoad")==null?"0":request.getParameter("optLoad");
String UserWebId = (String)session.getAttribute( "SessionUser");
%>



    <div id='content'>
        <script type="text/javascript">
		  var page="";
		  var reloadPageMenuClick=false; //Si se pone a True, se recarga la pagina menu.jsp cada vez que se pincha opcion.
		  var OptLoadJs = '<%=optLoad%>';

		  
			//variables globales
			var JsUIStyleCss = '<%=UIStyleCss%>'; //Estilo de la UI

            //tamaño ventanas (todas las paginas jquery)
            var anchoVentana = screen.availWidth-50;
            var altoVentana = screen.availHeight-280;
            var anchoVentanaOthers = 0;
			
		  
		 //Click de la opcion de menu. recarga la pagina	
          function menuclick(pagina, title)
          {
              if (reloadPageMenuClick == true)
              {
	              $("#paginaWeb").val(pagina);
	              $("#titleOption").val(title);
	              $("#Form1LoadMenu").submit();
              }
              else
              {
            	  $("#popupWindowLoad").jqxWindow('open');
                  loadpage(pagina, title);
                  $("#popupWindowLoad").jqxWindow('close');
              }
          }

	        
    	//carga pagina indicada en el menu (click)
		   function loadpage(pagina,title)
		        {

						
		        
		        		page = title;
				                $.post(pagina,null, 
				                        function(resp) {

				                			//Buscamosel Tab en el control y su posicion
				                			var num = $('#jqxTabs').jqxTabs('length');
											var pos = -1;
											var i = 0;
				                			for(i;i<num;i++)
					                		{
				                				if ($('#jqxTabs').jqxTabs('getTitleAt', i) == page)
					                				{
					    			 					pos = i;
					                				}
					                		}


											//-1 = no se encuentra creamos tab

											if (OptLoadJs == "1")
											{
												$('#jqxTabs').jqxTabs('removeLast'); //eliminamos (caso applyvals)
											}
											
				                			if (pos == -1)
					                		{
				                				//$('#jqxTabs').jqxTabs('removeLast');
				                				$('#jqxTabs').jqxTabs('addLast', page, resp);
						                	}
				                			else
					                		{
						                		//existe, posiciono el tab y asigno contenido	
				                				$('#jqxTabs').jqxTabs('select', pos);
				                				$('#jqxTabs').jqxTabs('setContentAt', pos, resp);  
							                }
				                        });                  
		        }				
		            

		   // Funcion de mostyrar mensaje en toda la web. Se usa desde todas las jquery pages
           function  showMensaje(texto,tipo)
           {
               //asigmno texto mensaje    
               $("#popupWindowMensajeTexto").html(texto);
               
               //Segun tipo pongo un titulo e imagen
               
               var time = 1200;
               if (tipo == 1 || tipo == null) //Informacion
               {
                   $("#popupWindowMensajeImagen").attr("src", "../../images/correct.jpg");
                   $("#popupWindowMensajeTitulo").html("Info");
               }
               else  //Error
               {
                   time = 0; //para que se pare el mensaje y no se oculte
                   $("#popupWindowMensajeImagen").attr("src", "../../images/no-error.jpg");
                   $("#popupWindowMensajeTitulo").html("Error");
               }
               
               //Abrimos la ventana
               $("#popupWindowMensaje").jqxWindow('open');
               
               //ocultamos la ventana
               if (time != 0)
               {
                   setTimeout(function() {
                       $("#popupWindowMensaje").jqxWindow('close'); //cerramos pasado el tiempo
                   }, time);
           }
           }

	        
            $(document).ready(function (){

            	chgLang('<%=viewIdioma%>'); 

            	 $("#popupWindowPassword").jqxWindow({
                     width: 350,height:170, resizable: true, theme: 'black', isModal: true, autoOpen: false, cancelButton: $("#CancelPassword"), modalOpacity: 0.6             
                 }); 
           
               $("#popupWindowLoad").jqxWindow({
                     width: 300,height:120, resizable: false,theme: 'black', isModal: true, autoOpen: false,modalOpacity: 0.1           
                 }); 
               $("#popupWindowLoad").jqxWindow({ position: { x: (anchoVentana+anchoVentanaOthers- 200) /2, y: 280 } });
               $('#popupWindowLoad').jqxWindow({ showCloseButton: false }); 


               $("#popupWindowMensaje").jqxWindow({
                     width: 370,height:160, resizable: false,theme: 'black', isModal: true, cancelButton: $("#menubuttonokmensaje"),autoOpen: false,modalOpacity: 0.1           
                 }); 
               $("#popupWindowMensaje").jqxWindow({ position: { x: (anchoVentana+anchoVentanaOthers- 370) /2, y: 280 } });
             //  $('#popupWindowMensaje').jqxWindow({ showCloseButton: false }); 

             
             
            	
                var altoVentana = screen.availHeight-200;
                
                $("#jqxMenu").jqxMenu({ width: '100%', height: '35px', theme: JsUIStyleCss});
                $('#jqxTabs').jqxTabs({ width: '100%', height: altoVentana, theme: JsUIStyleCss,showCloseButtons:true});


                var pagePost = '<%=pageJava%>';
                var TitlePost= '<%=titleOpt%>';
                
                if (pagePost != "")
                {
                    //Si pagina es de valores, asi pasamos los parametros (no hay otra forma)
                	pagePost = pagePost.replace("XXXX","?").replace("ZZZZ", "&").replace("ZZZZ", "&");
                    //reemplazamos posibles parametros.
                    loadpage(pagePost,TitlePost);
                }


                $("#iduser").jqxInput({  theme: JsUIStyleCss,width: '250px', height: '23px' });
                $("#clavenueva").jqxInput({  theme: JsUIStyleCss,width: '150px', height: '23px' });
                $("#clavenueva2").jqxInput({  theme: JsUIStyleCss,width: '150px', height: '23px' });
                $("#CancelPassword").jqxButton({ theme: 'ui-start' });
                $("#SavePassword").jqxButton({ theme: 'ui-start' });
                
                 $("#chgPasswordMenu").on('click', function () {
                            
                                  $("#popupWindowPassword").jqxWindow({ position: { x: (anchoVentana+anchoVentanaOthers- 350) /2, y: 155 } });
                                  $("#iduser").val('<%=UserWebId%>');
                                  $("#iduser").prop('disabled', true);
                                  $("#clavenueva").val('');
                                  $("#clavenueva2").val('');
                                   $("#popupWindowPassword").jqxWindow('open');
                          
                      }); 

                      
                      $("#chgPasswordImage").on('click', function () {
                            

                                  $("#popupWindowPassword").jqxWindow({ position: { x: (anchoVentana+anchoVentanaOthers- 350) /2, y: 155 } });
                                  $("#iduser").val('<%=UserWebId%>');
                                  $("#iduser").prop('disabled', true);
                                  $("#clavenueva").val('');
                                  $("#clavenueva2").val('');
                                   $("#popupWindowPassword").jqxWindow('open');
                          
                      });
                                   

              //boton Save del formulario cambio de clave
                $("#SavePassword").click(function () {
                    $('#Form').jqxValidator('validate');
                });
                
                //cuando este ok la validacion llamamos a cambio de clave
                $('#Form').jqxValidator({ onSuccess: function () { chgPassworddb(); } }); 
                
              
                //funcion que guarda de verdad.
                function chgPassworddb()
                {
                      //Ojo la validacioon de claves se hace con jquery con validaciones.

                              $.get('../admin/usuarios_save.jsp', {id_user: $("#iduser").val(),password:$("#clavenueva").val(),oper:'CHGPASSWORD'}, 
                                    function(resp) {
                                            //all finalizar mostramos el mensaje
                                            showMensaje(resp,1); 
                                    }
                                );
                              
                              $("#popupWindowPassword").jqxWindow('hide'); //ocultamos
                       
                 };
                  $('#Form').jqxValidator({
                                  //hintType: 'label',
                                  animationDuration: 500,
                                  theme: 'ui-start',
                                  rules: [
                                          //rule: 'length=3,12'    rule: 'notNumber'    
                                          { input: '#clavenueva', message: users_lista.validacion4, action: 'keyup, blur', rule: 'required' },
                                          { input: '#clavenueva', message: users_lista.validacion2(6,30), action: 'keyup, blur', rule: 'length=6,200' },
                                          { input: '#clavenueva2', message: users_lista.validacion4, action: 'keyup, blur', rule: 'required' },
                                          { input: '#clavenueva2', message: users_lista.validacion5, action: 'keyup, focus', 
                                                   rule: function (input, commit) 
                                                         {
                                                              // call commit with false, when you are doing server validation and you want to display a validation error on this field. 
                                                              if (input.val() === $('#clavenueva').val()) {
                                                                  return true;
                                                              }
                                                              return false;
                                                          } // de la funcion
                                          } //del input
                                                                         
                                       ] // de las rules
                            });                 
              
			        
                      // -------------------------------------------------------------------------------------------
		        // ToolTipText de los botones y acciones. Ojo siempre al final del Jquery.
			// -------------------------------------------------------------------------------------------                
                      
                      $("#chgPasswordImage").jqxTooltip({ content: submenu.op12, position: 'default'});
                      $("#MenulogoutClick").jqxTooltip({ content: 'Cerrar sesion', position: 'default'});                
			        
                
            });
        </script>
        
        <table width="100%">
        	<tr>
        	<td width="15%"> <img src="../../images/equilibrha.png" height="35"></td> 
        	<td width="85%">
	        	
	        
	           <div id='jqxMenu'>
	                <ul>
	                	<%
	                		if (optLoad.equals("0")){
	                	%>
			                    <li><a href="">Inicio</a></li>
			                    <li>Seguridad
			                        <ul style='width: 250px;'>
			                            <li><a href="#" onclick="menuclick('../admin/rolesseguridad_view.jsp','Roles de Seguridad');return false;">Roles de Seguridad</a></li>
			                            <li type='separator'></li>
			                            <li><a href="#" onclick="menuclick('../admin/usuarios_view.jsp','Usuarios del Sistema');return false;">Usuarios del Sistema</a></li>
			                            
			                        </ul>
			                    </li>
			                    <li>Tablas de referencia
			                        <ul style='width: 250px;'>
			                            <li><a href="#" onclick="menuclick('../auxiliares/devices_view.jsp','Dispositivos Móviles');return false;">Dispositivos Móviles</a></li>
			                            <li type='separator'></li>
			                            <li><a href="#" onclick="menuclick('../auxiliares/systems_view.jsp','Sistemas de la Empresa');return false;">Sistemas de la empresa</a></li>
			                            <li type='separator'></li>
			                            <li><a href="#" onclick="menuclick('../auxiliares/params_view.jsp','Parámetros Globales');return false;">Parámetros Globales</a></li>
			                            <li type='separator'></li>
			                            <li><a href="#" onclick="menuclick('../auxiliares/process_view.jsp','Procesos del Sistema');return false;">Procesos del Sistema</a></li>
			                            
			                        </ul>
			                    </li>
			                    <li>Control del Sistema
			                        <ul style='width: 250px;'>
			                            <li><a href="#" onclick="menuclick('../estadisticas/estadisticas_view.jsp','Estadísticas del sistema');return false;">Estadísticas del sistema</a></li>
			                            <li>Analíticas
			                        		<ul style='width: 250px;'>
			                            		<li><a href="#" onclick="menuclick('../estadisticas/user_role_view.jsp','Usuarios por role de seguridad');return false;">Usuarios por role de seguridad</a></li>
			                            		<li><a href="#" onclick="menuclick('../estadisticas/user_device_acc_view.jsp','Usuarios por dispostivo acceso');return false;">Usuarios por dispostivo acceso</a></li>
			                            		<li><a href="#" onclick="menuclick('../estadisticas/user_device_con_view.jsp','Usuarios por dispostivo conectado');return false;">Usuarios por dispostivo conectado</a></li>
			                            		<li><a href="#" onclick="menuclick('../estadisticas/user_system_view.jsp','Usuarios por Sistema');return false;">Usuarios por Sistema</a></li>
			                            		<li><a href="#" onclick="menuclick('../estadisticas/user_bloq_view.jsp','Usuarios activos/bloqueados');return false;">Usuarios activos/bloqueados</a></li>
			                            		<li><a href="#" onclick="menuclick('../estadisticas/user_login_view.jsp','Intentos de login por usuario');return false;">Intentos de login por usuario</a></li>
			                            		<li><a href="#" onclick="menuclick('../estadisticas/user_act_system_view.jsp','Usuarios activos por sistema');return false;">Usuarios activos por sistema</a></li>
			                            		<li><a href="#" onclick="menuclick('../estadisticas/sessions_actives_view.jsp','Sesiones activas por sistema');return false;">Sesiones activas por sistema</a></li>
			                            		</ul>
					                    <li><a href="#" onclick="menuclick('../parse/send.jsp','Notificaciones Push');return false;">Notificaciones Push</a></li>
					                    <li><a href="#" onclick="menuclick('../admin/cleanCaches.jsp','Limpieza de caches');return false;">Limpiar cachés</a></li>
					                    <li><a href="#" onclick="menuclick('../admin/infobackend.jsp','Información sistema');return false;">Información sistema</a></li>
					                   </li>
			                        </ul>
			                    </li>

	                    <%
	                    	}
	                    %>
	                </ul>
	            </div>
	          </td>
	       </tr>
	     </table>
	            
    </div> 

<%
 	//if (optLoad.equals("0")){
 %>
	

		 <%
		 	hb_users usr;
		 		 	 VinUsers user;
		 		 	 String name="";
		 		 	 try{
		 		 		//busco el usuario en la session
		 		 		 String segKey = (String)session.getAttribute( "SessionUser");
		 		 		 
		 		 		 usr = new hb_users();
		 		 		 user = usr.getUser(segKey);	
		 		 		 name = user.getUserName();
		 		 		 
		 		 	 }
		 		 	 catch(Exception e)
		 		 	 {}
		 		 	 finally
		 		 	 {
		 		 		 usr=null;
		 		 		 user=null;
		 		 	 }
		 %>
		  	 
		 
		<div class="pathmarco">
		     <table class="pathmarco">
		             <tr>
		                 <td width="86%"><label class="i18n" id="menu.conexion"></label> <label class="pathmarcoName"><%=name%></label></td>
		                 <td width="14%" align="center">
		                    <a href="../login/logout.jsp"> <img src="../../images/closeweb.png" height="30" id="MenulogoutClick" alt="Cerrar sesión"></a> 
		                    <img src="../../images/blanco.png" height="15" >
		                    <a href='#' ><img src='../../images/chgpassword.png' width='31' id='chgPasswordImage'></a>
		                 </td>
		             </tr>
		         </table>
 		</div>		 
		 
		 	
		 
<%//} %>
<div id="jqxTabs">
<ul style='margin-left: 20px;'>
        <li>Inicio</li>
    </ul>
    <div>
			 <div class="menu_equilibrha_logo">   
			    <center>
			    	<img src="../../images/equilibrha.png" height="90">
			    	<br><br>
			    	<img src="../../images/mobile1.png" height="250">
			    </center>
			 </div>  
    
    </div>
</div>



<!-- popoup modal cambio de clave -->

                    <div id="popupWindowPassword">
                           <div><label class="i18n labelnormal" id="users_lista.form2.title"></label></div>
                           <div style="overflow: hidden;">
                               <form id="Form" action="./">
                                    <table>
                                        <tr>
                                            <td align="right"><label class="i18n" id="users_lista.form1.usuario"></label></td>
                                            <td align="left"><input id="iduser" /></td>
                                        </tr>

                                         <tr>
                                            <td align="right"><label class="i18n" id="users_lista.form2.pass"></label></td>
                                            <td align="left"><input type="password" id="clavenueva" /></td>
                                        </tr>
                                         <tr>
                                            <td align="right"><label class="i18n" id="users_lista.form2.pass2"></label></td>
                                            <td align="left"><input type="password" id="clavenueva2" /></td>
                                        </tr>                                   
                                        <tr>
                                            <td align="right"></td>
                                            <td style="padding-top: 10px;" align="right"><input style="margin-right: 5px;" type="button" id="SavePassword" value="Cambiar clave" /><input id="CancelPassword" type="button" value="Cancelar" /></td>
                                        </tr>
                                    </table>
                               </form>
                           </div>
                      </div>



                    <!-- popoup Cargas -->

                    <div id="popupWindowLoad">
                           <div><label class="i18n" id="menu.loading"></div>
                           <div style="overflow: hidden;">
                               <form id="Form" action="./">
                                    <table>
                                        <tr>
                                            <br>
                                            <td align="center"><img src ='../../images/loading_1.gif' height='50'></td>
                                            <td align="center"> <label class="i18n" id="menu.loading2"></label></td>
                                            
                                        </tr>
                                    </table>
                               </form>
                           </div>
                      </div>


                    <!-- mENSAJES AL USUARIO -->

                    <div id="popupWindowMensaje">
                           <div id="popupWindowMensajeTitulo">Información Sistema</div>
                           <div style="overflow: hidden;">
                               <form id="Form" action="./">
                                    <table class="pathmarco">
                                        <tr>
                                            <br>
                                            <td align="center"></td>
                                            <td align="center"> <div class="pathmarco" id="popupWindowMensajeTexto"></div></td>
                                        </tr>
                                        <tr>
                                            <td colspan="2" align="center"> <a href='#' ><img src='../../images/button-ok.png' width='40' id='menubuttonokmensaje'></a></td>
                                        </tr>                                        
                                    </table>
                               </form>
                           </div>
                      </div>

</body>
</html>

