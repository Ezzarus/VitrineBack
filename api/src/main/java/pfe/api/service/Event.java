package pfe.api.service;

public enum Event {
    STOCK("Attention Stock faible, dépêchez-vous ! "),
    INDISPONIBLE("Produit indisponible. "),
    PROMO("Produit en promotion, profitez-en ! ");

    private String text;

    Event(String s) {
        this.text = s;
    }

    public String getText() {
        return text;
    }
}
