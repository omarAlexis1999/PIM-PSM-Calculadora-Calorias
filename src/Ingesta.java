/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.sql.Date;

// line 20 "model.ump"
// line 105 "model.ump"
public class Ingesta
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Ingesta Attributes
  private int unidades;
  private double caloria;
  private String denominacionCaloria;
  private Date fecha;

  //Ingesta Associations
  private Persona persona;
  private Alimento alimento;
  private ComidaDia comidaDia;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Ingesta(int aUnidades, double aCaloria, String aDenominacionCaloria, Date aFecha, Persona aPersona, Alimento aAlimento, ComidaDia aComidaDia)
  {
    unidades = aUnidades;
    caloria = aCaloria;
    denominacionCaloria = aDenominacionCaloria;
    fecha = aFecha;
    boolean didAddPersona = setPersona(aPersona);
    if (!didAddPersona)
    {
      throw new RuntimeException("Unable to create ingesta due to persona. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddAlimento = setAlimento(aAlimento);
    if (!didAddAlimento)
    {
      throw new RuntimeException("Unable to create ingesta due to alimento. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddComidaDia = setComidaDia(aComidaDia);
    if (!didAddComidaDia)
    {
      throw new RuntimeException("Unable to create ingesta due to comidaDia. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setUnidades(int aUnidades)
  {
    boolean wasSet = false;
    unidades = aUnidades;
    wasSet = true;
    return wasSet;
  }

  public boolean setCaloria(double aCaloria)
  {
    boolean wasSet = false;
    caloria = aCaloria;
    wasSet = true;
    return wasSet;
  }

  public boolean setDenominacionCaloria(String aDenominacionCaloria)
  {
    boolean wasSet = false;
    denominacionCaloria = aDenominacionCaloria;
    wasSet = true;
    return wasSet;
  }

  public boolean setFecha(Date aFecha)
  {
    boolean wasSet = false;
    fecha = aFecha;
    wasSet = true;
    return wasSet;
  }

  public int getUnidades()
  {
    return unidades;
  }

  public double getCaloria()
  {
    return caloria;
  }

  public String getDenominacionCaloria()
  {
    return denominacionCaloria;
  }

  public Date getFecha()
  {
    return fecha;
  }
  /* Code from template association_GetOne */
  public Persona getPersona()
  {
    return persona;
  }
  /* Code from template association_GetOne */
  public Alimento getAlimento()
  {
    return alimento;
  }
  /* Code from template association_GetOne */
  public ComidaDia getComidaDia()
  {
    return comidaDia;
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
      existingPersona.removeIngesta(this);
    }
    persona.addIngesta(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setAlimento(Alimento aAlimento)
  {
    boolean wasSet = false;
    if (aAlimento == null)
    {
      return wasSet;
    }

    Alimento existingAlimento = alimento;
    alimento = aAlimento;
    if (existingAlimento != null && !existingAlimento.equals(aAlimento))
    {
      existingAlimento.removeIngesta(this);
    }
    alimento.addIngesta(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setComidaDia(ComidaDia aComidaDia)
  {
    boolean wasSet = false;
    if (aComidaDia == null)
    {
      return wasSet;
    }

    ComidaDia existingComidaDia = comidaDia;
    comidaDia = aComidaDia;
    if (existingComidaDia != null && !existingComidaDia.equals(aComidaDia))
    {
      existingComidaDia.removeIngesta(this);
    }
    comidaDia.addIngesta(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Persona placeholderPersona = persona;
    this.persona = null;
    if(placeholderPersona != null)
    {
      placeholderPersona.removeIngesta(this);
    }
    Alimento placeholderAlimento = alimento;
    this.alimento = null;
    if(placeholderAlimento != null)
    {
      placeholderAlimento.removeIngesta(this);
    }
    ComidaDia placeholderComidaDia = comidaDia;
    this.comidaDia = null;
    if(placeholderComidaDia != null)
    {
      placeholderComidaDia.removeIngesta(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "unidades" + ":" + getUnidades()+ "," +
            "caloria" + ":" + getCaloria()+ "," +
            "denominacionCaloria" + ":" + getDenominacionCaloria()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "fecha" + "=" + (getFecha() != null ? !getFecha().equals(this)  ? getFecha().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "persona = "+(getPersona()!=null?Integer.toHexString(System.identityHashCode(getPersona())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "alimento = "+(getAlimento()!=null?Integer.toHexString(System.identityHashCode(getAlimento())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "comidaDia = "+(getComidaDia()!=null?Integer.toHexString(System.identityHashCode(getComidaDia())):"null");
  }
}