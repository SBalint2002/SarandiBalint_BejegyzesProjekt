package hu.petrik.bejegyzesprojektoop;

import java.time.LocalDateTime;

public class BejegyzesProjekt {
    private String szerzo;
    private String tartalom;
    private int likeok;
    private LocalDateTime letrejott;
    private LocalDateTime szerkesztve;

    public BejegyzesProjekt(String szerzo, String tartalom) {
        this.szerzo = szerzo;
        this.tartalom = tartalom;
        this.likeok = 0;
        this.letrejott = LocalDateTime.now();
        this.szerkesztve = LocalDateTime.now();
    }

    public String getSzerzo() {
        return this.szerzo;
    }

    public String getTartalom() {
        return this.tartalom;
    }

    public void setTartalom(String tartalom) {
        this.tartalom = tartalom;
    }

    public int getLikeok(){ return this.likeok; }

    public LocalDateTime getLetrejott() {
        return letrejott;
    }

    public LocalDateTime getSzerkesztve() {
        return szerkesztve;
    }

    public void like(){
        likeok++;
    }
}
