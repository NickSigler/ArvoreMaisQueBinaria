package Arvore.BST;


public class ArvoreBST {
    private Integer profundidade;
    private Integer altura;
    private Node raiz;

    public Node insert(int data) {
        Node no = new Node(data);
        if (raiz == null) {
            raiz = no;
        } else {
            Node noAtual = raiz;


            while (true) {
                Node parent;
                if (no.getData() > noAtual.getData()) {
                    parent = noAtual;
                    noAtual = noAtual.getDireito();
                    if (noAtual == null) {
                        parent.setDireito(no);
                        return no;
                    }
                } else {
                    parent = noAtual;
                    noAtual = noAtual.getEsquerdo();
                    if (noAtual == null) {
                        parent.setEsquerdo(no);
                        return no;
                    }
                }
            }
        }


        return no;
    }

    public boolean search(int data) {
        Node noAtual = raiz;
        while (true) {
            if (noAtual.getData() == data) {
                return true;
            } else {
                if (noAtual.getData() < data) {
                    noAtual = noAtual.getDireito();
                } else {
                    noAtual = noAtual.getEsquerdo();
                }
            }
            return false;
        }
    }


    public String remove(int data) {
        Node noAnterior = null;
        Node noAtual = raiz;
        boolean encontrado = false;


        while (noAtual != null) {
            if (data == noAtual.getData()) {
                encontrado = true;
                break;
            }
            noAnterior = noAtual;
            if (data < noAtual.getData())
            {
                noAtual = noAtual.getEsquerdo();
            } else {
                noAtual = noAtual.getDireito();
            }
        }


        if (!encontrado)
        {
            return String.format("Nó não foi achado e não foi deletado %d",this.raiz.getData());
        }

        if (noAtual.getEsquerdo() == null && noAtual.getDireito() == null)
        {
            if (noAnterior == null) {
                raiz = null; // O nó a ser removido é a raiz
            } else if (noAnterior.getEsquerdo() == noAtual) {
                noAnterior.setEsquerdo(null);
            } else {
                noAnterior.setDireito(null);
            }
        }
        else if (noAtual.getEsquerdo() == null || noAtual.getDireito() == null)
        {
            Node filho;
            if (noAtual.getEsquerdo() != null)
            {
                filho = noAtual.getEsquerdo();
            } else {
                filho = noAtual.getDireito();
            }

            if (noAnterior == null) {
                raiz = filho;
            } else if (noAnterior.getEsquerdo() == noAtual)
            {
                noAnterior.setEsquerdo(filho);
            } else {
                noAnterior.setDireito(filho);
            }
        }

        else
        {
            Node sucessor = noAtual.getDireito();
            Node paiSucessor = noAtual;

            while (sucessor.getEsquerdo() != null)
            {
                paiSucessor = sucessor;
                sucessor = sucessor.getEsquerdo();
            }

            noAtual.setData(sucessor.getData());

            if (paiSucessor == noAtual)
            {
                paiSucessor.setDireito(sucessor.getDireito());
            } else
            {
                paiSucessor.setEsquerdo(sucessor.getDireito());
            }
        }

        return String.format("Nó foi deletado %d",this.raiz.getData());

    }
    public void printTree() {
        if (raiz != null) {
            printTree(raiz, "");
        }
    }

    private void printTree(Node no, String prefix) {
        if (no != null) {
            System.out.println(prefix + "|-- " + no.getData());
            if (no.getEsquerdo() != null || no.getDireito() != null) {
                String newPrefix = prefix + "|   ";
                if (no.getEsquerdo() != null && no.getDireito() != null) {
                    printTree(no.getEsquerdo(), newPrefix + "|-- ");
                    printTree(no.getDireito(), newPrefix + "|-- ");
                } else if (no.getEsquerdo() != null) {
                    printTree(no.getEsquerdo(), newPrefix + "|-- ");
                } else {
                    printTree(no.getDireito(), newPrefix + "|-- ");
                }
            }
        }
    }



}
