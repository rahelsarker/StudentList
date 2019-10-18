import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList
{
	public static void main(String[] args)
	{
//		Check arguments for length
		if(args.length != 1)
		{
			System.out.println("Usage: java StudentList [Arguments] \n a - All Students\n r - Random Students\n c - Count Students \n + Adds New");
			return;
		}
//		Check arguments
		if(args[0].equals("a"))
		{
			System.out.println("Loading data ...");			
			try
			{
				BufferedReader fileStream = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String readFileContents = fileStream.readLine();
				String fileContent[] = readFileContents.split(",");
				for(String content : fileContent)
				{
					System.out.println(content);
				}
			}
			catch (Exception error)
			{

			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) 
		{
			System.out.println("Loading data ...");			
			try
			{
				BufferedReader fileStream = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String readFileContents = fileStream.readLine();
				// System.out.println(r);
				String fileContent[] = readFileContents.split(",");
				Random randomValue = new Random();
					int randomInteger = randomValue.nextInt(5);
						System.out.println(fileContent[randomInteger]);
			}
			catch (Exception error)
			{

			}
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+"))
		{
			System.out.println("Loading data ...");			
			try
			{
				BufferedWriter fileStream = new BufferedWriter(
						new FileWriter("students.txt", true));
				String addData = args[0].substring(1);
				Date dateValue = new Date();
				String df = "dd/mm/yyyy-hh:mm:ss a";
				DateFormat dateFormatValue = new SimpleDateFormat(df);
				String formatedDateValue= dateFormatValue.format(dateValue);
				fileStream.write(", "+addData+"\nList last updated on "+formatedDateValue);
				fileStream.close();
			}
			catch (Exception error)
			{

			}
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) 
		{
			System.out.println("Loading data ...");			
			try
			{
				BufferedReader fileStream = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String readFileContents = fileStream.readLine();
				String fileContent[] = readFileContents.split(",");
				boolean done = false;
				String searchData = args[0].substring(1);
				for(int idx = 0; idx<fileContent.length && !done; idx++)
				{
					if(fileContent[idx].equals(searchData))
					{
						System.out.println("We found it!");
							done=true;
					}
				}
			}
			catch (Exception error)
			{

			}
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) 
		{
			System.out.println("Loading data ...");			
			try
			{
				BufferedReader fileStream = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String countString = fileStream.readLine();
				char countValue[] = countString.toCharArray();
				boolean in_word = false;
				int count=0;
				for(char currentCount:countValue)
				{
					if(currentCount ==' ')
					{
						if (!in_word) {	count++; in_word =true;	}
						else { in_word=false;}
					}
				}
				System.out.println(count +" word(s) found " + countValue.length);
			}
			catch (Exception error)
			{

			}
			System.out.println("Data Loaded.");				
		}
	}
}