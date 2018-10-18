<%@include file="../globales/globalAllPages.jsp" %>
<%@include file="../login/seguridad_view.jsp" %>

<div id="FormParamsGlobal">
 <div id="FormParamsGlobalMain">
       <table width="100%">
           <tr>
               <td width="100%" colspan="3" align="center">
                   <!-- Grid -->
                   <div id="FormParamsGlobal_jqxgrid"></div>
               </td>
           </tr>
       </table>

 <!-- popoup modal de edición -->

                    <div id="popupWindowParamsGlobal">
                        <div><label class="i18n labelnormal" id="params_form_title"></label></div>
                           <div style="overflow: hidden;">
                               <form id="Form_popupWindowParamsGlobal" action="./">
                                   <table>
                                        <tr><!-- ID  -->
                                            <td align="right"><label class="i18n" id="params_form_id"></label></td>
                                            <td align="left"><input id="popupWindowParamsGlobal_id" /></td>
                                        </tr>
                                        <tr> <!-- Nombre -->
                                            <td align="right"><label class="i18n" id="params_form_name"></label></td>
                                            <td align="left"><input id="popupWindowParamsGlobal_name" /></td>
                                        </tr>
                                        <tr>
                                        <tr><!-- Valor -->
                                            <td align="right"><label class="i18n" id="params_form_value"></label></td>
                                            <td align="left"><input id="popupWindowParamsGlobal_value" /></div></td>
                                        </tr>
                                        <tr valign="top"> <!-- Comentario -->
                                            <td align="right"><label class="i18n" id="params_form_comment"></label></td>
                                            <td align="left"><textarea rows="4" cols="40" id="popupWindowParamsGlobal_comment"></textarea></td>
                                        </tr>
                                        <tr> <!-- Esto son los botones -->
                                            <td align="right"></td>
                                            <td style="padding-top: 10px;" align="right"><input type="button" style="margin-right: 5px;"  id="popupWindowParamsGlobal_Save" ></button><input id="popupWindowParamsGlobal_Cancel" type="button" value="Cancelar" /></td>
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
				 
                  $("#popupWindowParamsGlobal").jqxWindow({
                	  Height: altoForm1, width: anchoform1, resizable: false, theme: JsUIStyleCss, isModal: true, autoOpen: false, cancelButton: $("#popupWindowParamsGlobal_Cancel"), modalOpacity: 0.01, animationType: 'combined', showAnimationDuration: 400, closeAnimationDuration: 400            
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
                
				var source_FormParamsGlobal =
				{
					datatype: "json",
					datafields: [
						{ name: 'id'},
						{ name: 'name'},
						{ name: 'comment'},
						{ name: 'value'}
					],
					url: '../auxiliares/params_data.jsp',
					cache: false,
		                        id:'id',
		                        filter: function()
		                        {
		                                // update the grid and send a request to the server.
		                                $("#FormParamsGlobal_jqxgrid").jqxGrid('updatebounddata', 'filter');
		                        },
		                        sort: function()
		                        {
		                                // update the grid and send a request to the server.
		                                $("#FormParamsGlobal_jqxgrid").jqxGrid('updatebounddata', 'sort');
		                        },
		                        root: 'Rows',
		                        beforeprocessing: function(data)
		                        {		
		                                if (data != null)
		                                {
		                                	source_FormParamsGlobal.totalrecords = data[0].TotalRows;					
		                                }
		                        },
		                        addRow: function (rowID, rowData, position, commit) {

		   		            
		                                  $.post('../auxiliares/params_save.jsp', { oper : 'NEW', id : rowData.id, name : rowData.name, value: rowData.value, comment : rowData.comment }, 
		                                    function(resp) {
		                                           
		                                          if (resp.split('{')[0].trim() == "true")
		                                          {
		                                             commit(true);
		                                             $("#FormParamsGlobal_jqxgrid").jqxGrid('updatebounddata', 'cells');
		                                             $("#popupWindowParamsGlobal").jqxWindow('hide'); //ocultamos el Form Modal
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
		             
		                                $.post('../auxiliares/params_save.jsp', { oper : 'MOD', id : rowData.id, name : rowData.name, value: rowData.value, comment : rowData.comment }, 
		                                    function(resp) {
		                                        
		                                         if (resp.split('{')[0].trim() == "true")
		                                          {
		                                             commit(true); 
		                                             $("#FormParamsGlobal_jqxgrid").jqxGrid('updatebounddata', 'cells');
		                                             $("#popupWindowParamsGlobal").jqxWindow('hide'); //ocultamos el Form Modal
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
		                            
		                                $.post('../auxiliares/params_save.jsp', { oper : 'DEL', id : rowID }, 
		                                    function(resp) {
		                                         if (resp.split('{')[0].trim() == "true")
		                                          {
		                                             commit(true); 
		                                             $("#FormParamsGlobal_jqxgrid").jqxGrid('updatebounddata', 'cells');
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
                  $("#popupWindowParamsGlobal_Cancel").jqxButton({ theme: JsUIStyleCss });
                  $("#popupWindowParamsGlobal_Save").jqxButton({ theme: JsUIStyleCss });
                  $("#popupWindowParamsGlobal_Save").val(Save); //textos traducidos a botones
                  $("#popupWindowParamsGlobal_Cancel").val(Cancel); //textos traducidos a los botones		    
		          $("#popupWindowParamsGlobal_id").jqxInput({ theme: JsUIStyleCss,width: '100px', height: '23px' });
                  $("#popupWindowParamsGlobal_name").jqxInput({ theme: JsUIStyleCss,width: '200px', height: '23px' });
                  $("#popupWindowParamsGlobal_comment").jqxInput({ theme: JsUIStyleCss,width: '300px', height: '60px'});
                  $("#popupWindowParamsGlobal_value").jqxInput({ theme: JsUIStyleCss,width: '200px', height: '23px' });
                  
                  
                  var editrow = -1; //indica la linea a editar/eliminar/nuevo
                  var operacion = ""; //indica la operacion DEL cuando es necesario

                  
                  
                // -------------------------------------------------------------------------------------------
                // Validaciones del formulario
				// -------------------------------------------------------------------------------------------                
                    $('#Form_popupWindowParamsGlobal').jqxValidator({
                                    //hintType: 'label',
                                    animationDuration: 500,
                                    theme: JsUIStyleCss,
                                    rules: [
                                            { input: '#popupWindowParamsGlobal_name', message: Obligatorio, action: 'keyup, blur', rule: 'required' },
                                            { input: '#popupWindowParamsGlobal_value', message: Obligatorio, action: 'keyup, blur', rule: 'required' }
                                           ]
                              });        


                 // -------------------------------------------------------------------------------------------
                 // Adaptador del Origenprincipal
                 // -------------------------------------------------------------------------------------------
	                var dataadapter_FormParamsGlobal = new $.jqx.dataAdapter(source_FormParamsGlobal, {
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
				
                var pagerrenderer_FormParamsGlobal = function () {
                    var element = $("<div style='margin-left: 10px; margin-top: 5px; width: 100%; height: 100%; '></div>");
                    var datainfo = $("#FormParamsGlobal_jqxgrid").jqxGrid('getdatainformation');
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
                        $("#FormParamsGlobal_jqxgrid").jqxGrid('gotonextpage');
                    });
                    leftButton.click(function () {
                        $("#FormParamsGlobal_jqxgrid").jqxGrid('gotoprevpage');
                    });
                    return element;
                }

                $("#FormParamsGlobal_jqxgrid").on('pagechanged', function () {
                    var datainfo = $("#FormParamsGlobal_jqxgrid").jqxGrid('getdatainformation');
                    var paginginfo = datainfo.paginginformation;
                    self.label.text(1 + paginginfo.pagenum * paginginfo.pagesize + "-" + Math.min(datainfo.rowscount, (paginginfo.pagenum + 1) * paginginfo.pagesize) + ' of ' + datainfo.rowscount);
                });
                
                


                // -------------------------------------------------------------------------------------------
                // Definición del Grid de datos principal
				// -------------------------------------------------------------------------------------------                

   			    $("#FormParamsGlobal_jqxgrid").jqxGrid(
				{
                    theme: JsUIStyleCss,
                    source: dataadapter_FormParamsGlobal,
                    width: anchoVentana,
                    height: altoVentana,
                    columnsresize: true,
                    filterable: true,
                    pagesize: 20,
                    sortable: true,
                    autoheight: false,
                    pageable: true,
                    //pagermode: 'simple',
                    pagerrenderer: pagerrenderer_FormParamsGlobal,
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
                            { text: params_form_id, datafield: 'id', width: 0, hidden:true},
                            { text: params_form_name, datafield: 'name', width: "30%" },
                            { text: params_form_value, datafield: 'value', width: "20%"},
                            { text: params_form_comment, datafield: 'comment', width: "50%" },
                          ], //de columns

                        rendertoolbar: function (toolbar) {
                            
                            var container = $("<div style='margin: 2px;'></div>");

                            var input1 = $("<a href='#' ><img src='../../images/excel.png' width='27' id='popupWindowParamsGlobal_excelExport'></a>"); 
                            var input2 = $("<a href='#' ><img src='../../images/imprimir.png' width='25' id='popupWindowParamsGlobal_print'></a>"); 
                            var blanco = $("<a href='#' ><img src='../../images/blanco.png' width='22'></a>");
                            
                            var input3 = $("<a href='#' ><img src='../../images/refresh.png' width='22' id='popupWindowParamsGlobal_recargar'></a>");
                            var input4 = $("<a href='#' ><img src='../../images/new.png' width='23' id='popupWindowParamsGlobal_nuevo'></a>");
                            var input5 = $("<a href='#' ><img src='../../images/delete.png' width='25' id='popupWindowParamsGlobal_eliminar'></a>");
                            var input6 = $("<a href='#' ><img src='../../images/edit.png' width='22' id='popupWindowParamsGlobal_editar'></a>");
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
                  $("#popupWindowParamsGlobal").on('open', function () {
                  });

                  //boton Save del formulario. Validamos los datos
                  $("#popupWindowParamsGlobal_Save").click(function () {
                      $('#Form_popupWindowParamsGlobal').jqxValidator('validate');
                  });
                  
                   //cuando este ok la validacion llamamos a Guarda
                  $('#Form_popupWindowParamsGlobal').jqxValidator({ onSuccess: function () { popupWindowParamsGlobal_guarda(); } }); 
                  
    			// -------------------------------------------------------------------------------------------
                // boton Save del formulario
  				// -------------------------------------------------------------------------------------------                  
                  function popupWindowParamsGlobal_guarda() 
                  {
                      if (operacion == "MOD") {  //modificacion
                          //edicion
                          var row = {id : $("#popupWindowParamsGlobal_id").val(), name : $("#popupWindowParamsGlobal_name").val(), value : $("#popupWindowParamsGlobal_value").val(), comment : $("#popupWindowParamsGlobal_comment").val()};                          
                          var rowID = $('#FormParamsGlobal_jqxgrid').jqxGrid('getrowid', editrow);
                          $('#FormParamsGlobal_jqxgrid').jqxGrid('updaterow', rowID, row);
                      }
                      else if (operacion == "NEW") //Nuevo registro
                      {
                          var row = { id : $("#popupWindowParamsGlobal_id").val(), name : $("#popupWindowParamsGlobal_name").val(), value : $("#popupWindowParamsGlobal_value").val(), comment : $("#popupWindowParamsGlobal_comment").val()};
                          var rowID = -1;
                          var rowscount = $("#FormParamsGlobal_jqxgrid").jqxGrid('getdatainformation').rowscount;
                          $('#FormParamsGlobal_jqxgrid').jqxGrid('addRow', rowID, row,rowscount );
                      }
                       
                  };
                  
  				// -------------------------------------------------------------------------------------------
	            //Salida Excel
				// -------------------------------------------------------------------------------------------
					            
	            $("#popupWindowParamsGlobal_excelExport").click(function () {
	                
	                $("#FormParamsGlobal_jqxgrid").jqxGrid('exportdata', 'xls', 'FormParamsGlobal_jqxgrid');           
	            });

				// -------------------------------------------------------------------------------------------	            
	            //Recargar
				// -------------------------------------------------------------------------------------------	            
	            
	            $("#popupWindowParamsGlobal_recargar").click(function () {
	                
	                $("#FormParamsGlobal_jqxgrid").jqxGrid('updatebounddata', 'cells');          
	            });

	            
				// -------------------------------------------------------------------------------------------	            
        		//Imprimir
				// -------------------------------------------------------------------------------------------        		
		         $("#popupWindowParamsGlobal_print").click(function () {
		                var gridContent = $("#FormParamsGlobal_jqxgrid").jqxGrid('exportdata', 'html');
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
		            $("#popupWindowParamsGlobal_eliminar").on('click', function () {
		
		                if (confirm(DeleteMsg))
		                {
		                        var selectedrowindex = $("#FormParamsGlobal_jqxgrid").jqxGrid('getselectedrowindex');
		                        var rowscount = $("#FormParamsGlobal_jqxgrid").jqxGrid('getdatainformation').rowscount;
		                        if (selectedrowindex >= 0 && selectedrowindex < rowscount) {
		
		                            var id = $("#FormParamsGlobal_jqxgrid").jqxGrid('getrowid', selectedrowindex);
		                            var dataRecord = $("#FormParamsGlobal_jqxgrid").jqxGrid('getrowdata', id);
		                            var commit = $("#FormParamsGlobal_jqxgrid").jqxGrid('deleterow', dataRecord.id);
		                        }
		           		 }
		            });

		        // -------------------------------------------------------------------------------------------		 			
		        // Editar un Registro
		        // -------------------------------------------------------------------------------------------
               $("#popupWindowParamsGlobal_editar").on('click', function () {

                   		//Sacamos la fila seleccionada en el grid
		                var selectedrowindex = $("#FormParamsGlobal_jqxgrid").jqxGrid('getselectedrowindex');
		                var rowscount = $("#FormParamsGlobal_jqxgrid").jqxGrid('getdatainformation').rowscount;

		        		//Si está seleccionad y hay registros
	                  if (selectedrowindex >= 0 && selectedrowindex < rowscount) {
	                        var id = $("#FormParamsGlobal_jqxgrid").jqxGrid('getrowid', selectedrowindex);
	                        
	                        editrow = selectedrowindex;
	                        operacion = "MOD";
	                        var offset = $("#FormParamsGlobal_jqxgrid").offset();
	                        $("#popupWindowParamsGlobal").jqxWindow({ position: { x:(anchoVentana-anchoform1)/2, y: parseInt(offset.top) + 100 } });

		                    //Capuramos el "recordset" de la fila seleccionada. 
	                        var dataRecord = $("#FormParamsGlobal_jqxgrid").jqxGrid('getrowdata', selectedrowindex);

		                    //Asigno los campos
	                        $("#popupWindowParamsGlobal_id").val(dataRecord.id);
	                        $("#popupWindowParamsGlobal_name").val(dataRecord.name);
	                        $("#popupWindowParamsGlobal_comment").val(dataRecord.comment);
	                        $("#popupWindowParamsGlobal_value").val(dataRecord.value);
	                        
	                        //abrimos la ventana modal
	                        $("#popupWindowParamsGlobal").jqxWindow('open');

	                        //deshabilitamos siempre el id
	                        $("#popupWindowParamsGlobal_id").prop('disabled', true);
	                }
	            });

            	// -------------------------------------------------------------------------------------------
		        //  Nuevo Registro
		        // -------------------------------------------------------------------------------------------            
	            $("#popupWindowParamsGlobal_nuevo").on('click', function () {
	                     
	                     editrow = -1;  
	                     operacion = "NEW"; //Marco la operación 
	                     var offset = $("#FormParamsGlobal_jqxgrid").offset();
	                     $("#popupWindowParamsGlobal").jqxWindow({ position: { x:(anchoVentana-anchoform1)/2, y: parseInt(offset.top) + 100 } });

	                     // Pongo a blanco los campos
	                     $("#popupWindowParamsGlobal_id").val('');
	                     $("#popupWindowParamsGlobal_name").val('');
	                     $("#popupWindowParamsGlobal_comment").val('');
	                     $("#popupWindowParamsGlobal_value").val('');
                         
	                     //abro la ventana
	                     $("#popupWindowParamsGlobal").jqxWindow('open');

	                   	//deshabilitamos siempre el id
	                     $("#popupWindowParamsGlobal_id").prop('disabled', true); 
	            });     

	         	

		        // -------------------------------------------------------------------------------------------
		        // ToolTipText de los botones y acciones. Ojo siempre al final del Jquery.
				// -------------------------------------------------------------------------------------------                
                $("#popupWindowParamsGlobal_recargar").jqxTooltip({ content: Refresh, position: 'default'});
                $("#popupWindowParamsGlobal_print").jqxTooltip({ content: Print, position: 'default'});
                $("#popupWindowParamsGlobal_excelExport").jqxTooltip({ content: Excel, position: 'default'});
                $("#popupWindowParamsGlobal_nuevo").jqxTooltip({ content: New, position: 'default'});
                $("#popupWindowParamsGlobal_editar").jqxTooltip({ content: Edit, position: 'default'});
                $("#popupWindowParamsGlobal_eliminar").jqxTooltip({ content: Delete, position: 'default',});



			       
	});
</script>

</div>