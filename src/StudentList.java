import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList
{
	public static void main(String[] args)
	{
//		Check arguments for length
		if(args.length != Constants.MINARGLN)
		{
			System.out.println(Constants.MSGHELP);
			return;
		}
//		Read From File
		String readFileContents = readFromFile(Constants.DATAFILENAME);
		String fileContent[] = readFileContents.split(Constants.DATASEPERATOR);
//		Show all records operation
		if(args[0].equals(Constants.SHOWALL))
		{
			for(String content : fileContent)
			{
				System.out.println(content);
			}
		}
//		Thea random select operation
		else if(args[0].equals(Constants.SHOWRND))
		{
			Random randomValue = new Random();
			int randomInteger = randomValue.nextInt(fileContent.length);
			System.out.println(fileContent[randomInteger]);

		}
//		The add operation
		else if(args[0].contains(Constants.ADDTOFILE))
		{
			writeTofile(Constants.DATAFILENAME, args[0].substring(1));
		}
//		The search operation
		else if(args[0].contains(Constants.SEARCHFILE))
		{
			boolean searchedItemFound = false;
			String searchData = args[0].substring(1);
			for(String searchElement : fileContent)
			{
				if(searchElement.trim().equals(searchData))
				{
					System.out.println(Constants.MSGSEARCH);
					searchedItemFound=true;
					break;
				}
			}

		}
//		The count operation
		else if(args[0].contains(Constants.COUNTFILE))
		{
			char countValue[] = readFileContents.toCharArray();
			boolean presentInWords = false;
			int countCharacters=0;
			for(char currentCount:countValue)
			{
				if(currentCount ==' ')
				{
					if (!presentInWords)
					{
						countCharacters++; presentInWords = true;
					}
					else { presentInWords=false;}
				}
			}
			System.out.println(countCharacters + Constants.MSGSEARCHRESULT + countValue.length);
		}
//		Case for invalid arguments
		else
		{
			System.out.println(Constants.MSGHELP);
			return;
		}
	}
//	Read file method
	public static String readFromFile(String fileName)
	{
		System.out.println(Constants.MSGLOADSTART);
		String fileData = null;
		try {
			BufferedReader fileReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(fileName)));
			fileData = fileReader.readLine();
		} catch (Exception error)
		{

		}
		System.out.println(Constants.MSGLOADEND);
		return fileData;
	}
//	Write file method
	public static void writeTofile(String fileName, String newStudent)
	{
		System.out.println(Constants.MSGLOADSTART);
		try
		{
			BufferedWriter fileStream = new BufferedWriter(
					new FileWriter(fileName, true));
			String addData = newStudent;
			Date dateValue = new Date();
			String df = Constants.DATEFORMAT;
			DateFormat dateFormatValue = new SimpleDateFormat(df);
			String formatedDateValue= dateFormatValue.format(dateValue);
			fileStream.write(Constants.DATASEPERATOR+addData);
			fileStream.close();
		}
		catch (Exception error)
		{

		}
		System.out.println(Constants.MSGLOADEND);
		return;
	}
}