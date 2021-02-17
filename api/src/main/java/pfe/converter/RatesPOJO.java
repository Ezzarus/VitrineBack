package pfe.converter;

public class RatesPOJO {

    Rates rates;

    public RatesPOJO(){
        rates = new Rates();
    }

    public RatesPOJO(Rates given){
        rates = given;
    }

    class Rates {
         float USD;

         public Rates(){
             USD = 0;
         }

         public Rates(float value){
             USD = value;
         }
    }
}
