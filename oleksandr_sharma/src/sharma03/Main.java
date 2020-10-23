//package sharma03;

import java.util.Arrays;
import java.util.Scanner;
// задача (25-1)%15-1 = 2 
/* Ввести декілька рядків. Упорядкувати, а потім вивести рядки за алфавітом (перший пріоритет) та в порядку зростання їх довжини (другий пріоритет).
*/
public class Main {

	public static void main(String arg[]) {
		String[] arr = new String[5];
		Scanner temp = new Scanner(System.in);
		
		System.out.println("Enter a couple of strings(5)");
		for(int i = 0; i < 5; i++) {
			arr[i] = temp.nextLine();
		}
		temp.close();
		sort_by_alphabet(arr);
		
		System.out.println("Sorted array is:");
		for(int i = 0; i < 5; i++) {
			System.out.println(i + "." + arr[i]);
		}
		sort_by_length(arr);
		
		System.out.println("");
		
		System.out.println("Sorted array is:");
		for(int i = 0; i < 5; i++) {
			System.out.println(i + "." + arr[i]);
		}
		
	}
	public static void sort_by_alphabet(String[] array ) {
		Arrays.sort(array);
	}
	
	public static void sort_by_length(String[] array) {
		String temp = new String();
		
		int i, j, nMin;
		  for( i=0; i < array.length; i++)
		  { nMin=i;
		    temp=array[i];
		    for( j=i+1; j < array.length; j++)	// öèêë âûáîðà íàèìåíüøåãî ýëåìåíòà
		      if (array[j].length() < temp.length())
		      {	 nMin=j;			// èíäåêñ íàèìåíüøåãî ýëåìåíòà
			     temp=array[j];			//  çíà÷åíèå íàèìåíüøåãî ýëåìåíòà
		      }
		    array[nMin] = array[i];
		    array[i] = temp;			// ìåíÿåì ìåñòàìè íàèìåíüøèé ñ a[i]
		  }
		  temp = null;
	}
	
	
}
