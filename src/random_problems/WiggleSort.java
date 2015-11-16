package random_problems;

import java.util.ArrayList;
import java.util.Arrays;

public class WiggleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int a[]={5,2,7,8,-2,25,25};
		int a[]={2,3,5,11,14,15,9};
		sort5(a);


	}

	
	
	/**
	 * Best soluiont O(n) and inplace 
	 * @param arr
	 */
	void zigZag(int arr[])
	{
		int n= arr.length;
		// Flag true indicates relation ">" is expected,
		// else "<" is expected.  The first expected relation
		// is ">"
		boolean flag = true;

		for (int i=0; i<=n-2; i++)
		{
			if (flag)  /* ">" relation expected */
			{

				if (arr[i] < arr[i+1]){
					int temp= arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;

				}

			}
			else /* "<" relation expected */
			{

				if (arr[i] > arr[i+1])
				{
					int temp= arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;
				}

			}
			flag = !flag; /* flip flag */
		}
	}


	public static void sort2(int a[]){

		Arrays.sort(a);
		int n=a.length;
		int b[]= new int[a.length];
		int k=0;

		if(n%2==0){
			for(int i=0; i<n/2; i++){

				if(n-i-1==i){
					System.out.println(a[i]+" ");
					b[k++]=a[i];

				}
				else{
					System.out.println(a[n-i-1]+" ");
					b[k++]=a[n-i-1];
					System.out.println(a[i]+" ");
					b[k++]=a[i];
				}
			}
		}else{
			for(int i=0; i<(n/2)+1; i++){

				if(n-i-1==i){
					System.out.println(a[i]+" ");
					b[k++]=a[i];

				}
				else{
					System.out.println(a[n-i-1]+" ");
					b[k++]=a[n-i-1];
					System.out.println(a[i]+" ");
					b[k++]=a[i];
				}
			}
		}

	}


	public static void sort4(int a[]){

		Arrays.sort(a);

		int b[]=new int[a.length];

		int i=0;
		int j=a.length-1;
		int k=0;

		while(i<j){

			b[k++]=a[j--];
			b[k++]=a[i++];

		}		
		if(i==j){
			b[k++]=a[i];
		}

		for(int x=0; x<b.length; x++)
			System.out.print(" "+b[x]);

	}

	public static void sort5(int a[]){



		int b[]= new int[a.length];
		int k=0,j=0;
		int n;
		boolean hasOddlength=false;

		if(a.length%2==0){
			n=a.length/2;	
		}else
		{
			hasOddlength=true;
			n=a.length/2+1; 
		}


		for(int i=0; i<n; i=i+1){

			if(i==n-1 && hasOddlength){
				b[k++]=a[j];


			}else{
				if(a[j]>a[j+1]){
					b[k++]=a[j];
					b[k++]=a[j+1];
				}else{

					b[k++]=a[j+1];
					b[k++]=a[j];
				}
				j=j+2;
			}


		}

		for(int x=0; x<b.length; x++)
			System.out.print(" "+b[x]);


	}

}
