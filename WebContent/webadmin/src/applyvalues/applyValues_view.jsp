<%@include file="../globales/globalAllPages.jsp" %>
<%@include file="../login/seguridad_view.jsp" %>

<%
	//Cogemos los parámetros que vienen por el GET
	String level = request.getParameter("level");
	String code = request.getParameter("code");
	String codeName=request.getParameter("codeName");
%>



<div id="FormApplyVal">
 <div id="FormApplyValMain">
       <table width="100%">
           <tr>
               <td width="100%" colspan="3" align="center">
                   <!-- Grid -->
                   <div id="FormApplyVal_jqxgrid"></div>
               </td>
           </tr>
       </table>

 <!-- popoup modal de edición -->

                    <div id="popupWindowEditApplyVal">
                        <div><label class="i18n labelnormal" id="applyval_process_title2"></label></div>
                           <div style="overflow: hidden;">
                               <form id="Form_popupWindowEditApplyVal" action="./">
                                  
                                   <table>
                                        <tr><!-- Lista roles -->
                                            <td align="right"><label class="i18n" id="users_lista.form1.role"></label></td>
                                            <td align="left"><div id="popupWindowEditApplyVal_id_param"></div></td>
                                        </tr>
                                        
                                        <tr><!-- Valor -->
                                            <td align="right"><label class="i18n" id="params_form_value"></label></td>
                                            <td align="left"><input id="popupWindowEditApplyVal_value" /></td>
                                        </tr>
                                        <tr valign="top"> <!-- Comentario -->
                                            <td align="right"><label class="i18n" id="params_form_comment"></label></td>
                                            <td align="left"><textarea rows="4" cols="40" id="popupWindowEditApplyVal_comment"></textarea></td>
                                        </tr>
                                        <tr> <!-- Esto son los botones -->
                                            <td align="right"></td>
                                            <td style="padding-top: 10px;" align="right"><input type="button" style="margin-right: 5px;"  id="popupWindowEditApplyVal_Save" ><input id="popupWindowEditApplyVal_Cancel" type="button" value="Cancelar" /></td>
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
				 var altoForm1 =  220;
				 var levelData = '<%=level%>'; //Nivel de datos
				 var codeId = '<%=code%>';
				 var codeIdName = '<%=codeName%>';
				 
                  $("#popupWindowEditApplyVal").jqxWindow({
                	  Height: altoForm1, width: anchoform1, resizable: false, theme: JsUIStyleCss, isModal: true, autoOpen: false, cancelButton: $("#popupWindowEditApplyVal_Cancel"), modalOpacity: 0.01 , animationType: 'combined', showAnimationDuration: 400, closeAnimationDuration: 400            
                  });

                  
                //i18N
                chgLang('<%=viewIdioma%>');   


             	// ---------------------------------------------------------------------------------------------
				// View Multi-Tabla. Calculamos aqui las urls de datos y persistencia diferentes por level
				// ---------------------------------------------------------------------------------------------
				
				var url_read_data =''; //lectura
				var url_save_data = ''; //grabacion
				var tituloData = '';

				if (levelData=='PROCESS')
				{
					url_read_data = '../applyvalues/process_apply_data.jsp?idFilter='+codeId; //le pasamos el codigo por el que filtrar
					url_save_data = '../applyvalues/process_apply_save.jsp';
					tituloData = 'Proceso: (' + codeId + ') '+codeIdName;	
				}
				else if (levelData == 'USER')
				{
					url_read_data = '../applyvalues/users_apply_data.jsp?idFilter='+codeId; //le pasamos el codigo por el que filtrar
					url_save_data = '../applyvalues/users_apply_save.jsp';
					tituloData = 'Usuario: (' + codeId + ') '+codeIdName;	
				}
				else if (levelData == 'DEVICE')
				{
					url_read_data = '../applyvalues/device_apply_data.jsp?idFilter='+codeId; //le pasamos el codigo por el que filtrar
					url_save_data = '../applyvalues/device_apply_save.jsp';
					tituloData = 'Dispositivo: (' + codeId + ') '+codeIdName;	
				}
				else if (levelData == 'ROLE')
				{
					url_read_data = '../applyvalues/role_apply_data.jsp?idFilter='+codeId; //le pasamos el codigo por el que filtrar
					url_save_data = '../applyvalues/role_apply_save.jsp';
					tituloData = 'Role: (' + codeId + ') '+codeIdName;	
				}
				else if (levelData == 'SYSTEM')
				{
					url_read_data = '../applyvalues/system_apply_data.jsp?idFilter='+codeId; //le pasamos el codigo por el que filtrar
					url_save_data = '../applyvalues/system_apply_save.jsp';
					tituloData = 'Sistema: (' + codeId + ') '+codeIdName;	
				}


                

// -------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------
// FORMULARIO PRINCIPAL
// -------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------                
                
                // -------------------------------------------------------------------------------------------
                //Origen datos para alimentar datos Json/XML de los componentes 
                // -------------------------------------------------------------------------------------------
                
				var source_FormApplyVal =
				{
					datatype: "json",
					datafields: [
						{ name: 'id'}, 
						{ name: 'id_param'},
						{ name: 'name_param'},  //Para mostrar el nombre
						{ name: 'value'},  //nombre del role
						{ name: 'comment'},
						{ name: 'comment_param'} //Comentario de la tabla de parametro,Solo consulta					
					],
					url: url_read_data, //URL de lectura de los datos
					cache: false,
		                        
		                        filter: function()
		                        {
		                                // update the grid and send a request to the server.
		                                $("#FormApplyVal_jqxgrid").jqxGrid('updatebounddata', 'filter');
		                        },
		                        sort: function()
		                        {
		                                // update the grid and send a request to the server.
		                                $("#FormApplyVal_jqxgrid").jqxGrid('updatebounddata', 'sort');
		                        },
		                        
		                        beforeprocessing: function(data)
		                        {		
		                                if (data != null)
		                                {
		                                	source_FormApplyVal.totalrecords = data[0].TotalRows;					
		                                }
		                        },
		                        addRow: function (rowID, rowData, position, commit) {

		   		            
		                                  $.post(url_save_data, { oper : 'NEW', code: codeId, id_param: rowData.id_param,  value : rowData.value, comment : rowData.comment }, 
		                                    function(resp) {
		                                           
		                                          if (resp.split('{')[0].trim() == "true")
		                                          {
		                                             commit(true);
		                                             $("#FormApplyVal_jqxgrid").jqxGrid('updatebounddata', 'cells');
		                                             $("#popupWindowEditApplyVal").jqxWindow('hide'); //ocultamos el Form Modal
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
		             
		                                $.post(url_save_data, { oper : 'MOD', code: codeId, id_param: rowData.id_param,  value : rowData.value, comment : rowData.comment }, 
		                                    function(resp) {
		                                        
		                                         if (resp.split('{')[0].trim() == "true")
		                                          {
		                                             commit(true); 
		                                             $("#FormApplyVal_jqxgrid").jqxGrid('updatebounddata', 'cells');
		                                             $("#popupWindowEditApplyVal").jqxWindow('hide'); //ocultamos el Form Modal
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
		                                $.post(url_save_data, { oper : 'DEL', code: codeId, id_param : rowID }, 
		                                    function(resp) {
		                                         if (resp.split('{')[0].trim() == "true")
		                                          {
		                                             commit(true); 
		                                           //  showMensaje(resp.split('{')[1]);
		                                             $("#FormApplyVal_jqxgrid").jqxGrid('updatebounddata', 'cells');
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
                  $("#popupWindowEditApplyVal_Cancel").jqxButton({ theme: JsUIStyleCss });
                  $("#popupWindowEditApplyVal_Save").jqxButton({ theme: JsUIStyleCss });
                  $("#popupWindowEditApplyVal_Save").val(Save); //textos traducidos a botones
                  $("#popupWindowEditApplyVal_Cancel").val(Cancel); //textos traducidos a los botones		    
		          
                  $("#popupWindowEditApplyVal_value").jqxInput({ theme: JsUIStyleCss,width: '200px', height: '23px' });
                  $("#popupWindowEditApplyVal_comment").jqxInput({ theme: JsUIStyleCss,width: '300px', height: '60px'});
                  
                  var editrow = -1; //indica la linea a editar/eliminar/nuevo
                  var operacion = ""; //indica la operacion DEL cuando es necesario

                  
                  
                // -------------------------------------------------------------------------------------------
                // Validaciones del formulario
				// -------------------------------------------------------------------------------------------                
                    $('#Form_popupWindowEditApplyVal').jqxValidator({
                                    //hintType: 'label',
                                    animationDuration: 500,
                                    theme: JsUIStyleCss,
                                    rules: [
                                            { input: '#popupWindowEditApplyVal_value', message: Obligatorio, action: 'keyup, blur', rule: 'required' }
                                           ]
                              });        


                 // -------------------------------------------------------------------------------------------
                 // Adaptador del Origenprincipal
                 // -------------------------------------------------------------------------------------------
	                var dataadapter_FormApplyVal = new $.jqx.dataAdapter(source_FormApplyVal, {
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
			/*	
                var pagerrenderer_FormApplyVal = function () {
                    var element = $("<div style='margin-left: 10px; margin-top: 5px; width: 100%; height: 100%; '></div>");
                    var datainfo = $("#FormApplyVal_jqxgrid").jqxGrid('getdatainformation');
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
                    
                    if (JsUIStyleCss != '') {
                        handleStates('mousedown', rightButton, 'jqx-icon-arrow-right-selected-' + JsUIStyleCss, true);
                        handleStates('mouseup', rightButton, 'jqx-icon-arrow-right-selected-' + JsUIStyleCss, false);
                        handleStates('mousedown', leftButton, 'jqx-icon-arrow-left-selected-' + JsUIStyleCss, true);
                        handleStates('mouseup', leftButton, 'jqx-icon-arrow-left-selected-' + JsUIStyleCss, false);
                        handleStates('mouseenter', rightButton, 'jqx-icon-arrow-right-hover-' + JsUIStyleCss, true);
                        handleStates('mouseleave', rightButton, 'jqx-icon-arrow-right-hover-' + JsUIStyleCss, false);
                        handleStates('mouseenter', leftButton, 'jqx-icon-arrow-left-hover-' + JsUIStyleCss, true);
                        handleStates('mouseleave', leftButton, 'jqx-icon-arrow-left-hover-' + JsUIStyleCss, false);
                    }
                    rightButton.click(function () {
                        $("#FormApplyVal_jqxgrid").jqxGrid('gotonextpage');
                    });
                    leftButton.click(function () {
                        $("#FormApplyVal_jqxgrid").jqxGrid('gotoprevpage');
                    });
                    return element;
                }

                $("#FormApplyVal_jqxgrid").on('pagechanged', function () {
                    var datainfo = $("#FormApplyVal_jqxgrid").jqxGrid('getdatainformation');
                    var paginginfo = datainfo.paginginformation;
                    self.label.text(1 + paginginfo.pagenum * paginginfo.pagesize + "-" + Math.min(datainfo.rowscount, (paginginfo.pagenum + 1) * paginginfo.pagesize) + ' of ' + datainfo.rowscount);
                });
                
                
*/

                // -------------------------------------------------------------------------------------------
                // Definición del Grid de datos principal
				// -------------------------------------------------------------------------------------------                

   			    $("#FormApplyVal_jqxgrid").jqxGrid(
				{
                    theme: JsUIStyleCss,
                    source: dataadapter_FormApplyVal,
                    width: anchoVentana,
                    height: altoVentana,
                    columnsresize: true,
                    filterable: false,
                    sortable: true,
                    autoheight: false,
                    pageable: false,
                    //pagermode: 'simple',
                    //pagerrenderer: pagerrenderer_FormApplyVal,
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
                            { text: 'id', datafield: 'id', width: 0, hidden:true}, //pk
                            { text: 'id_param', datafield: 'id_param', width: 0, hidden:true }, //pk
                            { text: applyval_grid_name_param, datafield: 'name_param', width: "15%" },
                            { text: applyval_grid_value, datafield: 'value', width: "15%" },
                            { text: applyval_grid_comment, datafield: 'comment', width: "25%" },
                            { text: applyval_grid_comment_param, datafield: 'comment_param', width: "45%" }
                      ], //de columns
                        rendertoolbar: function (toolbar) {
                            
                            var container = $("<div style='margin: 2px;'></div>");

                            var input1 = $("<a href='#' ><img src='../../images/excel.png' width='27' id='popupWindowEditApplyVal_excelExport'></a>"); 
                            var input2 = $("<a href='#' ><img src='../../images/imprimir.png' width='25' id='popupWindowEditApplyVal_print'></a>"); 
                            var blanco = $("<a href='#' ><img src='../../images/blanco.png' width='22'></a>");
                            
                            var input3 = $("<a href='#' ><img src='../../images/refresh.png' width='22' id='popupWindowEditApplyVal_recargar'></a>");
                            var input4 = $("<a href='#' ><img src='../../images/new.png' width='23' id='popupWindowEditApplyVal_nuevo'></a>");
                            var input5 = $("<a href='#' ><img src='../../images/delete.png' width='25' id='popupWindowEditApplyVal_eliminar'></a>");
                            var input6 = $("<a href='#' ><img src='../../images/edit.png' width='22' id='popupWindowEditApplyVal_editar'></a>");
                            var blanco1 = $("<a href='#' ><img src='../../images/blanco.png' width='10'></a>");
                            var blanco2 = $("<a href='#' ><img src='../../images/blanco.png' width='10'></a>");
                            var blanco3 = $("<a href='#' ><img src='../../images/blanco.png' width='10'></a>");      

                            //titulo
                            var blanco3 = $("<label id='titulo'></label>"); 
                            
                            toolbar.append(container);
                            container.append(input3);
                            container.append(input4);
                            container.append(input5);
                            container.append(input6);                           
                            container.append(blanco);
                            container.append(input1);
                            container.append(input2);
                            container.append(blanco2);
                            container.append(tituloData);

                            
                       }

				});  //del grid 
                


		        // -------------------------------------------------------------------------------------------
		        // Acciones y Operaciones --------------------------------------------------------------------
				// -------------------------------------------------------------------------------------------                
  				// -------------------------------------------------------------------------------------------
			      // initialize the popup window and buttons.
                  $("#popupWindowEditApplyVal").on('open', function () {
                  });

                  //boton Save del formulario. Validamos los datos
                  $("#popupWindowEditApplyVal_Save").click(function () {
                      $('#Form_popupWindowEditApplyVal').jqxValidator('validate');
                  });
                  
                   //cuando este ok la validacion llamamos a Guarda
                  $('#Form_popupWindowEditApplyVal').jqxValidator({ onSuccess: function () { popupWindowEditApplyVal_guarda(); } });

                    
                  
    			// -------------------------------------------------------------------------------------------
                // boton Save del formulario
  				// -------------------------------------------------------------------------------------------                  
                  function popupWindowEditApplyVal_guarda() 
                  {
                	  var row = {id_param:$("#popupWindowEditApplyVal_id_param").val() ,value:$("#popupWindowEditApplyVal_value").val() ,comment: $("#popupWindowEditApplyVal_comment").val()};
                      if (operacion == "MOD") {  //modificacion
                          //edicion
                          var rowID = $('#FormApplyVal_jqxgrid').jqxGrid('getrowid', editrow);
                          $('#FormApplyVal_jqxgrid').jqxGrid('updaterow', rowID, row);
                      }
                      else if (operacion == "NEW") //Nuevo registro
                      {
                          var rowID = -1;
                          var rowscount = $("#FormApplyVal_jqxgrid").jqxGrid('getdatainformation').rowscount;
                          $('#FormApplyVal_jqxgrid').jqxGrid('addRow', rowID, row,rowscount );
                      }
                       
                  };
                  
  				// -------------------------------------------------------------------------------------------
	            //Salida Excel
				// -------------------------------------------------------------------------------------------
					            
	            $("#popupWindowEditApplyVal_excelExport").click(function () {
	                
	                $("#FormApplyVal_jqxgrid").jqxGrid('exportdata', 'xls', 'FormApplyVal_jqxgrid');           
	            });

				// -------------------------------------------------------------------------------------------	            
	            //Recargar
				// -------------------------------------------------------------------------------------------	            
	            
	            $("#popupWindowEditApplyVal_recargar").click(function () {
	                
	                $("#FormApplyVal_jqxgrid").jqxGrid('updatebounddata', 'cells');          
	            });

	            
				// -------------------------------------------------------------------------------------------	            
        		//Imprimir
				// -------------------------------------------------------------------------------------------        		
		         $("#popupWindowEditApplyVal_print").click(function () {
		                var gridContent = $("#FormApplyVal_jqxgrid").jqxGrid('exportdata', 'html');
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
		            $("#popupWindowEditApplyVal_eliminar").on('click', function () {
		
		                if (confirm(DeleteMsg))
		                {
		                        var selectedrowindex = $("#FormApplyVal_jqxgrid").jqxGrid('getselectedrowindex');
		                        var rowscount = $("#FormApplyVal_jqxgrid").jqxGrid('getdatainformation').rowscount;
		                        if (selectedrowindex >= 0 && selectedrowindex < rowscount) {
		
		                            var id = $("#FormApplyVal_jqxgrid").jqxGrid('getrowid', selectedrowindex);
		                            var dataRecord = $("#FormApplyVal_jqxgrid").jqxGrid('getrowdata', selectedrowindex);
		                            var commit = $("#FormApplyVal_jqxgrid").jqxGrid('deleteRow', dataRecord.id_param);
		                        }
		           		 }
		            });

		        // -------------------------------------------------------------------------------------------		 			
		        // Editar un Registro
		        // -------------------------------------------------------------------------------------------
               $("#popupWindowEditApplyVal_editar").on('click', function () {

                   		//Sacamos la fila seleccionada en el grid
		                var selectedrowindex = $("#FormApplyVal_jqxgrid").jqxGrid('getselectedrowindex');
		                var rowscount = $("#FormApplyVal_jqxgrid").jqxGrid('getdatainformation').rowscount;

		        		//Si está seleccionad y hay registros
	                  if (selectedrowindex >= 0 && selectedrowindex < rowscount) {
	                        var id = $("#FormApplyVal_jqxgrid").jqxGrid('getrowid', selectedrowindex);
	                        
	                        editrow = selectedrowindex;
	                        operacion = "MOD";
	                        var offset = $("#FormApplyVal_jqxgrid").offset();
	                        $("#popupWindowEditApplyVal").jqxWindow({ position: { x:(anchoVentana-anchoform1)/2, y: parseInt(offset.top) + 100 } });

		                    //Capuramos el "recordset" de la fila seleccionada. 
	                        var dataRecord = $("#FormApplyVal_jqxgrid").jqxGrid('getrowdata', selectedrowindex);

		                    //Asigno los campos
	                        $("#popupWindowEditApplyVal_id_param").val(dataRecord.id_param);
	                        $("#popupWindowEditApplyVal_value").val(dataRecord.value);
	                        $("#popupWindowEditApplyVal_comment").val(dataRecord.comment);
	                        $("#popupWindowEditApplyVal_id_param").val(dataRecord.id_param);
	                        
	                        //abrimos la ventana modal
	                        $("#popupWindowEditApplyVal").jqxWindow('open');

	                        //Deshabilito los campos que no se deban poder tocar
	                     //   $("#popupWindowEditApplyVal_id_param").jqxComboBox({ disabled: true });
	                   }
	            });

            	// -------------------------------------------------------------------------------------------
		        //  Nuevo Registro
		        // -------------------------------------------------------------------------------------------            
	            $("#popupWindowEditApplyVal_nuevo").on('click', function () {
	                     
	                     editrow = -1;  
	                     operacion = "NEW"; //Marco la operación 
	                     var offset = $("#FormApplyVal_jqxgrid").offset();
	                     $("#popupWindowEditApplyVal").jqxWindow({ position: { x:(anchoVentana-anchoform1)/2, y: parseInt(offset.top) + 100 } });

	                     // Pongo a blanco los campos
	                     $("#popupWindowEditApplyVal_id_param").jqxComboBox('val', null);
	                     $("#popupWindowEditApplyVal_value").val('');
	                     $("#popupWindowEditApplyVal_comment").val('');
                         
	                     //abro la ventana
	                     $("#popupWindowEditApplyVal").jqxWindow('open');

	                   	//habilito los campos que no se deban poder tocar
	                  //   $("#popupWindowEditApplyVal_id_param").jqxComboBox({ disabled: false });                     

	            });     

	         	

		        // -------------------------------------------------------------------------------------------
		        // ToolTipText de los botones y acciones. Ojo siempre al final del Jquery.
				// -------------------------------------------------------------------------------------------                
                $("#popupWindowEditApplyVal_recargar").jqxTooltip({ content: Refresh, position: 'default'});
                $("#popupWindowEditApplyVal_print").jqxTooltip({ content: Print, position: 'default'});
                $("#popupWindowEditApplyVal_excelExport").jqxTooltip({ content: Excel, position: 'default'});
                $("#popupWindowEditApplyVal_nuevo").jqxTooltip({ content: New, position: 'default'});
                $("#popupWindowEditApplyVal_editar").jqxTooltip({ content: Edit, position: 'default'});
                $("#popupWindowEditApplyVal_eliminar").jqxTooltip({ content: Delete, position: 'default',});


                // -------------------------------------------------------------------------------------------
                // LISTAS DE EDICION DEL PRINCIPAL - TABLAS REFERENCIA ETC.
                // -------------------------------------------------------------------------------------------                

                
                //del combo box de roles
                   var source_global_combo_Apply =
                      {
                          datatype: "json",
                          datafields: [
                              { name: 'id' },
                              { name: 'name' }
                          ],
                          url: '../auxiliares/params_data.jsp',
                          async: false
                      };
                      var dataAdapter_global_combo_Apply = new $.jqx.dataAdapter(source_global_combo_Apply);
                   // Create a jqxComboBox
                     $("#popupWindowEditApplyVal_id_param").jqxComboBox({theme: JsUIStyleCss, selectedIndex: 0, source: dataAdapter_global_combo_Apply, displayMember: "name", valueMember: "id", width: 300, height: 25});
                  
                   
                  
// -------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------
// FORMULARIOS AUXILIARES AL PRINCIPAL
// -------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------                

			       
	});
</script>

</div>