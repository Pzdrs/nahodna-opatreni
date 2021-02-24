package sample;

import com.google.gson.JsonArray;

import java.util.Random;

public class DataSet {
    private final String[] opatreni, authors;

    public DataSet(JsonArray opatreni, JsonArray authors) {
        this.opatreni = new String[opatreni.size()];
        this.authors = new String[authors.size()];

        for (int i = 0; i < opatreni.size(); i++) {
            this.opatreni[i] = opatreni.get(i).getAsString();
        }
        for (int i = 0; i < authors.size(); i++) {
            this.authors[i] = authors.get(i).getAsString();
        }
    }

    public String getRandomOpatreni() {
        return this.opatreni[new Random().nextInt(this.opatreni.length)];
    }

    public String getRandomAuthor() {
        return this.authors[new Random().nextInt(this.authors.length)];
    }
}
