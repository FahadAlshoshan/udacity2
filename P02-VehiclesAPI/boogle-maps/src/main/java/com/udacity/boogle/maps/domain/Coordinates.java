package com.udacity.boogle.maps.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Coordinates implements Serializable {

  @NotNull
  private double lat;
  @NotNull
  private double lon;

  public Coordinates(double lat, double lon) {
    this.lat = lat;
    this.lon = lon;
  }

  public Coordinates() {
  }

  public double getLat() {
    return lat;
  }

  public void setLat(double lat) {
    this.lat = lat;
  }

  public double getLon() {
    return lon;
  }

  public void setLon(double lon) {
    this.lon = lon;
  }
}
