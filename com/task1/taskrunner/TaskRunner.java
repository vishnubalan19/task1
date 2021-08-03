package com.task1.taskrunner;

import java.util.Scanner;

class TaskRunner{
    int size;
    int [] array;
    Scanner scanner = new Scanner(System.in);
    public void arrayUtil(){
        System.out.println("Enter size of an array and array");
        size = scanner.nextInt();
        array = new int [size];
        for(int i=0;i<size;i++){
            array[i]=scanner.nextInt();
        }
    }
    public void printArray(int [] array){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
    public static int findIndex(int [] array, int element){
        for(int i=0;i<array.length;i++){
            if(array[i]==element)
                return i;
        }
        return -1;
    }

    public static int sumValue(int [] array){
        int sum =0;
        for(int i=0;i<array.length;i++){
            sum+=array[i];
        }
        return sum;
    }


    public static int[] removeIndex(int [] array, int index){
        int [] arr = new int [array.length-1];
        int k=0;
        for(int i=0;i<array.length;i++){
            if(i!=index)
                arr[k++]=array[i];
        }
        return arr;
    }

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


    public static void findCommonElement(int [] array1, int [] array2){
        for(int i=0;i<array1.length;i++){
            for(int j=0;j<array2.length;j++){
                if(array1[i]==array2[j]){
                    System.out.print(array1[i]+" ");
                }
            }
        }
        System.out.println();
    }
    public static void findCommonElements(String [] array1, String [] array2){
        for(int i=0;i<array1.length;i++){
            for(int j=0;j<array2.length;j++){
                if(array1[i].equals(array2[j])){
                    System.out.print(array1[i]+" ");
                }
            }
        }
        System.out.println();
    }


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
        new TaskRunner().sort(array,0,array.length-1);
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


    public static float findAverage(int []array, int [] arr){
        int min = arr[0];
        int max = arr[1];
        float avg=0;
        int count=0;
        for(int i=0;i<array.length;i++){
            if(array[i]!=min && array[i]!=max){
                avg+=array[i];
            }
            else
                count++;
        }
        return (avg/(array.length-count));
    }


    public static void findTargetPairs(int [] array, int target){
        new TaskRunner().sort(array,0,array.length-1);
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


    public static int [] reverseArray(int [] array){
        int [] arr = new int [array.length];
        int k=0;
        for(int i=array.length-1;i>=0;i--){
            arr[k++]=array[i];
        }
        return arr;
    }

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


    public void merge(int [] array, int left, int mid, int right){
        int [] array1 = new int [mid-left+1];
        int [] array2 = new int [right-mid];
        for(int i=0;i<mid-left+1;i++)
            array1[i]=array[left+i];
        for(int i=0;i<right-mid;i++){
            array2[i]=array[mid+1+i];
        }
        int k=left,i=0,j=0;
        while(i<array1.length&&j<array2.length){
            if(array1[i]<array2[j])
                array[k++]=array1[i++];
            else
                array[k++]=array2[j++];
        }
        while(i<array1.length)
            array[k++]=array1[i++];
        while(j<array2.length)
            array[k++]=array2[j++];
    }
    public void sort(int [] array, int left, int right){
        if(left>=right)
            return;
        int mid = (left+right)/2;
        sort(array,left,mid);
        sort(array,mid+1,right);
        merge(array,left,mid,right);
    }


    public static int [] findLeaders(int [] array) {
        int count = 1, max = array[array.length - 1];
        for (int i = array.length - 2; i >= 0; i--) {
            if (max < array[i]) {
                max = array[i];
                count++;
            }
        }
        int[] arr = new int[count];
        count--;
        arr[count--] = array[array.length - 1];
        max = array[array.length - 1];
        for (int i = array.length - 2; i >= 0; i--) {
            if (max < array[i]) {
                max = array[i];
                arr[count--] = array[i];
            }
        }
        return arr;
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
            System.out.println("13. Separate odd and even integer in an array");
            System.out.println("14. Sort an array");
            System.out.println("15. Print all the leaders in an array");
            System.out.println("16. Exit");
            System.out.println("Enter your choice");
            int choice = scanner.nextInt();
            int val;
            switch(choice){
                case 1:
                    arrayUtil();
                    if(size>0){
                        System.out.println("Enter element to find");
                        int element = scanner.nextInt();
                        val = TaskRunner.findIndex(array,element);
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
                        System.out.println(TaskRunner.sumValue(array));
                    }
                    getChoice();
                    break;
                case 3:
                    arrayUtil();
                    if(size>0){
                        System.out.println("Enter element to find");
                        int element = scanner.nextInt();
                        val = TaskRunner.findIndex(array,element);
                        if(val!=-1)
                            array = TaskRunner.removeIndex(array,val);
                        printArray(array);
                    }
                    getChoice();
                    break;
                case 4:
                    arrayUtil();
                    if(size>0){
                        System.out.println("Enter element and its index");
                        int element = scanner.nextInt();
                        int index = scanner.nextInt();
                        if(index>-1&&index<array.length+1){
                            array = TaskRunner.insertIndex(array,element,index);
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
                        int element = scanner.nextInt();
                        val = TaskRunner.findIndex(array,element);
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
                        arr =  TaskRunner.findMinMax(array);
                        System.out.println("Minimum and Maximum is ");
                        printArray(arr);
                    }
                    getChoice();
                    break;
                case 7:
                    System.out.println("Enter 1 for int array comparision and 2 for string array comparision");
                    int innerChoice = scanner.nextInt();
                    switch(innerChoice){
                        case 1:
                            System.out.println("Enter array 1 size and its elements");
                            int size1=scanner.nextInt();
                            int [] array1 = new int [size1];
                            for(int i=0;i<size1;i++)
                                array1[i]=scanner.nextInt();
                            System.out.println("Enter array 2 size and its elements");
                            int size2=scanner.nextInt();
                            int [] array2 = new int [size2];
                            for(int i=0;i<size2;i++)
                                array2[i]=scanner.nextInt();
                            TaskRunner.findCommonElement(array1,array2);
                            break;
                        case 2:
                            System.out.println("Enter array 1 size and its elements");
                            int size3=scanner.nextInt();
                            String [] array3 = new String [size3];
                            for(int i=0;i<size3;i++)
                                array3[i]=scanner.next();
                            System.out.println("Enter array 2 size and its elements");
                            int size4=scanner.nextInt();
                            String [] array4 = new String [size4];
                            for(int i=0;i<size4;i++)
                                array4[i]=scanner.next();
                            TaskRunner.findCommonElements(array3,array4);
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
                        arr = TaskRunner.removeDuplicates(array);
                        printArray(arr);
                    }
                    getChoice();
                    break;
                case 9:
                    arrayUtil();
                    if(size>0){
                        int arr[];
                        arr = TaskRunner.findEvenAndOdd(array);
                        System.out.println("Even count and Odd count is");
                        printArray(arr);
                    }
                    getChoice();
                    break;
                case 10:
                    arrayUtil();
                    if(size>0){
                        int arr[];
                        arr = TaskRunner.findMinMax(array);
                        float avg = TaskRunner.findAverage(array,arr);
                        System.out.println(avg);
                    }
                    getChoice();
                    break;
                case 11:
                    arrayUtil();
                    if(size>0){
                        System.out.println("Enter target value");
                        int target = scanner.nextInt();
                        TaskRunner.findTargetPairs(array,target);
                    }
                    getChoice();
                    break;
                case 12:
                    arrayUtil();
                    if(size>0){
                        int arr[];
                        arr = TaskRunner.reverseArray(array);
                        printArray(arr);
                    }
                    getChoice();
                    break;
                case 13:
                    arrayUtil();
                    if(size>0){
                        int countArray[], arr[];
                        countArray = TaskRunner.findEvenAndOdd(array);
                        arr = TaskRunner.changeArray(array,countArray);
                        printArray(arr);
                    }
                    getChoice();
                    break;
                case 14:
                    arrayUtil();
                    if(size>0){
                        new TaskRunner().sort(array,0,array.length-1);
                        printArray(array);
                    }
                    getChoice();
                    break;
                case 15:
                    arrayUtil();
                    if(size>0){
                        int []arr;
                        arr = TaskRunner.findLeaders(array);
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
            scanner.close();
        }
    }
    public static void main(String [] args){
        new TaskRunner().getChoice();
    }
}
