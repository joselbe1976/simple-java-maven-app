<%@include file="../globales/globalAllPages.jsp" %>
<%@include file="../login/seguridad_view.jsp" %>

<!-- 
Pasos de plantilla.

1º. reemplazar FormUsers2 por FormXXXX
2ª reemplazar  popupWindowEditUsers por popupWindowEditXXXXX
3º quitar este comentario Html
4. Cambiar las paginas de source y los campos
5. MOntar la tabla
6. Montar la edicion
 -->


<div id="FormUsers2">
 <div id="FormUsers">
       <table width="100%">
           <tr>
               <td width="100%" colspan="3" align="center">
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
</div>


<script type="text/javascript">
$(document).ready(function () {
	
				 var anchoform1 = 400;	
				 var altoForm1 =  340;
				 
                  $("#popupWindowEditUsers").jqxWindow({
                	  Height: altoForm1, width: anchoform1, resizable: false, theme: JsUIStyleCss, isModal: true, autoOpen: false, cancelButton: $("#popupWindowEditUsers_Cancel"), modalOpacity: 0.01 , animationType: 'combined', showAnimationDuration: 400, closeAnimationDuration: 400            
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
                
				var source_FormUsers2 =
				{
					datatype: "json",
					datafields: [
						{ name: 'id_user'},
						{ name: 'user_name'},
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
		                                	source_FormUsers2.totalrecords = data[0].TotalRows;					
		                                }
		                        },
		                        addRow: function (rowID, rowData, position, commit) {

		   		            
		                                  $.post('../admin/usuarios_save.jsp', { oper : 'NEW', id_user : rowData.id_user, user_name : rowData.user_name, comment: rowData.comment,id_role: rowData.id_role, id_disp_access: rowData.id_disp_access, uuid_access:rowData.uuid_access, bloq:rowData.bloq }, 
		                                    function(resp) {
		                                           
		                                          if (resp.split('{')[0].trim() == "true")
		                                          {
		                                             commit(true);
		                                 //            showMensaje(resp.split('{')[1]);
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
		             
		                                $.post('../admin/usuarios_save.jsp', { oper : 'MOD', id_user : rowData.id_user, user_name : rowData.user_name, comment: rowData.comment,id_role: rowData.id_role, id_disp_access: rowData.id_disp_access, uuid_access:rowData.uuid_access, bloq:rowData.bloq }, 
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
                  $("#popupWindowEditUsers_user_name").jqxInput({ theme: JsUIStyleCss,width: '150px', height: '23px' });
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
	                var dataadapter_FormUsers2 = new $.jqx.dataAdapter(source_FormUsers2, {
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
				
                var pagerrenderer_FormUsers2 = function () {
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
                    source: dataadapter_FormUsers2,
                    width: anchoVentana,
                    height: altoVentana,
                    columnsresize: true,
                    filterable: true,
                    sortable: true,
                    autoheight: false,
                    pageable: true,
                    //pagermode: 'simple',
                    pagerrenderer: pagerrenderer_FormUsers2,
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
                            { text: users_lista.grid.id, datafield: 'id_user', width: 150},
                            { text: users_lista.grid.nombre, datafield: 'user_name', width: 300 },
                            { text: users_lista.grid.idrole, datafield: 'id_role', width: 70, hidden: true },
                            { text: users_lista.grid.role, datafield: 'name', width: 200 },
                            { text: users_lista.grid.uuid, datafield: 'uuid_access', width: 200 },
                            { text: users_lista.grid.dispositivo, datafield: 'id_disp_access', width: 0, hidden: true },
                            { text: users_lista.grid.dispositivo, datafield: 'device_name', width: 200 },
                            { text: users_lista.form1.bloq, datafield: 'bloq', width: 100 ,columntype: 'checkbox'},
                            { text: users_lista.grid.comment, datafield: 'comment', width: 300 }
                            
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
                                                  
                            
                            toolbar.append(container);
                            container.append(input3);
                            container.append(input4);
                            container.append(input5);
                            container.append(input6);                           
                            container.append(blanco);
                            container.append(input1);
                            container.append(input2);
                             
                       }

				});  //del grid 
                


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
                          var row = {id_disp_access:$("#popupWindowEditUsers_jqxComboDevice").val() ,id_role:$("#popupWindowEditUsers_jqxCombo").val() ,uuid_access:$("#popupWindowEditUsers_uuid").val() ,id_user: $("#popupWindowEditUsers_id_user").val(), user_name: $("#popupWindowEditUsers_user_name").val(), comment: $("#popupWindowEditUsers_comment").val(), bloq: $('#popupWindowEditUsers_bloq').jqxCheckBox('checked')==true ? 1 : 0};                          
                          var rowID = $('#FormUsers2_jqxgrid').jqxGrid('getrowid', editrow);
                          $('#FormUsers2_jqxgrid').jqxGrid('updaterow', rowID, row);
                          $("#popupWindowEditUsers").jqxWindow('hide'); //ocultamos el Form Modal
                      }
                      else if (operacion == "NEW") //Nuevo registro
                      {
                          var row = { id_disp_access:$("#popupWindowEditUsers_jqxComboDevice").val() ,id_role:$("#popupWindowEditUsers_jqxCombo").val() ,uuid_access:$("#popupWindowEditUsers_uuid").val() ,id_user: $("#popupWindowEditUsers_id_user").val(), user_name: $("#popupWindowEditUsers_user_name").val(), comment: $("#popupWindowEditUsers_comment").val(), bloq: $('#popupWindowEditUsers_bloq').jqxCheckBox('checked')==true ? 1 : 0};
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
                         
	                     //abro la ventana
	                     $("#popupWindowEditUsers").jqxWindow('open');

	                     //Deshabilito los campos que no se deban poder tocar
	                     $("#popupWindowEditUsers_id_user").prop('disabled', false); 
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


             // -------------------------------------------------------------------------------------------
             // LISTAS DE EDICION DEL PRINCIPAL - TABLAS REFERENCIA ETC.
             // -------------------------------------------------------------------------------------------                

             /* a
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
               */
                
               


                  
// -------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------
// FORMULARIOS AUXILIARES AL PRINCIPAL
// -------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------                

			       
	});
</script>

</div>