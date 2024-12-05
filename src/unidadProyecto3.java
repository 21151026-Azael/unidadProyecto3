
class Nodo {
    int valor;
    Nodo izquierdo, derecho;

    public Nodo(int valor) {
        this.valor = valor;
        izquierdo = derecho = null;
    }
}

public class unidadProyecto3 {

    Nodo raiz;

    public unidadProyecto3() {
        raiz = null;
    }

    public int calcularNivel(Nodo nodo, int valor, int nivel) {
        if (nodo == null) {
            return -1;
        }

        if (nodo.valor == valor) {
            return nivel;
        }

        int nivelIzquierda = calcularNivel(nodo.izquierdo, valor, nivel + 1);
        if (nivelIzquierda != -1) {
            return nivelIzquierda;
        }
        return calcularNivel(nodo.derecho, valor, nivel + 1);
    }

    public int calcularAltura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }

        int alturaIzquierda = calcularAltura(nodo.izquierdo);
        int alturaDerecha = calcularAltura(nodo.derecho);

        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    public int calcularPeso(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }

        return 1 + calcularPeso(nodo.izquierdo) + calcularPeso(nodo.derecho);
    }

    public Nodo insertar(Nodo nodo, int valor) {
        if (nodo == null) {
            nodo = new Nodo(valor);
            return nodo;
        }


        if (valor < nodo.valor) {
            nodo.izquierdo = insertar(nodo.izquierdo, valor);
        }
        else if (valor > nodo.valor) {
            nodo.derecho = insertar(nodo.derecho, valor);
        }

        return nodo;
    }

    public static void main(String[] args) {
        unidadProyecto3 arbol = new unidadProyecto3();

        arbol.raiz = arbol.insertar(arbol.raiz, 10);
        arbol.raiz = arbol.insertar(arbol.raiz, 5);
        arbol.raiz = arbol.insertar(arbol.raiz, 15);
        arbol.raiz = arbol.insertar(arbol.raiz, 3);
        arbol.raiz = arbol.insertar(arbol.raiz, 7);
        arbol.raiz = arbol.insertar(arbol.raiz, 12);
        arbol.raiz = arbol.insertar(arbol.raiz, 18);

        int nodoBusqueda = 7;
        System.out.println("Nivel del nodo " + nodoBusqueda + ": " + arbol.calcularNivel(arbol.raiz, nodoBusqueda, 0));
        System.out.println("Altura del arbol: " + arbol.calcularAltura(arbol.raiz));
        System.out.println("Peso del arbol: " + arbol.calcularPeso(arbol.raiz));
    }
}
