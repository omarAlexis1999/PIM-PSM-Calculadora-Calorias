/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.sql.Time;

// line 65 "model.ump"
// line 125 "model.ump"
public class ComidaDia
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ComidaDia Attributes
  private String nombreTipoComida;
  private Time hora;

  //ComidaDia Associations
  private Ingesta ingesta;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ComidaDia(String aNombreTipoComida, Time aHora, Ingesta aIngesta)
  {
    nombreTipoComida = aNombreTipoComida;
    hora = aHora;
    boolean didAddIngesta = setIngesta(aIngesta);
    if (!didAddIngesta)
    {
      throw new RuntimeException("Unable to create comidaDia due to ingesta. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
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
  /* Code from template association_GetOne */
  public Ingesta getIngesta()
  {
    return ingesta;
  }
  /* Code from template association_SetOneToMany */
  public boolean setIngesta(Ingesta aIngesta)
  {
    boolean wasSet = false;
    if (aIngesta == null)
    {
      return wasSet;
    }

    Ingesta existingIngesta = ingesta;
    ingesta = aIngesta;
    if (existingIngesta != null && !existingIngesta.equals(aIngesta))
    {
      existingIngesta.removeComidaDia(this);
    }
    ingesta.addComidaDia(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Ingesta placeholderIngesta = ingesta;
    this.ingesta = null;
    if(placeholderIngesta != null)
    {
      placeholderIngesta.removeComidaDia(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "nombreTipoComida" + ":" + getNombreTipoComida()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "hora" + "=" + (getHora() != null ? !getHora().equals(this)  ? getHora().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "ingesta = "+(getIngesta()!=null?Integer.toHexString(System.identityHashCode(getIngesta())):"null");
  }
}