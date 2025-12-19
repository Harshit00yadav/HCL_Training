package assignment1.Q2;

import java.util.function.Function;
import java.util.Scanner;
import java.util.ArrayList;

public class Menu{
	private String options[] = {"Insert", "Delete", "Append", "Find", "Sort", "EXIT"};
	private String optFind[] = {"Max", "Liner Search", "Binary Search", "BACK"};
	private String optSort[] = {"Insertion Sort", "BACK"};
	private String marr[];
	private ArrayList<Integer> array = new ArrayList<>();
	private String log = "status: ";
	private Scanner sc;

	public Menu(){
		this.sc = new Scanner(System.in);
		this.marr = this.options;
		this.array.add(7);
		this.array.add(4);
		this.array.add(9);
	}

	public void display(){
		System.out.println("\033[2K"+log);
		this.printarr();
		int i=1;
		for (String item: this.marr){
			System.out.printf("\t%d: %s\n", i++, item);
		}
	}
	
	public boolean choose(int n){
		n--;
		boolean rval = false;
		int oldlen = marr.length;
		try{
			switch(marr[n]){
				case "Insert":
					this.log = "action: Insert";
					this.insertFunc();
					break;
				case "Delete":
					this.log = "action: Delete";
					this.deleteFunc();
					break;
				case "Append":
					this.log = "action: Append";
					this.appendFunc();
					break;
				case "Find":
					this.log = "action: Find";
					this.marr = this.optFind;
					break;
				case "Max":
					this.log = "Max: " + this.fmax();
					break;
				case "Liner Search":
					this.linearSearch();
					break;
				case "Binary Search":
					this.binarySearch();
					break;
				case "Sort":
					this.log = "action: Sort";
					this.marr = this.optSort;
					break;
				case "Insertion Sort":
					this.insertionSort();
					break;
				case "BACK":
					this.log = "status:";
					this.marr = this.options;
					break;
				case "EXIT":
					rval = true;
					break;
				default:
					this.log = "error: Invalid Input!";
			}
		} catch (Exception e){
				this.log = "status: "+e;
		}
		this.clearUp(5+oldlen);
		return rval;
	}

	private void insertionSort(){
		int n = array.size();
		for (int i=1; i<n; i++){
			int key = array.get(i);
			int j = i-1;
			while (j >= 0 && array.get(j) > key){
				array.set(j+1, array.get(j));
				j--;
			}
			array.set(j+1, key);
		}
		this.log = "status: sorted!";
	}

	private void binarySearch(){
		int val;
		System.out.print("Value: ");
		val = this.sc.nextInt();
		boolean found = false;
		int head = 0;
		int tail = array.size() - 1;
		int mid=0;
		long start = System.nanoTime();
		while (head <= tail)
		{
			mid = head + (tail - head) / 2;
			if (array.get(mid) == val){
				found = true;
				break;
			} else if (array.get(mid) > val){
				tail = mid - 1;
			} else {
				head = mid + 1;
			}
		}
		long end = System.nanoTime();
		this.log = "find: @"+((found)?mid:"NotFound") + " in " +((double)(end-start)/1_000_000)+ "milisec";
		clearUp(1);
	}

	private void linearSearch(){
		int val;
		System.out.print("Value: ");
		val = this.sc.nextInt();
		int i=0;
		boolean found = false;
		long start = System.nanoTime();
		for (int e: array){
			if (val == e){
				found = true;
				break;
			}
			i++;
		}
		long end = System.nanoTime();
		this.log = "find: @"+((found)?i:"NotFound") + " in " +((double)(end-start)/1_000_000)+ "milisec";
		clearUp(1);
	}
	
	private int fmax(){
		int max = array.get(0);
		for (int e:array){
			if (max < e){
				max = e;
			}
		}
		return max;
	}

	private void insertFunc(){
		int indx__, val;
		System.out.print("Index: ");
		indx__ = this.sc.nextInt();
		System.out.print("Value: ");
		val = this.sc.nextInt();
		this.array.add(indx__, val);
		clearUp(2);
	}

	private void deleteFunc(){
		int indx__;
		System.out.print("Index: ");
		indx__ = this.sc.nextInt();
		this.array.remove(indx__);
		clearUp(1);
	}

	private void appendFunc(){
		int val;
		System.out.print("Value: ");
		val = this.sc.nextInt();
		this.array.add(val);
		clearUp(1);
	}

	private void clearUp(int n){
		for (int i=0; i<n; i++){
			System.out.printf("\r\033[2K\033[A");
		}
	}

	private void printarr(){
		System.out.print("┌"+"─┬".repeat(array.size()-1)+"─┐\n│");
		for (int i:array){
			System.out.printf("%d│", i);
		}
		System.out.print("\n└" + "─┴".repeat(array.size()-1)+"─┘\n");
	}
}
