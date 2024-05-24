/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/



// line 12 "model.ump"
// line 100 "model.ump"
public class NivelActividad
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //NivelActividad Attributes
  private String nombre;
  private String descripcion;
  private int rangoInicioDia;
  private int rangoFinalDia;

  //NivelActividad Associations
  private Persona persona;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public NivelActividad(String aNombre, String aDescripcion, int aRangoInicioDia, int aRangoFinalDia, Persona aPersona)
  {
    nombre = aNombre;
    descripcion = aDescripcion;
    rangoInicioDia = aRangoInicioDia;
    rangoFinalDia = aRangoFinalDia;
    boolean didAddPersona = setPersona(aPersona);
    if (!didAddPersona)
    {
      throw new RuntimeException("Unable to create nivelActividad due to persona. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
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

  public boolean setDescripcion(String aDescripcion)
  {
    boolean wasSet = false;
    descripcion = aDescripcion;
    wasSet = true;
    return wasSet;
  }

  public boolean setRangoInicioDia(int aRangoInicioDia)
  {
    boolean wasSet = false;
    rangoInicioDia = aRangoInicioDia;
    wasSet = true;
    return wasSet;
  }

  public boolean setRangoFinalDia(int aRangoFinalDia)
  {
    boolean wasSet = false;
    rangoFinalDia = aRangoFinalDia;
    wasSet = true;
    return wasSet;
  }

  public String getNombre()
  {
    return nombre;
  }

  public String getDescripcion()
  {
    return descripcion;
  }

  public int getRangoInicioDia()
  {
    return rangoInicioDia;
  }

  public int getRangoFinalDia()
  {
    return rangoFinalDia;
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
      existingPersona.removeNivelActividad(this);
    }
    persona.addNivelActividad(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Persona placeholderPersona = persona;
    this.persona = null;
    if(placeholderPersona != null)
    {
      placeholderPersona.removeNivelActividad(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "nombre" + ":" + getNombre()+ "," +
            "descripcion" + ":" + getDescripcion()+ "," +
            "rangoInicioDia" + ":" + getRangoInicioDia()+ "," +
            "rangoFinalDia" + ":" + getRangoFinalDia()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "persona = "+(getPersona()!=null?Integer.toHexString(System.identityHashCode(getPersona())):"null");
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 17 "model.ump"
  String getRangoDias(){return "";}
  ;

  
}