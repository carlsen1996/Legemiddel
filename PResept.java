public class PResept extends HvitResept {
  protected double pris;
  protected int reit = 3;

  public PResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
    super(legemiddel, utskrivendeLege, pasient, reit);
    this.pris = pris;
    reit = reit - 1;
  }
  @Override
  public double prisAaBetale() {
    if (legemiddel.hentPris() < 108) {
      return 0;
    }
    else {
      return legemiddel.hentPris() - 108;
    }
  }
}
