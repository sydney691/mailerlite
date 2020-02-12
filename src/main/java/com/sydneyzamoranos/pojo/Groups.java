package com.sydneyzamoranos.pojo;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Groups {
  private int id;

  private String name;

  private int total;

  private int active;

  private int unsubscribed;

  private int bounced;

  private int unconfirmed;

  private int junk;

  private int sent;

  private int opened;

  private int clicked;

  private int parent_id;

  private LocalDateTime date_created;

  private LocalDateTime date_updated;

}
