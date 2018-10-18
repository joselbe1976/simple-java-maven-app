<%@include file="../globales/globalAllPages.jsp" %>
<%@include file="../login/seguridad_view.jsp" %>



<div id="FormSystemsMain">
 <div id="FormSystems">
       <table width="100%">
           <tr>
               <td width="100%" colspan="3" align="center">
                   <!-- Grid -->
                   <div id="FormSystemsMain_jqxgrid"></div>
               </td>
           </tr>
       </table>

 <!-- popoup modal de edición -->

                    <div id="popupWindowEditSystems">
                        <div><label class="i18n labelnormal" id="systems_form_title"></label></div>
                           <div style="overflow: hidden;">
                               <form id="Form_popupWindowEditSystems" action="./">
                                  
                                   <table>
                                        <tr><!-- ID Systema -->
                                            <td align="right"><label class="i18n" id="systems_form_id_system"></label></td>
                                            <td align="left"><input id="popupWindowEditSystems_id_system" /></td>
                                        </tr>
                                        <tr> <!-- Nombre  -->
                                            <td align="right"><label class="i18n" id="systems_form_name"></label></td>
                                            <td align="left"><input id="popupWindowEditSystems_name" /></td>
                                        </tr>
                                        
                                        <tr>
                                            <td align="right"><label class="i18n" id="roles_lista.grid.channel"></label></td>
                                            <td align="left"><input id="popupWindowEditSystems_parse_channel" /></td>
                                        </tr>

                                        <!--  Check Token Login -->
  	                                    <tr>
                                            <td align="right"></td>
                                            <td align="left"><div id='popupWindowEditSystems_token_login'><span><label class="i18n" id="systems_form_token_login"></label></span></div></td>
                                        </tr>          
                                        <!--  Check All users -->
  	                                    <tr>
                                            <td align="right"></td>
                                            <td align="left"><div id='popupWindowEditSystems_all_users'><span><label class="i18n" id="systems_form_all_users"></label></span></div></td>
                                        </tr>          
                                        <tr> <!-- Usuario fijo  -->
                                            <td align="right"><label class="i18n" id="systems_form_user_fijo"></label></td>
                                            <td align="left"><input id="popupWindowEditSystems_user_fijo" /></td>
                                        </tr>
                                        <tr> <!-- Clave fijo  -->
                                            <td align="right"><label class="i18n" id="systems_form_pass_fijo"></label></td>
                                            <td align="left"><input type="password" id="popupWindowEditSystems_pass_fijo" /></td>
                                        </tr>
                                        <tr valign="top"> <!-- Comentario -->
                                            <td align="right"><label class="i18n" id="systems_form_comment"></label></td>
                                            <td align="left"><textarea rows="4" cols="40" id="popupWindowEditSystems_comment"></textarea></td>
                                        </tr>
                                        
                                        <tr> <!-- Esto son los botones -->
                                            <td align="right"></td>
                                            <td style="padding-top: 10px;" align="right"><input type="button" style="margin-right: 5px;"  id="popupWindowEditSystems_Save" ></button><input id="popupWindowEditSystems_Cancel" type="button" value="Cancelar" /></td>
                                        </tr>
                                        <tr>
                                            <td align="right"> </td>
                                            <td align="left"> </td>
                                        </tr>                                        
                                    </table>
                               </form>
                           </div>
                      </div>       
</div>


<script type="text/javascript">
$(document).ready(function () {
	
				 var anchoform1 = 400;	
				 var altoForm1 =  390;

				 
				 
                  $("#popupWindowEditSystems").jqxWindow({
                	  Height: altoForm1, width: anchoform1, resizable: false, theme: JsUIStyleCss, isModal: true, autoOpen: false, cancelButton: $("#popupWindowEditSystems_Cancel"), modalOpacity: 0.01, animationType: 'combined', showAnimationDuration: 400, closeAnimationDuration: 400            
                  });

                  
                //i18N
                chgLang('<%=viewIdioma%>');   


				

// -------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------
// FORMULARIO PRINCIPAL
// -------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------                
                
                // -------------------------------------------------------------------------------------------
                //Origen datos para alimentar datos Json/XML de los componentes 
                // -------------------------------------------------------------------------------------------
                
				var source =
				{
					datatype: "json",
					datafields: [
						{ name: 'id_system'},
						{ name: 'name'},
						{ name: 'comment'},
						{ name: 'chk_ldap'},
						{ name: 'chk_token_login'},
						{ name: 'chk_all_users'},
						{ name: 'sys_user_fijo'},
						{ name: 'sys_pass_fijo'},
						{ name: 'parse_channel'}
					],
					url: '../auxiliares/systems_data.jsp',
					cache: false,
		                        id:'id',
		                        filter: function()
		                        {
		                                // update the grid and send a request to the server.
		                                $("#FormSystemsMain_jqxgrid").jqxGrid('updatebounddata', 'filter');
		                        },
		                        sort: function()
		                        {
		                                // update the grid and send a request to the server.
		                                $("#FormSystemsMain_jqxgrid").jqxGrid('updatebounddata', 'sort');
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
			                        	
		                                  $.post('../auxiliares/systems_save.jsp', { oper : 'NEW', id_system : rowData.id_system, name : rowData.name,  comment: rowData.comment,sys_user_fijo: rowData.sys_user_fijo, sys_pass_fijo: rowData.sys_pass_fijo, token_login: rowData.token_login, all_users: rowData.all_users, parse_channel : rowData.parse_channel }, 
		                                    function(resp) {
		                                          if (resp.split('{')[0].trim() == "true")
		                                          {
		                                             commit(true);
		                                             $("#FormSystemsMain_jqxgrid").jqxGrid('updatebounddata', 'cells');
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
		                                $.post('../auxiliares/systems_save.jsp', { oper : 'MOD',  id_system : rowData.id_system, name : rowData.name,  comment: rowData.comment,sys_user_fijo: rowData.sys_user_fijo, sys_pass_fijo: rowData.sys_pass_fijo, token_login: rowData.token_login,  all_users: rowData.all_users, parse_channel : rowData.parse_channel }, 
		                                    function(resp) {
		                                        
		                                         if (resp.split('{')[0].trim() == "true")
		                                          {
		                                             commit(true); 
		                                             $("#FormSystemsMain_jqxgrid").jqxGrid('updatebounddata', 'cells');
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
		                                $.post('../auxiliares/systems_save.jsp', { oper : 'DEL', id_system : rowID }, 
		                                    function(resp) {
		                                         if (resp.split('{')[0].trim() == "true")
		                                          {
		                                             commit(true); 
		                                             $("#FormSystemsMain_jqxgrid").jqxGrid('updatebounddata', 'cells');
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
                  $("#popupWindowEditSystems_Cancel").jqxButton({ theme: JsUIStyleCss });
                  $("#popupWindowEditSystems_Save").jqxButton({ theme: JsUIStyleCss });
                  $("#popupWindowEditSystems_Save").val(Save); //textos traducidos a botones
                  $("#popupWindowEditSystems_Cancel").val(Cancel); //textos traducidos a los botones

                //Fields		    
		          $("#popupWindowEditSystems_id_system").jqxInput({ theme: JsUIStyleCss,width: '150px', height: '23px' });
                  $("#popupWindowEditSystems_name").jqxInput({ theme: JsUIStyleCss,width: '200px', height: '23px' });
                  $("#popupWindowEditSystems_parse_channel").jqxInput({ theme: JsUIStyleCss,width: '200px', height: '23px' });
                  $("#popupWindowEditSystems_comment").jqxInput({ theme: JsUIStyleCss,width: '300px', height: '60px'});
                  $("#popupWindowEditSystems_token_login").jqxCheckBox({ theme: JsUIStyleCss,height: 25});
                  
                  $("#popupWindowEditSystems_all_users").jqxCheckBox({ theme: JsUIStyleCss,height: 25});
                  $("#popupWindowEditSystems_user_fijo").jqxInput({ theme: JsUIStyleCss,width: '200px', height: '23px' });
                  $("#popupWindowEditSystems_pass_fijo").jqxInput({ theme: JsUIStyleCss,width: '200px', height: '23px' });
                  
                  var editrow = -1; //indica la linea a editar/eliminar/nuevo
                  var operacion = ""; //indica la operacion DEL cuando es necesario
                  
                // -------------------------------------------------------------------------------------------
                // Validaciones del formulario
				// -------------------------------------------------------------------------------------------                
                    $('#Form_popupWindowEditSystems').jqxValidator({
                                    //hintType: 'label',
                                    animationDuration: 500,
                                    theme: JsUIStyleCss,
                                    rules: [
                                            { input: '#popupWindowEditSystems_id_system', message: Obligatorio, action: 'keyup, blur', rule: 'required' },
                                            { input: '#popupWindowEditSystems_name', message: Obligatorio, action: 'keyup, blur', rule: 'required' },
                                            { input: '#popupWindowEditSystems_parse_channel', message: Obligatorio, action: 'keyup, blur', rule: 'required' }
                                           ]
                              });        


                 // -------------------------------------------------------------------------------------------
                 // Adaptador del Origenprincipal
                 // -------------------------------------------------------------------------------------------
	                var dataadapter = new $.jqx.dataAdapter(source, {
							loadError: function(xhr, status, error)
							{
								//Cotnrol de Errores. Si falla algo o la session etc. Se manda mensaje y al login
								showMensaje(ControlSessionMsg,2);
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
	                var pagerrendererSystems = function () {
	                    var element = $("<div style='margin-left: 10px; margin-top: 5px; width: 100%; height: 100%; '></div>");
	                    var datainfo = $("#FormSystemsMain_jqxgrid").jqxGrid('getdatainformation');
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
	                        $("#FormSystemsMain_jqxgrid").jqxGrid('gotonextpage');
	                    });
	                    leftButton.click(function () {
	                        $("#FormSystemsMain_jqxgrid").jqxGrid('gotoprevpage');
	                    });
	                    return element;
	                }

	                $("#FormSystemsMain_jqxgrid").on('pagechanged', function () {
	                    var datainfo = $("#FormSystemsMain_jqxgrid").jqxGrid('getdatainformation');
	                    var paginginfo = datainfo.paginginformation;
	                    self.label.text(1 + paginginfo.pagenum * paginginfo.pagesize + "-" + Math.min(datainfo.rowscount, (paginginfo.pagenum + 1) * paginginfo.pagesize) + ' of ' + datainfo.rowscount);
	                });
	                
	                

	                 
                // -------------------------------------------------------------------------------------------
                // Definición del Grid de datos principal
				// -------------------------------------------------------------------------------------------                

   			    $("#FormSystemsMain_jqxgrid").jqxGrid(
				{
                    theme: JsUIStyleCss,
                    source: dataadapter,
                    width: anchoVentana,
                    height: altoVentana,
                    //pagermode: 'simple',
                    pagerrenderer: pagerrendererSystems,  
                    columnsresize: true,                  
                    filterable: true,
                    filtermode: 'excel',
                    sortable: true,
                    autoheight: false,
                    pageable: true,
                    virtualmode: false,
                    altrows: false,
                    showtoolbar: true, //muestra la barra de herramientas superior
                    showstatusbar: false, //muestra la barra de abajo de estado
                    
                    rendergridrows: function(obj)
						{
							return obj.data;    
						},
                    columns: [
                             
                            { text: systems_form_id_system, datafield: 'id_system', width: 0, hidden: true },
                            { text: systems_form_name, datafield: 'name', width: "10%" },
                            { text: roles_lista.grid.channel, datafield: 'parse_channel', width: "15%"},
                            { text: systems_form_token_login, datafield: 'chk_token_login', width: "10%", columntype: 'checkbox' },
                            { text: systems_form_all_users, datafield: 'chk_all_users', width: "15%",columntype: 'checkbox' },
                            { text: systems_form_user_fijo, datafield: 'sys_user_fijo', width: "15%" },
                            { text: systems_form_pass_fijo, datafield: 'sys_pass_fijo', width: 0,hidden: true  },
                            { text: systems_form_comment, datafield: 'comment', width: "35%"}
                          ], //de columns

                        rendertoolbar: function (toolbar) {
                            
                            var container = $("<div style='margin: 2px;'></div>");

                            var input1 = $("<a href='#' ><img src='../../images/excel.png' width='27' id='popupWindowEditSystems_excelExport'></a>"); 
                            var input2 = $("<a href='#' ><img src='../../images/imprimir.png' width='25' id='popupWindowEditSystems_print'></a>"); 
                            var blanco = $("<a href='#' ><img src='../../images/blanco.png' width='22'></a>");
                            
                            var input3 = $("<a href='#' ><img src='../../images/refresh.png' width='22' id='popupWindowEditSystems_recargar'></a>");
                            var input4 = $("<a href='#' ><img src='../../images/new.png' width='23' id='popupWindowEditSystems_nuevo'></a>");
                            var input5 = $("<a href='#' ><img src='../../images/delete.png' width='25' id='popupWindowEditSystems_eliminar'></a>");
                            var input6 = $("<a href='#' ><img src='../../images/edit.png' width='22' id='popupWindowEditSystems_editar'></a>");
                            var blanco1 = $("<a href='#' ><img src='../../images/blanco.png' width='10'></a>");
                            var blanco2 = $("<a href='#' ><img src='../../images/blanco.png' width='10'></a>");
                            var blanco3 = $("<a href='#' ><img src='../../images/blanco.png' width='10'></a>");      
                            var input10 = $("<a href='#' ><img src='../../images/parameters.png' width='22' id='popupWindowEditSystems_parameters'></a>");

                                                 
                            
                            toolbar.append(container);
                            container.append(input3);
                            container.append(input4);
                            container.append(input5);
                            container.append(input6);                           
                            container.append(blanco);
                            container.append(input1);
                            container.append(input2);
                            container.append(blanco3);
                            container.append(input10); 
                       }

				});  //del grid 
                


		        // -------------------------------------------------------------------------------------------
		        // Acciones y Operaciones --------------------------------------------------------------------
				// -------------------------------------------------------------------------------------------                
  				// -------------------------------------------------------------------------------------------
			      // initialize the popup window and buttons.
                  $("#popupWindowEditSystems").on('open', function () {
                  });

                  //boton Save del formulario. Validamos los datos
                  $("#popupWindowEditSystems_Save").click(function () {
                      $('#Form_popupWindowEditSystems').jqxValidator('validate');
                  });
                  
                   //cuando este ok la validacion llamamos a Guarda
                  $('#Form_popupWindowEditSystems').jqxValidator({ onSuccess: function () { popupWindowEditSystems_guarda(); } }); 
                  
    			// -------------------------------------------------------------------------------------------
                // boton Save del formulario
  				// -------------------------------------------------------------------------------------------                  
                  function popupWindowEditSystems_guarda() 
                  {
                      if (operacion == "MOD") {  //modificacion
                          //edicion
                          
                          var row = {parse_channel:$("#popupWindowEditSystems_parse_channel").val(),id_system: $("#popupWindowEditSystems_id_system").val(), name: $("#popupWindowEditSystems_name").val() , comment: $("#popupWindowEditSystems_comment").val(),sys_user_fijo: $("#popupWindowEditSystems_user_fijo").val(), sys_pass_fijo: $("#popupWindowEditSystems_pass_fijo").val() ,all_users: $('#popupWindowEditSystems_all_users').jqxCheckBox('checked')==true ? 1 : 0,  token_login: $('#popupWindowEditSystems_token_login').jqxCheckBox('checked')==true ? 1 : 0};                          
                          var rowID = $('#FormSystemsMain_jqxgrid').jqxGrid('getrowid', editrow);
                          $('#FormSystemsMain_jqxgrid').jqxGrid('updaterow', rowID, row);
                          $("#popupWindowEditSystems").jqxWindow('hide'); //ocultamos el Form Modal
                      }
                      else if (operacion == "NEW") //Nuevo registro
                      {
                    	  var row = {parse_channel:$("#popupWindowEditSystems_parse_channel").val(),id_system: $("#popupWindowEditSystems_id_system").val(), name: $("#popupWindowEditSystems_name").val() , comment: $("#popupWindowEditSystems_comment").val(),sys_user_fijo: $("#popupWindowEditSystems_user_fijo").val(), sys_pass_fijo: $("#popupWindowEditSystems_pass_fijo").val() ,all_users: $('#popupWindowEditSystems_all_users').jqxCheckBox('checked')==true ? 1 : 0,  token_login: $('#popupWindowEditSystems_token_login').jqxCheckBox('checked')==true ? 1 : 0};
                          var rowID = -1;
                          var rowscount = $("#FormSystemsMain_jqxgrid").jqxGrid('getdatainformation').rowscount;
                          $('#FormSystemsMain_jqxgrid').jqxGrid('addRow', rowID, row,rowscount );
                          $("#popupWindowEditSystems").jqxWindow('hide'); //ocultamos el Form Modal
                      }
                       
                  };
                  
  				// -------------------------------------------------------------------------------------------
	            //Salida Excel
				// -------------------------------------------------------------------------------------------
					            
	            $("#popupWindowEditSystems_excelExport").click(function () {
	                
	                $("#FormSystemsMain_jqxgrid").jqxGrid('exportdata', 'xls', 'FormSystemsMain_jqxgrid');           
	            });

				// -------------------------------------------------------------------------------------------	            
	            //Recargar
				// -------------------------------------------------------------------------------------------	            
	            
	            $("#popupWindowEditSystems_recargar").click(function () {
	                
	                $("#FormSystemsMain_jqxgrid").jqxGrid('updatebounddata', 'cells');          
	            });

	            
				// -------------------------------------------------------------------------------------------	            
        		//Imprimir
				// -------------------------------------------------------------------------------------------        		
		         $("#popupWindowEditSystems_print").click(function () {
		                var gridContent = $("#FormSystemsMain_jqxgrid").jqxGrid('exportdata', 'html');
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
		            $("#popupWindowEditSystems_eliminar").on('click', function () {
		
		                if (confirm(DeleteMsg))
		                {
		                        var selectedrowindex = $("#FormSystemsMain_jqxgrid").jqxGrid('getselectedrowindex');
		                        var rowscount = $("#FormSystemsMain_jqxgrid").jqxGrid('getdatainformation').rowscount;
		                        if (selectedrowindex >= 0 && selectedrowindex < rowscount) {
		
		                            var id = $("#FormSystemsMain_jqxgrid").jqxGrid('getrowid', selectedrowindex);
		                            var dataRecord = $("#FormSystemsMain_jqxgrid").jqxGrid('getrowdata', id);
		                            var commit = $("#FormSystemsMain_jqxgrid").jqxGrid('deleterow', dataRecord.id_system);
		                        }
		           		 }
		            });

		        // -------------------------------------------------------------------------------------------		 			
		        // Editar un Registro
		        // -------------------------------------------------------------------------------------------
               $("#popupWindowEditSystems_editar").on('click', function () {

                   		//Sacamos la fila seleccionada en el grid
		                var selectedrowindex = $("#FormSystemsMain_jqxgrid").jqxGrid('getselectedrowindex');
		                var rowscount = $("#FormSystemsMain_jqxgrid").jqxGrid('getdatainformation').rowscount;

		        		//Si está seleccionad y hay registros
	                  if (selectedrowindex >= 0 && selectedrowindex < rowscount) {
	                        var id = $("#FormSystemsMain_jqxgrid").jqxGrid('getrowid', selectedrowindex);
	                        
	                        editrow = selectedrowindex;
	                        operacion = "MOD";
	                        var offset = $("#FormSystemsMain_jqxgrid").offset();
	                        $("#popupWindowEditSystems").jqxWindow({ position: { x:(anchoVentana-anchoform1)/2, y: parseInt(offset.top) + 100 } });

		                    //Capuramos el "recordset" de la fila seleccionada. 
	                        var dataRecord = $("#FormSystemsMain_jqxgrid").jqxGrid('getrowdata', selectedrowindex);

		                    //Asigno los campos
	        		          $("#popupWindowEditSystems_id_system").val(dataRecord.id_system);
	                          $("#popupWindowEditSystems_name").val(dataRecord.name);
	                          $("#popupWindowEditSystems_comment").val(dataRecord.comment);
	                          $("#popupWindowEditSystems_user_fijo").val(dataRecord.sys_user_fijo);
	                          $("#popupWindowEditSystems_pass_fijo").val(dataRecord.sys_pass_fijo);
	                          $("#popupWindowEditSystems_token_login").jqxCheckBox({ checked:dataRecord.chk_token_login==1?true:false});
	                          $("#popupWindowEditSystems_parse_channel").val(dataRecord.parse_channel);
	                          $("#popupWindowEditSystems_all_users").jqxCheckBox({ checked:dataRecord.chk_all_users==1?true:false});

	                        //abrimos la ventana modal
	                        $("#popupWindowEditSystems").jqxWindow('open');

	                        //deshabilitamos
	                        $("#popupWindowEditSystems_id_user").prop('disabled', true);
	                        $("#popupWindowEditSystems_parse_channel").prop('disabled', true);
	                }
	            });

            	// -------------------------------------------------------------------------------------------
		        //  Nuevo Registro
		        // -------------------------------------------------------------------------------------------            
	            $("#popupWindowEditSystems_nuevo").on('click', function () {
	                     
	                     editrow = -1;  
	                     operacion = "NEW"; //Marco la operación 
	                     var offset = $("#FormSystemsMain_jqxgrid").offset();
	                     $("#popupWindowEditSystems").jqxWindow({ position: { x:(anchoVentana-anchoform1)/2, y: parseInt(offset.top) + 100 } });

	                     // Pongo a blanco los campos
	        		          $("#popupWindowEditSystems_id_system").val('');
	                          $("#popupWindowEditSystems_name").val('');
	                          $("#popupWindowEditSystems_comment").val('');
	                          $("#popupWindowEditSystems_user_fijo").val('');
	                          $("#popupWindowEditSystems_pass_fijo").val('');
	                          $("#popupWindowEditSystems_token_login").jqxCheckBox({ checked:false});
	                          $("#popupWindowEditSystems_parse_channel").val('SYSTEM-');
	                          $("#popupWindowEditSystems_all_users").jqxCheckBox({ checked:false});
                         
	                     //abro la ventana
	                     $("#popupWindowEditSystems").jqxWindow('open');

	                     //Deshabilito los campos que no se deban poder tocar
	                     $("#popupWindowEditSystems_id_user").prop('disabled', false); 
	                     $("#popupWindowEditSystems_parse_channel").prop('disabled', false);
	            });     

	         // -------------------------------------------------------------------------------------------
		        //  Parámetros aplica-valor
		        // -------------------------------------------------------------------------------------------            
	            $("#popupWindowEditSystems_parameters").on('click', function () {
	
		            	//Sacamos la fila seleccionada en el grid
		                var selectedrowindex = $("#FormSystemsMain_jqxgrid").jqxGrid('getselectedrowindex');
		                var rowscount = $("#FormSystemsMain_jqxgrid").jqxGrid('getdatainformation').rowscount;
	
		        		//Si está seleccionad y hay registros
	                  if (selectedrowindex >= 0 && selectedrowindex < rowscount) {
	                        var id = $("#FormSystemsMain_jqxgrid").jqxGrid('getrowid', selectedrowindex);
	                        
	                        editrow = selectedrowindex;
	                        var offset = $("#FormSystemsMain_jqxgrid").offset();
	
		                    //Capuramos el "recordset" de la fila seleccionada. 
	                        var dataRecord = $("#FormSystemsMain_jqxgrid").jqxGrid('getrowdata', selectedrowindex);
	
		                    //Creamos la URL
	                        var urlApplProcess =  "../menu/main.jsp?titleOption="+applyval_process_title+"&optLoad=1&paginaWeb=../applyvalues/applyValues_view.jspXXXXlevel=SYSTEMZZZZcode="+dataRecord.id_system + 'ZZZZcodeName='+dataRecord.name;
	                        
							
							//Simulamos el CLICK
//							menuclick(urlApplProcess,applyval_process_title);    				

	                        //abrimos en nueva pestaña
	                        window.open(urlApplProcess,'_newtab');
	                	}	            
		         	
	            });     	         	

		        // -------------------------------------------------------------------------------------------
		        // ToolTipText de los botones y acciones. Ojo siempre al final del Jquery.
				// -------------------------------------------------------------------------------------------                
                $("#popupWindowEditSystems_recargar").jqxTooltip({ content: Refresh, position: 'default'});
                $("#popupWindowEditSystems_print").jqxTooltip({ content: Print, position: 'default'});
                $("#popupWindowEditSystems_excelExport").jqxTooltip({ content: Excel, position: 'default'});
                $("#popupWindowEditSystems_nuevo").jqxTooltip({ content: New, position: 'default'});
                $("#popupWindowEditSystems_editar").jqxTooltip({ content: Edit, position: 'default'});
                $("#popupWindowEditSystems_eliminar").jqxTooltip({ content: Delete, position: 'default',});
                $("#popupWindowEditSystems_parameters").jqxTooltip({ content: Parameters, position: 'default',});



                  
// -------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------
// FORMULARIOS AUXILIARES AL PRINCIPAL
// -------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------                

			       
	});
</script>

</div>