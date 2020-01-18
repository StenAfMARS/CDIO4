package Chancecard;

 abstract class ModelChanceCard {
  private int _iD;

  /**
   * ModelChanceCard() used for making a model of a chance card.
   * @param iD chance card ID
   */
  ModelChanceCard(int iD) {
   this._iD = iD;
  }

  /**
   * get_iD() used for getting the chance card ID.
   * @return private attribute _iD. The ID of a chance card.
   */
  public int get_iD() {
   return _iD;
  }
 }

