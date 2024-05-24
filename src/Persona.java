/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.sql.Date;
import java.util.*;

/**
 * Relaciones
 */
// line 2 "model.ump"
// line 63 "model.ump"
// line 91 "model.ump"
public class Persona
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Persona Attributes
  private String nombres;
  private Date fechaNacimiento;
  private double peso;
  private double altura;
  private String sexo;

  //Persona Associations
  private InformacionMedica informacionMedica;
  private List<Enfermedades> enfermedades;
  private List<Ingesta> ingestas;
  private List<NivelActividad> nivelActividads;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Persona(String aNombres, Date aFechaNacimiento, double aPeso, double aAltura, String aSexo, InformacionMedica aInformacionMedica)
  {
    nombres = aNombres;
    fechaNacimiento = aFechaNacimiento;
    peso = aPeso;
    altura = aAltura;
    sexo = aSexo;
    if (aInformacionMedica == null || aInformacionMedica.getPersona() != null)
    {
      throw new RuntimeException("Unable to create Persona due to aInformacionMedica. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    informacionMedica = aInformacionMedica;
    enfermedades = new ArrayList<Enfermedades>();
    ingestas = new ArrayList<Ingesta>();
    nivelActividads = new ArrayList<NivelActividad>();
  }

  public Persona(String aNombres, Date aFechaNacimiento, double aPeso, double aAltura, String aSexo, String aDensidadCaloricaForInformacionMedica, String aIndiceGlucemicoForInformacionMedica)
  {
    nombres = aNombres;
    fechaNacimiento = aFechaNacimiento;
    peso = aPeso;
    altura = aAltura;
    sexo = aSexo;
    informacionMedica = new InformacionMedica(aDensidadCaloricaForInformacionMedica, aIndiceGlucemicoForInformacionMedica, this);
    enfermedades = new ArrayList<Enfermedades>();
    ingestas = new ArrayList<Ingesta>();
    nivelActividads = new ArrayList<NivelActividad>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNombres(String aNombres)
  {
    boolean wasSet = false;
    nombres = aNombres;
    wasSet = true;
    return wasSet;
  }

  public boolean setFechaNacimiento(Date aFechaNacimiento)
  {
    boolean wasSet = false;
    fechaNacimiento = aFechaNacimiento;
    wasSet = true;
    return wasSet;
  }

  public boolean setPeso(double aPeso)
  {
    boolean wasSet = false;
    peso = aPeso;
    wasSet = true;
    return wasSet;
  }

  public boolean setAltura(double aAltura)
  {
    boolean wasSet = false;
    altura = aAltura;
    wasSet = true;
    return wasSet;
  }

  public boolean setSexo(String aSexo)
  {
    boolean wasSet = false;
    sexo = aSexo;
    wasSet = true;
    return wasSet;
  }

  public String getNombres()
  {
    return nombres;
  }

  public Date getFechaNacimiento()
  {
    return fechaNacimiento;
  }

  public double getPeso()
  {
    return peso;
  }

  public double getAltura()
  {
    return altura;
  }

  public String getSexo()
  {
    return sexo;
  }
  /* Code from template association_GetOne */
  public InformacionMedica getInformacionMedica()
  {
    return informacionMedica;
  }
  /* Code from template association_GetMany */
  public Enfermedades getEnfermedade(int index)
  {
    Enfermedades aEnfermedade = enfermedades.get(index);
    return aEnfermedade;
  }

  public List<Enfermedades> getEnfermedades()
  {
    List<Enfermedades> newEnfermedades = Collections.unmodifiableList(enfermedades);
    return newEnfermedades;
  }

  public int numberOfEnfermedades()
  {
    int number = enfermedades.size();
    return number;
  }

  public boolean hasEnfermedades()
  {
    boolean has = enfermedades.size() > 0;
    return has;
  }

  public int indexOfEnfermedade(Enfermedades aEnfermedade)
  {
    int index = enfermedades.indexOf(aEnfermedade);
    return index;
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
  public NivelActividad getNivelActividad(int index)
  {
    NivelActividad aNivelActividad = nivelActividads.get(index);
    return aNivelActividad;
  }

  public List<NivelActividad> getNivelActividads()
  {
    List<NivelActividad> newNivelActividads = Collections.unmodifiableList(nivelActividads);
    return newNivelActividads;
  }

  public int numberOfNivelActividads()
  {
    int number = nivelActividads.size();
    return number;
  }

  public boolean hasNivelActividads()
  {
    boolean has = nivelActividads.size() > 0;
    return has;
  }

  public int indexOfNivelActividad(NivelActividad aNivelActividad)
  {
    int index = nivelActividads.indexOf(aNivelActividad);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfEnfermedades()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Enfermedades addEnfermedade(String aNombre, boolean aEstaConsumiendoMedicacion, String aObservacion)
  {
    return new Enfermedades(aNombre, aEstaConsumiendoMedicacion, aObservacion, this);
  }

  public boolean addEnfermedade(Enfermedades aEnfermedade)
  {
    boolean wasAdded = false;
    if (enfermedades.contains(aEnfermedade)) { return false; }
    Persona existingPersona = aEnfermedade.getPersona();
    boolean isNewPersona = existingPersona != null && !this.equals(existingPersona);
    if (isNewPersona)
    {
      aEnfermedade.setPersona(this);
    }
    else
    {
      enfermedades.add(aEnfermedade);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeEnfermedade(Enfermedades aEnfermedade)
  {
    boolean wasRemoved = false;
    //Unable to remove aEnfermedade, as it must always have a persona
    if (!this.equals(aEnfermedade.getPersona()))
    {
      enfermedades.remove(aEnfermedade);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addEnfermedadeAt(Enfermedades aEnfermedade, int index)
  {  
    boolean wasAdded = false;
    if(addEnfermedade(aEnfermedade))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEnfermedades()) { index = numberOfEnfermedades() - 1; }
      enfermedades.remove(aEnfermedade);
      enfermedades.add(index, aEnfermedade);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveEnfermedadeAt(Enfermedades aEnfermedade, int index)
  {
    boolean wasAdded = false;
    if(enfermedades.contains(aEnfermedade))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEnfermedades()) { index = numberOfEnfermedades() - 1; }
      enfermedades.remove(aEnfermedade);
      enfermedades.add(index, aEnfermedade);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addEnfermedadeAt(aEnfermedade, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfIngestas()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Ingesta addIngesta(int aUnidades, double aCaloria, String aDenominacionCaloria, Date aFecha, Alimento aAlimento, ComidaDia aComidaDia)
  {
    return new Ingesta(aUnidades, aCaloria, aDenominacionCaloria, aFecha, this, aAlimento, aComidaDia);
  }

  public boolean addIngesta(Ingesta aIngesta)
  {
    boolean wasAdded = false;
    if (ingestas.contains(aIngesta)) { return false; }
    Persona existingPersona = aIngesta.getPersona();
    boolean isNewPersona = existingPersona != null && !this.equals(existingPersona);
    if (isNewPersona)
    {
      aIngesta.setPersona(this);
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
    //Unable to remove aIngesta, as it must always have a persona
    if (!this.equals(aIngesta.getPersona()))
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
  public static int minimumNumberOfNivelActividads()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public NivelActividad addNivelActividad(String aNombre, String aDescripcion, int aRangoInicioDia, int aRangoFinalDia)
  {
    return new NivelActividad(aNombre, aDescripcion, aRangoInicioDia, aRangoFinalDia, this);
  }

  public boolean addNivelActividad(NivelActividad aNivelActividad)
  {
    boolean wasAdded = false;
    if (nivelActividads.contains(aNivelActividad)) { return false; }
    Persona existingPersona = aNivelActividad.getPersona();
    boolean isNewPersona = existingPersona != null && !this.equals(existingPersona);
    if (isNewPersona)
    {
      aNivelActividad.setPersona(this);
    }
    else
    {
      nivelActividads.add(aNivelActividad);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeNivelActividad(NivelActividad aNivelActividad)
  {
    boolean wasRemoved = false;
    //Unable to remove aNivelActividad, as it must always have a persona
    if (!this.equals(aNivelActividad.getPersona()))
    {
      nivelActividads.remove(aNivelActividad);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addNivelActividadAt(NivelActividad aNivelActividad, int index)
  {  
    boolean wasAdded = false;
    if(addNivelActividad(aNivelActividad))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfNivelActividads()) { index = numberOfNivelActividads() - 1; }
      nivelActividads.remove(aNivelActividad);
      nivelActividads.add(index, aNivelActividad);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveNivelActividadAt(NivelActividad aNivelActividad, int index)
  {
    boolean wasAdded = false;
    if(nivelActividads.contains(aNivelActividad))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfNivelActividads()) { index = numberOfNivelActividads() - 1; }
      nivelActividads.remove(aNivelActividad);
      nivelActividads.add(index, aNivelActividad);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addNivelActividadAt(aNivelActividad, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    InformacionMedica existingInformacionMedica = informacionMedica;
    informacionMedica = null;
    if (existingInformacionMedica != null)
    {
      existingInformacionMedica.delete();
    }
    for(int i=enfermedades.size(); i > 0; i--)
    {
      Enfermedades aEnfermedade = enfermedades.get(i - 1);
      aEnfermedade.delete();
    }
    for(int i=ingestas.size(); i > 0; i--)
    {
      Ingesta aIngesta = ingestas.get(i - 1);
      aIngesta.delete();
    }
    for(int i=nivelActividads.size(); i > 0; i--)
    {
      NivelActividad aNivelActividad = nivelActividads.get(i - 1);
      aNivelActividad.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "nombres" + ":" + getNombres()+ "," +
            "peso" + ":" + getPeso()+ "," +
            "altura" + ":" + getAltura()+ "," +
            "sexo" + ":" + getSexo()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "fechaNacimiento" + "=" + (getFechaNacimiento() != null ? !getFechaNacimiento().equals(this)  ? getFechaNacimiento().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "informacionMedica = "+(getInformacionMedica()!=null?Integer.toHexString(System.identityHashCode(getInformacionMedica())):"null");
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 8 "model.ump"
  int calcularEdad(){return 0;} ;
// line 9 "model.ump"
  Double calcularIMC(){return 0.0;};

  
}