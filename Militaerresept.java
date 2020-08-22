public class Militaerresept extends HvitResept {
  protected double pris;

  public Militaerresept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
    super(legemiddel, utskrivendeLege, pasient, reit);
    this.pris = pris;
    reit = reit - 1;
  }
  @Override
  public double prisAaBetale() {
    return pris = 0;
  }
}
