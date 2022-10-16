import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main
{
    public static float ottieniMedia(List<Materia> materie)
    {
        float somma;

        somma = 0;
        for (Materia materia : materie)
            somma += materia.getCrediti() * materia.getVoto();

        return somma / materie.stream().map(Materia::getCrediti).reduce(0, Integer::sum);
    }
    public static float ottieniMediaDepurata(List<Materia> materie, int nCreditiScorporo)
    {
        if (materie.stream().map(Materia::getCrediti).reduce(0, Integer::sum) <= 16)
            return -1;

        int skip;
        float somma;

        somma = 0;
        skip = 0;
        for (Materia materia : materie.stream().sorted(Comparator.comparing(Materia::getVoto)).collect(Collectors.toList()))
        {
            for (int i = 0; i < materia.getCrediti(); i++)
                if (skip < nCreditiScorporo)
                    skip++;
                else
                    somma += materia.getVoto();
        }

        return somma / (materie.stream().map(Materia::getCrediti).reduce(0, Integer::sum) - nCreditiScorporo);
    }

    public static void main(String[] args)
    {
                                                           //
        int[] c = { 10, 12, 10, 8, 8, 8, 10, 6, 8, 10, 8, 8, 10, 8, 8, 6, 6, 8, 8, 10, 6 };
                                                                  //
        int[] v = { 29, 18, 23, 30, 19, 18, 19, 18, 28, 18, 27, 29, 30, 30, 30, 18, 30, 30, 18, 25, 30 };
        List<Materia> materie;
        Materia temp;

        materie = new ArrayList<>();
        for (int i = 0; i < c.length; i++)
        {
            temp = new Materia(" ", c[i]);
            temp.setVoto(v[i]);
            materie.add(temp);
        }
        System.out.println("Media: " + ottieniMedia(materie));
        System.out.println("Media depurata: " + ottieniMediaDepurata(materie, 16));
    }
}
