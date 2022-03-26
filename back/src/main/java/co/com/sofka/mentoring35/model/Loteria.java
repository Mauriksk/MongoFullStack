package co.com.sofka.mentoring35.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "boletos")
public class Loteria {
    @Id
    private String id;
    private String boleto;

    public String getId() {
        return id;
    }

    public String getBoleto() {
        return boleto;
    }

    public void setBoleto(String boleto) {
        this.boleto = boleto;
    }

    public void generarNumeroAletorio(){
        int numeroAletorio = (int) (Math.random()*(1000-1)) + 1;
        String numString = String.valueOf(numeroAletorio);
        setBoleto(numString);
    }
}
