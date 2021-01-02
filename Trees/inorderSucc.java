class Tree
{
	public Node inorderSuccessor(Node root,Node x)
    {
        if(x.right != null)
        {
            root = x.right;
            while(root.left != null)
                root = root.left;
            return root;
        }
        else
        {
            Node suc = null;
            while(root != null)
            {
                if(root.data > x.data)
                {
                    suc = root;
                    root = root.left;
                }
                else if(root.data < x.data)
                    root = root.right;
                else
                    break;
            }
            return suc;
        }
    }
}