import java.sql.Timestamp;

public class produto {

  private String desc;
  private int cod;
  private int forn_cod;
  private Timestamp datacad;
  private Timestamp dataatu;

  public String getDesc() {
    return this.desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public int getCod() {
    return this.cod;
  }

  public void setCod(int cod) {
    this.cod = cod;
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


  public int getForn_cod() {
    return this.forn_cod;
  }

  public void setForn_cod(int forn_cod) {
    this.forn_cod = forn_cod;
  }


}
