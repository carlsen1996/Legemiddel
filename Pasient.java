public class Pasient {
  protected String navn;
  protected String fodselsnummer;
  protected static int id;
  protected int denneId;
  protected Stabel<Resept> pasientresepter = new Stabel<Resept>();
  protected int narkAntPas = 0;


  public Pasient(String navn, String fodselsnummer) {
    denneId = id;
    id++;
    this.navn = navn;
    this.fodselsnummer = fodselsnummer;

  }
  public int hentId() {
    return denneId;
  }
  public String hentNavn() {
    return navn;
  }
  @Override
  public String toString() {
    return denneId + ": " + navn + ": " + fodselsnummer;
  }
  public Stabel<Resept> hentResepter() {
    return pasientresepter;
  }
}
