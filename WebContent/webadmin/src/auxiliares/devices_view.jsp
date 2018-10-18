<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../globales/globalAllPages.jsp" %>
<%@include file="../login/seguridad_view.jsp" %>

<div id="FormDevicesMain">
 <div id="FormDevices">
       <table width="100%">
           <tr>
               <td width="100%" colspan="3" align="center">
                   <!-- Grid -->
                   <div id="FormDevicesMain_jqxgrid"></div>
               </td>
           </tr>
       </table>

 <!-- popoup modal de edición -->

                    <div id="popupWindowEditDevices">
                        <div><label class="i18n labelnormal" id="devices_form_Title"></label></div>
                           <div style="overflow: hidden;">
                               <form id="Form_popupWindowEditDevices" action="./">
                                  
                                   <table>
                                        <tr><!-- ID Usuario -->
                                            <td align="right"><label class="i18n" id="devices_form_id_device"></label></td>
                                            <td align="left"><input id="popupWindowEditDevices_id_device" /></td>
                                        </tr>
                                        <tr> <!-- Nombre completo usuario -->
                                            <td align="right"><label class="i18n" id="devices_form_name"></label></td>
                                            <td align="left"><input id="popupWindowEditDevices_name" /></td>
                                        </tr>
                                        <tr>
                                            <td align="right"><label class="i18n" id="roles_lista.grid.channel"></label></td>
                                            <td align="left"><input id="popupWindowEditDevices_parse_channel" /></td>
                                        </tr>
                                        <tr>
                                            <td align="right"><label>Dispositivo Parse</label></td>
                                            <td align="left"><input id="popupWindowEditDevices_parse_device_type" /></td>
                                        </tr>
                                        
                                        <tr valign="top"> <!-- Comentario -->
                                            <td align="right"><label class="i18n" id="devices_form_comment"></label></td>
                                            <td align="left"><textarea rows="4" cols="40" id="popupWindowEditDevices_comment"></textarea></td>
                                        </tr>
                                        <tr> <!-- Esto son los botones -->
                                            <td align="right"></td>
                                            <td style="padding-top: 10px;" align="right"><input type="button" style="margin-right: 5px;"  id="popupWindowEditDevices_Save" ></button><input id="popupWindowEditDevices_Cancel" type="button" value="Cancelar" /></td>
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
				 var altoForm1 =  270;

                  $("#popupWindowEditDevices").jqxWindow({
                	  Height: altoForm1, width: anchoform1, resizable: false, theme: JsUIStyleCss, isModal: true, autoOpen: false, cancelButton: $("#popupWindowEditDevices_Cancel"), modalOpacity: 0.01, animationType: 'combined', showAnimationDuration: 400, closeAnimationDuration: 400            
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
						{ name: 'id_device'},
						{ name: 'name'},
						{ name: 'comment'},
						{ name: 'parse_channel'},
						{ name: 'parse_device_type'}
					],
					url: '../auxiliares/devices_data.jsp',
					cache: false,
		                        id:'id',
		                        filter: function()
		                        {
		                                // update the grid and send a request to the server.
		                                $("#FormDevicesMain_jqxgrid").jqxGrid('updatebounddata', 'filter');
		                        },
		                        sort: function()
		                        {
		                                // update the grid and send a request to the server.
		                                $("#FormDevicesMain_jqxgrid").jqxGrid('updatebounddata', 'sort');
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

		   		            
		                                  $.post('../auxiliares/devices_save.jsp', { oper : 'NEW', id_device : rowData.id_device, name : rowData.name, comment : rowData.comment, parse_channel : rowData.parse_channel, parse_device_type : rowData.parse_device_type }, 
		                                    function(resp) {
		                                           
		                                          if (resp.split('{')[0].trim() == "true")
		                                          {
		                                             commit(true);
		                                 //            showMensaje(resp.split('{')[1]);
		                                             $("#FormDevicesMain_jqxgrid").jqxGrid('updatebounddata', 'cells');
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
		             
		                                $.post('../auxiliares/devices_save.jsp', { oper : 'MOD', id_device : rowData.id_device, name : rowData.name, comment : rowData.comment, parse_channel : rowData.parse_channel, parse_device_type : rowData.parse_device_type }, 
		                                    function(resp) {
		                                        
		                                         if (resp.split('{')[0].trim() == "true")
		                                          {
		                                             commit(true); 
		                                    //         showMensaje(resp.split('{')[1]);
		                                             $("#FormDevicesMain_jqxgrid").jqxGrid('updatebounddata', 'cells');
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
		                            
		                                $.post('../auxiliares/devices_save.jsp', { oper : 'DEL', id_device : rowID }, 
		                                    function(resp) {
		                                         if (resp.split('{')[0].trim() == "true")
		                                          {
		                                             commit(true); 
		                                           //  showMensaje(resp.split('{')[1]);
		                                             $("#FormDevicesMain_jqxgrid").jqxGrid('updatebounddata', 'cells');
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
                  $("#popupWindowEditDevices_Cancel").jqxButton({ theme: JsUIStyleCss });
                  $("#popupWindowEditDevices_Save").jqxButton({ theme: JsUIStyleCss });
                  $("#popupWindowEditDevices_Save").val(Save); //textos traducidos a botones
                  $("#popupWindowEditDevices_Cancel").val(Cancel); //textos traducidos a los botones		    
		          $("#popupWindowEditDevices_id_device").jqxInput({ theme: JsUIStyleCss,width: '150px', height: '23px' });
                  $("#popupWindowEditDevices_name").jqxInput({ theme: JsUIStyleCss,width: '250px', height: '23px' });
                  $("#popupWindowEditDevices_parse_channel").jqxInput({ theme: JsUIStyleCss,width: '250px', height: '23px' });
                  $("#popupWindowEditDevices_parse_device_type").jqxInput({ theme: JsUIStyleCss,width: '150px', height: '23px' });
                  $("#popupWindowEditDevices_comment").jqxInput({ theme: JsUIStyleCss,width: '300px', height: '60px'});
                  
                  
                  var editrow = -1; //indica la linea a editar/eliminar/nuevo
                  var operacion = ""; //indica la operacion DEL cuando es necesario

                  
                  
                // -------------------------------------------------------------------------------------------
                // Validaciones del formulario
				// -------------------------------------------------------------------------------------------                
                    $('#Form_popupWindowEditDevices').jqxValidator({
                                    //hintType: 'label',
                                    animationDuration: 500,
                                    theme: JsUIStyleCss,
                                    rules: [
                                            { input: '#popupWindowEditDevices_id_device', message: Obligatorio, action: 'keyup, blur', rule: 'required' },
                                            { input: '#popupWindowEditDevices_name', message: Obligatorio, action: 'keyup, blur', rule: 'required' }
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
	                var pagerrendererDevices = function () {
	                    var element = $("<div style='margin-left: 10px; margin-top: 5px; width: 100%; height: 100%; '></div>");
	                    var datainfo = $("#FormDevicesMain_jqxgrid").jqxGrid('getdatainformation');
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
	                        $("FormDevicesMain_jqxgrid").jqxGrid('gotonextpage');
	                    });
	                    leftButton.click(function () {
	                        $("#FormDevicesMain_jqxgrid").jqxGrid('gotoprevpage');
	                    });
	                    return element;
	                }

	                $("#FormDevicesMain_jqxgrid").on('pagechanged', function () {
	                    var datainfo = $("#FormDevicesMain_jqxgrid").jqxGrid('getdatainformation');
	                    var paginginfo = datainfo.paginginformation;
	                    self.label.text(1 + paginginfo.pagenum * paginginfo.pagesize + "-" + Math.min(datainfo.rowscount, (paginginfo.pagenum + 1) * paginginfo.pagesize) + ' of ' + datainfo.rowscount);
	                });
	                
          


                // -------------------------------------------------------------------------------------------
                // Definición del Grid de datos principal
				// -------------------------------------------------------------------------------------------                

   			    $("#FormDevicesMain_jqxgrid").jqxGrid(
				{
                    theme: JsUIStyleCss,
                    source: dataadapter,
                    width: anchoVentana,
                    height: altoVentana,
                    columnsresize: true,
                    filterable: true,
                    sortable: true,
                    autoheight: false,
                    filtermode: 'excel',
                    pageable: true,
                    //pagermode: 'simple',
                    pagerrenderer: pagerrendererDevices,
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
                            { text: devices_form_id_device, datafield: 'id_device', width: 150, hidden:true},
                            { text: devices_form_name, datafield: 'name', width: "20%" },
                            { text: roles_lista.grid.channel, datafield: 'parse_channel', width: "20%" },
                            { text: 'Dispositivo Parse', datafield: 'parse_device_type', width: "20%" },
                            { text: devices_form_comment, datafield: 'comment', width: "40%" }
                            
                          ], //de columns

                        rendertoolbar: function (toolbar) {
                            
                            var container = $("<div style='margin: 2px;'></div>");

                            var input1 = $("<a href='#' ><img src='../../images/excel.png' width='27' id='popupWindowEditDevices_excelExport'></a>"); 
                            var input2 = $("<a href='#' ><img src='../../images/imprimir.png' width='25' id='popupWindowEditDevices_print'></a>"); 
                            var blanco = $("<a href='#' ><img src='../../images/blanco.png' width='22'></a>");
                            
                            var input3 = $("<a href='#' ><img src='../../images/refresh.png' width='22' id='popupWindowEditDevices_recargar'></a>");
                            var input4 = $("<a href='#' ><img src='../../images/new.png' width='23' id='popupWindowEditDevices_nuevo'></a>");
                            var input5 = $("<a href='#' ><img src='../../images/delete.png' width='25' id='popupWindowEditDevices_eliminar'></a>");
                            var input6 = $("<a href='#' ><img src='../../images/edit.png' width='22' id='popupWindowEditDevices_editar'></a>");
                            var blanco1 = $("<a href='#' ><img src='../../images/blanco.png' width='10'></a>");
                            var blanco2 = $("<a href='#' ><img src='../../images/blanco.png' width='10'></a>");
                            var blanco3 = $("<a href='#' ><img src='../../images/blanco.png' width='10'></a>");      
                            var input10 = $("<a href='#' ><img src='../../images/parameters.png' width='22' id='popupWindowEditDevices_parameters'></a>");

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
                  $("#popupWindowEditDevices").on('open', function () {
                  });

                  //boton Save del formulario. Validamos los datos
                  $("#popupWindowEditDevices_Save").click(function () {
                      $('#Form_popupWindowEditDevices').jqxValidator('validate');
                  });
                  
                   //cuando este ok la validacion llamamos a Guarda
                  $('#Form_popupWindowEditDevices').jqxValidator({ onSuccess: function () { popupWindowEditDevices_guarda(); } }); 
                  
    			// -------------------------------------------------------------------------------------------
                // boton Save del formulario
  				// -------------------------------------------------------------------------------------------                  
                  function popupWindowEditDevices_guarda() 
                  {
                      if (operacion == "MOD") {  //modificacion
                          //edicion
                          var row = {parse_device_type:$("#popupWindowEditDevices_parse_device_type").val(),parse_channel:$("#popupWindowEditDevices_parse_channel").val(),id_device:$("#popupWindowEditDevices_id_device").val() ,name:$("#popupWindowEditDevices_name").val() , comment: $("#popupWindowEditDevices_comment").val()};                          
                          var rowID = $('#FormDevicesMain_jqxgrid').jqxGrid('getrowid', editrow);
                          $('#FormDevicesMain_jqxgrid').jqxGrid('updaterow', rowID, row);
                          $("#popupWindowEditDevices").jqxWindow('hide'); //ocultamos el Form Modal
                      }
                      else if (operacion == "NEW") //Nuevo registro
                      {
                          var row = { parse_device_type:$("#popupWindowEditDevices_parse_device_type").val(),parse_channel:$("#popupWindowEditDevices_parse_channel").val(),id_device:$("#popupWindowEditDevices_id_device").val() ,name:$("#popupWindowEditDevices_name").val() , comment: $("#popupWindowEditDevices_comment").val()};
                          var rowID = -1;
                          var rowscount = $("#FormDevicesMain_jqxgrid").jqxGrid('getdatainformation').rowscount;
                          $('#FormDevicesMain_jqxgrid').jqxGrid('addRow', rowID, row,rowscount );
                          $("#popupWindowEditDevices").jqxWindow('hide'); //ocultamos el Form Modal
                      }
                       
                  };
                  
  				// -------------------------------------------------------------------------------------------
	            //Salida Excel
				// -------------------------------------------------------------------------------------------
					            
	            $("#popupWindowEditDevices_excelExport").click(function () {
	                
	                $("#FormDevicesMain_jqxgrid").jqxGrid('exportdata', 'xls', 'FormDevicesMain_jqxgrid');           
	            });

				// -------------------------------------------------------------------------------------------	            
	            //Recargar
				// -------------------------------------------------------------------------------------------	            
	            
	            $("#popupWindowEditDevices_recargar").click(function () {
	                
	                $("#FormDevicesMain_jqxgrid").jqxGrid('updatebounddata', 'cells');          
	            });

	            
				// -------------------------------------------------------------------------------------------	            
        		//Imprimir
				// -------------------------------------------------------------------------------------------        		
		         $("#popupWindowEditDevices_print").click(function () {
		                var gridContent = $("#FormDevicesMain_jqxgrid").jqxGrid('exportdata', 'html');
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
		            $("#popupWindowEditDevices_eliminar").on('click', function () {
		
		                if (confirm(DeleteMsg))
		                {
		                        var selectedrowindex = $("#FormDevicesMain_jqxgrid").jqxGrid('getselectedrowindex');
		                        var rowscount = $("#FormDevicesMain_jqxgrid").jqxGrid('getdatainformation').rowscount;
		                        if (selectedrowindex >= 0 && selectedrowindex < rowscount) {
		
		                            var id = $("#FormDevicesMain_jqxgrid").jqxGrid('getrowid', selectedrowindex);
		                            var dataRecord = $("#FormDevicesMain_jqxgrid").jqxGrid('getrowdata', id);
		                            var commit = $("#FormDevicesMain_jqxgrid").jqxGrid('deleterow', dataRecord.id_device	);
		                        }
		           		 }
		            });

		        // -------------------------------------------------------------------------------------------		 			
		        // Editar un Registro
		        // -------------------------------------------------------------------------------------------
               $("#popupWindowEditDevices_editar").on('click', function () {

                   		//Sacamos la fila seleccionada en el grid
		                var selectedrowindex = $("#FormDevicesMain_jqxgrid").jqxGrid('getselectedrowindex');
		                var rowscount = $("#FormDevicesMain_jqxgrid").jqxGrid('getdatainformation').rowscount;

		        		//Si está seleccionad y hay registros
	                  if (selectedrowindex >= 0 && selectedrowindex < rowscount) {
	                        var id = $("#FormDevicesMain_jqxgrid").jqxGrid('getrowid', selectedrowindex);
	                        
	                        editrow = selectedrowindex;
	                        operacion = "MOD";
	                        var offset = $("#FormDevicesMain_jqxgrid").offset();
	                        $("#popupWindowEditDevices").jqxWindow({ position: { x:(anchoVentana-anchoform1)/2, y: parseInt(offset.top) + 100 } });

		                    //Capuramos el "recordset" de la fila seleccionada. 
	                        var dataRecord = $("#FormDevicesMain_jqxgrid").jqxGrid('getrowdata', selectedrowindex);

		                    //Asigno los campos
	                        $("#popupWindowEditDevices_id_device").val(dataRecord.id_device);
	                        $("#popupWindowEditDevices_name").val(dataRecord.name);
	                        $("#popupWindowEditDevices_comment").val(dataRecord.comment);
	                        $("#popupWindowEditDevices_parse_channel").val(dataRecord.parse_channel);
	                        $("#popupWindowEditDevices_parse_device_type").val(dataRecord.parse_device_type);

	                        
	                        //abrimos la ventana modal
	                        $("#popupWindowEditDevices").jqxWindow('open');

	                        //deshabilitamos
	                        $("#popupWindowEditDevices_id_device").prop('disabled', true);
	                //        $("#popupWindowEditDevices_parse_channel").prop('disabled', true);
	                  //      $("#popupWindowEditDevices_parse_device_type").prop('disabled', true);
	                        
	                }
	            });

            	// -------------------------------------------------------------------------------------------
		        //  Nuevo Registro
		        // -------------------------------------------------------------------------------------------            
	            $("#popupWindowEditDevices_nuevo").on('click', function () {
	                     
	                     editrow = -1;  
	                     operacion = "NEW"; //Marco la operación 
	                     var offset = $("#FormDevicesMain_jqxgrid").offset();
	                     $("#popupWindowEditDevices").jqxWindow({ position: { x:(anchoVentana-anchoform1)/2, y: parseInt(offset.top) + 100 } });

	                     // Pongo a blanco los campos
	                     $("#popupWindowEditDevices_id_device").val('');
	                     $("#popupWindowEditDevices_name").val('');
	                     $("#popupWindowEditDevices_comment").val('');
	                     $("#popupWindowEditDevices_parse_channel").val('DEVICE-');
	                     $("#popupWindowEditDevices_parse_device_type").val('ios');	                     
                         
	                     //abro la ventana
	                     $("#popupWindowEditDevices").jqxWindow('open');

	                     //Deshabilito los campos que no se deban poder tocar
	                     $("#popupWindowEditDevices_id_device").prop('disabled', false); 
	                        $("#popupWindowEditDevices_parse_channel").prop('disabled', false);
	                        $("#popupWindowEditDevices_parse_device_type").prop('disabled', false);
	                     
	            });     

	         	


				// -------------------------------------------------------------------------------------------
			        //  Parámetros aplica-valor
			        // -------------------------------------------------------------------------------------------            
		            $("#popupWindowEditDevices_parameters").on('click', function () {
		
			            	//Sacamos la fila seleccionada en el grid
			                var selectedrowindex = $("#FormDevicesMain_jqxgrid").jqxGrid('getselectedrowindex');
			                var rowscount = $("#FormDevicesMain_jqxgrid").jqxGrid('getdatainformation').rowscount;
		
			        		//Si está seleccionad y hay registros
		                  if (selectedrowindex >= 0 && selectedrowindex < rowscount) {
		                        var id = $("#FormDevicesMain_jqxgrid").jqxGrid('getrowid', selectedrowindex);
		                        
		                        editrow = selectedrowindex;
		                        var offset = $("#FormDevicesMain_jqxgrid").offset();
		
			                    //Capuramos el "recordset" de la fila seleccionada. 
		                        var dataRecord = $("#FormDevicesMain_jqxgrid").jqxGrid('getrowdata', selectedrowindex);
		
			                    //Creamos la URL
		                        var urlApplProcess =  "../menu/main.jsp?titleOption="+applyval_process_title+"&optLoad=1&paginaWeb=../applyvalues/applyValues_view.jspXXXXlevel=DEVICEZZZZcode="+dataRecord.id_device + 'ZZZZcodeName='+dataRecord.name;
		                        
								
								//Simulamos el CLICK
//								menuclick(urlApplProcess,applyval_process_title);    				

		                        //abrimos en nueva pestaña
		                        window.open(urlApplProcess,'_newtab');
		                	}	            
			         	
		            });     
		            
		        // -------------------------------------------------------------------------------------------
		        // ToolTipText de los botones y acciones. Ojo siempre al final del Jquery.
				// -------------------------------------------------------------------------------------------                
                $("#popupWindowEditDevices_recargar").jqxTooltip({ content: Refresh, position: 'default'});
                $("#popupWindowEditDevices_print").jqxTooltip({ content: Print, position: 'default'});
                $("#popupWindowEditDevices_excelExport").jqxTooltip({ content: Excel, position: 'default'});
                $("#popupWindowEditDevices_nuevo").jqxTooltip({ content: New, position: 'default'});
                $("#popupWindowEditDevices_editar").jqxTooltip({ content: Edit, position: 'default'});
                $("#popupWindowEditDevices_eliminar").jqxTooltip({ content: Delete, position: 'default',});
                $("#popupWindowEditDevices_parameters").jqxTooltip({ content: Parameters, position: 'default',});
                  
// -------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------
// FORMULARIOS AUXILIARES AL PRINCIPAL
// -------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------                




			       
	});
</script>

</div>

