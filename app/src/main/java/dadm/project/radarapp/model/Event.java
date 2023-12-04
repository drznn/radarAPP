package dadm.project.radarapp.model;

public class Event {
    int imgEvento;
    String nomeEvento;
    String descricaoEvento;
    String data;

    public Event(int imgEvento, String nomeEvento, String descricaoEvento, String data) {
        this.imgEvento = imgEvento;
        this.nomeEvento = nomeEvento;
        this.descricaoEvento = descricaoEvento;
        this.data = data;
    }


    public int getImgEvento() {
        return imgEvento;
    }

    public void setImgEvento(int imgEvento) {
        this.imgEvento = imgEvento;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
