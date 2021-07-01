import java.util.*;
class FindIndex{
	public static int findIndex(int [] array, int element){
		for(int i=0;i<array.length;i++){
			if(array[i]==element)
				return i;
		}
		return -1;
	}
}
class Sum{
	public static int sumValue(int [] array){
		int sum =0;
		for(int i=0;i<array.length;i++){
			sum+=array[i];
		}
		return sum;
	}
}
class RemoveIndex{
	public static int[] removeIndex(int [] array, int index){
		int [] arr = new int [array.length-1];
		int k=0;
		for(int i=0;i<array.length;i++){
			if(i!=index)
				arr[k++]=array[i];
		}
		return arr;
	}
}
class InsertIndex{
	public static int [] insertIndex(int [] array, int element, int index){
		int [] arr = new int [array.length+1];
		int i,k=0;
		for(i=0;i<array.length;i++){
			if(i==index)
				arr[k++]=element;
			arr[k++]=array[i];
		}
		if(i==index)
			arr[k++]=element;
		return arr;
	}
}
class FindMinMax{
	public static int [] findMinMax(int [] array){
		int arr [] = new int [2];
		int min = 0, max =0;
		for(int i=1;i<array.length;i++){
			if(array[i]>array[max])
				max=i;
			if(array[i]<array[min])
				min=i;
		}
		arr[0]=array[min];
		arr[1]=array[max];
		return arr;
	}
}
class CommonElement{
	public static void findCommonElement(int [] a1, int [] a2){
		for(int i=0;i<a1.length;i++){
			for(int j=0;j<a2.length;j++){
				if(a1[i]==a2[j]){
					System.out.print(a1[i]+" ");
				}
			}
		}
		System.out.println();
	}
	public static void findCommonElements(String [] a1, String [] a2){
		for(int i=0;i<a1.length;i++){
			for(int j=0;j<a2.length;j++){
				if(a1[i].equals(a2[j])){
					System.out.print(a1[i]+" ");
				}
			}
		}
		System.out.println();
	}
}
class RemoveDuplicate{
	/*public static int [] removeDuplicates(int [] array){
		int max = array[0];
		for(int i=1;i<array.length;i++){
			max = Math.max(max,array[i]);
		}
		int [] arr = new int [max+1];
		int n=0;
		for(int i=0;i<array.length;i++){
			if(arr[array[i]]!=1)
				n++;
			arr[array[i]]=1;
		}
		int mainArray[] = new int [n];
		int k=0;
		for(int i=0;i<max+1;i++){
			if(arr[i]==1)
				mainArray[k++]=i;
		}
		return mainArray;
	}
	//it will be only suitable for 0 to positive integer -  O(n)
	*/
	//for negative numbers
	public static int [] removeDuplicates(int [] array){
		new Sort().sort(array,0,array.length-1);
		int count=0;
		for(int i=0;i<array.length;i++){
			while(i+1<array.length&&array[i]==array[i+1]){
				i++;
			}
			count++;
		}
		int arr [] = new int [count];
		count=0;
		for(int i=0;i<array.length;i++){
			while(i+1<array.length&&array[i]==array[i+1]){
				i++;
			}
			arr[count++]=array[i];
		}
		return arr;
	}
}
class FindCount{
	public static int [] findEvenAndOdd(int [] array){
		int [] arr = new int [2];
		int even=0,odd=0;
		for(int i=0;i<array.length;i++){
			if(array[i]%2==0)
				even++;
			else
				odd++;
		}
		arr[0]=even;
		arr[1]=odd;
		return arr;
	}
}
class Average{
	public static float findAverage(int []array, int [] arr){
		int min = arr[0];
		int max = arr[1];
		float avg=0;
		int n=0;
		for(int i=0;i<array.length;i++){
			if(array[i]!=min && array[i]!=max){
				avg+=array[i];
			}
			else
				n++;
		}
		return (avg/(array.length-n));
	}
}
class Target{
	public static void findTargetPairs(int [] array, int target){
		new Sort().sort(array,0,array.length-1);
		int i=0,j=array.length-1;
		while(i<j){
			if(array[i]+array[j]==target){
				System.out.println(array[i]+","+array[j]);
				do{i++;}while(array[i]==array[i+1]);
				do{j--;}while(array[j]==array[j+1]);
			}
			else if(array[i]+array[j]>target){
				do{j--;}while(array[j]==array[j+1]);
			}
			else 
				do{i++;}while(array[i]==array[i+1]);
			
		}
	}
}
class ReverseArray{
	public static int [] reverseArray(int [] array){
		int [] arr = new int [array.length];
		int k=0;
		for(int i=array.length-1;i>=0;i--){
			arr[k++]=array[i];
		}
		return arr;
	}
}
class ChangeArray{
	public static int [] changeArray(int [] array, int [] countArray){
		int [] arr = new int [array.length];
		int [] evenArray = new int [countArray[0]];
		int [] oddArray = new int [countArray[1]];
		int evenIndex=0, oddIndex=0;
		for(int i=0;i<array.length;i++){
			if(array[i]%2==0)
				evenArray[evenIndex++]=array[i];
			else
				oddArray[oddIndex++] = array[i];
		}
		int k=0,i=0;
		while(i<evenIndex){
			arr[k++]=evenArray[i++];
		}
		i=0;
		while(i<oddIndex){
			arr[k++]=oddArray[i++];
		}
		return arr;
	}
}
class Sort{
	public void merge(int [] array, int l, int mid, int r){
		int [] a1 = new int [mid-l+1];
		int [] a2 = new int [r-mid];
		for(int i=0;i<mid-l+1;i++)
			a1[i]=array[l+i];
		for(int i=0;i<r-mid;i++){
			a2[i]=array[mid+1+i];
		}
		int k=l,i=0,j=0;
		while(i<a1.length&&j<a2.length){
			if(a1[i]<a2[j])
				array[k++]=a1[i++];
			else
				array[k++]=a2[j++];
		}
		while(i<a1.length)
			array[k++]=a1[i++];
		while(j<a2.length)
			array[k++]=a2[j++];
	}
	public void sort(int [] array, int l, int r){
		if(l>=r)
			return;
		int mid = (l+r)/2;
		sort(array,l,mid);
		sort(array,mid+1,r);
		merge(array,l,mid,r);
	}
}
class Leader{
	public static int [] findLeaders(int [] array){
		int count=1,max=array[array.length-1];
		for(int i=array.length-2;i>=0;i--){
			if(max<array[i]){
				max=array[i];
				count++;
			}
		}
		int [] arr = new int [count];
		count--;
		arr[count--]=array[array.length-1];
		max = array[array.length-1];
		for(int i=array.length-2;i>=0;i--){
			if(max<array[i]){
				max=array[i];
				arr[count--]=array[i];
			}
		}
		return arr;
	}
}
class Task1Runner{
	int size;
	int [] array;
	Scanner sc = new Scanner(System.in);
	public void arrayUtil(){
		System.out.println("Enter size of an array and array");
		size = sc.nextInt();
		array = new int [size];
		for(int i=0;i<size;i++){
			array[i]=sc.nextInt();
		}
	}
	public void printArray(int [] array){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	public void getChoice(){
		try{
			System.out.println("Task 1");
			System.out.println("1. Find Index of an array element");
			System.out.println("2. Sum of all values");
			System.out.println("3. Remove index of an specific element");
			System.out.println("4. Insert an element into specific index");
			System.out.println("5. Test if an array contains a specific value");
			System.out.println("6. Find max and min of an array");
			System.out.println("7. Common element between two arrays");
			System.out.println("8. Remove duplicates in an array");
			System.out.println("9. No. of even and odd integer in an array");
			System.out.println("10. Average value of an array except largest and smallest values");
			System.out.println("11. Find the given sum in an array");
			System.out.println("12. Reverse the array of an integer");
			System.out.println("13. Seperate odd and even integer in an array");
			System.out.println("14. Sort an array");
			System.out.println("15. Print all the leaders in an array");
			System.out.println("16. Exit");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			int val;
			switch(choice){
				case 1:
					arrayUtil();
					if(size>0){
						System.out.println("Enter element to find");
						int element = sc.nextInt();
						val = FindIndex.findIndex(array,element);
						if(val!=-1)
							System.out.println(val);
						else
							System.out.println("Element not found");
					}
					getChoice();
					break;
				case 2:
					arrayUtil();
					if(size>0){
						System.out.println(Sum.sumValue(array));
					}
					getChoice();
					break;
				case 3:
					arrayUtil();
					if(size>0){
						System.out.println("Enter element to find");
						int element = sc.nextInt();
						val = FindIndex.findIndex(array,element);
						if(val!=-1)
						array = RemoveIndex.removeIndex(array,val);
						printArray(array);
					}
					getChoice();
					break;
				case 4:
					arrayUtil();
					if(size>0){
						System.out.println("Enter element and its index");
						int element = sc.nextInt();
						int index = sc.nextInt();
						if(index>-1&&index<array.length+1){
							array = InsertIndex.insertIndex(array,element,index);
							printArray(array);
						}
						else{
							System.out.println("Enter valid index");
						}
					}
					getChoice();
					break;
				case 5:
					arrayUtil();
					if(size>0){
						System.out.println("Enter element to find");
						int element = sc.nextInt();
						val = FindIndex.findIndex(array,element);
						if(val!=-1)
							System.out.println("Element found at index "+val);
						else
							System.out.println("Element not found");
					}
					getChoice();
					break;
				case 6:
					arrayUtil();
					if(size>0){
						int arr [];
						arr =  FindMinMax.findMinMax(array);
						System.out.println("Minimum and Maximum is ");
						printArray(arr);
					}
					getChoice();
					break;
				case 7:
					System.out.println("Enter 1 for int array comparision and 2 for string array comparision");
					int ch = sc.nextInt();
					switch(ch){
						case 1:
							System.out.println("Enter array 1 size and its elements");
							int s1=sc.nextInt();
							int [] a1 = new int [s1];
							for(int i=0;i<s1;i++)
								a1[i]=sc.nextInt();
							System.out.println("Enter array 2 size and its elements");
							int s2=sc.nextInt();
							int [] a2 = new int [s2];
							for(int i=0;i<s2;i++)
								a2[i]=sc.nextInt();
							CommonElement.findCommonElement(a1,a2);
							break;
						case 2:
							System.out.println("Enter array 1 size and its elements");
							int s3=sc.nextInt();
							String [] a3 = new String [s3];
							for(int i=0;i<s3;i++)
								a3[i]=sc.next();
							System.out.println("Enter array 2 size and its elements");
							int s4=sc.nextInt();
							String [] a4 = new String [s4];
							for(int i=0;i<s4;i++)
								a4[i]=sc.next();
							CommonElement.findCommonElements(a3,a4);
							break;
						default :
							System.out.println("Enter valid choice");
					}
					getChoice();
					break;
				case 8:
					arrayUtil();
					if(size>0){
						int arr [];
						arr = RemoveDuplicate.removeDuplicates(array);
						printArray(arr);
					}
					getChoice();
					break;
				case 9:
					arrayUtil();
					if(size>0){
						int arr[];
						arr = FindCount.findEvenAndOdd(array);
						System.out.println("Even count and Odd count is");
						printArray(arr);
					}
					getChoice();
					break;
				case 10:
					arrayUtil();
					if(size>0){
						int arr[];
						arr = FindMinMax.findMinMax(array);
						float avg = Average.findAverage(array,arr);
						System.out.println(avg);
					}
					getChoice();
					break;
				case 11:
					arrayUtil();
					if(size>0){
						System.out.println("Enter target value");
						int target = sc.nextInt();
						Target.findTargetPairs(array,target);
					}
					getChoice();
					break;
				case 12:
					arrayUtil();
					if(size>0){
						int arr[];
						arr = ReverseArray.reverseArray(array);
						printArray(arr);
					}
					getChoice();
					break;
				case 13:
					arrayUtil();
					if(size>0){
						int countArray[], arr[];
						countArray = FindCount.findEvenAndOdd(array);
						arr = ChangeArray.changeArray(array,countArray);
						printArray(arr);
					}
					getChoice();
					break;
				case 14:
					arrayUtil();
					if(size>0){
						new Sort().sort(array,0,array.length-1);
						printArray(array);
					}
					getChoice();
					break;
				case 15:
					arrayUtil();
					if(size>0){
						int []arr;
						arr = Leader.findLeaders(array);
						printArray(arr);
					}
					getChoice();
					break;
				case 16:
					break;
				default:
					System.out.println("Enter appropriate choice");
					getChoice();
					break;
			}
		}
		catch(Exception e){
			System.out.println("Enter appropriate value");
		}
		finally{
			sc.close();
		}
	}
	public static void main(String [] args){
		new Task1Runner().getChoice();
	}
}