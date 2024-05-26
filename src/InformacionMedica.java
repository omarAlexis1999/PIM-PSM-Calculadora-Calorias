/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.sql.Date;

// line 78 "model.ump"
// line 131 "model.ump"
public class InformacionMedica
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //InformacionMedica Attributes
  private String densidadCalorica;
  private String indiceGlucemico;

  //InformacionMedica Associations
  private Persona persona;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public InformacionMedica(String aDensidadCalorica, String aIndiceGlucemico, Persona aPersona)
  {
    densidadCalorica = aDensidadCalorica;
    indiceGlucemico = aIndiceGlucemico;
    if (aPersona == null || aPersona.getInformacionMedica() != null)
    {
      throw new RuntimeException("Unable to create InformacionMedica due to aPersona. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    persona = aPersona;
  }

  public InformacionMedica(String aDensidadCalorica, String aIndiceGlucemico, String aNombresForPersona, Date aFechaNacimientoForPersona, double aPesoForPersona, double aAlturaForPersona, String aSexoForPersona)
  {
    densidadCalorica = aDensidadCalorica;
    indiceGlucemico = aIndiceGlucemico;
    persona = new Persona(aNombresForPersona, aFechaNacimientoForPersona, aPesoForPersona, aAlturaForPersona, aSexoForPersona, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDensidadCalorica(String aDensidadCalorica)
  {
    boolean wasSet = false;
    densidadCalorica = aDensidadCalorica;
    wasSet = true;
    return wasSet;
  }

  public boolean setIndiceGlucemico(String aIndiceGlucemico)
  {
    boolean wasSet = false;
    indiceGlucemico = aIndiceGlucemico;
    wasSet = true;
    return wasSet;
  }

  public String getDensidadCalorica()
  {
    return densidadCalorica;
  }

  public String getIndiceGlucemico()
  {
    return indiceGlucemico;
  }
  /* Code from template association_GetOne */
  public Persona getPersona()
  {
    return persona;
  }

  public void delete()
  {
    Persona existingPersona = persona;
    persona = null;
    if (existingPersona != null)
    {
      existingPersona.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "densidadCalorica" + ":" + getDensidadCalorica()+ "," +
            "indiceGlucemico" + ":" + getIndiceGlucemico()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "persona = "+(getPersona()!=null?Integer.toHexString(System.identityHashCode(getPersona())):"null");
  }
}