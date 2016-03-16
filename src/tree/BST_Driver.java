package tree;

public class BST_Driver {

	public static void main(String [] args){
		int[] TestingArray = {8,6,9,11,10,12,5,1,3,2};
		BinarySerchTreeExtraFunctionality FirstBst = new BinarySerchTreeExtraFunctionality();
		FirstBst.createBinarySearchTree(TestingArray);
		FirstBst.displayTree();
		System.out.println("Sum of smallest sum path ="+ FirstBst.sumOfSmallestSumPath(FirstBst.root) );
		System.out.println("Sum of largest sum path = "+ FirstBst.sumOfLargestestSumPath(FirstBst.root));
		
	}
}
