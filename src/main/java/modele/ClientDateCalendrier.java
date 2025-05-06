package modele;

import java.util.Arrays;

public class ClientDateCalendrier {
    public static void main(String[] args) {
        DateCalendrier dc1 = new DateCalendrier(16, 2, 2022);
        DateCalendrier dc2 = new DateCalendrier(19, 2, 2022);
        DateCalendrier dc3 = new DateCalendrier(18, 2, 2022);
        DateCalendrier dc4 = new DateCalendrier(1, 1, 2025);
        dc1.dateDuLendemain();
        dc1.dateDeLaVeille();
        System.out.println(dc1);
        DateCalendrier[] datesCalendrier = {dc1, dc2, dc3};
        System.out.println(Arrays.toString(datesCalendrier));
        Arrays.sort(datesCalendrier);
        System.out.println(Arrays.toString(datesCalendrier));
        System.out.println(dc4.getchNumSem());
    }
}
