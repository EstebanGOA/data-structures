package tables;

public class Advertising {
    public String name;
    public String date;
    public int price;

    public Advertising(String name, String date, int price) {
        this.name = name;
        this.date = date;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  "\n\tNom: " + name +
                "\n\tDia: " + date +
                "\n\tPreu: " + price + '€';
    }
}
