

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Read_File extends ReadSkipExpression{

	public static void main(String args[]) throws IOException {

		String fileName = "C://Naresh//Selenium_Automation_Workspace//Test_Data_processing//Get_Party.txt";
        Map<String, String> main_excp_listr = new HashMap<String, String>();
        main_excp_listr.put("<DWLControl>", "</DWLControl>");
        List<String> Partial_Match = new ArrayList<String> ();
        ReadSkipExpression t = new ReadSkipExpression();
        
        Partial_Match = t.Skip_Element();
        
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String line;
			String key_value = "";
			int main_by_pass = 0;
			int sub_string_by_pass = 0;
			
			while ((line = br.readLine()) != null) {
				line = line.replaceAll("\t", "");
				sub_string_by_pass = 0;
				for(String str : Partial_Match)
	   		    {
	        	//  System.out.println("The score list"+ line.indexOf(str));
	        	  
	   			   if (line.indexOf(str) >= 0)
	   			   {
	   				//System.out.println("match true"+ line.indexOf(str));
	   				sub_string_by_pass = 1;
	   				  break;
	   						   
	   			   }
	   			
	   		    } 
				
				/*System.out.println("Current line"+ line);
				if (main_excp_listr.containsKey(line))
				{
					key_value = main_excp_listr.get(line).toString();
					//System.out.println("key value"+ key_value);
					main_by_pass = 1;
				}
				if ((main_by_pass == 1) && (line.contains(key_value)))
					{
					  main_by_pass = 0;
					  key_value = "";
					  
					}
					*/
				if ((main_by_pass == 0) &&  sub_string_by_pass == 0)
				{
					System.out.println(line);
				}
		
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}



}