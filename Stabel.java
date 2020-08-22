public class Stabel<T> extends Lenkeliste<T> {
  public Stabel() {
    
  }
  public void leggPaa(T x) {
    leggTil(x);
  }
  public T taAv() {
    int antall = super.stoerrelse() -1;
    return super.fjern(antall);
  }
}
