/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.util.*;
import java.sql.Date;

// line 27 "model.ump"
// line 70 "model.ump"
// line 110 "model.ump"
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
  private List<Ingesta> ingestas;
  private List<Nutriente> nutrientes;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Alimento(String aTipo, String aNombre, double aCalorias, double aProteinas, double aCarbohidratos, double aGrasas, double aFibra, String aUnidadMedida)
  {
    tipo = aTipo;
    nombre = aNombre;
    calorias = aCalorias;
    proteinas = aProteinas;
    carbohidratos = aCarbohidratos;
    grasas = aGrasas;
    fibra = aFibra;
    unidadMedida = aUnidadMedida;
    ingestas = new ArrayList<Ingesta>();
    nutrientes = new ArrayList<Nutriente>();
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
  /* Code from template association_GetMany */
  public Nutriente getNutriente(int index)
  {
    Nutriente aNutriente = nutrientes.get(index);
    return aNutriente;
  }

  public List<Nutriente> getNutrientes()
  {
    List<Nutriente> newNutrientes = Collections.unmodifiableList(nutrientes);
    return newNutrientes;
  }

  public int numberOfNutrientes()
  {
    int number = nutrientes.size();
    return number;
  }

  public boolean hasNutrientes()
  {
    boolean has = nutrientes.size() > 0;
    return has;
  }

  public int indexOfNutriente(Nutriente aNutriente)
  {
    int index = nutrientes.indexOf(aNutriente);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfIngestas()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Ingesta addIngesta(int aUnidades, double aCaloria, String aDenominacionCaloria, Date aFecha, Persona aPersona, ComidaDia aComidaDia)
  {
    return new Ingesta(aUnidades, aCaloria, aDenominacionCaloria, aFecha, aPersona, this, aComidaDia);
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfNutrientes()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Nutriente addNutriente(String aTipo_nutriente, String aNombre, double aValor)
  {
    return new Nutriente(aTipo_nutriente, aNombre, aValor, this);
  }

  public boolean addNutriente(Nutriente aNutriente)
  {
    boolean wasAdded = false;
    if (nutrientes.contains(aNutriente)) { return false; }
    Alimento existingAlimento = aNutriente.getAlimento();
    boolean isNewAlimento = existingAlimento != null && !this.equals(existingAlimento);
    if (isNewAlimento)
    {
      aNutriente.setAlimento(this);
    }
    else
    {
      nutrientes.add(aNutriente);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeNutriente(Nutriente aNutriente)
  {
    boolean wasRemoved = false;
    //Unable to remove aNutriente, as it must always have a alimento
    if (!this.equals(aNutriente.getAlimento()))
    {
      nutrientes.remove(aNutriente);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addNutrienteAt(Nutriente aNutriente, int index)
  {  
    boolean wasAdded = false;
    if(addNutriente(aNutriente))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfNutrientes()) { index = numberOfNutrientes() - 1; }
      nutrientes.remove(aNutriente);
      nutrientes.add(index, aNutriente);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveNutrienteAt(Nutriente aNutriente, int index)
  {
    boolean wasAdded = false;
    if(nutrientes.contains(aNutriente))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfNutrientes()) { index = numberOfNutrientes() - 1; }
      nutrientes.remove(aNutriente);
      nutrientes.add(index, aNutriente);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addNutrienteAt(aNutriente, index);
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
    for(int i=nutrientes.size(); i > 0; i--)
    {
      Nutriente aNutriente = nutrientes.get(i - 1);
      aNutriente.delete();
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
            "unidadMedida" + ":" + getUnidadMedida()+ "]";
  }
}