package pl.edu.pg.eti.ksg.po.lab1.transformacje;

public class ZlozenieTransformacji implements Transformacja{
    private final Transformacja[] tab;

    public ZlozenieTransformacji(Transformacja[] tab) {
        this.tab = tab;
    }

    @Override
    public Transformacja getTransformacjaOdwrotna() {
        Transformacja[] tab = new Transformacja[this.tab.length];
        try {
            for (int i = 0; i < this.tab.length; i++) {
                tab[i] = this.tab[this.tab.length - i - 1].getTransformacjaOdwrotna();
            }
        }
        catch (BrakTransformacjiOdwrotnejException ex)
        {
            ex.printStackTrace();
        }
        return new ZlozenieTransformacji(tab);
    }
    @Override
    public Punkt transformuj(Punkt p) {
        Punkt punkt = new Punkt(p.getX(), p.getY());

        for(Transformacja T : tab) {
            punkt = T.transformuj(punkt);
        }
        return punkt;
    }

    public Transformacja[] getTab() {
        return tab;
    }

    @Override
    public String toString() {
        String msg = "";
        for (Transformacja T : tab) {
            msg += T.toString();
            msg += '\n';
        }
        return msg;
    }
}
