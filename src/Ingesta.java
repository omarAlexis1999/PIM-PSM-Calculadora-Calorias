/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.sql.Date;
import java.util.*;
import java.sql.Time;

// line 30 "model.ump"
// line 107 "model.ump"
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
  private Alimento alimento;
  private Persona persona;
  private List<ComidaDia> comidaDias;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Ingesta(int aUnidades, double aCaloria, String aDenominacionCaloria, Date aFecha, Alimento aAlimento, Persona aPersona)
  {
    unidades = aUnidades;
    caloria = aCaloria;
    denominacionCaloria = aDenominacionCaloria;
    fecha = aFecha;
    boolean didAddAlimento = setAlimento(aAlimento);
    if (!didAddAlimento)
    {
      throw new RuntimeException("Unable to create ingesta due to alimento. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddPersona = setPersona(aPersona);
    if (!didAddPersona)
    {
      throw new RuntimeException("Unable to create ingesta due to persona. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    comidaDias = new ArrayList<ComidaDia>();
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
  public Alimento getAlimento()
  {
    return alimento;
  }
  /* Code from template association_GetOne */
  public Persona getPersona()
  {
    return persona;
  }
  /* Code from template association_GetMany */
  public ComidaDia getComidaDia(int index)
  {
    ComidaDia aComidaDia = comidaDias.get(index);
    return aComidaDia;
  }

  public List<ComidaDia> getComidaDias()
  {
    List<ComidaDia> newComidaDias = Collections.unmodifiableList(comidaDias);
    return newComidaDias;
  }

  public int numberOfComidaDias()
  {
    int number = comidaDias.size();
    return number;
  }

  public boolean hasComidaDias()
  {
    boolean has = comidaDias.size() > 0;
    return has;
  }

  public int indexOfComidaDia(ComidaDia aComidaDia)
  {
    int index = comidaDias.indexOf(aComidaDia);
    return index;
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfComidaDias()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public ComidaDia addComidaDia(String aNombreTipoComida, Time aHora)
  {
    return new ComidaDia(aNombreTipoComida, aHora, this);
  }

  public boolean addComidaDia(ComidaDia aComidaDia)
  {
    boolean wasAdded = false;
    if (comidaDias.contains(aComidaDia)) { return false; }
    Ingesta existingIngesta = aComidaDia.getIngesta();
    boolean isNewIngesta = existingIngesta != null && !this.equals(existingIngesta);
    if (isNewIngesta)
    {
      aComidaDia.setIngesta(this);
    }
    else
    {
      comidaDias.add(aComidaDia);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeComidaDia(ComidaDia aComidaDia)
  {
    boolean wasRemoved = false;
    //Unable to remove aComidaDia, as it must always have a ingesta
    if (!this.equals(aComidaDia.getIngesta()))
    {
      comidaDias.remove(aComidaDia);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addComidaDiaAt(ComidaDia aComidaDia, int index)
  {  
    boolean wasAdded = false;
    if(addComidaDia(aComidaDia))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfComidaDias()) { index = numberOfComidaDias() - 1; }
      comidaDias.remove(aComidaDia);
      comidaDias.add(index, aComidaDia);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveComidaDiaAt(ComidaDia aComidaDia, int index)
  {
    boolean wasAdded = false;
    if(comidaDias.contains(aComidaDia))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfComidaDias()) { index = numberOfComidaDias() - 1; }
      comidaDias.remove(aComidaDia);
      comidaDias.add(index, aComidaDia);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addComidaDiaAt(aComidaDia, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Alimento placeholderAlimento = alimento;
    this.alimento = null;
    if(placeholderAlimento != null)
    {
      placeholderAlimento.removeIngesta(this);
    }
    Persona placeholderPersona = persona;
    this.persona = null;
    if(placeholderPersona != null)
    {
      placeholderPersona.removeIngesta(this);
    }
    for(int i=comidaDias.size(); i > 0; i--)
    {
      ComidaDia aComidaDia = comidaDias.get(i - 1);
      aComidaDia.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "unidades" + ":" + getUnidades()+ "," +
            "caloria" + ":" + getCaloria()+ "," +
            "denominacionCaloria" + ":" + getDenominacionCaloria()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "fecha" + "=" + (getFecha() != null ? !getFecha().equals(this)  ? getFecha().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "alimento = "+(getAlimento()!=null?Integer.toHexString(System.identityHashCode(getAlimento())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "persona = "+(getPersona()!=null?Integer.toHexString(System.identityHashCode(getPersona())):"null");
  }
}