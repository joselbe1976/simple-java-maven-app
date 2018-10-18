<%@include file="../globales/globalAllPages.jsp" %>
<%@include file="../login/seguridad_view.jsp" %>

<div id="FormUsers2">
 <div id="FormUsers">
       <table width="100%">
           <tr>
               <td width="100%" align="center">
                   <!-- Grid -->
                   <div id="FormUsers2_jqxgrid"></div>
               </td>
           </tr>
       </table>

 <!-- popoup modal de edición -->

                    <div id="popupWindowEditUsers">
                        <div><label class="i18n labelnormal" id="users_lista.form1.title"></label></div>
                           <div style="overflow: hidden;">
                               <form id="Form_popupWindowEditUsers" action="./">
                                  
                                   <table>
                                        <tr><!-- ID Usuario -->
                                            <td align="right"><label class="i18n" id="users_lista.form1.usuario"></label></td>
                                            <td align="left"><input id="popupWindowEditUsers_id_user" /></td>
                                        </tr>
                                        <tr> <!-- Nombre completo usuario -->
                                            <td align="right"><label class="i18n" id="users_lista.form1.nombre"></label></td>
                                            <td align="left"><input id="popupWindowEditUsers_user_name" /></td>
                                        </tr>
                                        <tr> <!-- documento nif -->
                                            <td align="right"><label class="i18n" id="users_lista.form1.nif"></label></td>
                                            <td align="left"><input id="popupWindowEditUsers_nif" /></td>
                                        </tr>
                                        <tr> <!-- id empleado RRHH -->
                                            <td align="right"><label class="i18n" id="users_lista.form1.id_empleado"></label></td>
                                            <td align="left"><input id="popupWindowEditUsers_id_empleado" /></td>
                                        </tr>
                                        <tr> <!-- fase de alta -->
                                            <td align="right"><label class="i18n" id="users_lista.form1.fase_alta"></label></td>
                                            <td align="left"><input id="popupWindowEditUsers_fase_alta" /></td>
                                        </tr>

                                        <tr>
                                        <tr><!-- Lista roles -->
                                            <td align="right"><label class="i18n" id="users_lista.form1.role"></label></td>
                                            <td align="left"><div id="popupWindowEditUsers_jqxCombo"></div></td>
                                        </tr>
                                        <tr><!-- UUID de Acceso -->
                                            <td align="right"><label class="i18n" id="users_lista.form1.uuid"></label></td>
                                            <td align="left"><input id="popupWindowEditUsers_uuid" /></td>
                                        </tr>
                                        
                                        <tr> <!-- Dispositivo de  Acceso -->
                                            <td align="right"><label class="i18n" id="users_lista.form1.device"></label></td>
                                            <td align="left"><div id="popupWindowEditUsers_jqxComboDevice"></div></td>
                                        </tr>
                                        <!--  Check bloqueado -->
  	                                    <tr>
                                            <td align="right"></td>
                                            <td align="left"><div id='popupWindowEditUsers_bloq'><span><label class="i18n" id="users_lista.form1.bloq"></label></span></div></td>
                                        </tr>          
                                        <tr valign="top"> <!-- Comentario -->
                                            <td align="right"><label class="i18n" id="users_lista.grid.comment"></label></td>
                                            <td align="left"><textarea rows="4" cols="40" id="popupWindowEditUsers_comment"></textarea></td>
                                        </tr>
                                        <tr> <!-- Esto son los botones -->
                                            <td align="right"></td>
                                            <td style="padding-top: 10px;" align="right"><input type="button" style="margin-right: 5px;"  id="popupWindowEditUsers_Save" ></button><input id="popupWindowEditUsers_Cancel" type="button" value="Cancelar" /></td>
                                        </tr>
                                        <tr>
                                            <td align="right"> </td>
                                            <td align="left"> </td>
                                        </tr>                                        
                                    </table>
                               </form>
                           </div>
                      </div>       
                      
 		<!-- popoup modal de cambio de clave -->                      
                    <div id="popupWindowPasswordUser">
                           <div><label class="i18n labelnormal" id="users_lista.form2.title"></label></div>
                           <div style="overflow: hidden;">
                               <form id="Form_popupWindowPasswordUser" action="./">
                                    <table>
                                        <tr>
                                            <td align="right"><label class="i18n" id="users_lista.form1.usuario"></label></td>
                                            <td align="left"><input id="popupWindowPasswordUser_iduser" readonly/></td>
                                        </tr>

                                         <tr>
                                            <td align="right"><label class="i18n" id="users_lista.form2.pass"></label></td>
                                            <td align="left"><input type="password" id="popupWindowPasswordUser_clavenueva" /></td>
                                        </tr>
                                         <tr>
                                            <td align="right"><label class="i18n" id="users_lista.form2.pass2"></label></td>
                                            <td align="left"><input type="password" id="popupWindowPasswordUser_clavenueva2" /></td>
                                        </tr>                                   
                                        <tr>
                                            <td align="right"></td>
                                            <td style="padding-top: 10px;" align="right"><input style="margin-right: 5px;" type="button" id="popupWindowPasswordUser_Save" value="Cambiar clave" /><input id="popupWindowPasswordUser_Cancel" type="button" value="Cancelar" /></td>
                                        </tr>
                                        <tr>
                                            <td align="right"></td>
                                            <td style="padding-top: 10px;" align="right"></td>
                                        </tr>
                                    </table>
                               </form>
                           </div>
                      </div>
                      

 		<!-- popoup modal de Sistemas asignados al usuario-->                      
                    <div id="popupWindowUserSystems">
                           <div><label class="i18n labelnormal" id="users_systems_asign_titulo"></label></div>
                           <div style="overflow: hidden;">
                           		<div id="popupWindowUserSystems_jqxgrid"></div>
                           </div>
                     </div>
 		<!-- popoup modal de Lista de Systemas para agregar-->                      
                    <div id="popupWindowUserSystemsEdit">
                           <div><label class="i18n labelnormal" id="systems_form_title2"></label></div>
                           <div style="overflow: hidden;">
                           		<form id="Form_popupWindowUserSystemsEdit" action="./">
                                    <table>
                                    	<input type="hidden" id ="popupWindowUserSystemsEdit_id_user"> <!-- Campo oculto con el usuario -->
                                        <tr> <!-- Lista de Sistemas -->
                                            <td align="right"><label class="i18n" id="systems_form_id_system2"></label></td>
                                            <td align="left"><div id="popupWindowUserSystemsEdit_jqxComboSystem"></div></td>
                                        </tr>                                    
                                        <tr>
                                            <td align="right"></td>
                                            <td style="padding-top: 10px;" align="right"><input style="margin-right: 5px;" type="button" id="popupWindowUserSystemsEdit_Save" value="Aceptar" /><input id="popupWindowUserSystemsEdit_Cancel" type="button" value="Cancelar" /></td>
                                        </tr>
                                        <tr>
                                            <td align="right"></td>
                                            <td style="padding-top: 10px;" align="right"></td>
                                        </tr>
                                    </table>
                               </form>
                           </div>
                     </div>    
                     
                    <!-- Menú contextual del grid --> 
 					<div id='FormUsers2_jqxgrid_Menu_Contextual'>
        				<ul>
	            			<li><img src="../../images/chgpassword_black.png" width="20"></img><span> <label class="i18n" id="users_menu_context_chgpass"></label></span></li>
	            			<li><img src='../../images/settings38_black.png' width='20'/><span> <label class="i18n" id="users_menu_context_sisasig"></label></span></li>
	            			<li><img src='../../images/edit_black.png' width='20'/><span> <label class="i18n" id="users_menu_context_edit"></label></span></li>
	       				</ul>
       				</div>                     
                     
</div>


<script type="text/javascript">
$(document).ready(function () {
	
				 var anchoform1 = 400;	
				 var altoForm1 =  410;
				 var altoForm2 =  150;			
				 var anchoform2 = 280;
				 var altoForm3 =  340;			
				 var anchoform3 = 400;
				 var altoForm4 =  120;			
				 var anchoform4 = 300;

				 var FormUsers2_jqxgrid_Menu_Contextual = $("#FormUsers2_jqxgrid_Menu_Contextual").jqxMenu({ width: 200, height: 105, autoOpenPopup: false, mode: 'popup'});
				 				 
                  $("#popupWindowEditUsers").jqxWindow({
                	  Height: altoForm1, width: anchoform1, resizable: false, theme: JsUIStyleCss, isModal: true, autoOpen: false, cancelButton: $("#popupWindowEditUsers_Cancel"), modalOpacity: 0.01, animationType: 'combined', showAnimationDuration: 400, closeAnimationDuration: 400            
                  });

                  $("#popupWindowPasswordUser").jqxWindow({
                	  Height: altoForm2, width: anchoform2, resizable: false, theme: JsUIStyleCss, isModal: true, autoOpen: false, cancelButton: $("#popupWindowPasswordUser_Cancel"), modalOpacity: 0.01, animationType: 'combined', showAnimationDuration: 400, closeAnimationDuration: 400            
                  });

                  $("#popupWindowUserSystems").jqxWindow({
                	  Height: altoForm3, width: anchoform3, resizable: false, theme: JsUIStyleCss, isModal: true, autoOpen: false, modalOpacity: 0.01, animationType: 'combined', showAnimationDuration: 400, closeAnimationDuration: 400            
                  });
                  
                  $("#popupWindowUserSystemsEdit").jqxWindow({
                	  Height: altoForm4, width: anchoform4, resizable: false, theme: JsUIStyleCss, isModal: true, autoOpen: false, cancelButton: $("#popupWindowUserSystemsEdit_Cancel"), modalOpacity: 0.01, animationType: 'combined', showAnimationDuration: 400, closeAnimationDuration: 400            
                  });

                  
                //i18N
                chgLang('<%=viewIdioma%>');   


// -------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------
// FORMULARIO PRINCIPAL
// -------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------                

				var UserEditId=""; //variable donde se almacena el usuario que se edita sus sistemas


                // -------------------------------------------------------------------------------------------
                //Origen datos para alimentar datos Json/XML de los componentes 
                // -------------------------------------------------------------------------------------------
                
				var source =
				{
					datatype: "json",
					datafields: [
						{ name: 'id_user'},
						{ name: 'user_name'},
						{ name: 'nif'},
						{ name: 'id_empleado_rrhh'},
						{ name: 'fase_alta_rrhh'},
						{ name: 'id_role'},
						{ name: 'name'},  //nombre del role
						{ name: 'comment'},
						{ name: 'uuid_access'},
						{ name: 'id_disp_access'},
						{ name: 'device_name'},
						{ name: 'bloq'}
					],
					url: '../admin/usuarios_data.jsp',
					cache: false,
		                        id:'id',
		                        filter: function()
		                        {
		                                // update the grid and send a request to the server.
		                                $("#FormUsers2_jqxgrid").jqxGrid('updatebounddata', 'filter');
		                        },
		                        sort: function()
		                        {
		                                // update the grid and send a request to the server.
		                                $("#FormUsers2_jqxgrid").jqxGrid('updatebounddata', 'sort');
		                        },
		                        root: 'Rows',
		                        beforeprocessing: function(data)
		                        {		
		                                if (data != null)
		                                {
		                                        source.totalrecords = data[0].TotalRows;					
		                                }
		                        },
		                        addRow: function (rowID, rowData, position, commit) {

		   		            
		                                  $.post('../admin/usuarios_save.jsp', { oper : 'NEW', id_user : rowData.id_user, user_name : rowData.user_name, comment: rowData.comment,id_role: rowData.id_role, id_disp_access: rowData.id_disp_access, uuid_access:rowData.uuid_access, bloq:rowData.bloq, nif : rowData.nif, id_empleado_rrhh : rowData.id_empleado_rrhh, fase_alta_rrhh: rowData.fase_alta_rrhh }, 
		                                    function(resp) {
		                                           
		                                          if (resp.split('{')[0].trim() == "true")
		                                          {
		                                             commit(true);
		                                             $("#FormUsers2_jqxgrid").jqxGrid('updatebounddata', 'cells');
		                                             showMensaje(resp.split('{')[1],1);
		                                          }                                          
		                                          else
		                                          {
		                                              commit(false);
		                                              showMensaje(resp.split('{')[1],2); //mensaje de error
		                                          
		                                          }
		                                          
		                                          
		                                    }
		                                );
		                        },
		                        updateRow: function (rowID, rowData, commit) {
		             
		                                $.post('../admin/usuarios_save.jsp', { oper : 'MOD', id_user : rowData.id_user, user_name : rowData.user_name, comment: rowData.comment,id_role: rowData.id_role, id_disp_access: rowData.id_disp_access, uuid_access:rowData.uuid_access, bloq:rowData.bloq, nif : rowData.nif, id_empleado_rrhh : rowData.id_empleado_rrhh, fase_alta_rrhh: rowData.fase_alta_rrhh }, 
		                                    function(resp) {
		                                        
		                                         if (resp.split('{')[0].trim() == "true")
		                                          {
		                                             commit(true); 
		                                    //         showMensaje(resp.split('{')[1]);
		                                             $("#FormUsers2_jqxgrid").jqxGrid('updatebounddata', 'cells');
		                                             showMensaje(resp.split('{')[1],1);
		                                          }                                          
		                                          else
		                                          {
		                                              commit(false);
		                                              showMensaje(resp.split('{')[1],2); //mensaje de error
		                                          
		                                          }  
		                                    }
		                                );
		                        },
		                        deleteRow: function (rowID, commit) {
		                            
		                                $.post('../admin/usuarios_save.jsp', { oper : 'DEL', id_user : rowID }, 
		                                    function(resp) {
		                                         if (resp.split('{')[0].trim() == "true")
		                                          {
		                                             commit(true); 
		                                           //  showMensaje(resp.split('{')[1]);
		                                             $("#FormUsers2_jqxgrid").jqxGrid('updatebounddata', 'cells');
		                                             showMensaje(resp.split('{')[1],1);
		                                          }                                          
		                                          else
		                                          {
		                                              commit(false);
		                                              showMensaje(resp.split('{')[1],2); //mensaje de error
		                                          }  
		                                    }
		                                );
		                        },                        
						};
		
                
                // -------------------------------------------------------------------------------------------
                // Formato de los campos de los Modales y botones
                // -------------------------------------------------------------------------------------------
                  $("#popupWindowEditUsers_Cancel").jqxButton({ theme: JsUIStyleCss });
                  $("#popupWindowEditUsers_Save").jqxButton({ theme: JsUIStyleCss });
                  $("#popupWindowEditUsers_Save").val(Save); //textos traducidos a botones
                  $("#popupWindowEditUsers_Cancel").val(Cancel); //textos traducidos a los botones		    
		          $("#popupWindowEditUsers_id_user").jqxInput({ theme: JsUIStyleCss,width: '150px', height: '23px' });
                  $("#popupWindowEditUsers_user_name").jqxInput({ theme: JsUIStyleCss,width: '200px', height: '23px' });
                  $("#popupWindowEditUsers_nif").jqxInput({ theme: JsUIStyleCss,width: '100px', height: '23px' });
                  $("#popupWindowEditUsers_id_empleado").jqxInput({ theme: JsUIStyleCss,width: '100px', height: '23px' });
                  $("#popupWindowEditUsers_fase_alta").jqxInput({ theme: JsUIStyleCss,width: '100px', height: '23px' });
                  $("#popupWindowEditUsers_comment").jqxInput({ theme: JsUIStyleCss,width: '300px', height: '60px'});
                  $("#popupWindowEditUsers_uuid").jqxInput({ theme: JsUIStyleCss,width: '250px', height: '23px' });
                  $("#popupWindowEditUsers_bloq").jqxCheckBox({ theme: JsUIStyleCss,height: 25});
                  
                  var editrow = -1; //indica la linea a editar/eliminar/nuevo
                  var operacion = ""; //indica la operacion DEL cuando es necesario

                  
                  
                // -------------------------------------------------------------------------------------------
                // Validaciones del formulario
				// -------------------------------------------------------------------------------------------                
                    $('#Form_popupWindowEditUsers').jqxValidator({
                                    //hintType: 'label',
                                    animationDuration: 500,
                                    theme: JsUIStyleCss,
                                    rules: [
                                            { input: '#popupWindowEditUsers_id_user', message: Obligatorio, action: 'keyup, blur', rule: 'required' },
                                            { input: '#popupWindowEditUsers_user_name', message: Obligatorio, action: 'keyup, blur', rule: 'required' }
                                           ]
                              });        


                 // -------------------------------------------------------------------------------------------
                 // Adaptador del Origenprincipal
                 // -------------------------------------------------------------------------------------------
	                var dataadapter = new $.jqx.dataAdapter(source, {
							loadError: function(xhr, status, error)
							{
								//Cotnrol de Errores. Si falla algo o la session etc. Se manda mensaje y al login
								showMensaje(ControlSessionMsg);
								window.location = "../../index.html";
								return;
								
							},
	                        loadComplete: function () {
	                            // data is loaded.
	                        },
							downloadComplete:function(edata, textStatus, jqXHR)
							{
	
	                        }                        
					});


	                // -------------------------------------------------------------------------------------------
	                //Renderizamos el paginador, en caso de que sea necesario. Sino eliminar. Default no render
					// -------------------------------------------------------------------------------------------                
	                var pagerrendererUsers = function () {
	                    var element = $("<div style='margin-left: 10px; margin-top: 5px; width: 100%; height: 100%; '></div>");
	                    var datainfo = $("#FormUsers2_jqxgrid").jqxGrid('getdatainformation');
	                    var paginginfo = datainfo.paginginformation;
	                    var leftButton = $("<div style='padding: 0px; float: left;'><div style='margin-left: 9px; width: 16px; height: 16px;'></div></div>");
	                    leftButton.find('div').addClass('jqx-icon-arrow-left');
	                    leftButton.width(36);
	                    leftButton.jqxButton({ theme: JsUIStyleCss });
	                    var rightButton = $("<div style='padding: 0px; margin: 0px 3px; float: left;'><div style='margin-left: 9px; width: 16px; height: 16px;'></div></div>");
	                    rightButton.find('div').addClass('jqx-icon-arrow-right');
	                    rightButton.width(36);
	                    rightButton.jqxButton({ theme: JsUIStyleCss });
	                    leftButton.appendTo(element);
	                    rightButton.appendTo(element);
	                    var label = $("<div style='font-size: 11px; margin: 2px 3px; font-weight: bold; float: left;'></div>");
	                    label.text("1-" + paginginfo.pagesize + ' de ' + datainfo.rowscount);
	                    label.appendTo(element);
	                    self.label = label;
	                    // update buttons states.
	                    var handleStates = function (event, button, className, add) {
	                        button.on(event, function () {
	                            if (add == true) {
	                                button.find('div').addClass(className);
	                            }
	                            else button.find('div').removeClass(className);
	                        });
	                    }
	                    var theme = JsUIStyleCss;
	                    if (JsUIStyleCss != '') {
	                        handleStates('mousedown', rightButton, 'jqx-icon-arrow-right-selected-' + theme, true);
	                        handleStates('mouseup', rightButton, 'jqx-icon-arrow-right-selected-' + theme, false);
	                        handleStates('mousedown', leftButton, 'jqx-icon-arrow-left-selected-' + theme, true);
	                        handleStates('mouseup', leftButton, 'jqx-icon-arrow-left-selected-' + theme, false);
	                        handleStates('mouseenter', rightButton, 'jqx-icon-arrow-right-hover-' + theme, true);
	                        handleStates('mouseleave', rightButton, 'jqx-icon-arrow-right-hover-' + theme, false);
	                        handleStates('mouseenter', leftButton, 'jqx-icon-arrow-left-hover-' + theme, true);
	                        handleStates('mouseleave', leftButton, 'jqx-icon-arrow-left-hover-' + theme, false);
	                    }
	                    rightButton.click(function () {
	                        $("#FormUsers2_jqxgrid").jqxGrid('gotonextpage');
	                    });
	                    leftButton.click(function () {
	                        $("#FormUsers2_jqxgrid").jqxGrid('gotoprevpage');
	                    });
	                    return element;
	                }

	                $("#FormUsers2_jqxgrid").on('pagechanged', function () {
	                    var datainfo = $("#FormUsers2_jqxgrid").jqxGrid('getdatainformation');
	                    var paginginfo = datainfo.paginginformation;
	                    self.label.text(1 + paginginfo.pagenum * paginginfo.pagesize + "-" + Math.min(datainfo.rowscount, (paginginfo.pagenum + 1) * paginginfo.pagesize) + ' of ' + datainfo.rowscount);
	                });


                // -------------------------------------------------------------------------------------------
                // Definición del Grid de datos principal
				// -------------------------------------------------------------------------------------------                

   			    $("#FormUsers2_jqxgrid").jqxGrid(
				{
                    theme: JsUIStyleCss,
                    source: dataadapter,
                    width: anchoVentana,
                    height: altoVentana,
                    columnsresize: true, 
                    filterable: true,
                    filtermode: 'excel',
                    sortable: true,
                    autoheight: false,
                    pageable: true,
                    //pagermode: 'simple',
                    pagerrenderer: pagerrendererUsers,
                    virtualmode: false,
                    altrows: false,
                    showtoolbar: true, //muestra la barra de herramientas superior
                    showstatusbar: false, //muestra la barra de abajo de estado
                    
                    rendergridrows: function(obj)
						{
							return obj.data;    
						},
                    columns: [
							//{ text: 'id', datafield: 'id_user', width: 0, hidden: true}, //El id de la tabla                              
                            { text: users_lista.grid.id, datafield: 'id_user', width: "10%"},
                            { text: users_lista.grid.nombre, datafield: 'user_name', width: "20%"},
                            { text: users_lista.grid.idrole, datafield: 'id_role', width: 70, hidden: true },
                            { text: users_lista.grid.role, datafield: 'name', width: "10%" },
                            { text: users_lista.grid.uuid, datafield: 'uuid_access', width: "15%" },
                            { text: users_lista.grid.dispositivo, datafield: 'id_disp_access', width: 0, hidden: true },
                            { text: users_lista.grid.dispositivo, datafield: 'device_name', width: "10%" },
                            { text: users_lista.form1.bloq, datafield: 'bloq', width: "10%" ,columntype: 'checkbox'},
                            { text: users_lista.grid.comment, datafield: 'comment', width: "25%" }
                            
                          ], //de columns

                        rendertoolbar: function (toolbar) {
                            
                        	 var container = $("<div style='margin: 2px;'></div>");

                            var input1 = $("<a href='#' ><img src='../../images/excel.png' width='27' id='popupWindowEditUsers_excelExport'></a>"); 
                            var input2 = $("<a href='#' ><img src='../../images/imprimir.png' width='25' id='popupWindowEditUsers_print'></a>"); 
                            var blanco = $("<a href='#' ><img src='../../images/blanco.png' width='22'></a>");
                            
                            var input3 = $("<a href='#' ><img src='../../images/refresh.png' width='22' id='popupWindowEditUsers_recargar'></a>");
                            var input4 = $("<a href='#' ><img src='../../images/new.png' width='23' id='popupWindowEditUsers_nuevo'></a>");
                            var input5 = $("<a href='#' ><img src='../../images/delete.png' width='25' id='popupWindowEditUsers_eliminar'></a>");
                            var input6 = $("<a href='#' ><img src='../../images/edit.png' width='22' id='popupWindowEditUsers_editar'></a>");
                            var blanco1 = $("<a href='#' ><img src='../../images/blanco.png' width='10'></a>");
                            var blanco2 = $("<a href='#' ><img src='../../images/blanco.png' width='10'></a>");
                            var blanco3 = $("<a href='#' ><img src='../../images/blanco.png' width='10'></a>");      
                            var password = $("<a href='#' ><img src='../../images/chgpassword.png' width='25' id='popupWindowEditUsers_chgpassword'></a>");                      
                            var usersystems = $("<a href='#' ><img src='../../images/settings38.png' width='25' id='popupWindowEditUsers_usersystems'></a>");
                            var input10 = $("<a href='#' ><img src='../../images/parameters.png' width='22' id='popupWindowEditUsers_parameters'></a>");
                            
                            
                            toolbar.append(container);
                            container.append(input3);
                            container.append(input4);
                            container.append(input5);
                            container.append(input6);                           
                            container.append(blanco);
                            container.append(input1);
                            container.append(input2);
                            container.append(blanco2);
                            container.append(password); 
                            container.append(usersystems);
                            container.append(input10);  
                       }

				});  //del grid 

				  $("#FormUsers2_jqxgrid").on('contextmenu', function () {
		                return false;
		            });
				
				 $("#FormUsers2_jqxgrid").on('rowclick', function (event) {
		                if (event.args.rightclick) {
		                	var scrollTop = $(window).scrollTop();
		                    var scrollLeft = $(window).scrollLeft();			                
		                	FormUsers2_jqxgrid_Menu_Contextual.jqxMenu('open', parseInt(event.args.originalEvent.clientX) + 5 + scrollLeft, parseInt(event.args.originalEvent.clientY) + 5 + scrollTop);
		                    return false;
		                }
		            });
                //menú contextual click
				$("#FormUsers2_jqxgrid_Menu_Contextual").on('itemclick', function (event) {
	                var args = event.args;

	                if ($.trim($(args).text()) == $("#users_menu_context_chgpass").html()) {
		                //cambio de clave
	                	$("#popupWindowEditUsers_chgpassword").click();
	                }
	                else if ($.trim($(args).text()) == $("#users_menu_context_sisasig").html()) {
	                	$("#popupWindowEditUsers_usersystems").click();
	                }
	                else if ($.trim($(args).text()) == $("#users_menu_context_edit").html()) {
	                	$("#popupWindowEditUsers_editar").click();
	                }
	            });


				// -------------------------------------------------------------------------------------------
		        // Acciones y Operaciones --------------------------------------------------------------------
				// -------------------------------------------------------------------------------------------                
  				// -------------------------------------------------------------------------------------------
			      // initialize the popup window and buttons.
                  $("#popupWindowEditUsers").on('open', function () {
                  });

                  //boton Save del formulario. Validamos los datos
                  $("#popupWindowEditUsers_Save").click(function () {
                      $('#Form_popupWindowEditUsers').jqxValidator('validate');
                  });
                  
                   //cuando este ok la validacion llamamos a Guarda
                  $('#Form_popupWindowEditUsers').jqxValidator({ onSuccess: function () { popupWindowEditUsers_guarda(); } }); 
                  
    			// -------------------------------------------------------------------------------------------
                // boton Save del formulario
  				// -------------------------------------------------------------------------------------------                  
                  function popupWindowEditUsers_guarda() 
                  {
                      if (operacion == "MOD") {  //modificacion
                          //edicion
                          var row = {nif:$("#popupWindowEditUsers_nif").val(),fase_alta_rrhh:$("#popupWindowEditUsers_fase_alta").val(),id_empleado_rrhh:$("#popupWindowEditUsers_id_empleado").val()  ,id_disp_access:$("#popupWindowEditUsers_jqxComboDevice").val() ,id_role:$("#popupWindowEditUsers_jqxCombo").val() ,uuid_access:$("#popupWindowEditUsers_uuid").val() ,id_user: $("#popupWindowEditUsers_id_user").val(), user_name: $("#popupWindowEditUsers_user_name").val(), comment: $("#popupWindowEditUsers_comment").val(), bloq: $('#popupWindowEditUsers_bloq').jqxCheckBox('checked')==true ? 1 : 0};                          
                          var rowID = $('#FormUsers2_jqxgrid').jqxGrid('getrowid', editrow);
                          $('#FormUsers2_jqxgrid').jqxGrid('updaterow', rowID, row);
                          $("#popupWindowEditUsers").jqxWindow('hide'); //ocultamos el Form Modal
                      }
                      else if (operacion == "NEW") //Nuevo registro
                      {
                          var row = { nif:$("#popupWindowEditUsers_nif").val(),fase_alta_rrhh:$("#popupWindowEditUsers_fase_alta").val(),id_empleado_rrhh:$("#popupWindowEditUsers_id_empleado").val()  ,id_disp_access:$("#popupWindowEditUsers_jqxComboDevice").val() ,id_role:$("#popupWindowEditUsers_jqxCombo").val() ,uuid_access:$("#popupWindowEditUsers_uuid").val() ,id_user: $("#popupWindowEditUsers_id_user").val(), user_name: $("#popupWindowEditUsers_user_name").val(), comment: $("#popupWindowEditUsers_comment").val(), bloq: $('#popupWindowEditUsers_bloq').jqxCheckBox('checked')==true ? 1 : 0};
                          var rowID = -1;
                          var rowscount = $("#FormUsers2_jqxgrid").jqxGrid('getdatainformation').rowscount;
                          $('#FormUsers2_jqxgrid').jqxGrid('addRow', rowID, row,rowscount );
                          $("#popupWindowEditUsers").jqxWindow('hide'); //ocultamos el Form Modal
                      }
                       
                  };
                  
  				// -------------------------------------------------------------------------------------------
	            //Salida Excel
				// -------------------------------------------------------------------------------------------
					            
	            $("#popupWindowEditUsers_excelExport").click(function () {
	                
	                $("#FormUsers2_jqxgrid").jqxGrid('exportdata', 'xls', 'FormUsers2_jqxgrid');           
	            });

				// -------------------------------------------------------------------------------------------	            
	            //Recargar
				// -------------------------------------------------------------------------------------------	            
	            
	            $("#popupWindowEditUsers_recargar").click(function () {
	                
	                $("#FormUsers2_jqxgrid").jqxGrid('updatebounddata', 'cells');          
	            });

	            
				// -------------------------------------------------------------------------------------------	            
        		//Imprimir
				// -------------------------------------------------------------------------------------------        		
		         $("#popupWindowEditUsers_print").click(function () {
		                var gridContent = $("#FormUsers2_jqxgrid").jqxGrid('exportdata', 'html');
		                var newWindow = window.open('', '', 'width=800, height=500'),
		     
		                document = newWindow.document.open(),
		                pageContent =
		                    '<!DOCTYPE html>\n' +
		                    '<html>\n' +
		                    '<head>\n' +
		                    '<meta charset="utf-8" />\n' +
		                    '<title>Impresion</title>\n' +
		                    '</head>\n' +
		                    '<body>\n' + gridContent + '\n</body>\n</html>';
		                document.write(pageContent);
		                document.close();
		                newWindow.print();
		            });
					// -------------------------------------------------------------------------------------------
					// Eliminar un registro
					// -------------------------------------------------------------------------------------------		 			            
		            $("#popupWindowEditUsers_eliminar").on('click', function () {
		
		                if (confirm(DeleteMsg))
		                {
		                        var selectedrowindex = $("#FormUsers2_jqxgrid").jqxGrid('getselectedrowindex');
		                        var rowscount = $("#FormUsers2_jqxgrid").jqxGrid('getdatainformation').rowscount;
		                        if (selectedrowindex >= 0 && selectedrowindex < rowscount) {
		
		                            var id = $("#FormUsers2_jqxgrid").jqxGrid('getrowid', selectedrowindex);
		                            var dataRecord = $("#FormUsers2_jqxgrid").jqxGrid('getrowdata', id);
		                            var commit = $("#FormUsers2_jqxgrid").jqxGrid('deleterow', dataRecord.id_user);
		                        }
		           		 }
		            });

		        // -------------------------------------------------------------------------------------------		 			
		        // Editar un Registro
		        // -------------------------------------------------------------------------------------------
               $("#popupWindowEditUsers_editar").on('click', function () {

                   		//Sacamos la fila seleccionada en el grid
		                var selectedrowindex = $("#FormUsers2_jqxgrid").jqxGrid('getselectedrowindex');
		                var rowscount = $("#FormUsers2_jqxgrid").jqxGrid('getdatainformation').rowscount;

		        		//Si está seleccionad y hay registros
	                  if (selectedrowindex >= 0 && selectedrowindex < rowscount) {
	                        var id = $("#FormUsers2_jqxgrid").jqxGrid('getrowid', selectedrowindex);
	                        
	                        editrow = selectedrowindex;
	                        operacion = "MOD";
	                        var offset = $("#FormUsers2_jqxgrid").offset();
	                        $("#popupWindowEditUsers").jqxWindow({ position: { x:(anchoVentana-anchoform1)/2, y: parseInt(offset.top) + 100 } });

		                    //Capuramos el "recordset" de la fila seleccionada. 
	                        var dataRecord = $("#FormUsers2_jqxgrid").jqxGrid('getrowdata', selectedrowindex);

		                    //Asigno los campos
	                        $("#popupWindowEditUsers_id_user").val(dataRecord.id_user);
	                        $("#popupWindowEditUsers_user_name").val(dataRecord.user_name);

	                        $("#popupWindowEditUsers_nif").val(dataRecord.nif);
	                        $("#popupWindowEditUsers_id_empleado").val(dataRecord.id_empleado_rrhh);
	                        $("#popupWindowEditUsers_fase_alta").val(dataRecord.fase_alta_rrhh);
	                        
	                        $("#popupWindowEditUsers_comment").val(dataRecord.comment);
	                        $("#popupWindowEditUsers_uuid").val(dataRecord.uuid_access);
	                        $("#popupWindowEditUsers_jqxCombo").val(dataRecord.id_role);
	                        $("#popupWindowEditUsers_jqxComboDevice").val(dataRecord.id_disp_access);

	    					if (dataRecord.bloq == 1)
		    				{
	    						$('#popupWindowEditUsers_bloq').jqxCheckBox({ checked:true });
		    				}
	    					else
		    				{
	    						$('#popupWindowEditUsers_bloq').jqxCheckBox({ checked:false });
			    			}
	                        
	                        //abrimos la ventana modal
	                        $("#popupWindowEditUsers").jqxWindow('open');

	                        //deshabilitamos
	                        $("#popupWindowEditUsers_id_user").prop('disabled', true);
	                }
	            });

            	// -------------------------------------------------------------------------------------------
		        //  Nuevo Registro
		        // -------------------------------------------------------------------------------------------            
	            $("#popupWindowEditUsers_nuevo").on('click', function () {
	                     
	                     editrow = -1;  
	                     operacion = "NEW"; //Marco la operación 
	                     var offset = $("#FormUsers2_jqxgrid").offset();
	                     $("#popupWindowEditUsers").jqxWindow({ position: { x:(anchoVentana-anchoform1)/2, y: parseInt(offset.top) + 100 } });

	                     // Pongo a blanco los campos
	                     $("#popupWindowEditUsers_id_user").val('');
	                     $("#popupWindowEditUsers_user_name").val('');
	                     $("#popupWindowEditUsers_comment").val('');
	                     $("#popupWindowEditUsers_uuid").val('');
                         $("#popupWindowEditUsers_jqxCombo").val(null); 
                         $("#popupWindowEditUsers_jqxComboDevice").val('0'); //valor por defecto
                         $('#popupWindowEditUsers_bloq').jqxCheckBox({ checked:false });
	                     $("#popupWindowEditUsers_nif").val('');
	                     $("#popupWindowEditUsers_id_empleado").val('');
	                     $("#popupWindowEditUsers_fase_alta").val('');                         
                         
	                     //abro la ventana
	                     $("#popupWindowEditUsers").jqxWindow('open');

	                     //Deshabilito los campos que no se deban poder tocar
	                     $("#popupWindowEditUsers_id_user").prop('disabled', false); 
	            });     

	         	// -----------------------------------------------------------------
                //  Boton de cambio de clave
                // -----------------------------------------------------------------
                $("#popupWindowEditUsers_chgpassword").on('click', function () {
                          
                        var selectedrowindex = $("#FormUsers2_jqxgrid").jqxGrid('getselectedrowindex');
                        var rowscount = $("#FormUsers2_jqxgrid").jqxGrid('getdatainformation').rowscount;

                          if (selectedrowindex >= 0 && selectedrowindex < rowscount) {
                                var id = $("#FormUsers2_jqxgrid").jqxGrid('getrowid', selectedrowindex);
                                var offset = $("#FormUsers2_jqxgrid").offset();
                                $("#popupWindowPasswordUser").jqxWindow({ position: { x:(anchoVentana-anchoform2)/2, y: parseInt(offset.top) + 100 }});
                            
                                var dataRecord = $("#FormUsers2_jqxgrid").jqxGrid('getrowdata', selectedrowindex);
                                $("#popupWindowPasswordUser_iduser").val(dataRecord.id_user);
                                $("#popupWindowPasswordUser_iduser").prop('disabled', true);
                                $("#popupWindowPasswordUser_clavenueva").val('');
                                $("#popupWindowPasswordUser_clavenueva2").val('');
                                 $("#popupWindowPasswordUser").jqxWindow('open');
                           }
                 });          


	         	// -----------------------------------------------------------------
                //  Boton de Sistemas asignados al usuario
                // -----------------------------------------------------------------
                $("#popupWindowEditUsers_usersystems").on('click', function () {
                          
                        var selectedrowindex = $("#FormUsers2_jqxgrid").jqxGrid('getselectedrowindex');
                        var rowscount = $("#FormUsers2_jqxgrid").jqxGrid('getdatainformation').rowscount;

                          if (selectedrowindex >= 0 && selectedrowindex < rowscount) {
                                var id = $("#FormUsers2_jqxgrid").jqxGrid('getrowid', selectedrowindex);
                                var offset = $("#FormUsers2_jqxgrid").offset();
                                $("#popupWindowUserSystems").jqxWindow({ position: { x:(anchoVentana-anchoform3)/2, y: parseInt(offset.top) + 100 }});
                            
                                var dataRecord = $("#FormUsers2_jqxgrid").jqxGrid('getrowdata', selectedrowindex);

                                UserEditId = dataRecord.id_user; //indicamos el usuario de edicion
		                        //montamos la URL y recargamos
                                sourceSystems.url = '../admin/usuarios_system_data.jsp?id_user=' + dataRecord.id_user;
                                $("#popupWindowUserSystems_jqxgrid").jqxGrid({source:sourceSystems});    
                                $("#popupWindowUserSystems_jqxgrid").jqxGrid("refresh");
                                $("#popupWindowUserSystems").jqxWindow('open');
                           }
                 });          


             // -------------------------------------------------------------------------------------------
		        //  Parámetros aplica-valor
		        // -------------------------------------------------------------------------------------------            
	            $("#popupWindowEditUsers_parameters").on('click', function () {
	
		            	//Sacamos la fila seleccionada en el grid
  						var selectedrowindex = $("#FormUsers2_jqxgrid").jqxGrid('getselectedrowindex');
                        var rowscount = $("#FormUsers2_jqxgrid").jqxGrid('getdatainformation').rowscount;
	
		        		//Si está seleccionad y hay registros
	                  if (selectedrowindex >= 0 && selectedrowindex < rowscount) {
	                        var id = $("#FormUsers2_jqxgrid").jqxGrid('getrowid', selectedrowindex);
	                        
	                        editrow = selectedrowindex;
	                        var offset = $("#FormUsers2_jqxgrid").offset();
	
		                    //Capuramos el "recordset" de la fila seleccionada. 
	                        var dataRecord = $("#FormUsers2_jqxgrid").jqxGrid('getrowdata', selectedrowindex);
	

		                    //Creamos la URL
	                        var urlApplProcess =  "../menu/main.jsp?titleOption="+applyval_process_title+"&optLoad=1&paginaWeb=../applyvalues/applyValues_view.jspXXXXlevel=USERZZZZcode="+dataRecord.id_user + 'ZZZZcodeName='+dataRecord.user_name;
	                        
							
							//Simulamos el CLICK
//							menuclick(urlApplProcess,applyval_process_title);    				

	                        //abrimos en nueva pestaña
	                        window.open(urlApplProcess,'_newtab');
									
	                        
	                	}	            
		         	
	            });     
	         	

		        // -------------------------------------------------------------------------------------------
		        // ToolTipText de los botones y acciones. Ojo siempre al final del Jquery.
				// -------------------------------------------------------------------------------------------                
                $("#popupWindowEditUsers_recargar").jqxTooltip({ content: Refresh, position: 'default'});
                $("#popupWindowEditUsers_print").jqxTooltip({ content: Print, position: 'default'});
                $("#popupWindowEditUsers_excelExport").jqxTooltip({ content: Excel, position: 'default'});
                $("#popupWindowEditUsers_nuevo").jqxTooltip({ content: New, position: 'default'});
                $("#popupWindowEditUsers_editar").jqxTooltip({ content: Edit, position: 'default'});
                $("#popupWindowEditUsers_eliminar").jqxTooltip({ content: Delete, position: 'default',});
                $("#popupWindowEditUsers_chgpassword").jqxTooltip({ content: users_lista.TootipText.chgPassword, position: 'default'});
                $("#popupWindowEditUsers_usersystems").jqxTooltip({ content: users_lista.TootipText.usersystems, position: 'default'});
                $("#popupWindowEditUsers_parameters").jqxTooltip({ content: Parameters, position: 'default'});
                
                
             // -------------------------------------------------------------------------------------------
             // LISTAS DE EDICION DEL PRINCIPAL 
             // -------------------------------------------------------------------------------------------                

             //del combo box de roles
                var sourcecb =
                   {
                       datatype: "json",
                       datafields: [
                           { name: 'id' },
                           { name: 'name' }
                       ],
                       url: '../admin/rolesseguridad_data.jsp',
                       async: true
                   };
                   var dataAdaptercb = new $.jqx.dataAdapter(sourcecb);
                // Create a jqxComboBox
                  $("#popupWindowEditUsers_jqxCombo").jqxComboBox({theme: JsUIStyleCss, selectedIndex: 0, source: dataAdaptercb, displayMember: "name", valueMember: "id", width: 200, height: 25});
                
               //del combo box Dispositivos
                  var source_dispositivo =
                     {
                         datatype: "json",
                         datafields: [
                             { name: 'id_device' },
                             { name: 'name' }
                         ],
                         url: '../admin/lista_devices.jsp',
                         async: true
                     };
                     var dataAdapter_dispositivo = new $.jqx.dataAdapter(source_dispositivo);
                  // Create a jqxComboBox
                    $("#popupWindowEditUsers_jqxComboDevice").jqxComboBox({theme: JsUIStyleCss, selectedIndex: 0, source: dataAdapter_dispositivo, displayMember: "name", valueMember: "id_device", width: 200, height: 25});



                  popupWindowEditUsers_jqxComboDevice

                  
// -------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------
// FORMULARIO CAMBIO DE CLAVE
// -------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------                

				// -------------------------------------------------------------------------------------------
                // Validaciones del formulario cambio de clave
				// -------------------------------------------------------------------------------------------                
                  $('#Form_popupWindowPasswordUser').jqxValidator({
                                  //hintType: 'label',
                                  animationDuration: 500,
                                  theme: JsUIStyleCss,
                                  rules: [
                                          //rule: 'length=3,12'    rule: 'notNumber'    
                                          { input: '#popupWindowPasswordUser_clavenueva', message: users_lista.validacion4, action: 'keyup, blur', rule: 'required' },
                                          { input: '#popupWindowPasswordUser_clavenueva', message: users_lista.validacion2(6,30), action: 'keyup, blur', rule: 'length=6,30' },
                                          { input: '#popupWindowPasswordUser_clavenueva2', message: users_lista.validacion4, action: 'keyup, blur', rule: 'required' },
                                          { input: '#popupWindowPasswordUser_clavenueva2', message: users_lista.validacion5, action: 'keyup, focus', 
                                                   rule: function (input, commit) 
                                                         {
                                                              // call commit with false, when you are doing server validation and you want to display a validation error on this field.
                                                               
                                                              if (input.val() === $('#popupWindowPasswordUser_clavenueva').val()) {
                                                                  return true;
                                                              }
                                                              return false;
                                                          } // de la funcion
                                          } //del input
                                                                         
                                       ] // de las rules
                   });                
                  
  				// -------------------------------------------------------------------------------------------
                // Formatos
  				// -------------------------------------------------------------------------------------------                
        		  $("#popupWindowPasswordUser_iduser").jqxInput({ theme: JsUIStyleCss });
                  $("#popupWindowPasswordUser_clavenueva").jqxInput({ theme: JsUIStyleCss });
                  $("#popupWindowPasswordUser_clavenueva2").jqxInput({ theme: JsUIStyleCss });
                  $("#popupWindowPasswordUser_Cancel").jqxButton({ theme: JsUIStyleCss });
                   $("#popupWindowPasswordUser_Save").jqxButton({ theme: JsUIStyleCss });
                  $("#popupWindowPasswordUser_Save").val(Save); //textos traducidos a botones
                  $("#popupWindowPasswordUser_Cancel").val(Cancel); //textos traducidos a los botones		    
                  


    			// -------------------------------------------------------------------------------------------
                // Acciones sobre el formulario de cambio de clave
    			// ------------------------------------------------------------------------------------------- 

    			  // -------------------------------------------------------------------------
                  // Save Password
                  // -------------------------------------------------------------------------
                  $("#popupWindowPasswordUser_Save").click(function () {
                      $('#Form_popupWindowPasswordUser').jqxValidator('validate');
                  });
                  
                  //cuando este ok la validacion llamamos a cambio de clave
                  // -------------------------------------------------------------------------
                  $('#Form_popupWindowPasswordUser').jqxValidator({ onSuccess: function () { chgPassworddb(); }}); 
                  
                
                  //funcion que guarda de verdad.
                  // -------------------------------------------------------------------------
                  function chgPassworddb()
                  {
                        //Ojo la validacioon de claves se hace con jquery con validaciones.
                                $.get('../admin/usuarios_save.jsp', {oper:'CHGPASSWORD' , id_user: $("#popupWindowPasswordUser_iduser").val(), password:$("#popupWindowPasswordUser_clavenueva").val()}, 
                                      function(resp) {
                                              //all finalizar mostramos el mensaje
                                              showMensaje(resp.trim()); 
                                      }
                                  );
                                
                                $("#popupWindowPasswordUser").jqxWindow('hide'); //ocultamos el Form Modal
                         
                   };

                   // -------------------------------------------------------------------------
                   // Cancel Form Password
                   // -------------------------------------------------------------------------
                   $("#popupWindowPasswordUser_Cancel").click(function () {
                	   $("#popupWindowPasswordUser").jqxWindow('hide'); //ocultamos el Form Modal
                   });    






// -------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------
// FORMULARIO SISTEMAS ASIGNADOS AL USUARIO
// -------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------                
					var anchoGridSystems=anchoform3-10;
					var altoGridSystems = altoForm3-40;

         			// -------------------------------------------------------------------------------------------
                    // Origen de los datos
            		// -------------------------------------------------------------------------------------------                       

		               	var sourceSystems =
						{
							datatype: "json",
							datafields: [
								{ name: 'id_user'},
								{ name: 'id_system'},
								{ name: 'name'}
							],
							url: '../admin/usuarios_system_data.jsp',
							cache: false,
				                        id:'id',
				                        filter: function()
				                        {
				                                // update the grid and send a request to the server.
				                                $("#popupWindowUserSystems_jqxgrid").jqxGrid('updatebounddata', 'filter');
				                        },
				                        sort: function()
				                        {
				                                // update the grid and send a request to the server.
				                                $("#popupWindowUserSystems_jqxgrid").jqxGrid('updatebounddata', 'sort');
				                        },
				                        root: 'Rows',
				                        beforeprocessing: function(data)
				                        {		
				                                if (data != null)
				                                {
				                                        source.totalrecords = data[0].TotalRows;					
				                                }
				                        }
				                                            
								};
		

				                // -------------------------------------------------------------------------------------------
				                 // Adaptador del Origenprincipal
				                 // -------------------------------------------------------------------------------------------
					                var dataadapterSystems = new $.jqx.dataAdapter(sourceSystems, {
											loadError: function(xhr, status, error)
											{
												//Cotnrol de Errores. Si falla algo o la session etc. Se manda mensaje y al login
												showMensaje(ControlSessionMsg);
												window.location = "../../index.html";
												return;
												
											},
					                        loadComplete: function () {
					                            // data is loaded.
					                        },
											downloadComplete:function(edata, textStatus, jqXHR)
											{
					
					                        }                        
									});



				                // -------------------------------------------------------------------------------------------
				                // Definición del Grid de datos 
								// -------------------------------------------------------------------------------------------                

				   			    $("#popupWindowUserSystems_jqxgrid").jqxGrid(
								{
				                    theme: JsUIStyleCss,
				                    source: dataadapterSystems,
				                    width: anchoGridSystems,
				                    height: altoGridSystems,
				                    columnsresize: true, 
				                    filterable: false,
				                    sortable: false,
				                    autoheight: false,
				                    pageable: false,
				                    //pagermode: 'simple',
				                    //pagerrenderer: pagerrendererUsers,
				                    virtualmode: false,
				                    altrows: false,
				                    showtoolbar: true, //muestra la barra de herramientas superior
				                    showstatusbar: false, //muestra la barra de abajo de estado
				                    
				                    rendergridrows: function(obj)
										{
											return obj.data;    
										},
				                    columns: [
											{ text: 'user', datafield: 'id_user', width: 0, hidden:true},                            
				                            { text: systems_form_id_system, datafield: 'id_system', width: "50%"},
				                            { text: systems_form_name, datafield: 'name', width: "50%"}

				                            
				                          ], //de columns

				                        rendertoolbar: function (toolbar) {
				                            
				                            var container2 = $("<div style='margin: 2px;'></div>");

				                            
				                            var input31 = $("<a href='#' ><img src='../../images/refresh.png' width='22' id='popupWindowUserSystems_recargar'></a>");
				                            var input41 = $("<a href='#' ><img src='../../images/new.png' width='23' id='popupWindowUserSystems_nuevo'></a>");
				                            var input51 = $("<a href='#' ><img src='../../images/delete.png' width='25' id='popupWindowUserSystems_eliminar'></a>");
				                            
				                            toolbar.append(container2);
				                            container2.append(input31);
				                            container2.append(input41);
				                            container2.append(input51);
				                       }

								});  //del grid 
				                


								// -------------------------------------------------------------------------------------------	            
					            //Recargar
								// -------------------------------------------------------------------------------------------	            
					            
					            $("#popupWindowUserSystems_recargar").click(function () {
					                
					                $("#popupWindowUserSystems_jqxgrid").jqxGrid('updatebounddata', 'cells');          
					            });

					            
								
								// -------------------------------------------------------------------------------------------
								// Eliminar un registro Systema asociado al usuario
								// -------------------------------------------------------------------------------------------		 			            
						          $("#popupWindowUserSystems_eliminar").on('click', function () {
						
						                if (confirm(DeleteMsg))
						                {
						                        var selectedrowindex = $("#popupWindowUserSystems_jqxgrid").jqxGrid('getselectedrowindex');
						                        var rowscount = $("#popupWindowUserSystems_jqxgrid").jqxGrid('getdatainformation').rowscount;
						                        if (selectedrowindex >= 0 && selectedrowindex < rowscount) {
						
						                            var id = $("#popupWindowUserSystems_jqxgrid").jqxGrid('getrowid', selectedrowindex);
						                            var dataRecord = $("#popupWindowUserSystems_jqxgrid").jqxGrid('getrowdata', id);

						                            //lanzamos la grabacion por el post
					                                $.post('../admin/usuarios_system_save.jsp', { oper : 'DEL', id_user : UserEditId , id_system : dataRecord.id_system}, 
					                                    function(resp) {
					                                         if (resp.split('{')[0].trim() == "true")
					                                          {
					                                             $("#popupWindowUserSystems_jqxgrid").jqxGrid('updatebounddata', 'cells');
					                                          }                                          
					                                          else
					                                          {
					                                             $("#popupWindowUserSystems_jqxgrid").jqxGrid('updatebounddata', 'cells');
					                                              showMensaje(resp.split('{')[1]); //mensaje de error
					                                          }  
					                                    }
					                                );
					                    						                            
						                        }
						           		 }
						            });

						        

				            	// -------------------------------------------------------------------------------------------
						        //  Nuevo Registro Systema
						        // -------------------------------------------------------------------------------------------            
					            $("#popupWindowUserSystems_nuevo").on('click', function () {
					                     
					                     editrow = -1;  
					                     operacion = "NEW"; //Marco la operación 
					                     var offset = $("#popupWindowUserSystems_jqxgrid").offset();
					                     $("#popupWindowUserSystemsEdit").jqxWindow({ position: { x:(anchoVentana-anchoform4)/2, y: parseInt(offset.top) + 100 } });
					                     //abro la ventana
					                     $("#popupWindowUserSystemsEdit").jqxWindow('open');

					            });     

					        


				                // -------------------------------------------------------------------------------------------
				                // Formato de los campos de los Modales y botones
				                // -------------------------------------------------------------------------------------------
				                
				                $("#popupWindowUserSystemsEdit_Save").jqxButton({ theme: JsUIStyleCss });
				                $("#popupWindowUserSystemsEdit_Save").val(Save); //textos traducidos a botones
				                $("#popupWindowUserSystemsEdit_Cancel").jqxButton({ theme: JsUIStyleCss });
				                $("#popupWindowUserSystemsEdit_Cancel").val(Save); //textos traducidos a botones

				                // -------------------------------------------------------------------------------------------
				                // Formato de los campos de los Modales y botones
				                // -------------------------------------------------------------------------------------------				                
				                $("#popupWindowUserSystems_recargar").jqxTooltip({ content: Refresh, position: 'default'});
				                $("#popupWindowUserSystems_nuevo").jqxTooltip({ content: New, position: 'default'});
				                $("#popupWindowUserSystems_eliminar").jqxTooltip({ content: Delete, position: 'default',});



				                // -------------------------------------------------------------------------------------------
				                // LISTAS DE EDICION DE SISTEMAS DEL USUARIO 
				                // -------------------------------------------------------------------------------------------                

				                //del combo box de roles
				                   var sourceSystems =
				                      {
				                          datatype: "json",
				                          datafields: [
				                              { name: 'id_system' },
				                              { name: 'name' }
				                          ],
				                          url: '../auxiliares/systems_data.jsp',
				                          async: true
				                      };
				                      var dataAdapterSystems = new $.jqx.dataAdapter(sourceSystems);
				                   // Create a jqxComboBox
				                     $("#popupWindowUserSystemsEdit_jqxComboSystem").jqxComboBox({theme: JsUIStyleCss, selectedIndex: 0, source: dataAdapterSystems, displayMember: "name", valueMember: "id_system", width: 200, height: 25});
				                   
				                
				                     // -------------------------------------------------------------------------
				                     // Cancel Form 
				                     // -------------------------------------------------------------------------
				                     $("#popupWindowUserSystemsEdit_Cancel").click(function () {
				                  	   $("#popupWindowUserSystemsEdit").jqxWindow('hide'); //ocultamos el Form Modal
				                     });    

				                     // -------------------------------------------------------------------------
				                     // Save 
				                     // -------------------------------------------------------------------------
				                     $("#popupWindowUserSystemsEdit_Save").click(function () {
										 
				                    	 //UserEditId aqui la variable con el usuario
				                          $.post('../admin/usuarios_system_save.jsp', { oper : 'NEW', id_user : UserEditId, id_system:$("#popupWindowUserSystemsEdit_jqxComboSystem").val()}, 
				                                    function(resp) {
				                                          if (resp.split('{')[0].trim() == "true")
				                                          {
				                                             $("#popupWindowUserSystems_jqxgrid").jqxGrid('updatebounddata', 'cells');
				                                             $("#popupWindowUserSystemsEdit").jqxWindow('hide'); //ocultamos el Form Modal
				                                             showMensaje(resp.split('{')[1],1); 
				                                          }                                          
				                                          else
				                                          {
				                                              showMensaje(resp.split('{')[1],2); //mensaje de error
					                                          $("#popupWindowUserSystems_jqxgrid").jqxGrid('updatebounddata', 'cells');
				                                          }
				                            });//del post   
				                     });    
				                     
								
	});
</script>

</div>