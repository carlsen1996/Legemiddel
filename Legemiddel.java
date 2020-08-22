public class Legemiddel {
  private String navn;
  private double pris;
  private double virkestoff;
  protected static int id = 0;
  protected int gjeldendeID;



  public Legemiddel(String navn, double pris, double virkestoff) {
    this.navn = navn;
    this.pris = pris;
    this.virkestoff = virkestoff;
    gjeldendeID = id;
    id++;
  }

  public int hentId() {
    return gjeldendeID;
  }

  public String hentNavn() {
    return navn;
  }

  public double hentPris() {
    return pris;
  }

  public double hentVirkestoff() {
    return virkestoff;
  }
  public double settNyPris(double nyPris) {
    return pris = nyPris;
  }
  @Override
  public String toString() {
    return navn + " koster " + pris + "kr og inneholder " + virkestoff + " mg virkestoff og med id " + gjeldendeID;
  }
}
