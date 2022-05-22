package tables;

/**
 * Clase que se encargará de guardar la información relacionada con los anuncios introducidos al sistema.
 */
public class Advertising {

    public String name;
    public String date;
    public int price;

    /**
     * Constructor de Advertising.
     * @param name Titulo del anuncio.
     * @param date Fecha del anuncio.
     * @param price Precio del anuncio.
     */
    public Advertising(String name, String date, int price) {
        this.name = name;
        this.date = date;
        this.price = price;
    }

    /**
     * Método que devolverá el título del anuncio.
     * @return String con el título del anuncio.
     */
    public String getName() {
        return name;
    }

    /**
     * Método que cambiará el título del anuncio.
     * @param name String con el nuevo título del anuncio.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método que recogerá la fecha del anuncio.
     * @return String con la fecha del anuncio.
     */
    public String getDate() {
        return date;
    }

    /**
     * Método que devolverá el precio del anuncio.
     * @return Integer con el precio del anuncio.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Método que actualizará el precio del anuncio.
     * @param price Integer con el nuevo precio del anuncio.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Método que imprimirá la información del anuncio con el formato especificado.
     * @return String con la información del anuncio.
     */
    @Override
    public String toString() {
        return  "\n\tNom: " + name +
                "\n\tDia: " + date +
                "\n\tPreu: " + price + '€';
    }
}
