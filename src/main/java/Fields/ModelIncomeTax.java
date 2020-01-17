package Fields;

import java.awt.*;
class ModelIncomeTax extends ModelField {
 private int _rent;

 /**
  * ModelIncomeTax used to make a model for the income tax field.
  * @param name name of the field.
  * @param backgroundColor background color of the field.
  * @param rent rent of the field.
  */
 public ModelIncomeTax(String name, Color backgroundColor, int rent) {
  super(name, backgroundColor);
  this._rent = rent;
 }
}
