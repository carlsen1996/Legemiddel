public class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T> {
  public SortertLenkeliste() {

  }

  @Override
  public void leggTil(T x) {
    Node node = new Node(x);
    Node nodePos = start;
    int nr = 0;

    if (ant == 0) {
      super.leggTil(x);
    }
    else {
      while (nodePos != null && (node.info.compareTo(nodePos.info) > 0)) {
        nr++;
        nodePos = nodePos.neste;
      }
      super.leggTil(nr, x);
    }
  }
  @Override
  public T fjern() {
    return super.fjern(ant - 1);
  }
  @Override
  public void sett(int pos, T x) {
    throw new UnsupportedOperationException("Du kan ikke sette inn noe her");
  }
  @Override
  public void leggTil(int pos, T x) {
    throw new UnsupportedOperationException("Du kan ikke sette inn noe her");
  }
}
