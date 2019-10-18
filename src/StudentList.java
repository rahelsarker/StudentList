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
//		Read From File
		String readFileContents = readFromFile("students.txt");
		String fileContent[] = readFileContents.split(",");
//		Check arguments
		if(args[0].equals("a"))
		{
			for(String content : fileContent)
			{
				System.out.println(content);
			}
		}
		else if(args[0].equals("r")) 
		{
			Random randomValue = new Random();
			int randomInteger = randomValue.nextInt(5);
			System.out.println(fileContent[randomInteger]);

		}
		else if(args[0].contains("+"))
		{
			writeTofile("students.txt", args[0].substring(1));
		}
		else if(args[0].contains("?")) 
		{
			boolean done = false;
			String searchData = args[0].substring(1);

			for(int idx = 0; idx<fileContent.length && !done; idx++)
			{
				String compareData = fileContent[idx].trim();
				if(compareData.equals(searchData))
				{
					System.out.println("We found it!");
					done=true;
				}
			}

		}
		else if(args[0].contains("c")) 
		{
			//String countString = fileStream.readLine();
			char countValue[] = readFileContents.toCharArray();
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
	}

	public static String readFromFile(String fileName)
	{
		System.out.println("Loading data ...");
		String fileData = null;
		try {
			BufferedReader fileReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(fileName)));
			fileData = fileReader.readLine();
		} catch (Exception e)
		{

		}

		System.out.println("Data Loaded.");
		return fileData;
	}
	public static void writeTofile(String fileName, String newStudent)
	{
		System.out.println("Loading data ...");
		try
		{
			BufferedWriter fileStream = new BufferedWriter(
					new FileWriter("students.txt", true));
			String addData = newStudent;
			Date dateValue = new Date();
			String df = "dd/mm/yyyy-hh:mm:ss a";
			DateFormat dateFormatValue = new SimpleDateFormat(df);
			String formatedDateValue= dateFormatValue.format(dateValue);
			//fileStream.write(", "+addData+"\nList last updated on "+formatedDateValue);
			fileStream.write(", "+addData);
			fileStream.close();
		}
		catch (Exception error)
		{

		}
		System.out.println("Data Loaded.");
		return;
	}
}