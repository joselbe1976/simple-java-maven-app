<%@include file="../globales/globalAllPages.jsp" %>
<%@include file="../login/seguridad_view.jsp" %>



<div id="FormAnalitica2">
 <div id="FormAnalitica2_1">
       <table width="100%">
           <tr>
               <td width="100%" colspan="3" align="center">
                   <!-- Grid -->
                   <div id="FormAnalitica2_jqxgrid"></div>
               </td>
           </tr>
       </table>

   
</div>


<script type="text/javascript">
$(document).ready(function () {
	
                  
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
                
				var source_FormAnalitica2 =
				{
					datatype: "json",
					datafields: [
						{ name: 'num'},
						{ name: 'name'}
					],
					url: '../estadisticas/user_device_acc_data.jsp',
					cache: false
				};
		
            

                 // -------------------------------------------------------------------------------------------
                 // Adaptador del Origenprincipal
                 // -------------------------------------------------------------------------------------------
	                var dataadapter_FormAnalitica2 = new $.jqx.dataAdapter(source_FormAnalitica2, {
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
                // Definición del Grid de datos principal
				// -------------------------------------------------------------------------------------------                

   			    $("#FormAnalitica2_jqxgrid").jqxGrid(
				{
                    theme: JsUIStyleCss,
                    source: dataadapter_FormAnalitica2,
                    width: anchoVentana,
                    height: altoVentana,
                    columnsresize: true,
                    filterable: false,
                    sortable: false,
                    autoheight: false,
                    pageable: false,
                    //pagermode: 'simple',
                    //pagerrenderer: pagerrenderer_FormAnalitica2,
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
                            { text: analiticas_grid_name_2, datafield: 'name', width: "50%"},
                            { text: analiticas_grid_num_1, datafield: 'num', width: "50%" }
                            
                          ], //de columns

                        rendertoolbar: function (toolbar) {
                            
                            var container = $("<div style='margin: 2px;'></div>");

                            var input1 = $("<a href='#' ><img src='../../images/excel.png' width='27' id='popupWindowAnalitica2_excelExport'></a>"); 
                            var input2 = $("<a href='#' ><img src='../../images/imprimir.png' width='25' id='popupWindowAnalitica2_print'></a>"); 
                            var blanco = $("<a href='#' ><img src='../../images/blanco.png' width='22'></a>");
                            
                            var input3 = $("<a href='#' ><img src='../../images/refresh.png' width='22' id='popupWindowAnalitica2_recargar'></a>");
                                                  
                            
                            toolbar.append(container);
                            container.append(input3);
                            container.append(blanco);
                            container.append(input1);
                            container.append(input2);
                             
                       }

				});  //del grid 
                


		      
                  
  				// -------------------------------------------------------------------------------------------
	            //Salida Excel
				// -------------------------------------------------------------------------------------------
					            
	            $("#popupWindowAnalitica2_excelExport").click(function () {
	                
	                $("#FormAnalitica2_jqxgrid").jqxGrid('exportdata', 'xls', 'FormAnalitica2_jqxgrid');           
	            });

				// -------------------------------------------------------------------------------------------	            
	            //Recargar
				// -------------------------------------------------------------------------------------------	            
	            
	            $("#popupWindowAnalitica2_recargar").click(function () {
	                
	                $("#FormAnalitica2_jqxgrid").jqxGrid('updatebounddata', 'cells');          
	            });

	            
				// -------------------------------------------------------------------------------------------	            
        		//Imprimir
				// -------------------------------------------------------------------------------------------        		
		         $("#popupWindowAnalitica2_print").click(function () {
		                var gridContent = $("#FormAnalitica2_jqxgrid").jqxGrid('exportdata', 'html');
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
                $("#popupWindowAnalitica2_recargar").jqxTooltip({ content: Refresh, position: 'default'});
                $("#popupWindowAnalitica2_print").jqxTooltip({ content: Print, position: 'default'});
                $("#popupWindowAnalitica2_excelExport").jqxTooltip({ content: Excel, position: 'default'});

			       
	});
</script>

</div>