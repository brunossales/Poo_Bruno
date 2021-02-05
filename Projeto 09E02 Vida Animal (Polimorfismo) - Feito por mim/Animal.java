public abstract class Animal {
    protected float peso;
    protected int idade;
    protected int membros;

    public abstract void emitirSom();

    public abstract void comer(int i);
}

interface Cor {
    String corPelo();
}
