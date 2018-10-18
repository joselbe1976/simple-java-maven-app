<%

//parametros de paginacion que envia la tabla jquery

int pagenum=0;
int pagesize = 30;
int filterscount = 0;
String where=" (1=1) ";

try{
	pagenum = Integer.parseInt(request.getParameter("pagenum"));
	pagesize = Integer.parseInt(request.getParameter("pagesize"));
	filterscount = Integer.parseInt(request.getParameter("filterscount"));
}
catch(Exception e){}

int start = pagenum * pagesize;

//sqlBase es la sentencia Base


String query = " LIMIT " + start  + ", "+pagesize;
String filterquery = "";


if (filterscount > 0)
{
	where += "AND (";
	String tmpdatafield = "";
	int tmpfilteroperator = 0;
	for (int i=0; i < filterscount; i++)
    {
		// get the filter's value.
		String filtervalue = "";
		try{
			filtervalue = request.getParameter("filtervalue"+i);
		}
		catch(Exception e){}
		
		// get the filter's condition.
		String filtercondition = request.getParameter("filtercondition"+i);
		// get the filter's column.
		String filterdatafield = request.getParameter("filterdatafield"+i);
		// get the filter's operator.
		int filteroperator = Integer.parseInt(request.getParameter("filteroperator"+i));
		
		if (tmpdatafield.equals(""))
		{
			tmpdatafield = filterdatafield;			
		}
		else if (!tmpdatafield.equals(filterdatafield))
		{
			where += ")AND(";
		}
		else if (tmpdatafield.equals(filterdatafield))
		{
			if (filteroperator == 0)
			{
				where += " AND ";
			}
			else where += " OR ";	
		}
		
		// build the "WHERE" clause depending on the filter's condition, value and datafield.
		if (filtercondition.equals("CONTAINS"))
				where += " " + filterdatafield + " LIKE '%" + filtervalue +"%'";
		else if (filtercondition.equals("DOES_NOT_CONTAIN"))
				where += " " + filterdatafield + " NOT LIKE '%" + filtervalue +"%'";
		else if (filtercondition.equals("EQUAL"))
				where += " " + filterdatafield + " = '" + filtervalue + "'";
		else if (filtercondition.equals("NOT_EQUAL"))
				where += " " + filterdatafield + " <> '" + filtervalue + "'";
		else if (filtercondition.equals("GREATER_THAN"))
				where += " " + filterdatafield + " > '" + filtervalue + "'";
		else if (filtercondition.equals("LESS_THAN"))
				where += " " + filterdatafield + " < '" + filtervalue + "'";
		else if (filtercondition.equals("GREATER_THAN_OR_EQUAL"))
				where += " " + filterdatafield + " >= '" + filtervalue +"'";
		else if (filtercondition.equals("LESS_THAN_OR_EQUAL"))
				where += " " + filterdatafield + " <= '" + filtervalue +"'";
		else if (filtercondition.equals("STARTS_WITH"))
				where += " " + filterdatafield + " LIKE '" + filtervalue +"%'";
		else if (filtercondition.equals("ENDS_WITH"))
				where += " " + filterdatafield + " LIKE '%" + filtervalue +"'";
		
						
		if (i == filterscount - 1)
		{
			where += ")";
		}
		
		
		
		tmpfilteroperator = filteroperator;
		tmpdatafield = filterdatafield;			
	}
	// build the query.
    query="";
	query = "where";
	filterquery = query;

}

String sortdatafield = "";
String sortorder="";

try{
	sortdatafield  = request.getParameter("sortdatafield");
	sortorder = request.getParameter("sortorder");
}
catch(Exception e){}
finally
{
	if (sortdatafield == null) { sortdatafield = "";}
	if (sortorder == null) { sortorder = "";}
}



query="";
//ordenacion de campo
if (!sortdatafield.equals(""))
{

	if (!sortorder.equals(""))
	{
				
		System.out.print("\n\n order==> start:"+start + "  hasta:"+ pagesize);
				if (sortorder.equals("desc"))
				{
					query = " ORDER BY" + " " + sortdatafield + " DESC";
				}
				else if (sortorder.equals("asc"))
				{
					query = "  ORDER BY" + " " + sortdatafield + " ASC";
				}
					
	}
}        

where += query;
System.out.print("\n\n SQL:"+where);
%>