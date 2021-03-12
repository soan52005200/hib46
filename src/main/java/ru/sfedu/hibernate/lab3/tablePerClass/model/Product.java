package ru.sfedu.hibernate.lab3.tablePerClass.model;



import ru.sfedu.hibernate.lab3.tablePerClass.model.ProductType;

import javax.persistence.*;
import java.util.Date;

/**
 * Class Product
 */
@Entity
@Table(schema = "lab3_tpc")

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Product {

  //
  // Fields
  //

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;
 @Temporal(TemporalType.TIME)
  protected Date receiptDate;

  protected String name;

  protected String manufacturer;

  protected Integer ageLimit;
 @Enumerated(EnumType.STRING)
  protected ProductType type;
  
  //
  // Constructors
  //
  public Product () { };

  public Product(Date receiptDate, String name, String manufacturer, Integer ageLimit, ProductType type) {
    this.receiptDate = receiptDate;
    this.name = name;
    this.manufacturer = manufacturer;
    this.ageLimit = ageLimit;
    this.type = type;
  }

  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of id
   * @param newVar the new value of id
   */
  public void setId (Long newVar) {
    id = newVar;
  }

  /**
   * Get the value of id
   * @return the value of id
   */
  public Long getId () {
    return id;
  }

  /**
   * Set the value of receiptDate
   * @param newVar the new value of receiptDate
   */
  public void setReceiptDate (Date newVar) {
    receiptDate = newVar;
  }

  /**
   * Get the value of receiptDate
   * @return the value of receiptDate
   */
  public Date getReceiptDate () {
    return receiptDate;
  }

  /**
   * Set the value of name
   * @param newVar the new value of name
   */
  public void setName (String newVar) {
    name = newVar;
  }

  /**
   * Get the value of name
   * @return the value of name
   */
  public String getName () {
    return name;
  }

  /**
   * Set the value of manufacturer
   * @param newVar the new value of manufacturer
   */
  public void setManufacturer (String newVar) {
    manufacturer = newVar;
  }

  /**
   * Get the value of manufacturer
   * @return the value of manufacturer
   */
  public String getManufacturer () {
    return manufacturer;
  }

  /**
   * Set the value of ageLimit
   * @param newVar the new value of ageLimit
   */
  public void setAgeLimit (Integer newVar) {
    ageLimit = newVar;
  }

  /**
   * Get the value of ageLimit
   * @return the value of ageLimit
   */
  public Integer getAgeLimit () {
    return ageLimit;
  }

  public ProductType getType() {
    return type;
  }

  public void setType(ProductType type) {
    this.type = type;
  }

//
  // Other methods
  //

}
