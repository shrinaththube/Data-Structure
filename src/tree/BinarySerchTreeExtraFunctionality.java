package tree;

public class BinarySerchTreeExtraFunctionality extends BinarySearchTree {
		//This method finds the path in BST which has smallest sum from root node to one of the leaf. It returns that sum to user or caller  
		public int sumOfSmallestSumPath(TreeNode travelingNode)
		{
			if(travelingNode==null) return 0;
			
			else if(travelingNode.leftNode == null)
				return sumOfSmallestSumPath(travelingNode.rightNode) + travelingNode.value;
			
			else if(travelingNode.rightNode == null)
				return sumOfSmallestSumPath(travelingNode.leftNode) + travelingNode.value;
		
			return Math.min(sumOfSmallestSumPath(travelingNode.leftNode), sumOfSmallestSumPath(travelingNode.rightNode)) + travelingNode.value;
		}
		
		//This method finds the path in BST which has largest sum from root node to one of the leaf. It returns that sum to user or caller  
		public int sumOfLargestestSumPath(TreeNode travelingNode)
		{
			if(travelingNode==null) return 0;
			
			else if(travelingNode.leftNode == null)
				return sumOfLargestestSumPath(travelingNode.rightNode) + travelingNode.value;
			
			else if(travelingNode.rightNode == null)
				return sumOfLargestestSumPath(travelingNode.leftNode) + travelingNode.value;
		
			return Math.max(sumOfLargestestSumPath(travelingNode.leftNode), sumOfLargestestSumPath(travelingNode.rightNode)) + travelingNode.value;
		}
		
}
