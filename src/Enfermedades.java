/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/



// line 83 "model.ump"
// line 136 "model.ump"
public class Enfermedades
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Enfermedades Attributes
  private String nombre;
  private boolean estaConsumiendoMedicacion;
  private String observacion;

  //Enfermedades Associations
  private Persona persona;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Enfermedades(String aNombre, boolean aEstaConsumiendoMedicacion, String aObservacion, Persona aPersona)
  {
    nombre = aNombre;
    estaConsumiendoMedicacion = aEstaConsumiendoMedicacion;
    observacion = aObservacion;
    boolean didAddPersona = setPersona(aPersona);
    if (!didAddPersona)
    {
      throw new RuntimeException("Unable to create enfermedade due to persona. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNombre(String aNombre)
  {
    boolean wasSet = false;
    nombre = aNombre;
    wasSet = true;
    return wasSet;
  }

  public boolean setEstaConsumiendoMedicacion(boolean aEstaConsumiendoMedicacion)
  {
    boolean wasSet = false;
    estaConsumiendoMedicacion = aEstaConsumiendoMedicacion;
    wasSet = true;
    return wasSet;
  }

  public boolean setObservacion(String aObservacion)
  {
    boolean wasSet = false;
    observacion = aObservacion;
    wasSet = true;
    return wasSet;
  }

  public String getNombre()
  {
    return nombre;
  }

  public boolean getEstaConsumiendoMedicacion()
  {
    return estaConsumiendoMedicacion;
  }

  public String getObservacion()
  {
    return observacion;
  }
  /* Code from template attribute_IsBoolean */
  public boolean isEstaConsumiendoMedicacion()
  {
    return estaConsumiendoMedicacion;
  }
  /* Code from template association_GetOne */
  public Persona getPersona()
  {
    return persona;
  }
  /* Code from template association_SetOneToMany */
  public boolean setPersona(Persona aPersona)
  {
    boolean wasSet = false;
    if (aPersona == null)
    {
      return wasSet;
    }

    Persona existingPersona = persona;
    persona = aPersona;
    if (existingPersona != null && !existingPersona.equals(aPersona))
    {
      existingPersona.removeEnfermedade(this);
    }
    persona.addEnfermedade(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Persona placeholderPersona = persona;
    this.persona = null;
    if(placeholderPersona != null)
    {
      placeholderPersona.removeEnfermedade(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "nombre" + ":" + getNombre()+ "," +
            "estaConsumiendoMedicacion" + ":" + getEstaConsumiendoMedicacion()+ "," +
            "observacion" + ":" + getObservacion()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "persona = "+(getPersona()!=null?Integer.toHexString(System.identityHashCode(getPersona())):"null");
  }
}