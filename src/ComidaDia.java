/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.sql.Time;
import java.util.*;
import java.sql.Date;

// line 44 "model.ump"
// line 75 "model.ump"
// line 83 "model.ump"
// line 122 "model.ump"
public class ComidaDia
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ComidaDia Attributes
  private String nombreTipoComida;
  private Time hora;

  //ComidaDia Associations
  private List<Ingesta> ingestas;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ComidaDia(String aNombreTipoComida, Time aHora)
  {
    nombreTipoComida = aNombreTipoComida;
    hora = aHora;
    ingestas = new ArrayList<Ingesta>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNombreTipoComida(String aNombreTipoComida)
  {
    boolean wasSet = false;
    nombreTipoComida = aNombreTipoComida;
    wasSet = true;
    return wasSet;
  }

  public boolean setHora(Time aHora)
  {
    boolean wasSet = false;
    hora = aHora;
    wasSet = true;
    return wasSet;
  }

  public String getNombreTipoComida()
  {
    return nombreTipoComida;
  }

  public Time getHora()
  {
    return hora;
  }
  /* Code from template association_GetMany */
  public Ingesta getIngesta(int index)
  {
    Ingesta aIngesta = ingestas.get(index);
    return aIngesta;
  }

  public List<Ingesta> getIngestas()
  {
    List<Ingesta> newIngestas = Collections.unmodifiableList(ingestas);
    return newIngestas;
  }

  public int numberOfIngestas()
  {
    int number = ingestas.size();
    return number;
  }

  public boolean hasIngestas()
  {
    boolean has = ingestas.size() > 0;
    return has;
  }

  public int indexOfIngesta(Ingesta aIngesta)
  {
    int index = ingestas.indexOf(aIngesta);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfIngestas()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Ingesta addIngesta(int aUnidades, double aCaloria, String aDenominacionCaloria, Date aFecha, Persona aPersona, Alimento aAlimento)
  {
    return new Ingesta(aUnidades, aCaloria, aDenominacionCaloria, aFecha, aPersona, aAlimento, this);
  }

  public boolean addIngesta(Ingesta aIngesta)
  {
    boolean wasAdded = false;
    if (ingestas.contains(aIngesta)) { return false; }
    ComidaDia existingComidaDia = aIngesta.getComidaDia();
    boolean isNewComidaDia = existingComidaDia != null && !this.equals(existingComidaDia);
    if (isNewComidaDia)
    {
      aIngesta.setComidaDia(this);
    }
    else
    {
      ingestas.add(aIngesta);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeIngesta(Ingesta aIngesta)
  {
    boolean wasRemoved = false;
    //Unable to remove aIngesta, as it must always have a comidaDia
    if (!this.equals(aIngesta.getComidaDia()))
    {
      ingestas.remove(aIngesta);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addIngestaAt(Ingesta aIngesta, int index)
  {  
    boolean wasAdded = false;
    if(addIngesta(aIngesta))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIngestas()) { index = numberOfIngestas() - 1; }
      ingestas.remove(aIngesta);
      ingestas.add(index, aIngesta);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveIngestaAt(Ingesta aIngesta, int index)
  {
    boolean wasAdded = false;
    if(ingestas.contains(aIngesta))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIngestas()) { index = numberOfIngestas() - 1; }
      ingestas.remove(aIngesta);
      ingestas.add(index, aIngesta);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addIngestaAt(aIngesta, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=ingestas.size(); i > 0; i--)
    {
      Ingesta aIngesta = ingestas.get(i - 1);
      aIngesta.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "nombreTipoComida" + ":" + getNombreTipoComida()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "hora" + "=" + (getHora() != null ? !getHora().equals(this)  ? getHora().toString().replaceAll("  ","    ") : "this" : "null");
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------

  
}