 public class Lege implements Comparable<Lege> {
  protected String navn;
  protected Legemiddel legemiddel;
  protected Pasient pasient;
  protected int reit;
  protected Lenkeliste<Resept> utskrevedeResepter = new Lenkeliste<Resept>();
  protected int narkAnt = 0;


  public Lege(String navn) {
    this.navn = navn;

  }
  public String hentNavn() {
    return navn;
  }
  public Resept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
    Resept resept = new BlaaResept(legemiddel, this, pasient, reit);
    if (this instanceof Spesialist) {
      utskrevedeResepter.leggTil(resept);
      pasient.pasientresepter.leggPaa(resept);
      return resept;
    }
    else {
      if (legemiddel instanceof PreparatA) {
        throw new UlovligUtskrift(this, legemiddel);
      }
      utskrevedeResepter.leggTil(resept);
      pasient.pasientresepter.leggPaa(resept);
      return resept;
    }
  }
  public Resept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) {
    Resept resept = new HvitResept(legemiddel, this, pasient, reit);
    utskrevedeResepter.leggTil(resept);
    pasient.pasientresepter.leggPaa(resept);
    return resept;
  }
  public Resept skrivPResept(Legemiddel legemiddel, Pasient pasient, int reit) {
    Resept resept = new PResept(legemiddel, this, pasient, reit);
    utskrevedeResepter.leggTil(resept);
    pasient.pasientresepter.leggPaa(resept);
    return resept;
  }
  public Resept skrivMilitaerresept(Legemiddel legemiddel, Pasient pasient, int reit) {
    Resept resept = new Militaerresept(legemiddel, this, pasient, reit);
    utskrevedeResepter.leggTil(resept);
    pasient.pasientresepter.leggPaa(resept);
    return resept;
  }

  @Override
  public String toString() {
    return navn;
  }
  @Override
  public int compareTo(Lege annen) {
    return this.navn.compareTo(annen.hentNavn());
  }

}
