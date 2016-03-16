package tree;

/**
 * @author Shrinath
 *
 *BinarySearchTree class takes array, and create tree. It can display tree in Inorder, Preorder, Postorder method.
 *
 * -----Methods----
 *public void createBinarySearchTree(int array[]){} 
 *public void displayTree(){}
 */
public class BinarySearchTree {

	public TreeNode root = null;
	public TreeNode travel =null;
	
	public static void main(String[] args) {
		//Test case
		BinarySearchTree tree1 = new BinarySearchTree();
		int[] array1 = {8,6,9,11,10,12,5,1,3,2};
		
		tree1.createBinarySearchTree(array1);
		tree1.displayTree();
	}

	// Assigning root node to tree object, Parameter required - "value" of node,Checked their should be one root node only
	public void setRootNode(int value){
		if(this.root == null){
			this.root = new TreeNode(value);
			this.root.leftNode = null;
			this.root.rightNode = null;
		}
		else{
			System.out.println("Root is allready assign "+"Root value = "+this.root.value);
		}
	}
	
	public TreeNode creatTreeNode(int value){
		TreeNode newNode = new TreeNode(value);
		return newNode;
	}
	
	// Add node to created tree according to Binary serach tree algorithm 
	public void addNode(int value,TreeNode refNode){
		TreeNode newNode = null;
		if(this.root==null){ this.setRootNode(value); return;}
		if(refNode.value>value){
			if(refNode.leftNode!=null)
				addNode(value,refNode.leftNode);
			else{
				 newNode  = new TreeNode(value);
				 refNode.leftNode = newNode;
			}
		}
		else{
			if(refNode.rightNode!=null)
				addNode(value,refNode.rightNode);
			else{
				 newNode  = new TreeNode(value);
				 refNode.rightNode = newNode;
			}
		}
	}
	
	//Print tree by Inorder traversing , This is recursion method, parameter required- root node reference, It is also method of sorting
	public void printInorder(TreeNode travel){
		if(travel == null){ return;}
		
		printInorder(travel.leftNode);
		System.out.print(" "+travel.value);
		printInorder(travel.rightNode);
	}
	
	//Print tree by Preorder traversing , This is recursion method, parameter required- root node reference
	public void printPreorder(TreeNode travel){
		if(travel == null){ return; }
		
		System.out.print(travel.value+" ");
		printPreorder(travel.leftNode);
		printPreorder(travel.rightNode);
	}
	
	//Print tree by Postorder traversing , This is recursion method, parameter required- root node reference
	public void printPostorder(TreeNode travel){
			if(travel == null){ return; }
			
			printPostorder(travel.leftNode);
			printPostorder(travel.rightNode);
			System.out.print(travel.value+" ");
		}

	//Display tree. This handles all indentation of printing
	public void displayTree(){
		System.out.print("Tree print in Inorder = ");
		this.printInorder(this.root);
		System.out.println();
		System.out.print("Tree print in Preorder = ");
		this.printPreorder(this.root);
		System.out.println();
		System.out.print("Tree print in Postorder = ");
		this.printPostorder(this.root);
		System.out.println();
	}
	
	// Create tree from fixed size of data set. This is not balanced tree 
	public void createBinarySearchTree(int array[]){
		if(this.root == null){ this.setRootNode(array[0]); }

		for(int i = 1;i<array.length;i++){ this.addNode(array[i],this.root); }
	}
}
