public class Spesialist extends Lege {
  protected int kontrollID;
  public Spesialist(String navn, int kontrollID) {
    super(navn);
    this.kontrollID = kontrollID;
  }
  public int hentKontrollID() {
    return kontrollID;
  }
}
