package ru.sfedu.hibernate.lab3.mappedSuperclass.model;



import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import java.lang.reflect.Type;
import java.util.Date;

import static javax.persistence.TemporalType.TIME;

/**
 * Class Eatable
 */

@Entity
@Table(schema = "lab3_mp")
public class Eatable extends Product {

  //
  // Fields
  // /@Date
  @Temporal(TIME)
  private Date bestBefore;
  
  //
  // Constructors
  //
  public Eatable () { };

  public Eatable(Date receiptDate, String name, String manufacturer, Integer ageLimit, Date bestBefore) {
    super(receiptDate, name, manufacturer, ageLimit, ProductType.EATABLE);
    this.bestBefore = bestBefore;
  }

  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of bestBefore
   * @param newVar the new value of bestBefore
   */
  public void setBestBefore (Date newVar) {
    bestBefore = newVar;
  }

  /**
   * Get the value of bestBefore
   * @return the value of bestBefore
   */
  public Date getBestBefore () {
    return bestBefore;
  }

  //
  // Other methods
  //


  @Override
  public String toString() {
    return "Eatable{" +
            "bestBefore=" + bestBefore +
            ", id=" + id +
            ", receiptDate=" + receiptDate +
            ", name='" + name + '\'' +
            ", manufacturer='" + manufacturer + '\'' +
            ", ageLimit=" + ageLimit +
            ", type=" + type +
            '}';
  }
}
