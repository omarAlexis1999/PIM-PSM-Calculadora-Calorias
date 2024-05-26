import java.sql.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        InformacionMedica infoMedica = new InformacionMedica("Alta", "Medio", "Juan Perez", new Date(92, 4, 15), 75.0, 1.75, "Masculino");

        System.out.println(infoMedica.getPersona().toString());
        System.out.println(infoMedica.getDensidadCalorica());
        System.out.println(infoMedica.getIndiceGlucemico());
    }
}