package com.sydneyzamoranos.pojo;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName(value = "data")
public class Subscribers {
  private int id;
  private String email;
  private String color;
  private String name;
}
