package workExam;

import java.util.Objects;



public class Toys implements Comparable<Toys> {

    private int toyId;
    private String toyName;
    private int drawnToys;
    private int[] clientId = {1, 2, 3, 4, 5};
    private String[] nameClient = {"Женя", "Петя", "Света", "Галя", "Женя"};
   

    public Toys(int toyId, String toyName, int drawnToys) {
        this.toyId = toyId;
        this.toyName = toyName;
        this.drawnToys = drawnToys;
        
    }

    public Toys (int clientId[], String nameClient[]){
        this.clientId = clientId;
        this.nameClient = nameClient;
    }
   

    public int getToyId() {
        return toyId;
    }

    public String getToyName() {
        return toyName;
    }

    public int getDrawnToys() {
        return drawnToys;
    }

    

    public int[] getClientId() {
        return clientId;
    }

    public String[] getNameClient() {
        return nameClient;
    }



    public void setVClientId(int clientId[]) {
        this.clientId = clientId;
    }

    


    public void setDrawnToys(int drawnToys) {
        this.drawnToys = drawnToys;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toys toy = (Toys) o;
        return toyName.equals(toy.toyName);
    }

    public String getInfo() {
        return String.format("ID: %d, Название: %s  ", toyId, toyName);
    }


    @Override
    public int hashCode() {
        return Objects.hash(toyName);
    }

   
    @Override
    public int compareTo(Toys o) {
        return Integer.compare(this.drawnToys, o.drawnToys);
    }
}