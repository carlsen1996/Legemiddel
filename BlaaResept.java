public class BlaaResept extends Resept {
  protected static int id;
  protected int gjeldendeId;
  protected double pris;

  public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
    super(legemiddel, utskrivendeLege, pasient, reit);
    gjeldendeId = id;
    id++;
    reit = reit - 1;


  }
  @Override
  public String farge() {
    return "Blaa";
  }
  @Override
  public double prisAaBetale() {
    return legemiddel.hentPris() / 4;
  }

}
