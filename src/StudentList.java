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
//		Check arguments
		if(args[0].equals(Constants.SHOWALL))
		{
			for(String content : fileContent)
			{
				System.out.println(content);
			}
		}
		else if(args[0].equals(Constants.SHOWRND))
		{
			Random randomValue = new Random();
			int randomInteger = randomValue.nextInt(fileContent.length);
			System.out.println(fileContent[randomInteger]);

		}
		else if(args[0].contains(Constants.ADDTOFILE))
		{
			writeTofile(Constants.DATAFILENAME, args[0].substring(1));
		}
		else if(args[0].contains(Constants.SEARCHFILE))
		{
			boolean done = false;
			String searchData = args[0].substring(1);

			for(int idx = 0; idx<fileContent.length && !done; idx++)
			{
				String compareData = fileContent[idx];
				if(compareData.equals(searchData))
				{
					System.out.println(Constants.MSGSEARCH);
					done=true;
				}
			}

		}
		else if(args[0].contains(Constants.COUNTFILE))
		{
			//String countString = fileStream.readLine();
			char countValue[] = readFileContents.toCharArray();
			boolean in_word = false;
			int count=0;
			for(char currentCount:countValue)
			{
				if(currentCount ==' ')
				{
					if (!in_word)
					{
						count++; in_word = true;
					}
					else { in_word=false;}
				}
			}
			System.out.println(count + Constants.MSGSEARCHRESULT + countValue.length);
		}
	}

	public static String readFromFile(String fileName)
	{
		System.out.println(Constants.MSGLOADSTART);
		String fileData = null;
		try {
			BufferedReader fileReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(fileName)));
			fileData = fileReader.readLine();
		} catch (Exception e)
		{

		}

		System.out.println(Constants.MSGLOADEND);
		return fileData;
	}
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