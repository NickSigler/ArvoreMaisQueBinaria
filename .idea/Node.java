package Arvore.BST;

public class Node
{
    private Node esquerdo;
    private Node direito;
    private Integer data;
    public Node(int data)
    {
        this.data = data;
    }
    public Node getEsquerdo()
    {
        return this.esquerdo;
    }
    public void setEsquerdo(Node esquerdo)
    {
        this.esquerdo = esquerdo;
    }
    public Node getDireito()
    {
        return this.direito;
    }
    public void setDireito(Node direito)
    {
        this.direito = direito;
    }
    public int getData()
    {
        return this.data;
    }
    public void setData(int data)
    {
        this.data = data;
    }






}
