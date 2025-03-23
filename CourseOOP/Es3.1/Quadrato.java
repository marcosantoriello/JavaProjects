public class Quadrato extends Rettangolo {
    public Quadrato(double lato) {
        super(lato, lato);
    }

    @Override
    public void setAltezza(double lato) {
        super.setAltezza(lato);
        super.setBase(lato);
    }

    @Override
    public void setBase(double lato) {
        super.setBase(lato);
        super.setAltezza(lato);
    }

    @Override
    public String toString() {
        return "Sono un quadrato che copre un'area di" + this.calcolaArea() + "mq";
    }

}
