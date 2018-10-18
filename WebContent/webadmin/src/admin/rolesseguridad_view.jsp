<%
// Step 1. Reemplazar  "popupWindowEditRole" por el nombre único en todas las paginas
// Todos los objetos deben tener un nombr eunico para no terner problemas de duplicidad en el DOM de Javascript
%> 
<%@include file="../globales/globalAllPages.jsp" %>
<%@include file="../login/seguridad_view.jsp" %>



<div id="popupWindowEditRole_Main_View">
  <div id="popupWindowEditRole_Form">
       <table width="100%">
           <tr>
 				<td width="100%" align="center">
                   <!-- Grid -->
                   <div id="jqxgrid_Roles"></div>
               </td>
               
           </tr>
       </table>

				 <!-- popoup modal de edición -->

                    <div id="popupWindowEditRole">
                        <div><label class="i18n labelnormal" id="roles_lista_windows_title"></label></div>
                           <div style="overflow: hidden;">
                               <form id="Form_popupWindowEditRole" action="./">
                                  
                                   <table>
                                        <tr>
                                            <td align="right"><label class="i18n" id="roles_lista.lbl_id"></label></td>
                                            <td align="left"><input id="popupWindowEditRole_id" /></td>
                                        </tr>
                                        <tr>
                                            <td align="right"><label class="i18n" id="roles_lista.lbl_nombre"></label></td>
                                            <td align="left"><input id="popupWindowEditRole_name" /></td>
                                        </tr>
                                        <tr>
                                            <td align="right"><label class="i18n" id="roles_lista.grid.channel"></label></td>
                                            <td align="left"><input id="popupWindowEditRole_parse_channel" /></td>
                                        </tr>

                                        <tr valign="top">
                                            <td align="right"><label class="i18n" id="roles_lista.grid.comment"></label></td>
                                            <td align="left"><textarea rows="4" cols="40" id="popupWindowEditRole_comment"></textarea></td>
                                        </tr>
                                        <tr>
                                            <td align="right"></td>
                                            <td style="padding-top: 10px;" align="right"><input type="button" style="margin-right: 5px;"  id="popupWindowEditRole_Save" ></button><input id="popupWindowEditRole_Cancel" type="button" value="Cancelar" /></td>
                                        </tr>
                                        <tr>
                                            <td align="right"> </td>
                                            <td align="left"><br> </td>
                                        </tr>                                        
                                    </table>
                               </form>
                           </div>
                      </div>       
    
</div>


<script type="text/javascript">
$(document).ready(function () {
	
				 var anchoform1 = 400;		
				 var altoForm1 =  250;
			

                  $("#popupWindowEditRole").jqxWindow({
                	  Height: altoForm1, width: anchoform1, resizable: false, theme: JsUIStyleCss, isModal: true, autoOpen: false, cancelButton: $("#popupWindowEditRole_Cancel"), modalOpacity: 0.01, animationType: 'combined', showAnimationDuration: 400, closeAnimationDuration: 400            
                  });
                  
                //i18N
                chgLang('<%=viewIdioma%>');   

			

                // -------------------------------------------------------------------------------------------
                // -------------------------------------------------------------------------------------------
                //Origen datos para alimentar datos Json/XML de los componentes 
                // -------------------------------------------------------------------------------------------
				// -------------------------------------------------------------------------------------------                
                
				var popupWindowEditRole_source =
				{
					datatype: "json",
					datafields: [
						{ name: 'id'},
						{ name: 'name'},
						{ name: 'comment'},
						{ name : 'parse_channel'}
		
					],
					url: '../admin/rolesseguridad_data.jsp',
					cache: false,
		                        id:'id',
		                        filter: function()
		                        {
		                                // update the grid and send a request to the server.
		                                $("#jqxgrid_Roles ").jqxGrid('updatebounddata', 'filter');
		                        },
		                        sort: function()
		                        {
		                                // update the grid and send a request to the server.
		                                $("#jqxgrid_Roles ").jqxGrid('updatebounddata', 'sort');
		                        },
		                        root: 'Rows',
		                        beforeprocessing: function(data)
		                        {		
		                                if (data != null)
		                                {
		                                	popupWindowEditRole_source.totalrecords = data[0].TotalRows;					
		                                }
		                        },
		                        addRow: function (rowID, rowData, position, commit) {
		                 
		                                  $.post('../admin/rolesseguridad_save.jsp', { oper : 'NEW', id : rowData.id, name : rowData.name, comment: rowData.comment , parse_channel: rowData.parse_channel}, 
		                                    function(resp) {
		                                           
		                                          if (resp.split('{')[0].trim() == "true")
		                                          {
		                                             commit(true);
		                                             $("#jqxgrid_Roles ").jqxGrid('updatebounddata', 'cells');
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
		             
		                                $.post('../admin/rolesseguridad_save.jsp', { oper : 'MOD', id : rowData.id, name : rowData.name, comment: rowData.comment, parse_channel: rowData.parse_channel }, 
		                                    function(resp) {
		                                        
		                                         if (resp.split('{')[0].trim() == "true")
		                                          {
		                                             commit(true); 
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
		                            
		                                $.post('../admin/rolesseguridad_save.jsp', { oper : 'DEL', id : rowID ,name:'', comment: ''}, 
		                                    function(resp) {
		                                         if (resp.split('{')[0].trim() == "true")
		                                          {
		                                             commit(true); 
		                                             $("#jqxgrid_Roles ").jqxGrid('updatebounddata', 'cells');
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
                // -------------------------------------------------------------------------------------------
                // Formato de los campos de los Modales y botones
                // -------------------------------------------------------------------------------------------
				// -------------------------------------------------------------------------------------------                
                  $("#popupWindowEditRole_Cancel").jqxButton({ theme: JsUIStyleCss });
                  $("#popupWindowEditRole_Save").jqxButton({ theme: JsUIStyleCss });
                  $("#popupWindowEditRole_Save").val(Save); //textos traducidos a botones
                  $("#popupWindowEditRole_Cancel").val(Cancel); //textos traducidos a los botones		    
		          $("#popupWindowEditRole_id").jqxInput({ theme: JsUIStyleCss,width: '150px', height: '23px' });
                  $("#popupWindowEditRole_name").jqxInput({ theme: JsUIStyleCss,width: '150px', height: '23px' });
                  $("#popupWindowEditRole_parse_channel").jqxInput({ theme: JsUIStyleCss,width: '150px', height: '23px' });
                  $("#popupWindowEditRole_comment").jqxInput({ theme: JsUIStyleCss,width: '300px', height: '60px'});

                  var editrow = -1; //indica la linea a editar/eliminar/nuevo
                  var operacion = ""; //indica la operacion DEL cuando es necesario

                  
                  
                // -------------------------------------------------------------------------------------------
                // -------------------------------------------------------------------------------------------
                // Validaciones del formulario
                // -------------------------------------------------------------------------------------------
				// -------------------------------------------------------------------------------------------                
                    $('#Form_popupWindowEditRole').jqxValidator({
                                    //hintType: 'label',
                                    animationDuration: 500,
                                    theme: JsUIStyleCss,
                                    rules: [
                                            { input: '#popupWindowEditRole_name', message: Obligatorio, action: 'keyup, blur', rule: 'required' }                                           ]
                              });        


                 // -------------------------------------------------------------------------------------------
                 // -------------------------------------------------------------------------------------------
                 // Adaptador del Origenprincipal
                 // -------------------------------------------------------------------------------------------
    			 // -------------------------------------------------------------------------------------------                
	                var popupWindowEditRole_dataadapter = new $.jqx.dataAdapter(popupWindowEditRole_source, {
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
	                var pagerrendererRoles = function () {
	                    var element = $("<div style='margin-left: 10px; margin-top: 5px; width: 100%; height: 100%; '></div>");
	                    var datainfo = $("#jqxgrid_Roles").jqxGrid('getdatainformation');
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
	                        $("#jqxgrid_Roles").jqxGrid('gotonextpage');
	                    });
	                    leftButton.click(function () {
	                        $("#jqxgrid_Roles").jqxGrid('gotoprevpage');
	                    });
	                    return element;
	                }

	                $("#jqxgrid_Roles").on('pagechanged', function () {
	                    var datainfo = $("#jqxgrid_Roles").jqxGrid('getdatainformation');
	                    var paginginfo = datainfo.paginginformation;
	                    self.label.text(1 + paginginfo.pagenum * paginginfo.pagesize + "-" + Math.min(datainfo.rowscount, (paginginfo.pagenum + 1) * paginginfo.pagesize) + ' of ' + datainfo.rowscount);
	                });


                // -------------------------------------------------------------------------------------------
                // -------------------------------------------------------------------------------------------
                // Definición del Grid de datos principal
                // -------------------------------------------------------------------------------------------
				// -------------------------------------------------------------------------------------------                

   			    $("#jqxgrid_Roles").jqxGrid(
				{
                    theme: JsUIStyleCss,
                    source: popupWindowEditRole_dataadapter,
                    width: anchoVentana,
                    height: altoVentana,
                    columnsresize: true, 
                    filterable: true,
                    filtermode: 'excel',
                    sortable: true,
                    autoheight: false,
                    pageable: true,
                    //pagermode: 'simple',
                    pagerrenderer: pagerrendererRoles,
                    virtualmode: false,
                    altrows: false,
                    showtoolbar: true, //muestra la barra de herramientas superior
                    showstatusbar: false, //muestra la barra de abajo de estado
                    rendergridrows: function(obj)
						{
							return obj.data;    
						},
                    columns: [
                            { text: roles_lista.grid.id, datafield: 'id', width: 0, hidden:true},
                            { text: roles_lista.grid.nombre, datafield: 'name', width: "25%" },
                            { text: roles_lista.grid.channel, datafield: 'parse_channel', width: "25%" },
                            { text: roles_lista.grid.comment, datafield: 'comment', width: "50%" }
                          ], //de columns

                        rendertoolbar: function (toolbar) {
                            var me = this;
                            var container = $("<div style='margin: 2px;'></div>");

                            var input1 = $("<a href='#' ><img src='../../images/excel.png' width='27' id='popupWindowEditRole_excelExport'></a>"); 
                            var input2 = $("<a href='#' ><img src='../../images/imprimir.png' width='25' id='popupWindowEditRole_print'></a>"); 
                            var blanco = $("<a href='#' ><img src='../../images/blanco.png' width='22'></a>");
                            
                            var input3 = $("<a href='#' ><img src='../../images/refresh.png' width='22' id='popupWindowEditRole_recargar'></a>");
                            var input4 = $("<a href='#' ><img src='../../images/new.png' width='23' id='popupWindowEditRole_nuevo'></a>");
                            var input5 = $("<a href='#' ><img src='../../images/delete.png' width='25' id='popupWindowEditRole_eliminar'></a>");
                            var input6 = $("<a href='#' ><img src='../../images/edit.png' width='22' id='popupWindowEditRole_editar'></a>");
                            var blanco1 = $("<a href='#' ><img src='../../images/blanco.png' width='10'></a>");
                            var blanco2 = $("<a href='#' ><img src='../../images/blanco.png' width='10'></a>");
                            var blanco3 = $("<a href='#' ><img src='../../images/blanco.png' width='10'></a>");                            
                            var input10 = $("<a href='#' ><img src='../../images/parameters.png' width='22' id='popupWindowEditRole_parameters'></a>");

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
                             
                       },
                      renderstatusbar: function (statusbar) {
                      }
				});  //del grid 
                


		        // -------------------------------------------------------------------------------------------
		        // -------------------------------------------------------------------------------------------
		        // Acciones y Operaciones
		        // -------------------------------------------------------------------------------------------
				// -------------------------------------------------------------------------------------------                

			      // initialize the popup window and buttons.
                  $("#popupWindowEditRole").on('open', function () {
                  });

                  //boton Save del formulario. Validamos los datos
                  $("#popupWindowEditRole_Save").click(function () {
                      $('#Form_popupWindowEditRole').jqxValidator('validate');
                  });
                  
                   //cuando este ok la validacion llamamos a Guarda
                  $('#Form_popupWindowEditRole').jqxValidator({ onSuccess: function () { guarda(); } }); 
                  

                  //boton Save del formulario
                  function guarda() 
                  {
                      if (operacion == "MOD") {  //modificacion
                          //edicion
                          var row = { id: $("#popupWindowEditRole_id").val(), name: $("#popupWindowEditRole_name").val(), comment: $("#popupWindowEditRole_comment").val(),parse_channel: $("#popupWindowEditRole_parse_channel").val()};
                          var rowID = $('#jqxgrid_Roles ').jqxGrid('getrowid', editrow);
                          $('#jqxgrid_Roles ').jqxGrid('updaterow', rowID, row);
                          $("#popupWindowEditRole").jqxWindow('hide'); //ocultamos el Form Modal
                      }
                      else if (operacion == "NEW") //Nuevo registro
                      {
                          var row = { id: '', name: $("#popupWindowEditRole_name").val(), comment: $("#popupWindowEditRole_comment").val(),parse_channel: $("#popupWindowEditRole_parse_channel").val()};
                          var rowID = -1;
                          var rowscount = $("#jqxgrid_Roles ").jqxGrid('getdatainformation').rowscount;
                          $('#jqxgrid_Roles ').jqxGrid('addRow', rowID, row,rowscount );
                          $("#popupWindowEditRole").jqxWindow('hide'); //ocultamos el Form Modal
                      }
                       
                  };
	
	            //Salida Excel
	            $("#popupWindowEditRole_excelExport").click(function () {
	                
	                $("#jqxgrid_Roles ").jqxGrid('exportdata', 'xls', 'jqxGrid');           
	            });

	            //Recargar
	            $("#popupWindowEditRole_recargar").click(function () {
	                
	                $("#jqxgrid_Roles ").jqxGrid('updatebounddata', 'cells');          
	            });
        		//Imprimir
		         $("#popupWindowEditRole_print").click(function () {
		                var gridContent = $("#jqxgrid_Roles ").jqxGrid('exportdata', 'html');
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

		 			//Eliminar un registro            
		            $("#popupWindowEditRole_eliminar").on('click', function () {
		
		                if (confirm(DeleteMsg))
		                {
		                        var selectedrowindex = $("#jqxgrid_Roles ").jqxGrid('getselectedrowindex');
		                        var rowscount = $("#jqxgrid_Roles ").jqxGrid('getdatainformation').rowscount;
		                        if (selectedrowindex >= 0 && selectedrowindex < rowscount) {
		
		                            var id = $("#jqxgrid_Roles ").jqxGrid('getrowid', selectedrowindex);
		                            var commit = $("#jqxgrid_Roles ").jqxGrid('deleterow', id);
		                        }
		            }
		            });

		            //Editar un Registro
               $("#popupWindowEditRole_editar").on('click', function () {

                   		//Sacamos la fila seleccionada en el grid
		                var selectedrowindex = $("#jqxgrid_Roles ").jqxGrid('getselectedrowindex');
		                var rowscount = $("#jqxgrid_Roles ").jqxGrid('getdatainformation').rowscount;

		        		//Si está seleccionad y hay registros
	                  if (selectedrowindex >= 0 && selectedrowindex < rowscount) {
	                        var id = $("#jqxgrid_Roles ").jqxGrid('getrowid', selectedrowindex);
	                        
	                        editrow = selectedrowindex;
	                        operacion = "MOD";
	                        var offset = $("#jqxgrid_Roles").offset();
	                        $("#popupWindowEditRole").jqxWindow({ position: { x:(anchoVentana-anchoform1)/2, y: parseInt(offset.top) + 100 } });

		                    //Capuramos el "recordset" de la fila seleccionada. 
	                        var dataRecord = $("#jqxgrid_Roles ").jqxGrid('getrowdata', selectedrowindex);

		                    //Asigno los campos
	                        $("#popupWindowEditRole_id").val(dataRecord.id);
	                        $("#popupWindowEditRole_name").val(dataRecord.name);
	                        $("#popupWindowEditRole_comment").val(dataRecord.comment);
	                        $("#popupWindowEditRole_parse_channel").val(dataRecord.parse_channel);

	                        //abrimos la ventana modal
	                        $("#popupWindowEditRole").jqxWindow('open');

	                        //deshabilitamos
	                        $("#popupWindowEditRole_id").prop('disabled', true);
	                        $("#popupWindowEditRole_parse_channel").prop('disabled', true); //parse no permite modificacion
	                }
	            });

		        //Nuevo Registro            
	            $("#popupWindowEditRole_nuevo").on('click', function () {
	                     
	                     editrow = -1;  
	                     operacion = "NEW"; //Marco la operación 
	                     var offset = $("#jqxgrid_Roles").offset();
	                     $("#popupWindowEditRole").jqxWindow({ position: { x:(anchoVentana-anchoform1)/2, y: parseInt(offset.top) + 100 } });

	                     // Pongo a blanco los campos
	                     $("#popupWindowEditRole_id").val('');
	                     $("#popupWindowEditRole_name").val('');
	                     $("#popupWindowEditRole_comment").val('');
	                     $("#popupWindowEditRole_parse_channel").val('');

	                     //abro la ventana
	                     $("#popupWindowEditRole").jqxWindow('open');

	                     //Deshabilito los campos que no se deban poder tocar
	                     $("#popupWindowEditRole_id").prop('disabled', true); //Autonumerico en BBDD
	                     $("#popupWindowEditRole_parse_channel").prop('disabled', false); 
	            });     



				// -------------------------------------------------------------------------------------------
			        //  Parámetros aplica-valor
			        // -------------------------------------------------------------------------------------------            
		            $("#popupWindowEditRole_parameters").on('click', function () {
		
			            	//Sacamos la fila seleccionada en el grid
			                var selectedrowindex = $("#jqxgrid_Roles").jqxGrid('getselectedrowindex');
			                var rowscount = $("#jqxgrid_Roles").jqxGrid('getdatainformation').rowscount;
		
			        		//Si está seleccionad y hay registros
		                  if (selectedrowindex >= 0 && selectedrowindex < rowscount) {
		                        var id = $("#jqxgrid_Roles").jqxGrid('getrowid', selectedrowindex);
		                        
		                        editrow = selectedrowindex;
		                        var offset = $("#jqxgrid_Roles").offset();
		
			                    //Capuramos el "recordset" de la fila seleccionada. 
		                        var dataRecord = $("#jqxgrid_Roles").jqxGrid('getrowdata', selectedrowindex);
		
			                    //Creamos la URL
		                        var urlApplProcess =  "../menu/main.jsp?titleOption="+applyval_process_title+"&optLoad=1&paginaWeb=../applyvalues/applyValues_view.jspXXXXlevel=ROLEZZZZcode="+dataRecord.id + 'ZZZZcodeName='+dataRecord.name;
		                        
								
								//Simulamos el CLICK
//								menuclick(urlApplProcess,applyval_process_title);    				

		                        //abrimos en nueva pestaña
		                        window.open(urlApplProcess,'_newtab');
		                	}	            
			         	
		            });     	            



		        // -------------------------------------------------------------------------------------------
		        // -------------------------------------------------------------------------------------------
		        // ToolTipText de los botones y acciones. Ojo siempre al final del Jquery.
		        // -------------------------------------------------------------------------------------------
				// -------------------------------------------------------------------------------------------                

                $("#popupWindowEditRole_recargar").jqxTooltip({ content: Refresh, position: 'default', name: 'movieTooltip'});
                $("#popupWindowEditRole_print").jqxTooltip({ content: Print, position: 'default', name: 'movieTooltip'});
                $("#popupWindowEditRole_excelExport").jqxTooltip({ content: Excel, position: 'default', name: 'movieTooltip'});
                $("#popupWindowEditRole_nuevo").jqxTooltip({ content: New, position: 'default', name: 'movieTooltip'});
                $("#popupWindowEditRole_editar").jqxTooltip({ content: Edit, position: 'default', name: 'movieTooltip'});
                $("#popupWindowEditRole_eliminar").jqxTooltip({ content: Delete, position: 'default', name: 'movieTooltip'});
                $("#popupWindowEditRole_parameters").jqxTooltip({ content: Parameters, position: 'default',});
		        
	});
</script>
</div>