package ru.sfedu.hibernate.lab3.singleTable.model;



import ru.sfedu.hibernate.lab3.singleTable.model.Product;
import ru.sfedu.hibernate.lab3.singleTable.model.ProductType;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Class Uneatable
 */
@Entity
//@Table(schema = "lab3_st")
public class Uneatable extends Product {

  //
  // Fields
  //

  
  //
  // Constructors
  //
  public Uneatable() { };

  public Uneatable(Date receiptDate, String name, String manufacturer, Integer ageLimit) {
    super(receiptDate, name, manufacturer, ageLimit, ProductType.UNEATABLE);
  }
  //
  // Methods
  //


  //
  // Accessor methods
  //

  //
  // Other methods
  //


  @Override
  public String toString() {
    return "Uneatable{" +
            "id=" + id +
            ", receiptDate=" + receiptDate +
            ", name='" + name + '\'' +
            ", manufacturer='" + manufacturer + '\'' +
            ", ageLimit=" + ageLimit +
            ", type=" + type +
            '}';
  }
}
