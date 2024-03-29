//package sharma13_14;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {
	static List<Agency> agencies = new List<Agency>();
    @SuppressWarnings("unchecked")
	public static void lets_go(int flag) throws ClassNotFoundException, IOException {
    	
    	System.setProperty("console.encoding","Cp866");
    	int choice = 0;
		Scanner temp = new Scanner(System.in);
		do {
			Helper.print_main_menu();
			choice = temp.nextInt();
			switch(choice) {
			case 1:
				if(flag > 0) {
					get_data(agencies);
				}
				else {
					int listSize = 0;
					try (BufferedReader in = new BufferedReader(new FileReader("/home/alexsharma/Документи/LABS_JAVA_OOP/oop-khpi/oleksandr_sharma/src/sharma13-14/notes3.txt")))
				    {
					 listSize = in.read();
				    }
				 catch(Exception FileNotFoundException) {
					 
				 };
				agencies = Serialization.LongTermPersistenceRead(listSize,flag);
				}
				break;
			case 2:
				if(agencies.getSize() == 0) {System.out.println("Enter data first"); break;} 
				Helper.showAgencies(agencies);
				break;
			case 3:
				if(agencies.getSize() == 0) {System.out.println("Enter data first"); break;} 
				agencies.remove(agencies.getTail().getData());
				break;
			case 4:
				if(agencies.getSize() == 0) {System.out.println("Enter data first"); break;}
				 Serialization.LongTermPersistenceWrite(agencies, agencies.getSize());
				break;
			case 5:
				int listSize = 0;
				 try (BufferedReader in = new BufferedReader(new FileReader(directory())))
				    {
					 listSize = in.read();
				    }
				 catch(Exception FileNotFoundException) {
					 
				 };
				agencies = Serialization.LongTermPersistenceRead(listSize, flag);
				break;
			case 6:
				System.out.println(agencies.toString(agencies));
			case 7:
				Agency[] tempp = new Agency[agencies.getSize()];
				tempp = agencies.toArray();
				for(int i = 0; i < tempp.length; i++) {
					System.out.println(tempp[i].getFirmName());
				}
			case 8:
				agencies.sortList();
			case 9:
				matchByCondition(agencies);
			case 10:
				ThreadHelper.starter_accountGenerator();
			case 11:
				ThreadHelper.start_all_threads();
			case 12:
				long i = ThreadHelper.comparison_parallel();
				long j = ThreadHelper.comparison_sequential();

				System.out.println("------------------------------------------------");
				System.out.println("Time of the parallel execution   | " + i + " ms");
				System.out.println("------------------------------------------------");
				System.out.println("Time of the sequential execution | " + j + " ms");
				System.out.println("------------------------------------------------");
				break;
			default:
				break;
			}
		}while(choice!=13);
    }
    
    public static void print_main_menu(){
		System.out.println("1.Enter data");
		System.out.println("2.Show current data");
        System.out.println("3.Remove tail");
		System.out.println("4.Save data");
        System.out.println("5.Recover data");
        System.out.println("6.To string");
        System.out.println("7.To Array");
        System.out.println("8.Sort list");
        System.out.println("9.Match search");
        System.out.println("10.Generate data");
        System.out.println("11.Thread count");
        System.out.println("12.Parallel and sequental comparsion");
	}
	public static void showAgencies(List<Agency> agencies) {
		for(Agency temp : agencies) {
			temp.print();
		}
	}

	public static String enterFirmName() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Назвиние фирмы : ");
		String firmName = sc.nextLine();
		if(validateText(firmName) == true)
		{ 
			return firmName;
		}
		else {
			System.out.println("Try again");
			enterFirmName();
		}
		return "";
	}
	public static String enterPosition() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Должность: ");
		String position = sc.nextLine();
		if(validateText(position) == true)
		{ 
			return position;
		}
		else {
			System.out.println("Try again");
			enterPosition();
		}
		return "";
	}
	public static String enterCircs() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Условия работы : ");
		String circs = sc.nextLine();
		if(validateText(circs) == true)
		{ 
			return circs;
		}
		else {
			System.out.println("Try again");
			enterCircs();
		}
		return "";
	}
	
	public static int enterSalary() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Зарплата : ");
		Integer salary = sc.nextInt();
		if(validateInt(salary.toString()) == true)
		{ 
			return salary;
		}
		else {
			System.out.println("Try again");
			enterSalary();
		}
		return 0;
	}
	
	public static boolean enterKey() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Есть ли какие-то дополнительные требования?");
		boolean choice = sc.nextBoolean();
		return choice;
	}
	
	public static int enterExperience() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Опыт работы : ");
		Integer exp = sc.nextInt();
		if(validateInt(exp.toString()) == true)
		{ 
			return exp;
		}
		else {
			System.out.println("Try again");
			enterExperience();
		}
		return 0;
	}
	public static String enterEducation() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Введите образование : ");
		String educ = sc.nextLine();
		if(validateText(educ) == true)
		{ 
			return educ;
		}
		else {
			System.out.println("Try again");
			enterEducation();
		}
		return "";
	}
	
	public static void get_data(List<Agency> list) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int size = sc.nextInt();
		Agency tempp = new Agency();
		for (int i = 0; i < size; i++) {
			tempp = new Agency();
			System.out.println((i+1));
			tempp.setFirmName(enterFirmName());
			tempp.setPosition(enterPosition());
			tempp.setCircs(enterCircs());
			tempp.setSalary(enterSalary());
			tempp.setKey(enterKey());
			if(tempp.getKey() == true) tempp.isNeedRequierments(enterExperience(), enterEducation());
			list.add(tempp);
			tempp = null;
		}
	}
static String directory() {
		int index_const = 3, index2, index3, choice;
		String fileName = writeFileName();
		File file = new File(fileName);
		File file2 = new File(file.getAbsolutePath());
		String currPos = file2.getParent();
		while(true) {
			index2 = 0;
			index3 = 0;
			File currFolder = new File(currPos);
			File[] folders = currFolder.listFiles();
			int[] indexes = new int[folders.length];

			System.out.printf("%-30s","1) .");
			System.out.printf("%-30s","2) ..");
			for(int i = 0; i < folders.length; i++) {
				if(folders[i].isDirectory() && !folders[i].isHidden())   {
					indexes[index2] = i;
					if(index2%4 == 3) System.out.printf("%-30s", (index_const + index3++) + ") " + folders[i].getName());
					else if(index2%4 == 2) System.out.printf("%-30s", (index_const + index3++) + ") " + folders[i].getName());
					else if(index2%4 == 1) System.out.printf("%-30s\n", (index_const + index3++) + ") " + folders[i].getName());
					else System.out.printf("%-30s", (index_const + index3++) + ") " + folders[i].getName());
					index2++;
				}
			}
			Scanner sc = new Scanner(System.in);
			System.out.print("\n" + currPos + "> ");
			choice = sc.nextInt();
			if(choice == 1) 
				break;
			else if(choice == 2 && currFolder.getParent() != null) {
				currPos = currFolder.getParent();
			}
			else if((choice-index_const) < index2 && (choice-index_const) >= 0) {
				currPos = folders[indexes[choice-index_const]].getAbsolutePath();
			}
			else {
				System.out.println("Try again.");
			}
		}
		
		return currPos + "\\" + fileName;
	}
	private static String writeFileName() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter file name: ");
		String fileName = sc.nextLine();
		return fileName;
	}
	
	private static boolean validateText(String text) {
		Pattern p = Pattern.compile("^[a-zA-Z]{1,}");
		Matcher m = p.matcher(text);
		return m.matches();
	}
	private static boolean validateInt(String text ) {
		Pattern p = Pattern.compile("^[0-9]{1,}");
		Matcher m = p.matcher(text);
		return m.matches();
	}
	
	private static void matchByCondition(List<Agency> agencies) {
		Pattern p = Pattern.compile("^[0]{0,}[1-9]{2,}");
		for (Agency a : agencies) {
			Matcher m = null;
			if(a.getKey()) {m = p.matcher(a.getReqs().getYexp().toString());}
			else { return;}
			if(m.matches() == true) {
				Pattern n = Pattern.compile("^(teacher|trainer)");
				m = n.matcher(a.getPosition());
				if(m.matches() == true) {
					Pattern z = Pattern.compile(".*(English skills | English | Knowledge of English | level of English)\\w*");
					m = z.matcher(a.getReqs().getEducation());
					a.print();
				}
				
			}
		}
	}
	
	public static int numberEnterer(int size) {
		String input = "";
		int userChoice;
		Scanner userInput = new Scanner(System.in);
		while (true) {
			input = userInput.nextLine();
			try {
				userChoice = Integer.parseInt(input);
				if(userChoice >= 0 && userChoice < size) 
					break;
			} catch (Exception e){
				System.out.println("");
			}
		}
		return userChoice;
	}
	
	
}
