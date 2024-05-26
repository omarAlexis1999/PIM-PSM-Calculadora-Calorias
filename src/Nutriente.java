/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.util.*;

// line 52 "model.ump"
// line 120 "model.ump"
public class Nutriente
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Nutriente Attributes
  private String tipo_nutriente;
  private String nombre;
  private double valor;

  //Nutriente Associations
  private List<Alimento> alimentos;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Nutriente(String aTipo_nutriente, String aNombre, double aValor)
  {
    tipo_nutriente = aTipo_nutriente;
    nombre = aNombre;
    valor = aValor;
    alimentos = new ArrayList<Alimento>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTipo_nutriente(String aTipo_nutriente)
  {
    boolean wasSet = false;
    tipo_nutriente = aTipo_nutriente;
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

  public boolean setValor(double aValor)
  {
    boolean wasSet = false;
    valor = aValor;
    wasSet = true;
    return wasSet;
  }

  public String getTipo_nutriente()
  {
    return tipo_nutriente;
  }

  public String getNombre()
  {
    return nombre;
  }

  public double getValor()
  {
    return valor;
  }
  /* Code from template association_GetMany */
  public Alimento getAlimento(int index)
  {
    Alimento aAlimento = alimentos.get(index);
    return aAlimento;
  }

  public List<Alimento> getAlimentos()
  {
    List<Alimento> newAlimentos = Collections.unmodifiableList(alimentos);
    return newAlimentos;
  }

  public int numberOfAlimentos()
  {
    int number = alimentos.size();
    return number;
  }

  public boolean hasAlimentos()
  {
    boolean has = alimentos.size() > 0;
    return has;
  }

  public int indexOfAlimento(Alimento aAlimento)
  {
    int index = alimentos.indexOf(aAlimento);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAlimentos()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Alimento addAlimento(String aTipo, String aNombre, double aCalorias, double aProteinas, double aCarbohidratos, double aGrasas, double aFibra, String aUnidadMedida)
  {
    return new Alimento(aTipo, aNombre, aCalorias, aProteinas, aCarbohidratos, aGrasas, aFibra, aUnidadMedida, this);
  }

  public boolean addAlimento(Alimento aAlimento)
  {
    boolean wasAdded = false;
    if (alimentos.contains(aAlimento)) { return false; }
    Nutriente existingNutriente = aAlimento.getNutriente();
    boolean isNewNutriente = existingNutriente != null && !this.equals(existingNutriente);
    if (isNewNutriente)
    {
      aAlimento.setNutriente(this);
    }
    else
    {
      alimentos.add(aAlimento);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAlimento(Alimento aAlimento)
  {
    boolean wasRemoved = false;
    //Unable to remove aAlimento, as it must always have a nutriente
    if (!this.equals(aAlimento.getNutriente()))
    {
      alimentos.remove(aAlimento);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addAlimentoAt(Alimento aAlimento, int index)
  {  
    boolean wasAdded = false;
    if(addAlimento(aAlimento))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAlimentos()) { index = numberOfAlimentos() - 1; }
      alimentos.remove(aAlimento);
      alimentos.add(index, aAlimento);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAlimentoAt(Alimento aAlimento, int index)
  {
    boolean wasAdded = false;
    if(alimentos.contains(aAlimento))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAlimentos()) { index = numberOfAlimentos() - 1; }
      alimentos.remove(aAlimento);
      alimentos.add(index, aAlimento);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAlimentoAt(aAlimento, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=alimentos.size(); i > 0; i--)
    {
      Alimento aAlimento = alimentos.get(i - 1);
      aAlimento.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "tipo_nutriente" + ":" + getTipo_nutriente()+ "," +
            "nombre" + ":" + getNombre()+ "," +
            "valor" + ":" + getValor()+ "]";
  }
}