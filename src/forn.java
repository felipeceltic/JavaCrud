import java.sql.Timestamp;

public class forn {
  private int cod;
  private String name;
  private Timestamp datacad;
  private Timestamp dataatu;


  public int getCod() {
    return this.cod;
  }

  public void setCod(int cod) {
    this.cod = cod;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Timestamp getDatacad() {
    return this.datacad;
  }

  public void setDatacad(Timestamp datacad) {
    this.datacad = datacad;
  }

  public Timestamp getDataatu() {
    return this.dataatu;
  }

  public void setDataatu(Timestamp dataatu) {
    this.dataatu = dataatu;
  }

}
