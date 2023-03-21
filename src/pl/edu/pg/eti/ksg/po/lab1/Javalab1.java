package pl.edu.pg.eti.ksg.po.lab1;
import pl.edu.pg.eti.ksg.po.lab1.transformacje.*;

public class Javalab1 {
    public static void main(String[] args)
    {
        /*
         * Konstrukcja językowa try {} catch (...){} służy do
         * obsługi wyjątków. Kod w bloku try jest monitorowany
         * pod kątem wystąpienia wyjątku bądź wyjątków
         * wspomnianych na początku bloku/bloków catch.
         * Jeżeli gdzieś w bloku try wystąpi wyjątek, to sterowanie
         * zostanie natychmiast przeniesione do bloku catch.
         * Tam powinien znajdować się kod obsługujący wyjątek.
         * Może to być np. wypisanie stosu wywołań na wyjście błędów
         * lub zapisanie wyjątku w logach, lub wyrzucenie (zgłoszenie)
         * innego wyjątku lepiej opisującego sytuacje (można załączyć
         * wyjątek który zainicjował to zdarzenie patrz. Konstruktor
         * klasy java.lang.Exception)
         */
        try
        {
            Punkt p = new Punkt(2, 2);
            Transformacja[] tr = new Transformacja[2];
            tr[0] = new Skalowanie(2, 0.5);
            tr[1] = new Obrot(Math.PI/2);
            Transformacja z = new ZlozenieTransformacji(tr);

            System.out.println(p);
            System.out.println(z);

            Punkt p2 = z.transformuj(p);
            System.out.println(p2);

            Transformacja zr = z.getTransformacjaOdwrotna();
            Punkt p3 = zr.transformuj(p2);
            System.out.println(p3);
        }
        catch (BrakTransformacjiOdwrotnejException ex)
        {
            ex.printStackTrace();
        }
    }
}
