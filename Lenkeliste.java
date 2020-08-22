import java.util.Iterator;
import java.lang.Iterable;


public class Lenkeliste<T> implements Liste<T> {
  int ant = 0;
  public class Node {
    T info;
    Node neste;

    public Node(T info) {
      this.info = info;
      neste = null;
    }
  }

  Node start;


  public Lenkeliste() {
    start = null;
  }
  public void leggTil(T x) {
    Node node = new Node(x);
    ant++;

    if (start == null) {
      start = node;
    }
    else {
      Node denneNode = start;
      while (denneNode.neste != null) {
        denneNode = denneNode.neste;
      }
      denneNode.neste = node;
    }
  }

  public T fjern() {
    if (start == null) {
      throw new UgyldigListeIndeks(0);
    }
    else {
      T info = start.info;
      start = start.neste;
      ant--;
      return info;
    }
  }
  public void sett(int pos, T x) {
    Node nodeUt = start;
    for (int i = 0; i < pos; i++) {
      nodeUt = nodeUt.neste;
    }
    if (pos < 0 || pos > stoerrelse() - 1) {
      throw new UgyldigListeIndeks(pos);
    }
    else {
      nodeUt.info = x;
    }
  }
  public void leggTil(int pos, T x) {
    Node nyNode = new Node(x);
    Node nodePos = start;
    Node nodeForrige = start;

    if (pos < 0 || pos > stoerrelse()) {
      throw new UgyldigListeIndeks(pos);
    }
    else {
      ant++;
      if (pos == 0 && start == null) {
        start = nyNode;
      }
      else if (pos == 0 && start != null){
        Node nodeNeste = start;
        start = nyNode;
        nyNode.neste = nodeNeste;
      }
      else {
        for (int i = 0; i < pos; i++) {
          nodePos = nodePos.neste;
        }
        for (int i = 0; i < (pos - 1); i++) {
          nodeForrige = nodeForrige.neste;
        }
        if (nodePos == null) {
          Node denneNode = start;
          while (denneNode.neste != null) {
            denneNode = denneNode.neste;
          }
          denneNode.neste = nyNode;
        }
        else {
          nodeForrige.neste = nyNode;
          nyNode.neste = nodePos;
        }
      }
    }
  }
  public T fjern(int pos) {
    if (pos < 0 || pos > stoerrelse() - 1) {
      throw new UgyldigListeIndeks(pos);
    }
    if (stoerrelse() == 1) {
      T info = start.info;
      start = start.neste;
      ant--;
      return info;
    }
    else {
      Node nodePos = start;
      for (int i = 0; i < (pos - 1); i++) {
        nodePos = nodePos.neste;
      }
      Node nodeNeste = nodePos.neste;
      nodePos.neste = nodeNeste.neste;
      ant--;
      return nodeNeste.info;

    }
  }
  public int stoerrelse() {
    return ant;
  }
  public T hent(int pos){
    Node nodePos = start;
    if (pos < 0 || pos > stoerrelse() - 1) {
      throw new UgyldigListeIndeks(pos);
    }
    else {
      if (pos == 0) {
        return nodePos.info;
      }
      else {
        for (int i = 0; i < pos; i++) {
          nodePos = nodePos.neste;
        }
        return nodePos.info;
      }
    }
  }

  public class LenkelisteIterator implements Iterator<T> {
    Node nodePos = start;
    @Override
    public boolean hasNext() {
      return nodePos != null;
    }
    @Override
    public T next() {
      Node tmp = nodePos;
      nodePos = nodePos.neste;
      return tmp.info;
    }
  }

  public Iterator<T> iterator() {
    return new LenkelisteIterator();
  }
}
