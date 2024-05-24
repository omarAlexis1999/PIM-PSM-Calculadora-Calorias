/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/



// line 38 "model.ump"
// line 79 "model.ump"
// line 117 "model.ump"
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
  private Alimento alimento;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Nutriente(String aTipo_nutriente, String aNombre, double aValor, Alimento aAlimento)
  {
    tipo_nutriente = aTipo_nutriente;
    nombre = aNombre;
    valor = aValor;
    boolean didAddAlimento = setAlimento(aAlimento);
    if (!didAddAlimento)
    {
      throw new RuntimeException("Unable to create nutriente due to alimento. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
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
  /* Code from template association_GetOne */
  public Alimento getAlimento()
  {
    return alimento;
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
      existingAlimento.removeNutriente(this);
    }
    alimento.addNutriente(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Alimento placeholderAlimento = alimento;
    this.alimento = null;
    if(placeholderAlimento != null)
    {
      placeholderAlimento.removeNutriente(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "tipo_nutriente" + ":" + getTipo_nutriente()+ "," +
            "nombre" + ":" + getNombre()+ "," +
            "valor" + ":" + getValor()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "alimento = "+(getAlimento()!=null?Integer.toHexString(System.identityHashCode(getAlimento())):"null");
  }

  
}