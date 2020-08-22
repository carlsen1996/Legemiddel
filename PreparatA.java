public class PreparatA extends Legemiddel {
  //narkotisk
  private int styrke;

  public PreparatA(String navn, double pris, double virkestoff, int styrke) {
    super(navn, pris, virkestoff);
    this.styrke = styrke;

  }

  public int hentNarkotiskStyrke() {
    return styrke;
  }
}
