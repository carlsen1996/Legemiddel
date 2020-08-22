public class HvitResept extends Resept {
  protected static int id;
  protected int gjeldendeId;
  protected double pris;

  public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
    super(legemiddel, utskrivendeLege, pasient, reit);
    gjeldendeId = id;
    id++;

  }
  @Override
  public String farge() {
    return "Hvit";
  }
  @Override
  public double prisAaBetale() {
    return legemiddel.hentPris();
  }
}
