public abstract class Resept {
  protected Pasient pasient;
  protected int reit;
  protected Legemiddel legemiddel;
  protected Lege utskrivendeLege;
  protected static int id;
  protected int gjeldendeID;

  public Resept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
    this.pasient = pasient;
    this.reit = reit;
    this.legemiddel = legemiddel;
    this.utskrivendeLege = utskrivendeLege;
    gjeldendeID = id;
    id++;

  }
  public int hentId() {
    return gjeldendeID;
  }
  public String hentLegemiddel() {
    return legemiddel.hentNavn();
  }

  public Lege hentLege() {
    return utskrivendeLege;
  }
  public Pasient hentPasientId() {
    return pasient;
  }
  public int hentReit() {
    return reit;
  }
  public boolean bruk() {
    if (reit <= 0) {
      return false;
    }
    else {
      reit--;
      return true;
    }
  }

  abstract public String farge();

  abstract public double prisAaBetale();

  public String toString() {
    return hentLegemiddel() + " koster " + prisAaBetale() + "kr for pasienten " + pasient.hentNavn() + " og er skrevet ut av " + hentLege() + ". Det er " + hentReit() + " reit igjen og id er " + gjeldendeID;
  }
}
