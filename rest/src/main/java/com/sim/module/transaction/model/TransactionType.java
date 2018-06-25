package com.sim.module.transaction.model;

public class TransactionType {
  private TransactionCode code;
  private String label;
  private String description;

  public TransactionCode getCode() {
    return code;
  }

  public void setCode(TransactionCode code) {
    this.code = code;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "TransactionType{" +
        "code=" + code +
        ", label='" + label + '\'' +
        ", description='" + description + '\'' +
        '}';
  }
}
