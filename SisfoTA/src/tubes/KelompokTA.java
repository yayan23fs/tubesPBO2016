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
public class KelompokTA {
  private String topik;
  private Mahasiswa[] anggota;
  private int jum;
  

  public KelompokTA(String topik) {
    this.topik = topik;
    this.anggota = new Mahasiswa[5];
    this.jum = 0;
  }

  public String getTopik() {
    return topik;
  }
  
  private boolean cekMahasiswa(Mahasiswa m){
    for(int i=0; i<jum;i++){
      if(anggota[i].equals(m)) 
        return true;
    }
    return false;
  }
  
  public void setTopik(String topik) {
    this.topik = topik;
  }
  public void addAnggota(Mahasiswa m){
    if (cekMahasiswa(m))
      return;
    if(jum<5){
      anggota[jum++] =m;
    }
  }
  public void removeAnggota(String nim){
    for(int i=0; i<jum;i++){
      if(anggota[i].getNim().equals(nim)){
        anggota[i] = null;
        for(int j=i+1; j<jum; j++){
          anggota[j-1] = anggota[j];
        }
        anggota[jum-1] = null;
        jum--;
        return;
      }
    }
  }
  
  public Mahasiswa getAnggota(int indeks){
    if (indeks < jum)
      return anggota[indeks];
    return null;
  }
  public Mahasiswa getAnggota(String nim){
    for(int i=0; i<jum;i++){
      if(anggota[i].getNim().equals(nim)){
        return anggota[i];
      }
    }
    return null;
  }
}
