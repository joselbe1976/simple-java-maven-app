<%@include file="../globales/globalAllPages.jsp" %>
<%@include file="../login/seguridad_view.jsp" %>

<div id="FormProcess">
 <div id="FormProcessMain">
       <table width="100%">
           <tr>
               <td width="100%" colspan="3" align="center">
                   <!-- Grid -->
                   <div id="FormProcess_jqxgrid"></div>
               </td>
           </tr>
       </table>

 <!-- popoup modal de edición -->

                    <div id="popupWindowEditProcess">
                        <div><label class="i18n labelnormal" id="process_form_title"></label></div>
                           <div style="overflow: hidden;">
                               <form id="Form_popupWindowEditProcess" action="./">
                                   <table>
                                        <tr><!-- ID Proceso -->
                                            <td align="right"><label class="i18n" id="process_form_id"></label></td>
                                            <td align="left"><input id="popupWindowEditProcess_id_process" /></td>
                                        </tr>
                                        <tr> <!-- Nombre -->
                                            <td align="right"><label class="i18n" id="process_form_name"></label></td>
                                            <td align="left"><input id="popupWindowEditProcess_name" /></td>
                                        </tr>
                                        <tr>
                                        <tr><!-- Lista roles -->
                                            <td align="right"><label class="i18n" id="process_form_id_System"></label></td>
                                            <td align="left"><div id="popupWindowEditProcess_id_system"></div></td>
                                        </tr>
                                        <tr valign="top"> <!-- Comentario -->
                                            <td align="right"><label class="i18n" id="process_form_comment"></label></td>
                                            <td align="left"><textarea rows="4" cols="40" id="popupWindowEditProcess_comment"></textarea></td>
                                        </tr>
                                        <tr> <!-- Esto son los botones -->
                                            <td align="right"></td>
                                            <td style="padding-top: 10px;" align="right"><input type="button" style="margin-right: 5px;"  id="popupWindowEditProcess_Save" ></button><input id="popupWindowEditProcess_Cancel" type="button" value="Cancelar" /></td>
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
				 var altoForm1 =  240;
				 
                  $("#popupWindowEditProcess").jqxWindow({
                	  Height: altoForm1, width: anchoform1, resizable: false, theme: JsUIStyleCss, isModal: true, autoOpen: false, cancelButton: $("#popupWindowEditProcess_Cancel"), modalOpacity: 0.01 , animationType: 'combined', showAnimationDuration: 400, closeAnimationDuration: 400           
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
                
				var source_FormProcess =
				{
					datatype: "json",
					datafields: [
						{ name: 'id_process'},
						{ name: 'name'},
						{ name: 'id_system'},
						{ name: 'name_system'},  //nombre del role
						{ name: 'comment'}
					],
					url: '../auxiliares/process_data.jsp',
					cache: false,
		                        id:'id',
		                        filter: function()
		                        {
		                                // update the grid and send a request to the server.
		                                $("#FormProcess_jqxgrid").jqxGrid('updatebounddata', 'filter');
		                        },
		                        sort: function()
		                        {
		                                // update the grid and send a request to the server.
		                                $("#FormProcess_jqxgrid").jqxGrid('updatebounddata', 'sort');
		                        },
		                        root: 'Rows',
		                        beforeprocessing: function(data)
		                        {		
		                                if (data != null)
		                                {
		                                	source_FormProcess.totalrecords = data[0].TotalRows;					
		                                }
		                        },
		                        addRow: function (rowID, rowData, position, commit) {

		   		            
		                                  $.post('../auxiliares/process_save.jsp', { oper : 'NEW', id_process  : rowData.id_process, name : rowData.name, id_system  : rowData.id_system , comment : rowData.comment}, 
		                                    function(resp) {
		                                           
		                                          if (resp.split('{')[0].trim() == "true")
		                                          {
		                                             commit(true);
		                                             $("#FormProcess_jqxgrid").jqxGrid('updatebounddata', 'cells');
		                                             $("#popupWindowEditProcess").jqxWindow('hide'); //ocultamos el Form Modal
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
		             
		                                $.post('../auxiliares/process_save.jsp', { oper : 'MOD', id_process  : rowData.id_process, name : rowData.name, id_system  : rowData.id_system , comment : rowData.comment }, 
		                                    function(resp) {
		                                        
		                                         if (resp.split('{')[0].trim() == "true")
		                                          {
		                                             commit(true); 
		                                             $("#FormProcess_jqxgrid").jqxGrid('updatebounddata', 'cells');
		                                             $("#popupWindowEditProcess").jqxWindow('hide'); //ocultamos el Form Modal
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
		                            
		                                $.post('../auxiliares/process_save.jsp', { oper : 'DEL', id_process : rowID }, 
		                                    function(resp) {
		                                         if (resp.split('{')[0].trim() == "true")
		                                          {
		                                             commit(true); 
		                                             $("#FormProcess_jqxgrid").jqxGrid('updatebounddata', 'cells');
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
                  $("#popupWindowEditProcess_Cancel").jqxButton({ theme: JsUIStyleCss });
                  $("#popupWindowEditProcess_Save").jqxButton({ theme: JsUIStyleCss });
                  $("#popupWindowEditProcess_Save").val(Save); //textos traducidos a botones
                  $("#popupWindowEditProcess_Cancel").val(Cancel); //textos traducidos a los botones		    
		          $("#popupWindowEditProcess_id_process").jqxInput({ theme: JsUIStyleCss,width: '200px', height: '23px' });
                  $("#popupWindowEditProcess_name").jqxInput({ theme: JsUIStyleCss,width: '200px', height: '23px' });
                  $("#popupWindowEditProcess_comment").jqxInput({ theme: JsUIStyleCss,width: '300px', height: '60px'});
                  
                  var editrow = -1; //indica la linea a editar/eliminar/nuevo
                  var operacion = ""; //indica la operacion DEL cuando es necesario

                  
                  
                // -------------------------------------------------------------------------------------------
                // Validaciones del formulario
				// -------------------------------------------------------------------------------------------                
                    $('#Form_popupWindowEditProcess').jqxValidator({
                                    //hintType: 'label',
                                    animationDuration: 500,
                                    theme: JsUIStyleCss,
                                    rules: [
                                            { input: '#popupWindowEditProcess_id_process', message: Obligatorio, action: 'keyup, blur', rule: 'required' },
                                            { input: '#popupWindowEditProcess_name', message: Obligatorio, action: 'keyup, blur', rule: 'required' }
                                           ]
                              });        


                 // -------------------------------------------------------------------------------------------
                 // Adaptador del Origenprincipal
                 // -------------------------------------------------------------------------------------------
	                var dataadapter_FormProcess = new $.jqx.dataAdapter(source_FormProcess, {
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
				
                var pagerrenderer_FormProcess = function () {
                    var element = $("<div style='margin-left: 10px; margin-top: 5px; width: 100%; height: 100%; '></div>");
                    var datainfo = $("#FormProcess_jqxgrid").jqxGrid('getdatainformation');
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
                        $("#FormProcess_jqxgrid").jqxGrid('gotonextpage');
                    });
                    leftButton.click(function () {
                        $("#FormProcess_jqxgrid").jqxGrid('gotoprevpage');
                    });
                    return element;
                }

                $("#FormProcess_jqxgrid").on('pagechanged', function () {
                    var datainfo = $("#FormProcess_jqxgrid").jqxGrid('getdatainformation');
                    var paginginfo = datainfo.paginginformation;
                    self.label.text(1 + paginginfo.pagenum * paginginfo.pagesize + "-" + Math.min(datainfo.rowscount, (paginginfo.pagenum + 1) * paginginfo.pagesize) + ' of ' + datainfo.rowscount);
                });
                
                


                // -------------------------------------------------------------------------------------------
                // Definición del Grid de datos principal
				// -------------------------------------------------------------------------------------------                

   			    $("#FormProcess_jqxgrid").jqxGrid(
				{
                    theme: JsUIStyleCss,
                    source: dataadapter_FormProcess,
                    width: anchoVentana,
                    height: altoVentana,
                    columnsresize: true,
                    pagesize: 20,
                    filterable: true,
                    filtermode: 'excel',
                    sortable: true,
                    autoheight: false,
                    pageable: true,
                    //pagermode: 'simple',
                    pagerrenderer: pagerrenderer_FormProcess,
                    virtualmode: false,
                    altrows: false,
                    showtoolbar: true, //muestra la barra de herramientas superior
                    showstatusbar: false, //muestra la barra de abajo de estado
                    
                    rendergridrows: function(obj)
						{
							return obj.data;    
						},
                    columns: [

                            { text: process_form_id, datafield: 'id_process', width: 0, hidden:true},
                            { text: process_form_name, datafield: 'name', width: "25%" },
                            { text: process_form_id_System, datafield: 'id_system', width: 0, hidden:true },
                            { text: process_form_name_System, datafield: 'name_system', width: "25%" },
                            { text: process_form_comment, datafield: 'comment', width: "50%" }
                          ], //de columns

                        rendertoolbar: function (toolbar) {
                            
                        	 var container = $("<div style='margin: 2px;'></div>");

                            var input1 = $("<a href='#' ><img src='../../images/excel.png' width='27' id='popupWindowEditProcess_excelExport'></a>"); 
                            var input2 = $("<a href='#' ><img src='../../images/imprimir.png' width='25' id='popupWindowEditProcess_print'></a>"); 
                            var blanco = $("<a href='#' ><img src='../../images/blanco.png' width='22'></a>");
                            
                            var input3 = $("<a href='#' ><img src='../../images/refresh.png' width='22' id='popupWindowEditProcess_recargar'></a>");
                            var input4 = $("<a href='#' ><img src='../../images/new.png' width='23' id='popupWindowEditProcess_nuevo'></a>");
                            var input5 = $("<a href='#' ><img src='../../images/delete.png' width='25' id='popupWindowEditProcess_eliminar'></a>");
                            var input6 = $("<a href='#' ><img src='../../images/edit.png' width='22' id='popupWindowEditProcess_editar'></a>");
                            var blanco1 = $("<a href='#' ><img src='../../images/blanco.png' width='10'></a>");
                            var blanco2 = $("<a href='#' ><img src='../../images/blanco.png' width='10'></a>");
                            var blanco3 = $("<a href='#' ><img src='../../images/blanco.png' width='10'></a>");      
                            var input10 = $("<a href='#' ><img src='../../images/parameters.png' width='22' id='popupWindowEditProcess_parameters'></a>");
                            
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
                  $("#popupWindowEditProcess").on('open', function () {
                  });

                  //boton Save del formulario. Validamos los datos
                  $("#popupWindowEditProcess_Save").click(function () {
                      $('#Form_popupWindowEditProcess').jqxValidator('validate');
                  });
                  
                   //cuando este ok la validacion llamamos a Guarda
                  $('#Form_popupWindowEditProcess').jqxValidator({ onSuccess: function () { popupWindowEditProcess_guarda(); } }); 
                  
    			// -------------------------------------------------------------------------------------------
                // boton Save del formulario
  				// -------------------------------------------------------------------------------------------                  
                  function popupWindowEditProcess_guarda() 
                  {
                	  var row = {id_process:$("#popupWindowEditProcess_id_process").val(), name:$("#popupWindowEditProcess_name").val(), comment:$("#popupWindowEditProcess_comment").val(), id_system:$("#popupWindowEditProcess_id_system").val() };
                	  
                      if (operacion == "MOD") {  //modificacion
                          //edicion
                          var rowID = $('#FormProcess_jqxgrid').jqxGrid('getrowid', editrow);
                          $('#FormProcess_jqxgrid').jqxGrid('updaterow', rowID, row);
                      }
                      else if (operacion == "NEW") //Nuevo registro
                      {
                          var rowID = -1;
                          var rowscount = $("#FormProcess_jqxgrid").jqxGrid('getdatainformation').rowscount;
                          $('#FormProcess_jqxgrid').jqxGrid('addRow', rowID, row,rowscount );
                      }
                       
                  };
                  
  				// -------------------------------------------------------------------------------------------
	            //Salida Excel
				// -------------------------------------------------------------------------------------------
					            
	            $("#popupWindowEditProcess_excelExport").click(function () {
	                
	                $("#FormProcess_jqxgrid").jqxGrid('exportdata', 'xls', 'FormProcess_jqxgrid');           
	            });

				// -------------------------------------------------------------------------------------------	            
	            //Recargar
				// -------------------------------------------------------------------------------------------	            
	            
	            $("#popupWindowEditProcess_recargar").click(function () {
	                
	                $("#FormProcess_jqxgrid").jqxGrid('updatebounddata', 'cells');          
	            });

	            
				// -------------------------------------------------------------------------------------------	            
        		//Imprimir
				// -------------------------------------------------------------------------------------------        		
		         $("#popupWindowEditProcess_print").click(function () {
		                var gridContent = $("#FormProcess_jqxgrid").jqxGrid('exportdata', 'html');
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
		            $("#popupWindowEditProcess_eliminar").on('click', function () {
		
		                if (confirm(DeleteMsg))
		                {
		                        var selectedrowindex = $("#FormProcess_jqxgrid").jqxGrid('getselectedrowindex');
		                        var rowscount = $("#FormProcess_jqxgrid").jqxGrid('getdatainformation').rowscount;
		                        if (selectedrowindex >= 0 && selectedrowindex < rowscount) {
		
		                            var id = $("#FormProcess_jqxgrid").jqxGrid('getrowid', selectedrowindex);
		                            var dataRecord = $("#FormProcess_jqxgrid").jqxGrid('getrowdata', id);
		                            var commit = $("#FormProcess_jqxgrid").jqxGrid('deleterow', dataRecord.id_process);
		                        }
		           		 }
		            });

		        // -------------------------------------------------------------------------------------------		 			
		        // Editar un Registro
		        // -------------------------------------------------------------------------------------------
               $("#popupWindowEditProcess_editar").on('click', function () {

                   		//Sacamos la fila seleccionada en el grid
		                var selectedrowindex = $("#FormProcess_jqxgrid").jqxGrid('getselectedrowindex');
		                var rowscount = $("#FormProcess_jqxgrid").jqxGrid('getdatainformation').rowscount;

		        		//Si está seleccionad y hay registros
	                  if (selectedrowindex >= 0 && selectedrowindex < rowscount) {
	                        var id = $("#FormProcess_jqxgrid").jqxGrid('getrowid', selectedrowindex);
	                        
	                        editrow = selectedrowindex;
	                        operacion = "MOD";
	                        var offset = $("#FormProcess_jqxgrid").offset();
	                        $("#popupWindowEditProcess").jqxWindow({ position: { x:(anchoVentana-anchoform1)/2, y: parseInt(offset.top) + 100 } });

		                    //Capuramos el "recordset" de la fila seleccionada. 
	                        var dataRecord = $("#FormProcess_jqxgrid").jqxGrid('getrowdata', selectedrowindex);

		                    //Asigno los campos
	                        $("#popupWindowEditProcess_id_process").val(dataRecord.id_process);
	                        $("#popupWindowEditProcess_name").val(dataRecord.name);
	                        $("#popupWindowEditProcess_comment").val(dataRecord.comment);
	                        $("#popupWindowEditProcess_id_system").val(dataRecord.id_system);

	    				
	                        
	                        //abrimos la ventana modal
	                        $("#popupWindowEditProcess").jqxWindow('open');

	                        //deshabilitamos
	                        $("#popupWindowEditProcess_id_process").prop('disabled', true);
	                }
	            });

            	// -------------------------------------------------------------------------------------------
		        //  Nuevo Registro
		        // -------------------------------------------------------------------------------------------            
	            $("#popupWindowEditProcess_nuevo").on('click', function () {
	                     
	                     editrow = -1;  
	                     operacion = "NEW"; //Marco la operación 
	                     var offset = $("#FormProcess_jqxgrid").offset();
	                     $("#popupWindowEditProcess").jqxWindow({ position: { x:(anchoVentana-anchoform1)/2, y: parseInt(offset.top) + 100 } });

	                     // Pongo a blanco los campos
	                     $("#popupWindowEditProcess_id_process").val('');
	                     $("#popupWindowEditProcess_name").val('');
	                     $("#popupWindowEditProcess_comment").val('');
                         $("#popupWindowEditProcess_id_system").val(null); 
                         
	                     //abro la ventana
	                     $("#popupWindowEditProcess").jqxWindow('open');

	                     //Deshabilito los campos que no se deban poder tocar
	                     $("#popupWindowEditProcess_id_process").prop('disabled', false); 
	            });     



            	// -------------------------------------------------------------------------------------------
		        //  Parámetros aplica-valor
		        // -------------------------------------------------------------------------------------------            
	            $("#popupWindowEditProcess_parameters").on('click', function () {
	
		            	//Sacamos la fila seleccionada en el grid
		                var selectedrowindex = $("#FormProcess_jqxgrid").jqxGrid('getselectedrowindex');
		                var rowscount = $("#FormProcess_jqxgrid").jqxGrid('getdatainformation').rowscount;
	
		        		//Si está seleccionad y hay registros
	                  if (selectedrowindex >= 0 && selectedrowindex < rowscount) {
	                        var id = $("#FormProcess_jqxgrid").jqxGrid('getrowid', selectedrowindex);
	                        
	                        editrow = selectedrowindex;
	                        var offset = $("#FormProcess_jqxgrid").offset();
	
		                    //Capuramos el "recordset" de la fila seleccionada. 
	                        var dataRecord = $("#FormProcess_jqxgrid").jqxGrid('getrowdata', selectedrowindex);
	
		                    //Creamos la URL
	                        var urlApplProcess =  "../menu/main.jsp?titleOption="+applyval_process_title+"&optLoad=1&paginaWeb=../applyvalues/applyValues_view.jspXXXXlevel=PROCESSZZZZcode="+dataRecord.id_process + 'ZZZZcodeName='+dataRecord.name;
	                        
							
							//Simulamos el CLICK
//							menuclick(urlApplProcess,applyval_process_title);    				

	                        //abrimos en nueva pestaña
	                        window.open(urlApplProcess,'_newtab');
	                	}	            
		         	
	            });     

		        // -------------------------------------------------------------------------------------------
		        // ToolTipText de los botones y acciones. Ojo siempre al final del Jquery.
				// -------------------------------------------------------------------------------------------                
                $("#popupWindowEditProcess_recargar").jqxTooltip({ content: Refresh, position: 'default'});
                $("#popupWindowEditProcess_print").jqxTooltip({ content: Print, position: 'default'});
                $("#popupWindowEditProcess_excelExport").jqxTooltip({ content: Excel, position: 'default'});
                $("#popupWindowEditProcess_nuevo").jqxTooltip({ content: New, position: 'default'});
                $("#popupWindowEditProcess_editar").jqxTooltip({ content: Edit, position: 'default'});
                $("#popupWindowEditProcess_eliminar").jqxTooltip({ content: Delete, position: 'default',});
                $("#popupWindowEditProcess_parameters").jqxTooltip({ content: Parameters, position: 'default',});


             // -------------------------------------------------------------------------------------------
             // LISTAS DE EDICION DEL PRINCIPAL - TABLAS REFERENCIA ETC.
             // -------------------------------------------------------------------------------------------                

             
             //del combo box de roles
                var source_systems_process =
                   {
                       datatype: "json",
                       datafields: [
                           { name: 'id_system' },
                           { name: 'name' }
                       ],
                       url: '../auxiliares/systems_data.jsp',
                       async: true
                   };
                   var dataAdapter_systems_process = new $.jqx.dataAdapter(source_systems_process);
                // Create a jqxComboBox
                  $("#popupWindowEditProcess_id_system").jqxComboBox({theme: JsUIStyleCss, selectedIndex: 0, source: dataAdapter_systems_process, displayMember: "name", valueMember: "id_system", width: 200, height: 25});
               
                
               


                  
// -------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------
// FORMULARIOS AUXILIARES AL PRINCIPAL
// -------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------                

			       
	});
</script>

</div>