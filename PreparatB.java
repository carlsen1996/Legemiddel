public class PreparatB extends Legemiddel {
  //vanedannende
  private int styrke;

  public PreparatB(String navn, double pris, double virkestoff, int styrke) {
    super(navn, pris, virkestoff);
    this.styrke = styrke;

  }

  public int hentVanedannendeStyrke() {
    return styrke;
  }
}
