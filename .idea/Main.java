package Arvore.BST;

public class Main
{
    public static void main(String[] args)
    {
        ArvoreBST arvore = new ArvoreBST();
        arvore.insert(1);
        arvore.insert(2);
        arvore.insert(3);
        arvore.insert(4);
        arvore.insert(5);
        arvore.insert(0);
        arvore.insert(-1);
        arvore.remove(2);



        arvore.printTree();
    }



}
