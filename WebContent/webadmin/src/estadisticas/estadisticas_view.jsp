<%@include file="../globales/globalAllPages.jsp" %>
<%@include file="../login/seguridad_view.jsp" %>
<script type="text/javascript" src="../../jqwidgets/jqxexpander.js"></script>



<div id="FormEstadisticas">
 <div id="FormEstadisticasMain">
       <table width="100%">
	       <tr >
	       		<td width="100%" colspan="3" align="center">
	        		<div id='FormEstadisticas_jqxExpander'>
	        		<div></div>
	        		<div>
	        			<table width="100%">
	        				<tr>
	        					<td width="15%" align="right"><label class="i18n" id="estadisticas_grid_user"></label></td>
	        					<td width="35%"><div id="FormEstadisticas_jqxusers"></div></td>
	        					<td width="15%" align="right"><label class="i18n" id="estadisticas_grid_process"></label></td>
	        					<td width="35%"><div id="FormEstadisticas_jqxprocess"></div></td>
	        				</tr>
							<tr>
	        					<td width="15%" align="right"><label class="i18n" id="estadisticas_grid_System"></label></td>
	        					<td width="35%"><div id="FormEstadisticas_jqxsystems"></div></td>
	        					<td width="15%" align="right"><label class="i18n" id="estadisticas_grid_info"></label></td>
	        					<td width="35%"><input type="text" id="FormEstadisticas_info"/></td>
	        				</tr>	        				
	        			</table>
	        		
	        		</div>
            		</div>
            	</td>
	       	</tr>
	       <tr>
               <td width="100%" colspan="3" align="center">
                   <!-- Grid -->
                   <div id="FormEstadisticas_jqxgrid"></div>
               </td>
           </tr>
       </table>
</div>


<script type="text/javascript">
$(document).ready(function () {

		    //i18N
		    chgLang('<%=viewIdioma%>');  
			
			$("#FormEstadisticas_jqxExpander").jqxExpander({ width: '99%', theme:JsUIStyleCss});
			$('#FormEstadisticas_jqxExpander').jqxExpander('setHeaderContent', estadisticas_process_titulo_filtro); 

			$('#FormEstadisticas_jqxExpander').on('collapsed', function () { 
				$('#FormEstadisticas_jqxgrid').jqxGrid({ height: altoVentana-30 });
			}); 
			$('#FormEstadisticas_jqxExpander').on('expanded', function () { 
				$('#FormEstadisticas_jqxgrid').jqxGrid({ height: altoVentana -110});
			}); 	

	                   

			$("#FormEstadisticas_info").jqxInput({ theme: JsUIStyleCss,width: '500px', height: '25px'});

    			

// -------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------
// FORMULARIO PRINCIPAL
// -------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------                
                
                // -------------------------------------------------------------------------------------------
                //Origen datos para alimentar datos Json/XML de los componentes 
                // -------------------------------------------------------------------------------------------
                
				var source_FormEstadisticas =
				{
					datatype: "json",
					datafields: [
						{ name: 'ordinal'},
						{ name: 'id_user'},
						{ name: 'user_name'},
						{ name: 'id_process'},
						{ name: 'name_process'}, 
						{ name: 'comment'},
						{ name: 'id_system'},
						{ name: 'name_system'},
						{ name: 'date_exec',type: 'date', format: 'dd/MM/yyyy HH:mm:ss'}, 
						{ name: 'text'}
					],
					url: '../estadisticas/estadisticas_data.jsp',
					cache: false,
		                        id:'id',
		                        filter: function()
		                        {
		                                // update the grid and send a request to the server.
		                                $("#FormEstadisticas_jqxgrid").jqxGrid('updatebounddata', 'filter');
		                        },
		                        sort: function()
		                        {
		                                // update the grid and send a request to the server.
		                                $("#FormEstadisticas_jqxgrid").jqxGrid('updatebounddata', 'sort');
		                        },
		                        root: 'Rows',
		                        beforeprocessing: function(data)
		                        {		
		                                if (data != null)
		                                {
		                                	source_FormEstadisticas.totalrecords = data[0].TotalRows;					
		                                }
		                        }
		                                               
						};
		
                
                  
                  var editrow = -1; //indica la linea a editar/eliminar/nuevo
                  var operacion = ""; //indica la operacion DEL cuando es necesario

                  
                  
             
                 // -------------------------------------------------------------------------------------------
                 // Adaptador del Origenprincipal
                 // -------------------------------------------------------------------------------------------
	                var dataadapter_FormEstadisticas = new $.jqx.dataAdapter(source_FormEstadisticas, {
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
				
                var pagerrenderer_FormEstadisticas = function () {
                    var element = $("<div style='margin-left: 10px; margin-top: 5px; width: 100%; height: 100%; '></div>");
                    var datainfo = $("#FormEstadisticas_jqxgrid").jqxGrid('getdatainformation');
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
                        $("#FormEstadisticas_jqxgrid").jqxGrid('gotonextpage');
                    });
                    leftButton.click(function () {
                        $("#FormEstadisticas_jqxgrid").jqxGrid('gotoprevpage');
                    });
                    return element;
                }

                $("#FormEstadisticas_jqxgrid").on('pagechanged', function () {
                    var datainfo = $("#FormEstadisticas_jqxgrid").jqxGrid('getdatainformation');
                    var paginginfo = datainfo.paginginformation;
                    self.label.text(1 + paginginfo.pagenum * paginginfo.pagesize + "-" + Math.min(datainfo.rowscount, (paginginfo.pagenum + 1) * paginginfo.pagesize) + ' of ' + datainfo.rowscount);
                });
                
                


                // -------------------------------------------------------------------------------------------
                // Definición del Grid de datos principal
				// -------------------------------------------------------------------------------------------                

   			    $("#FormEstadisticas_jqxgrid").jqxGrid(
				{
                    theme: JsUIStyleCss,
                    source: dataadapter_FormEstadisticas,
                    width: anchoVentana,
                    height: altoVentana-110,
                    columnsresize: true,
                    filterable: true,//NO FILTER
                    filtermode: 'excel',
                    showfilterrow: false,
                    
                    sortable: true,
                    autoheight: false,
                    pageable: true,
                    //pagermode: 'simple',
                    pagesize: 20,
                    pagerrenderer: pagerrenderer_FormEstadisticas,
                    virtualmode: false,
                    altrows: false,
                    showtoolbar: true, //muestra la barra de herramientas superior
                    showstatusbar: false, //muestra la barra de abajo de estado
                    
                    rendergridrows: function(obj)
						{
							return obj.data;    
						},
                    columns: [
							{ text: 'ordinal', datafield: 'ordinal', width: 0, hidden: true},                               
                            { text: 'id_user', datafield: 'id_user', width: 0,hidden: true},
                            { text: estadisticas_grid_user_name, datafield: 'user_name', width: "15%", filtertype: 'checkedlist' },
                            { text: estadisticas_grid_fecha, datafield: 'date_exec', width: "12%" ,cellsformat: 'dd/MM/yyyy HH:mm:ss',filtertype: 'date'},
                            { text: 'id_process', datafield: 'id_process', width: 0, hidden: true},
                            { text: estadisticas_grid_process_name, datafield: 'name_process', width: "15%", filtertype: 'checkedlist' },
                            { text: 'id_system', datafield: 'id_system', width: 0,hidden: true },
                            { text: estadisticas_grid_system_name, datafield: 'name_system', width: "10%" , filtertype: 'checkedlist'},
                            { text: estadisticas_grid_info, datafield: 'text', width: "30%" },
                            { text: estadisticas_grid_comment, datafield: 'comment', width: 500 }                            
                            
                          ], //de columns
                        rendertoolbar: function (toolbar) {
                            
                            var container = $("<div style='margin: 2px;'></div>");

                            var input1 = $("<a href='#' ><img src='../../images/excel.png' width='27' id='popupWindowEditEstadisticas_excelExport'></a>"); 
                            var input2 = $("<a href='#' ><img src='../../images/imprimir.png' width='25' id='popupWindowEditEstadisticas_print'></a>"); 
                            var blanco = $("<a href='#' ><img src='../../images/blanco.png' width='22'></a>");
                            
                            var input3 = $("<a href='#' ><img src='../../images/refresh.png' width='22' id='popupWindowEditEstadisticas_recargar'></a>");
                            var blanco1 = $("<a href='#' ><img src='../../images/blanco.png' width='10'></a>");
                            var blanco2 = $("<a href='#' ><img src='../../images/blanco.png' width='10'></a>");
                            var blanco3 = $("<a href='#' ><img src='../../images/blanco.png' width='10'></a>");      
                                                  
                            
                            toolbar.append(container);
                            container.append(input3);
                            container.append(input1);
                            container.append(input2);
                             
                       }

				});  //del grid 
                
  				// -------------------------------------------------------------------------------------------
	            //Salida Excel
				// -------------------------------------------------------------------------------------------
					            
	            $("#popupWindowEditEstadisticas_excelExport").click(function () {
	                
	                $("#FormEstadisticas_jqxgrid").jqxGrid('exportdata', 'xls', 'FormEstadisticas_jqxgrid');           
	            });

				// -------------------------------------------------------------------------------------------	            
	            //Recargar
				// -------------------------------------------------------------------------------------------	            
	            
	            $("#popupWindowEditEstadisticas_recargar").click(function () {

					//buscamos los filtros y montamos la URL
					// -- Usuarios ---
					
					var items = $("#FormEstadisticas_jqxusers").jqxComboBox('getSelectedItems');
					var selectedusers = "";
                    $.each(items, function (index) {
                    	selectedusers += this.value;
                        if (items.length - 1 != index) {
                        	selectedusers += ",";
                        }
                    });

					//Sistemas
					var items = $("#FormEstadisticas_jqxsystems").jqxComboBox('getSelectedItems');
					var selectedsystems = "";
                    $.each(items, function (index) {
                    	selectedsystems += this.value;
                        if (items.length - 1 != index) {
                        	selectedsystems += ",";
                        }
                    });
                    
					//procesos
					var items = $("#FormEstadisticas_jqxprocess").jqxComboBox('getSelectedItems');
					var selectedprocess = "";
                    $.each(items, function (index) {
                    	selectedprocess += this.value;
                        if (items.length - 1 != index) {
                        	selectedprocess += ",";
                        }
                    });


                    //Campo info
					var info = $("#FormEstadisticas_info").val();                    


                    var estadisticas_url = "../estadisticas/estadisticas_data.jsp?users="+selectedusers + "&systems="+selectedsystems + "&process="+selectedprocess + "&info="+info;
                    source_FormEstadisticas.url = estadisticas_url;
                    
                    $("#FormEstadisticas_jqxgrid").jqxGrid({source:source_FormEstadisticas});					
                    
	                //$("#FormEstadisticas_jqxgrid").jqxGrid('updatebounddata', 'cells');          
	            });

	            
				// -------------------------------------------------------------------------------------------	            
        		//Imprimir
				// -------------------------------------------------------------------------------------------        		
		         $("#popupWindowEditEstadisticas_print").click(function () {
		                var gridContent = $("#FormEstadisticas_jqxgrid").jqxGrid('exportdata', 'html');
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
		        // ToolTipText de los botones y acciones. Ojo siempre al final del Jquery.
				// -------------------------------------------------------------------------------------------                
                $("#popupWindowEditEstadisticas_recargar").jqxTooltip({ content: Refresh, position: 'default'});
                $("#popupWindowEditEstadisticas_print").jqxTooltip({ content: Print, position: 'default'});
                $("#popupWindowEditEstadisticas_excelExport").jqxTooltip({ content: Excel, position: 'default'});


             // -------------------------------------------------------------------------------------------
             // LISTAS DE EDICION DEL PRINCIPAL - TABLAS REFERENCIA ETC.
             // -------------------------------------------------------------------------------------------                

    			//Lista de usuarios
                var source_FormEstadisticas_users =
                   {
                       datatype: "json",
                       datafields: [
                           { name: 'id_user' },
                           { name: 'user_name' }
                       ],
                       url: '../admin/lista_usuarios_data.jsp',
                       async: true
                   };
                   var dataAdapter_FormEstadisticas_users = new $.jqx.dataAdapter(source_FormEstadisticas_users);
                // Create a jqxComboBox
                  $("#FormEstadisticas_jqxusers").jqxComboBox({theme: JsUIStyleCss,multiSelect: true, selectedIndex: 0, source: dataAdapter_FormEstadisticas_users, displayMember: "user_name", valueMember: "id_user", width: 500, height: 25});
               
                

      			//Lista de Procesos
                  var source_FormEstadisticas_process =
                     {
                         datatype: "json",
                         datafields: [
                             { name: 'id_process' },
                             { name: 'name' }
                         ],
                         url: '../auxiliares/lista_process_data.jsp',
                         async: true
                     };
                     var dataAdapter_FormEstadisticas_process = new $.jqx.dataAdapter(source_FormEstadisticas_process);
                  // Create a jqxComboBox
                    $("#FormEstadisticas_jqxprocess").jqxComboBox({theme: JsUIStyleCss, multiSelect: true,selectedIndex: 0, source: dataAdapter_FormEstadisticas_process, displayMember: "name", valueMember: "id_process", width: 500, height: 25});
                  

          			//Lista de Systemas
                    var source_FormEstadisticas_systems =
                       {
                           datatype: "json",
                           datafields: [
                               { name: 'id_system' },
                               { name: 'name' }
                           ],
                           url: '../auxiliares/lista_systems_data.jsp',
                           async: true
                       };
                       var dataAdapter_FormEstadisticas_systems = new $.jqx.dataAdapter(source_FormEstadisticas_systems);
                    // Create a jqxComboBox
                      $("#FormEstadisticas_jqxsystems").jqxComboBox({theme: JsUIStyleCss,multiSelect: true, selectedIndex: 0, source: dataAdapter_FormEstadisticas_systems, displayMember: "name", valueMember: "id_system", width: 500, height: 25});
                    


                  
// -------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------
// FORMULARIOS AUXILIARES AL PRINCIPAL
// -------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------                

			       
	});
</script>

</div>