/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.util.*;
import java.sql.Date;

// line 39 "model.ump"
// line 114 "model.ump"
public class Alimento
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Alimento Attributes
  private String tipo;
  private String nombre;
  private double calorias;
  private double proteinas;
  private double carbohidratos;
  private double grasas;
  private double fibra;
  private String unidadMedida;

  //Alimento Associations
  private Nutriente nutriente;
  private List<Ingesta> ingestas;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Alimento(String aTipo, String aNombre, double aCalorias, double aProteinas, double aCarbohidratos, double aGrasas, double aFibra, String aUnidadMedida, Nutriente aNutriente)
  {
    tipo = aTipo;
    nombre = aNombre;
    calorias = aCalorias;
    proteinas = aProteinas;
    carbohidratos = aCarbohidratos;
    grasas = aGrasas;
    fibra = aFibra;
    unidadMedida = aUnidadMedida;
    boolean didAddNutriente = setNutriente(aNutriente);
    if (!didAddNutriente)
    {
      throw new RuntimeException("Unable to create alimento due to nutriente. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    ingestas = new ArrayList<Ingesta>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTipo(String aTipo)
  {
    boolean wasSet = false;
    tipo = aTipo;
    wasSet = true;
    return wasSet;
  }

  public boolean setNombre(String aNombre)
  {
    boolean wasSet = false;
    nombre = aNombre;
    wasSet = true;
    return wasSet;
  }

  public boolean setCalorias(double aCalorias)
  {
    boolean wasSet = false;
    calorias = aCalorias;
    wasSet = true;
    return wasSet;
  }

  public boolean setProteinas(double aProteinas)
  {
    boolean wasSet = false;
    proteinas = aProteinas;
    wasSet = true;
    return wasSet;
  }

  public boolean setCarbohidratos(double aCarbohidratos)
  {
    boolean wasSet = false;
    carbohidratos = aCarbohidratos;
    wasSet = true;
    return wasSet;
  }

  public boolean setGrasas(double aGrasas)
  {
    boolean wasSet = false;
    grasas = aGrasas;
    wasSet = true;
    return wasSet;
  }

  public boolean setFibra(double aFibra)
  {
    boolean wasSet = false;
    fibra = aFibra;
    wasSet = true;
    return wasSet;
  }

  public boolean setUnidadMedida(String aUnidadMedida)
  {
    boolean wasSet = false;
    unidadMedida = aUnidadMedida;
    wasSet = true;
    return wasSet;
  }

  public String getTipo()
  {
    return tipo;
  }

  public String getNombre()
  {
    return nombre;
  }

  public double getCalorias()
  {
    return calorias;
  }

  public double getProteinas()
  {
    return proteinas;
  }

  public double getCarbohidratos()
  {
    return carbohidratos;
  }

  public double getGrasas()
  {
    return grasas;
  }

  public double getFibra()
  {
    return fibra;
  }

  public String getUnidadMedida()
  {
    return unidadMedida;
  }
  /* Code from template association_GetOne */
  public Nutriente getNutriente()
  {
    return nutriente;
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
  /* Code from template association_SetOneToMany */
  public boolean setNutriente(Nutriente aNutriente)
  {
    boolean wasSet = false;
    if (aNutriente == null)
    {
      return wasSet;
    }

    Nutriente existingNutriente = nutriente;
    nutriente = aNutriente;
    if (existingNutriente != null && !existingNutriente.equals(aNutriente))
    {
      existingNutriente.removeAlimento(this);
    }
    nutriente.addAlimento(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfIngestas()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Ingesta addIngesta(int aUnidades, double aCaloria, String aDenominacionCaloria, Date aFecha, Persona aPersona)
  {
    return new Ingesta(aUnidades, aCaloria, aDenominacionCaloria, aFecha, this, aPersona);
  }

  public boolean addIngesta(Ingesta aIngesta)
  {
    boolean wasAdded = false;
    if (ingestas.contains(aIngesta)) { return false; }
    Alimento existingAlimento = aIngesta.getAlimento();
    boolean isNewAlimento = existingAlimento != null && !this.equals(existingAlimento);
    if (isNewAlimento)
    {
      aIngesta.setAlimento(this);
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
    //Unable to remove aIngesta, as it must always have a alimento
    if (!this.equals(aIngesta.getAlimento()))
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
    Nutriente placeholderNutriente = nutriente;
    this.nutriente = null;
    if(placeholderNutriente != null)
    {
      placeholderNutriente.removeAlimento(this);
    }
    for(int i=ingestas.size(); i > 0; i--)
    {
      Ingesta aIngesta = ingestas.get(i - 1);
      aIngesta.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "tipo" + ":" + getTipo()+ "," +
            "nombre" + ":" + getNombre()+ "," +
            "calorias" + ":" + getCalorias()+ "," +
            "proteinas" + ":" + getProteinas()+ "," +
            "carbohidratos" + ":" + getCarbohidratos()+ "," +
            "grasas" + ":" + getGrasas()+ "," +
            "fibra" + ":" + getFibra()+ "," +
            "unidadMedida" + ":" + getUnidadMedida()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "nutriente = "+(getNutriente()!=null?Integer.toHexString(System.identityHashCode(getNutriente())):"null");
  }
}