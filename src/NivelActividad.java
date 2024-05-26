/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.sql.Date;

// line 20 "model.ump"
// line 102 "model.ump"
public class NivelActividad
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //NivelActividad Attributes
  private String nombre;
  private String descripcion;
  private Date rangoInicioDia;
  private Date rangoFinalDia;

  //NivelActividad Associations
  private Persona persona;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public NivelActividad(String aNombre, String aDescripcion, Date aRangoInicioDia, Date aRangoFinalDia, Persona aPersona)
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

  public boolean setRangoInicioDia(Date aRangoInicioDia)
  {
    boolean wasSet = false;
    rangoInicioDia = aRangoInicioDia;
    wasSet = true;
    return wasSet;
  }

  public boolean setRangoFinalDia(Date aRangoFinalDia)
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

  public Date getRangoInicioDia()
  {
    return rangoInicioDia;
  }

  public Date getRangoFinalDia()
  {
    return rangoFinalDia;
  }
  /* Code from template association_GetOne */
  public Persona getPersona()
  {
    return persona;
  }
  /* Code from template association_SetOneToMandatoryMany */
  public boolean setPersona(Persona aPersona)
  {
    boolean wasSet = false;
    //Must provide persona to nivelActividad
    if (aPersona == null)
    {
      return wasSet;
    }

    if (persona != null && persona.numberOfNivelActividads() <= Persona.minimumNumberOfNivelActividads())
    {
      return wasSet;
    }

    Persona existingPersona = persona;
    persona = aPersona;
    if (existingPersona != null && !existingPersona.equals(aPersona))
    {
      boolean didRemove = existingPersona.removeNivelActividad(this);
      if (!didRemove)
      {
        persona = existingPersona;
        return wasSet;
      }
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

  // line 27 "model.ump"
  public String getRangoDias(){
    return "";
  }


  public String toString()
  {
    return super.toString() + "["+
            "nombre" + ":" + getNombre()+ "," +
            "descripcion" + ":" + getDescripcion()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "rangoInicioDia" + "=" + (getRangoInicioDia() != null ? !getRangoInicioDia().equals(this)  ? getRangoInicioDia().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "rangoFinalDia" + "=" + (getRangoFinalDia() != null ? !getRangoFinalDia().equals(this)  ? getRangoFinalDia().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "persona = "+(getPersona()!=null?Integer.toHexString(System.identityHashCode(getPersona())):"null");
  }
}