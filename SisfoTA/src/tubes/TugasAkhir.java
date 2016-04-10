/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

/**
 *
 * @author YAYAN
 */
public class TugasAkhir {
  private Dosen[] pembimbing;
  private String judul;

  public TugasAkhir(String judul) {
    this.judul = judul;
    this.pembimbing = new Dosen[2];
  }

  public String getJudul() {
    return judul;
  }

  public void setJudul(String judul) {
    this.judul = judul;
  }
  public void setPembimbing(Dosen d, int i){
    if(i==1 || i==2){
      this.pembimbing[i-1] = d;
    }
  }
  public Dosen getPembimbing(String nip){
    for(int i=0; i<2;i++){
      if(pembimbing[i].getNip().equals(nip)){
        return pembimbing[i];
      }
    }
    return null;
  }
  public Dosen getPembimbing(int indeks){
    if (indeks ==1 || indeks ==2)
      return pembimbing[indeks];
    return null;
  }
  
}
